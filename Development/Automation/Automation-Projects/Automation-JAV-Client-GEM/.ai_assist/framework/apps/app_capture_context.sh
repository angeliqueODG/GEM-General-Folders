#!/bin/bash

# ===============================================================
# @file app_capture_context.sh
# @description Orchestrates the execution of scripts to capture the project context.
#
# This script sequentially executes generate_tree.sh, generate_paths.sh, and generate_context.sh,
# ensuring each script completes successfully before proceeding to the next.
# ===============================================================

# Function to check the exit status of the last executed command
check_status() {
  if [ $? -ne 0 ]; then
    echo_red "Error: $1 failed to execute successfully." # Using color_functions
    exit 1
  fi
}

main() {
    echo ""
    echo "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓"
    echo "┃ Project Context Capture ┃"
    echo "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛"

    # ======= Set variables and source common functions =======
    local script_directory_path=$(dirname "$(realpath "$0")")
    local root_directory_path=$(realpath "$script_directory_path/../../..")

    # Source common functions for colored output (path relative to app_capture_context.sh)
    source "$script_directory_path/../common/color_functions.sh"

    local config_file="${root_directory_path}/.ai_assist/aa_config.yaml"

    # ======= Check for required software =======
    if ! command -v yq &> /dev/null; then
        echo_red "Error: yq is required but not installed. Please install yq and try again."
        exit 1
    fi

    # ======= Read configuration =======
    if [ ! -f "$config_file" ]; then
        echo_red "Error: Configuration file ${config_file#$root_directory_path/} not found!" # Prettify path for output
        exit 1
    fi
    echo_green "==> Reading configuration from '${config_file#$root_directory_path/}'..."

    local common_output_directory=$(yq e '.common_output_directory' "$config_file")
    local auto_clear_output=$(yq e '.auto_clear_output_on_capture' "$config_file") # Keeping this for now as per your provided code

    local full_output_path="$root_directory_path/$common_output_directory"

    # ======= Optional: Clear output directory if configured =======
    # Addressing the duplicated output clearing logic by calling the dedicated app_clear_output.sh script.
    # This ensures consistency and centralizes the cleanup logic.
    if [ "$auto_clear_output" = "true" ]; then
        echo_blue "==> Initiating cleanup of previous output directory via app_clear_output.sh..."
        # Execute app_clear_output.sh from the project root using its relative path
        "$root_directory_path"/.ai_assist/framework/apps/app_clear_output.sh
        check_status "app_clear_output.sh" # Ensure the clear operation was successful
    fi

    # ======= Execute context generation scripts =======
    echo_blue "==> Running generate_tree.sh..."
    # Ensure correct relative path from the project root where aa.sh invokes this script.
    # If app_capture_context.sh is run from the project root, these paths are correct.
    "$root_directory_path"/.ai_assist/framework/scripts/generate_tree.sh
    check_status "generate_tree.sh"

    echo_blue "==> Running generate_paths.sh..."
    "$root_directory_path"/.ai_assist/framework/scripts/generate_paths.sh
    check_status "generate_paths.sh"

    echo_blue "==> Running generate_context.sh..."
    "$root_directory_path"/.ai_assist/framework/scripts/generate_context.sh
    check_status "generate_context.sh"

    # ======= Output instructions =======
    echo_green "================================================================================="
    echo_green "Project context has been successfully captured."
    echo_green "To share this with the AI assistant, please upload the generated context files"
    echo_green "to a public repository or file-sharing service and provide the links."
    echo_green "================================================================================="
    echo "" # Add a newline for better readability in the terminal

    # Pause for user to read messages
    sleep 2
}

# Run the main script
main