#!/bin/bash

# ===============================================================
# @file app_clear_output.sh
# @description Provides a utility to clear the common output directory for the AI Assist project.
#
# This script reads the 'common_output_directory' from 'aa_config.yaml' and
# removes the specified directory and its contents if it exists.
# ===============================================================

main() {
    echo ""
    echo "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓"
    echo "┃ Clear Output Directory Utility ┃"
    echo "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛"

    # ======= Set variables =======
    # Configuration file path relative to the script's location
    # All framework scripts (like generate_context.sh, generate_paths.sh, generate_tree.sh)
    # determine their root directory by going up three levels from their script directory [5-7].
    local config_file="../../../.ai_assist/aa_config.yaml"

    # Get the directory path of the current script
    local script_directory_path=$(dirname "$(realpath "$0")") # [5-7]

    # Calculate the project root directory
    local root_directory_path=$(realpath "$script_directory_path/../../..") # [5-7]

    # Create the full configuration file path
    local config_directory_file_path=$(realpath "$script_directory_path/$config_file") # [5-7]

    # Source common functions for colored output
    # This path is relative to app_clear_output.sh
    source "$script_directory_path/../common/color_functions.sh" # [8, 9]

    # ======= Check for required software =======
    # Check if yq is installed, as it's needed to read YAML configuration [5, 7, 10].
    if ! command -v yq &> /dev/null; then
        echo_red "==> yq is required but not installed. Please install yq and try again."
        exit 1
    fi

    # ======= Read configuration =======
    # Check if the configuration file exists [6, 11, 12]
    if [ ! -f "$config_directory_file_path" ]; then
        echo_red "==> Configuration file '${config_directory_file_path#$root_directory_path/}' not found!"
        exit 1
    fi
    echo_green "==> Reading configuration from '${config_directory_file_path#$root_directory_path/}'..." # [11-13]

    # Get the common output directory from the configuration file [11-14]
    local common_output_directory=$(yq e '.common_output_directory' "$config_directory_file_path")

    # Construct the full path to the output directory
    local full_output_path="$root_directory_path/$common_output_directory"

    # ======= Clear the output directory =======
    if [ -d "$full_output_path" ]; then
        echo_yellow "==> Removing output directory: $full_output_path"
        rm -r "$full_output_path"
        echo_green "==> Output directory removed successfully."
    else
        echo_blue "==> Output directory '$full_output_path' does not exist, no cleanup needed."
    fi

    # Pause for user to read messages
    sleep 2
}

# Run the main script
main