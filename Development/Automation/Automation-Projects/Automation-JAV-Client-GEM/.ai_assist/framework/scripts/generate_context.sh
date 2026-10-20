#!/bin/bash
# ===============================================================
# @file generate_context.sh
# @path .ai_assist/framework/scripts/generate_context.sh
# @description Gathers the content of specified project files and outputs them to a file with a timestamp.
# 
# This shell script gathers the content of specified project files and outputs them to a file with a timestamp.
# The script reads the list of files from the output of generate_paths.sh.
# 
# The script is part of the AI Assist Utils project developed by Greg Paskal.
# Written by: Greg Paskal.
# Last updated: 2024-12-27.
# 
# To execute the script, run the following command:
# ./.ai_assist/framework/scripts/generate_context.sh
# 
# Once the script is executed, it will output the context of the project files to a file with a timestamp.
# 
# Open that file and select its contents and ask Copilot to do the following:
# "Take a look at the selected file contents. Review it but only provide a simple summary of the name of the file and what you found and the total number of lines you reviewed."
# ===============================================================

# ======= Constants =======
HEADER_LINES=24 # Number of lines to account for the header
FILE_SERIES_HEADER_LINES=3 # Number of lines to account for the file series header
FILE_SERIES_FOOTER_LINES=4 # Number of lines to account for the file section footer
FILE_SECTION_HEADER_LINES=4 # Number of lines to account for the file section header plus a single space.
SUMMARY_OF_REVIEWED_FILES=7 # Number of lines to account for the footer

generate_header() {
  local file_path=$1
  local timestamp=$2

  # Initialize content
  local content=""

  # Add the header content
  content+="filepath: $file_path\n"
  content+="Context generated on: $timestamp\n"

  # Write file series header
  if [ "$total_files" -gt 1 ]; then
      content+="=================================================================================\n"
      if [ "$file_counter" -eq 1 ]; then
          content+="File $file_counter of $total_files in a series. Refer to 'context_$(printf "%02d" $((file_counter + 1)))_of_$(printf "%02d" $total_files).txt' for continuation.\n"
      else
          content+="File $file_counter of $total_files in a series. Refer to 'context_$(printf "%02d" $((file_counter - 1)))_of_$(printf "%02d" $total_files).txt' for previous content.\n"
      fi
      
      # Increment counts
      total_lines_current_output_file=$((total_lines_current_output_file + FILE_SERIES_HEADER_LINES)) # Increment total_lines_current_output_file
      total_lines_all_output_files=$((total_lines_all_output_files + FILE_SERIES_HEADER_LINES)) # Continue the count
  fi

  # Add the header content
  content+="=================================================================================\n"
  content+="This file consolidates all the relevant code and documentation for the project.\n"
  content+="The content is organized by file, with each section clearly marked.\n"
  content+="\n"
  content+="Instructions for AI Assistant (Copilot):\n"
  content+="1. Review the content of each file section.\n"
  content+="2. Provide a summary of the file's purpose and key points.\n"
  content+="3. Highlight any potential issues or areas for improvement.\n"
  content+="4. Note the total number of lines reviewed for each file.\n"
  content+="\n"
  content+="File Sections:\n"
  content+="- Each section starts with a header indicating filename, line_count and file_size.\n"
  content+="- The content of the file follows the header.\n"
  content+="\n"
  content+="Example Section Header:\n"
  content+="=================================================================================\n"
  content+="Content from file: <filename> follows for next <line_count> lines (file_size).\n"
  content+="---------------------------------------------------------------------------------\n"
  content+="\n"
  content+="Thank you for your assistance in reviewing this project!\n"
  content+="================================================================================="

  # Write the content to the output file
  echo -e "$content" >> "$output_directory_file_path"
}

generate_summary() {
  local output_directory_file_path=$1
  local total_files_reviewed=$2
  local total_lines=$3
  local total_lines_all_output_files=$4
  local content=""

  content+="\n"
  content+="=================================================================================\n"
  content+="Summary of Reviewed Files:\n"
  content+="=================================================================================\n"
  content+="Total Files Reviewed: $total_files_reviewed\n"
  content+="Total Lines Reviewed: $total_lines\n"
  content+="Total Line Count: $total_lines_all_output_files"

  echo -e "$content" >> "$output_directory_file_path"
}

# Calculate the number of output files needed
calculate_file_count() {
  local maximum_line_length=$1
  shift
  local files=("$@")

  # Initialize counts
  local file_counter=1
  local total_lines_current_output_file=0

  # Loop through each file and simulate the addition of content
  for file in "${files[@]}"; do

    # Check if the file exists
    if [ -f "$file" ]; then

      # Get the file line count
      local file_line_count=$(wc -l < "$file" | xargs)

      # Check if the file ends with a newline character and if not, increment the line count
      if [ -n "$(tail -c 1 "$file")" ]; then
        file_line_count=$((file_line_count + 1))
      fi

      # Check if the estimated line count exceeds the maximum line length
      if [ $((HEADER_LINES + FILE_SERIES_HEADER_LINES + total_lines_current_output_file + file_line_count + FILE_SERIES_FOOTER_LINES + SUMMARY_OF_REVIEWED_FILES)) -gt $maximum_line_length ]; then

        # Reset the count
        total_lines_current_output_file=0

        # Increment the file counter
        file_counter=$((file_counter + 1))
      fi

      total_lines_current_output_file=$((total_lines_current_output_file + FILE_SECTION_HEADER_LINES + file_line_count))
    fi
  done

  echo $file_counter
}

generate_content() {
  local output_directory=$1
  local base_filename=$2
  local timestamp=$3
  local maximum_line_length=$4
  local total_files=$5
  shift 5
  local files=("$@")

  # Initialize counts
  local total_lines=0
  local total_files_reviewed=0
  local total_lines_current_output_file=HEADER_LINES
  local total_lines_all_output_files=0
  local file_counter=1

  # Initialize content variable
  local content=""

  # Generate the initial output file path
  local output_directory_file_path="${output_directory}/${base_filename}_$(printf "%02d" $file_counter)_of_$(printf "%02d" $total_files).txt"

  # Generate header for the output file
  content+=$(generate_header "$output_directory_file_path" "$timestamp")
  total_lines_all_output_files=$((total_lines_all_output_files + HEADER_LINES)) # Increment total_lines_all_output_files by HEADER_LINES

  # Loop through each file and add content to the output file
  for file in "${files[@]}"; do

    # Check if the file exists
    if [ -f "$file" ]; then

      #Get the file line count
      local file_line_count=$(wc -l < "$file" | xargs)

      # Check if the file ends with a newline character and if not, increment the line count
      if [ -n "$(tail -c 1 "$file")" ]; then
        file_line_count=$((file_line_count + 1))
      fi

      echo "==> Processing file: $file ($file_line_count lines)"

      # Check if the estimated line count exceeds the maximum line length
      if [ $((file_line_count + total_lines_current_output_file + SUMMARY_OF_REVIEWED_FILES + FILE_SECTION_HEADER_LINES)) -gt $maximum_line_length ]; then

      echo "file_counter: $file_counter   total_files: $total_files"
      # Add footer
      if [ "$total_files" -gt 1 ]; then
          content+="\n"
          content+="=================================================================================\n"
          if [ "$file_counter" -eq "$total_files" ]; then
              content+="End of file $file_counter of $total_files. This is the final file in the series.\n"
          else
              content+="End of file $file_counter of $total_files. Refer to 'context_$(printf "%02d" $((file_counter + 1)))_of_$(printf "%02d" $total_files).txt' for the continuation.\n"
          fi
          content+="================================================================================="
          total_lines_current_output_file=$((total_lines_current_output_file + FILE_SERIES_FOOTER_LINES)) # Increment total_lines_current_output_file
          total_lines_all_output_files=$((total_lines_all_output_files + FILE_SERIES_FOOTER_LINES)) # Continue the count
      fi

        # Write the content to the output file
        echo -e "$content" >> "$output_directory_file_path"

        # Reset the content and counts for the next output file
        content=""
        file_counter=$((file_counter + 1))
        total_lines_current_output_file=HEADER_LINES # Reset the count
        total_lines_all_output_files=$((total_lines_all_output_files + HEADER_LINES)) # Continue the count
        
        # Generate the next output file path
        output_directory_file_path="${output_directory}/${base_filename}_$(printf "%02d" $file_counter)_of_$(printf "%02d" $total_files).txt"

        # Generate header for the next output file
        content+=$(generate_header "$output_directory_file_path" "$timestamp")
      fi

      # Get the file size
      local file_size=$(stat -f%z "$file" | awk '{ split("B KB MB GB TB", v); s=1; while($1>1024){$1/=1024; s++} printf "%.1f %s", $1, v[s] }')

      # Add the section header
      content+="\n"
      content+="=================================================================================\n"
      content+="Content from file: \"$(basename "$file")\" follows for next $((file_line_count)) lines (size: $file_size) (total_lines_current_output_file: $total_lines_current_output_file).\n"
      content+="---------------------------------------------------------------------------------\n"
      
      # Increment counts
      total_lines_current_output_file=$((total_lines_current_output_file + FILE_SECTION_HEADER_LINES)) # Increment total_lines_current_output_file
      total_lines_all_output_files=$((total_lines_all_output_files + FILE_SECTION_HEADER_LINES)) # Increment total_lines_all_output_files

      # Add the content of the file to content
      content+=$(cat "$file")
      content+="\n"

      # Increment counts
      total_lines=$((total_lines + file_line_count))
      total_files_reviewed=$((total_files_reviewed + 1))
      total_lines_current_output_file=$((total_lines_current_output_file + file_line_count)) # Increment total_lines_current_output_file
      total_lines_all_output_files=$((total_lines_all_output_files + file_line_count)) # Increment total_lines_all_output_files
    fi
  done

  # Increment counts
  total_lines_current_output_file=$((total_lines_current_output_file + SUMMARY_OF_REVIEWED_FILES)) # Add footer lines
  total_lines_all_output_files=$((total_lines_all_output_files + SUMMARY_OF_REVIEWED_FILES)) # Increment total_lines_all_output_files

  # Generate summary for the output file
  content+=$(generate_summary "$output_directory_file_path" "$total_files_reviewed" "$total_lines" "$total_lines_all_output_files")

  if [ "$total_files" -gt 1 ]; then
      content+="\n"
      content+="=================================================================================\n"
      if [ "$file_counter" -eq "$total_files" ]; then
          content+="End of file $file_counter of $total_files. This is the final file in the series.\n"
      else
          content+="End of file $file_counter of $total_files. Refer to 'context_$(printf "%02d" $((file_counter + 1)))_of_$(printf "%02d" $total_files).txt' for the continuation.\n"
      fi
      content+="================================================================================="
      total_lines_current_output_file=$((total_lines_current_output_file + FILE_SERIES_FOOTER_LINES)) # Increment total_lines_current_output_file
      total_lines_all_output_files=$((total_lines_all_output_files + FILE_SERIES_FOOTER_LINES)) # Continue the count
  fi

  # Write the content to the output file
  echo -e "$content" >> "$output_directory_file_path"
}

main() {
  echo ""
  echo "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓"
  echo "┃           Project Context Generator          ┃"
  echo "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛"

  # ======= Set variables =======
  local config_file="../../../.ai_assist/aa_config.yaml" # Consolidated configuration file
  timestamp=$(date +"%B %d, %Y, %H:%M:%S") # Human-friendly timestamp for output file

  # ======= Check for required software =======

  # Check if yq is installed
  if ! command -v yq &> /dev/null; then
    echo "==> yq is required but not installed. Please install yq and try again."
    exit 1
  fi

  # ======= Read configuration =======

  # Get the directory path of the current script in a variable
  local script_directory_path=$(dirname "$(realpath "$0")")
  local root_directory_path=$(realpath "$script_directory_path/../../..")

  # Create the configuration file path
  local config_directory_file_path=$(realpath "$script_directory_path/$config_file")

  # Check if the configuration file exists
  if [ ! -f "$config_directory_file_path" ]; then
    echo "==> Configuration directory file ${config_directory_file_path#$root_directory_path/} not found!"
    exit 1
  fi

  echo "==> Reading configuration from ${config_directory_file_path#$root_directory_path/}..."

  # Get the common output directory from the configuration file
  common_output_directory=$(yq e '.common_output_directory' "$config_directory_file_path")

  # Check if the common output directory exists
  if [ ! -d "$root_directory_path/$common_output_directory" ]; then
    echo "==> Creating common output directory: $common_output_directory"
    mkdir -p "$root_directory_path/$common_output_directory"
  fi

  # Get the output file from the configuration file
  output_file=$(yq e '.generate_context.output_file' "$config_directory_file_path")

  # Get the output locations from the configuration file
  output_locations=$(yq e '.generate_context.output_locations' "$config_directory_file_path")

  # Get the maximum line length from the configuration file
  maximum_line_length=$(yq e '.generate_context.maximum_line_length' "$config_directory_file_path")

  # Get Generated Paths File
  echo "==> Retrieving project paths file..."
  local generated_paths_file=$(yq e '.generate_paths.output_file' "$config_directory_file_path")
  generated_paths_file="$common_output_directory/paths/$generated_paths_file"

  # Ensure the generated paths file exists
  echo "==> Verifying the existence of the generated paths file..."
  if [ ! -f "$root_directory_path/$generated_paths_file" ]; then
    echo "==> Generated paths file not found!"
    exit 1
  fi

  # ======= Read the list of files from the paths file =======
  files=()
  while IFS= read -r line; do
    # Skip lines that are not valid file paths
    if [[ -f "$line" ]]; then
      files+=("$line")
    fi
  done < "$root_directory_path/$generated_paths_file"
  echo "==> Found ${#files[@]} files in $generated_paths_file"

  # ======= Calculate the number of output files needed =======
  local total_files=$(calculate_file_count "$maximum_line_length" "${files[@]}")
  echo "==> Total output files needed: $total_files"

  # ======= Remove old non-timestamped files =======
  echo "==> Removing old non-timestamped context files..."
  find "$root_directory_path/$common_output_directory" -type f -name 'context_??_of_??.txt' -exec rm {} +

  # ======= Generate content and save to files =======
  echo "==> Generating content file..."

  # Loop through the output locations and save the content
  for location in $(echo "$output_locations" | yq e -o=json '.[]' | jq -r @base64); do
    _jq() {
      echo "$location" | base64 --decode | jq -r "$1"
    }

    # Get the output path
    output_path=$(_jq '.path' | sed "s|\${common_output_directory}|$common_output_directory|g")

    # Get the save timestamped version flag
    save_timestamped_version=$(_jq '.save_timestamped_version')

    # Check if the output directory exists and create it if necessary
    if [ ! -d "$root_directory_path/$output_path" ]; then
      echo "==> Creating output directory: $output_path"
      mkdir -p "$root_directory_path/$output_path"
    fi

    # Generate content for the output file
    generate_content "$root_directory_path/$output_path" "context" "$timestamp" "$maximum_line_length" "$total_files" "${files[@]}"

    # Save to the timestamped version if required
    if [ "$save_timestamped_version" = true ]; then
      for i in $(seq 1 $total_files); do
        local output_directory_file_path_timestamped="$root_directory_path/$output_path/context_${timestamp}_$(printf "%02d" $i)_of_$(printf "%02d" $total_files).txt"
        cp "$root_directory_path/$output_path/context_$(printf "%02d" $i)_of_$(printf "%02d" $total_files).txt" "$output_directory_file_path_timestamped"
      done
    fi

    # Print instructions on how to share the output
    local relative_output_directory_file_path="${output_directory_file_path#$root_directory_path/}"
    echo "==> Project context has been captured in $relative_output_directory_file_path"
    if [ "$save_timestamped_version" = true ]; then
      local relative_output_directory_file_path_timestamped="${output_directory_file_path_timestamped#$root_directory_path/}"
      echo "==> Project context has also been captured in $relative_output_directory_file_path_timestamped"
    fi
  done
}

# Run the main script
main