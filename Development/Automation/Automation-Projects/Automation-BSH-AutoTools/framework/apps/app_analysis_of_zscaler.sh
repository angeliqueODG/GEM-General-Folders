#!/bin/bash
# app_analysis_of_zscaler.sh - Analysis of ZScaler
VERSION="1.0"
# -------------------------------------------------------

# ================== Common Variables ========================
TITLE="Analysis of ZScaler - Version $VERSION "
LANDMARK="Automation-Projects"
PROJECT_NAME="Automation-BSH-AutoTools"
SCRIPT_PATH="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )" # Get current script path
AUTOMATION_PROJECTS_PATH="${SCRIPT_PATH%%$LANDMARK*}$LANDMARK"
AUTOTOOLS_PATH="$AUTOMATION_PROJECTS_PATH/$PROJECT_NAME"

# ================== Load Functions ==================
source "$AUTOTOOLS_PATH/framework/common/color_functions.sh" # Include color functions

clear # Clear the terminal
echo_cyan "============================================================"
echo_cyan "=                Analysis of ZScaler                       ="
echo_cyan "============================================================"
echo_cyan ""

# ================== Java Installation Search Locations ========================
declare -a locations=(
  "/Applications/Zscaler/Zscaler.app"                       # ZScaler Client Connector App
  "/Library/LaunchAgents/com.zscaler.tray.plist"            # ZScaler LaunchAgent
  "/Library/LaunchDaemons/com.zscaler.service.plist"        # ZScaler LaunchDaemon
  "/Library/LaunchDaemons/com.zscaler.tunnel.plist"         # ZScaler LaunchDaemon
  "/Library/LaunchDaemons/com.zscaler.UPMServiceController" # ZScaler LaunchDaemon
)

# Check locations
echo_cyan "--------------------------------------"
echo_cyan "| Searching common ZScaler locations |"
echo_cyan "--------------------------------------"

for location in "${locations[@]}"; do
  echo_cyan
  echo_cyan "- - - Begin - - -"
  if [ -d "$location" ]; then # Is this a directory?
    echo_cyan "ls -l $location"
    echo_cyan
    ls -l "$location"
    echo_cyan
    echo_cyan "                        ----------------------- File / Directory / Link Check ----------------------"
    ls -l "$location" | while read -r line; do
      [[ $line == total* ]] && continue # Skip line if it contains "total"

      # Check if the line is a symbolic link
      if [[ $(echo $line | awk '{print substr($1, 1, 1)}') == "l" ]]; then
        # Get paths to test

        symbolic_link_path="$(echo $line | awk '{print $9}')"
        if [[ "$symbolic_link_path" == /* ]]; then
            symbolic_link_path="$symbolic_link_path"
        elif [[ "$symbolic_link_path" == ../* ]]; then
            symbolic_link_path="$(dirname "$(dirname "$location")")/${symbolic_link_path:3}"
        else
            symbolic_link_path="$location/$symbolic_link_path"
        fi

        symbolic_link_path_absolute_path=$(readlink -f "$symbolic_link_path")

        symbolic_link_target=$(echo $line | awk '{print $11}')
        if [[ "$symbolic_link_target" == /* ]]; then
            symbolic_link_target="$symbolic_link_target"
        elif [[ "$symbolic_link_target" == ../* ]]; then
            symbolic_link_target="$(dirname "$(dirname "$location")")/${symbolic_link_target:3}"
        else
            symbolic_link_target="$location/$symbolic_link_target"
        fi

        symbolic_link_target_absolute_path=$(readlink -f "$symbolic_link_target")

        # Test paths
        [ -e "$symbolic_link_path" ]                 && echo_green "                     Symbolic link: '$symbolic_link_path' exists." || echo_red "                     Symbolic link: '$symbolic_link_path' does not exist. Warning!"
        [ -e "$symbolic_link_path_absolute_path" ]   && echo_green "       Symbolic link absolute path: '$symbolic_link_path_absolute_path' exists." || echo_red "       Symbolic link absolute path: '$symbolic_link_path_absolute_path' does not exist. Warning!"
        [ -e "$symbolic_link_target" ]               && echo_green "              Symbolic link target: '$symbolic_link_target' exists." || echo_red "              Symbolic link target: '$symbolic_link_target' does not exist. Warning!"
        [ -e "$symbolic_link_target_absolute_path" ] && echo_green "Symbolic link target absolute path: '$symbolic_link_target_absolute_path' exists." || echo_red "Symbolic link target absolute path: '$symbolic_link_target_absolute_path' does not exist. Warning!"
      else
        # Get paths to test
        full_path="$location/$(echo $line | awk '{print $9}')" # Get the absolute path
        # Test path
        [ -e "$full_path" ]                          && echo_green "                         Full path: '$full_path' exists." || echo_red "                         Full path: '$full_path' does not exist. Warning!"
      fi
    done
  else
    echo_yellow "Directory not found at $location"
  fi
  echo_cyan "- - - End - - -"

done

# # Check for ZScaler Client Connector App
# if [ -d "/Applications/Zscaler/Zscaler.app" ]; then
#     echo "ZScaler Client Connector App is installed."
# else
#     echo "ZScaler Client Connector App is not installed."
# fi

# Check for ZScaler service status
zscaler_service_name="com.zscaler.ZscalerService" # Replace with actual service name if different
if launchctl list | grep -q "$zscaler_service_name"; then
    echo "ZScaler service is running."
else
    echo "ZScaler service is not running."
fi

# Check for ZScaler in network settings
network_service="Wi-Fi" # Replace with actual network service name if different
zscaler_network_setting=$(networksetup -getwebproxy "$network_service")

if [[ $zscaler_network_setting == *"Enabled: Yes"* ]]; then
    echo "ZScaler proxy is enabled in network settings."
else
    echo "ZScaler proxy is not enabled in network settings."
fi

# Check for ZScaler LaunchDaemons
launch_daemons_path="/Library/LaunchDaemons"
zscaler_launch_daemon="com.zscaler.ZscalerService.plist" # Replace with actual plist file name if different

if [ -f "$launch_daemons_path/$zscaler_launch_daemon" ]; then
    echo "ZScaler LaunchDaemon is installed."
else
    echo "ZScaler LaunchDaemon is not installed."
fi

# Check for ZScaler LaunchAgents
launch_agents_path="/Library/LaunchAgents"
zscaler_launch_agent="com.zscaler.ZscalerService.agent.plist" # Replace with actual plist file name if different

if [ -f "$launch_agents_path/$zscaler_launch_agent" ]; then
    echo "ZScaler LaunchAgent is installed."
else
    echo "ZScaler LaunchAgent is not installed."
fi

echo
echo_cyan "-----------------------------------------------------------------------------------------"
echo_cyan ""
echo_cyan "Search complete."
echo_cyan ""