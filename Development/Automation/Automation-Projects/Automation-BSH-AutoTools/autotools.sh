#!/bin/bash
# ===============================================================
# Automation Tools
# Developed by Greg Paskal - May 2024
VERSION="1.1"
# ===============================================================
# Description
#   This script provides a menu-driven interface for launching
#   various automation tools and helper scripts. It's audience
#   is primarily automation engineers and developers.
# ===============================================================
# Change Log
# Date        Name            Version            Description
# ----------  --------------  -------  -----------------------------------------
# 2024-05-01  G. Paskal        1.0     Initial creation
# 2024-05-13  G. Paskal        1.1     Added ZScaler analysis
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

# The Option key, details, and command to execute. The order of the menu items is determined by the order in which they are added below
add_menu_item "ia" "Install Automation Development for Java|Installing Automation Development software for Java...|\"cd $PATH_AUTOMATION_PROJECTS/Automation-BSH-AutoTools; ./framework/apps/app_install_auto_dev_for_java.sh;\""
add_menu_item "aj" "Analysis of Java|Analyzing Java...|\"cd $PATH_AUTOMATION_PROJECTS/Automation-BSH-AutoTools; ./framework/apps/app_analysis_of_java.sh;\""
add_menu_item "az" "Analysis of ZScaler|Analyzing ZScaler...|\"cd $PATH_AUTOMATION_PROJECTS/Automation-BSH-AutoTools; ./framework/apps/app_analysis_of_zscaler.sh;\""
add_menu_item "ap" "Go to Automation-Projects|Opening Automation-Projects...|\"cd $PATH_AUTOMATION_PROJECTS\""
add_menu_item "-"  ""
add_menu_item "ex" "Experimental|Launch Experimental...|\"echo 'PATH_AUTOMATION_EXP: $PATH_AUTOMATION_EXP'; cd '$PATH_AUTOMATION_EXP'\""
add_menu_item "--" "------------------|------------------|------------------"
add_menu_item "x"  "Exit|Exiting...|exit 0"

# ================== Common Variables ========================
TITLE="Auto Tools - Version $VERSION "
LANDMARK="Automation-Projects"
PROJECT_NAME="Automation-BSH-AutoTools"
SCRIPT_PATH="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )" # Get current script path
AUTOMATION_PROJECTS_PATH="${SCRIPT_PATH%%$LANDMARK*}$LANDMARK"
AUTOTOOLS_PATH="$AUTOMATION_PROJECTS_PATH/$PROJECT_NAME"

# ================== Common Functions ==================
source "$AUTOTOOLS_PATH/framework/common/color_functions.sh" # Include color functions

# Function to calculate the maximum length of menu items and title message
# This is used to format the menu display
calculate_max_length() {

    # Get max length from title message
    max_length=${#TITLE}

    # Get max length from menu items
    for index in "${menu_order[@]}"; do
        IFS='|' read -ra parts <<< "${menu_values[$index-1]}"
        len=${#parts[0]}
        # Update max length if current length is greater that max length
        ((len > max_length)) && max_length=$len
    done
}

# Function to display a line of a specific length
# The length is determined by the maximum length of the menu items and title message
display_line() {
    echo_orange $(printf '=%.0s' $(seq 1 $(($max_length + 12))));
}

# Function to display the dynamic menu
# The menu is formatted based on the maximum length of the menu items and title message
display_menu() {
    display_line
    padding=$(( (($max_length + 11) - ${#TITLE} ) / 2 ))
    echo_orange "$(printf "=%*s%s%*s=\n" "$padding" "" "$TITLE" "$padding" "")";
    display_line
    echo_orange "$(printf "=%-2s%-6s%-1s%-7s%-$(($max_length - 7))s%-1s=\n" "" "Option" "" "Details")";
    echo_orange "$(printf "=%-2s%-6s%-1s%-7s%-$(($max_length - 7))s%-1s=\n" "" "------" "" "-------" "")";
    for index in "${menu_order[@]}"; do
        IFS='|' read -ra parts <<< "${menu_values[$index-1]}"
        # Check if key contains "-"
        if [[ "${menu_keys[$index-1]}" == *"-"* ]]; then
            dashes=$(printf "%0.s-" $(seq 1 $max_length))
            echo_orange "$(printf "=%-2s%6s%-1s%-$(($max_length))s%-1s=\n" "" "  " "" "$dashes" "")";
        else
            echo_orange "$(printf "=%-2s%6s%-1s%-$(($max_length))s%-1s=\n" "" "${menu_keys[$index-1]}  " "" "${parts[0]}" "")";
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