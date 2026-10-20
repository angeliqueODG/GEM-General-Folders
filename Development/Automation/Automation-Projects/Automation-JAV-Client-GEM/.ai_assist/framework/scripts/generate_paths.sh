#!/bin/bash
# ===============================================================
# @file generate_paths.sh
# @path .ai_assist/framework/scripts/generate_paths.sh
# @description Generates the paths of the project files.
# 
# This shell script generates the paths of the project files.
# The script reads configuration from a YAML file and requires tree and yq to be installed.
# The script generates a text file with the project paths.
# 
# The script is part of the AI Assist Utils project developed by Greg Paskal.
# Written by: Greg Paskal.
# Last updated: 2024-12-27.
# 
# To execute the script, run the following command:
# ./.ai_assist/framework/scripts/generate_paths.sh
# ===============================================================

main() {
  echo ""
  echo "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓"
  echo "┃           Project Paths Generator            ┃"
  echo "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛"

  # ======= Set variables =======
  local config_file="../../../.ai_assist/aa_config.yaml" # Consolidated configuration file
  timestamp=$(date +"%B %d, %Y, %H:%M:%S") # Human-friendly timestamp for output file

  # ======= Check for required software =======

  # Check if tree is installed
  if ! command -v tree &> /dev/null; then
    echo "==> tree is required but not installed. Please install tree and try again."
    exit 1
  fi

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
  output_file=$(yq e '.generate_paths.output_file' "$config_directory_file_path")

  # Get the output locations from the configuration file
  output_locations=$(yq e '.generate_paths.output_locations' "$config_directory_file_path")

  # Check and create all necessary directories
  echo "==> Checking and creating necessary directories..."
  for location in $(echo "$output_locations" | yq e -o=json '.[]' | jq -r @base64); do
    _jq() {
      echo "$location" | base64 --decode | jq -r "$1"
    }

    output_path=$(_jq '.path' | sed "s|\${common_output_directory}|$common_output_directory|g")

    # Check if the output directory exists
    if [ ! -d "$root_directory_path/$output_path" ]; then
      echo "==> Creating output directory: $output_path"
      mkdir -p "$root_directory_path/$output_path"
    fi
  done

  # Get the ignore patterns from the configuration file
  local ignore_patterns=$(yq e '.generate_paths.ignore_patterns' "$config_directory_file_path")

 # Capture project paths
  echo "==> Capture project paths..."
  path_content_raw=$(tree -aif --noreport -I "$ignore_patterns")

  # Get the directories and store them in a variable
  directories=$(find . -type d | grep -Eiv "$ignore_patterns")

  # Exclude directories if specified in the configuration and sort the content
  local exclude_directories=$(yq e '.generate_paths.exclude_directories' "$config_directory_file_path")
  if [ "$exclude_directories" = true ]; then
    path_content=$(echo "$path_content_raw" | grep -Fivxf <(echo "$directories") | sort)
  else
    path_content=$(echo "$path_content_raw" | sort)
  fi

  echo "==> Saving project paths to output locations..."
  # Save project paths to each output location
  for location in $(echo "$output_locations" | yq e -o=json '.[]' | jq -r @base64); do
    _jq() {
      echo "$location" | base64 --decode | jq -r "$1"
    }

    output_path=$(_jq '.path' | sed "s|\${common_output_directory}|$common_output_directory|g")
    save_timestamped_version=$(_jq '.save_timestamped_version')

    # Create the output file paths
    output_directory_file_path="$root_directory_path/$output_path/$output_file"
    output_directory_file_path_timestamped="$root_directory_path/$output_path/paths_$(date +"%Y%m%d_%H%M%S").txt"

  # Save the project paths content with header
  {
    echo "// filepath: ${output_directory_file_path#$root_directory_path/}"
    echo "Paths generated on: $timestamp"
    echo "================================================================================="
    echo "This file contains the paths of the project files."
    echo "The content is organized alphabetically by file name."
    echo ""
    echo "Instructions for AI Assistant (Copilot):"
    echo "1. Review the paths structure."
    echo "2. Provide a summary of the directory and file organization."
    echo "3. Highlight any potential issues or areas for improvement."
    echo "4. Note the total number of files."
    echo ""
    echo "Thank you for your assistance in reviewing this project!"
    echo "================================================================================="
    echo ""
    echo "$path_content"
  } > "$output_directory_file_path"
  echo "==> Saved project paths: ${output_directory_file_path#$root_directory_path/}"

  # Conditionally save the timestamped version
  if [ "$save_timestamped_version" = true ]; then
    {
      echo "// filepath: ${output_directory_file_path_timestamped#$root_directory_path/}"
      echo "Paths generated on: $timestamp"
      echo "================================================================================="
      echo "This file contains the paths of the project files."
      echo "The content is organized alphabetically by file name."
      echo ""
      echo "Instructions for AI Assistant (Copilot):"
      echo "1. Review the paths structure."
      echo "2. Provide a summary of the directory and file organization."
      echo "3. Highlight any potential issues or areas for improvement."
      echo "4. Note the total number of files."
      echo ""
      echo "Thank you for your assistance in reviewing this project!"
      echo "================================================================================="
      echo ""
      echo "$path_content"
    } > "$output_directory_file_path_timestamped"
    echo "==> Saved project paths with timestamp: ${output_directory_file_path_timestamped#$root_directory_path/}"
  fi
  done
}

main