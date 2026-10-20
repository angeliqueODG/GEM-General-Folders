#!/bin/bash
# ===============================================================
# @file aa.sh
# @description Provides a menu-driven interface for launching AI Assist tools and utilities.
# 
# This script contains functions to add menu items, display the menu, handle user choices, and execute commands based on the user's selection.
# It handles the setup of the menu, user interactions, and command execution.
# ./.ai_assist/aa.sh
# ===============================================================
# AI Assist Tools
# Developed by Greg Paskal - Jan 2025
VERSION="1.10"
# ===============================================================
# Description
#   This script provides a menu-driven interface for launching
#   AI Assist tools and utilities.
# ===============================================================
# Change Log
# Date        Name            Version            Description
# ----------  --------------  -------  --------------------------
# 2025-01-03  G. Paskal        1.0     Initial creation
# 2025-01-06  G. Paskal        1.1     Break context into smaller files
# 2025-01-07  G. Paskal        1.2     Documentation updates
# 2025-01-08  G. Paskal        1.3     Documentation Improvements
# 2025-07-15  G. Paskal        1.4     Documentation Updates
# 2025-07-15  G. Paskal        1.5     Improvements for NotebookLM AI
# 2025-07-15  G. Paskal        1.6     Refactored the naming of the config file.
# 2025-07-15  G. Paskal        1.7     Created option to clear output directory
# 2025-07-16  G. Paskal        1.8     Updated requirements and enhanced App script execution to close windows.
# 2025-07-28  G. Paskal        1.9     Enhanced to utilize AI Training Data to recognize desirable and undesirable code characteristics.
# 2025-07-29  G. Paskal        1.10    Enhanced AI instructions for code output.
# ===============================================================

clear # Clear the terminal

# ================== Menu Items ========================
declare -a menu_keys
declare -a menu_values
declare -a menu_order

# Function to add a menu item
# Arguments:
#   key: The key for the menu item
#   value: The value for the menu item, in the format "display text|confirmation text|command"
add_menu_item() {
    local key="$1"
    local value="$2"
    menu_keys+=("$key")
    menu_values+=("$value")
    menu_order+=("${#menu_keys[@]}")
}

# ================== Common Variables ========================
SCRIPT_PATH="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )" # Get current script path
PROJECT_PATH="$(dirname "$SCRIPT_PATH")" # Get project path
echo "SCRIPT_PATH: $SCRIPT_PATH"
AA_FRAMEWORK_PATH="$SCRIPT_PATH/framework"
TITLE="AI Assist - Version $VERSION "

# ================== Menu Items ========================
# The Option key, details, and command to execute. The order of the menu items is determined by the order in which they are added below
add_menu_item "cc" "Capture Context|Capturing Context...|\"cd $PROJECT_PATH/; ./.ai_assist/framework/apps/app_capture_context.sh; exit;\""
add_menu_item "co" "Clear Output Directory|Clearing output directory...|\"cd $PROJECT_PATH/; ./.ai_assist/framework/apps/app_clear_output.sh; exit;\""
add_menu_item "-"  ""
add_menu_item "x"  "Exit|Exiting...|exit 0"

# ================== Common Functions ==================
source "$SCRIPT_PATH/framework/common/color_functions.sh" # Include color functions

# Function to calculate the maximum length of menu items and title message
# This is used to format the menu display
calculate_max_length() {

    # Get max length from title message
    max_length=${#TITLE}

    # Get max length from menu items
    for index in "${menu_order[@]}"; do
        IFS='|'
        read -ra parts <<< "${menu_values[$index-1]}"
        len=${#parts[0]}
        # Update max length if current length is greater that max length
        ((len > max_length)) && max_length=$len
    done
}

# Function to display a line of a specific length
# The length is determined by the maximum length of the menu items and title message
display_line() {
    local line=""
    for ((i = 0; i < $((max_length + 12)); i++)); do line="${line}="; done
    echo_magenta "$line"
}

# Function to display the dynamic menu
# The menu is formatted based on the maximum length of the menu items and title message
display_menu() {
    display_line
    padding=$(( (($max_length + 11) - ${#TITLE} ) / 2 ))
    echo_magenta "$(printf "=%*s%s%*s=\n" "$padding" "" "$TITLE" "$padding" "")";
    display_line
    echo_magenta "$(printf "=%-2s%-6s%-1s%-7s%-$(($max_length - 7))s%-1s=\n" "" "Option" "" "Details")";
    echo_magenta "$(printf "=%-2s%-6s%-1s%-7s%-$(($max_length - 7))s%-1s=\n" "" "------" "" "-------" "")";
    for index in "${menu_order[@]}"; do
        IFS='|'
        read -ra parts <<< "${menu_values[$index-1]}"
        # Check if key contains "-"
        if [[ "${menu_keys[$index-1]}" == *"-"* ]]; then
            dashes=""; for ((i = 0; i < $max_length; i++)); do dashes="${dashes}-"; done
            echo_magenta "$(printf "=%-2s%6s%-1s%-$(($max_length))s%-1s=\n" "" "  " "" "$dashes" "")";
        else
            echo_magenta "$(printf "=%-2s%6s%-1s%-$(($max_length))s%-1s=\n" "" "${menu_keys[$index-1]}  " "" "${parts[0]}" "")";
        fi
    done
    display_line
}

# Function to handle the user's choice
# This function executes the command associated with the chosen menu item
# If the choice is not a valid menu item key, it displays an error message
handle_choice() {
    local found=0
    for index in "${!menu_keys[@]}"; do
        if [[ "${menu_keys[$index]}" == "$choice" ]]; then
            found=1
            IFS='|' read -ra parts <<< "${menu_values[$index]}"
            echo_green "${parts[1]}"
            echo
            if [[ "$choice" != "x" ]]; then
                osascript -e "tell app \"Terminal\" to do script ${parts[2]}"
                clear
            else
                exit 0
            fi
            break
        fi
    done
    if [[ $found -eq 0 ]]; then
        echo_red "Invalid choice: $choice"
        sleep 1
        clear
    fi
}

# Calculate max length
calculate_max_length

# Display the menu and prompt user for input
while true; do
    display_menu
    read -p "Enter your option: " choice
    handle_choice
done