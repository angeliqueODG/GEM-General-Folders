#!/bin/bash
# app_analysis_of_java.sh - Analysis of Java
VERSION="1.0"
# -------------------------------------------------------

# ================== Common Variables ========================
TITLE="Analysis of Java - Version $VERSION "
LANDMARK="Automation-Projects"
PROJECT_NAME="Automation-BSH-AutoTools"
SCRIPT_PATH="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )" # Get current script path
AUTOMATION_PROJECTS_PATH="${SCRIPT_PATH%%$LANDMARK*}$LANDMARK"
AUTOTOOLS_PATH="$AUTOMATION_PROJECTS_PATH/$PROJECT_NAME"

# ================== Load Functions ==================
source "$AUTOTOOLS_PATH/framework/common/color_functions.sh" # Include color functions

clear # Clear the terminal
echo_cyan "============================================================"
echo_cyan "=                     Analysis of Java                     ="
echo_cyan "============================================================"
echo_cyan ""

# ================== Java Installation Search Locations ========================
declare -a locations=(
  "/Library/Java/JavaVirtualMachines"                     # Default location for JDKs
  "/System/Library/Frameworks/JavaVM.framework/Versions"  # Apple location for Java
  "/usr/local/Cellar/openjdk"                             # Homebrew location for OpenJDK - Intel Macs
  "/usr/local/opt/java"                                   # Homebrew location for Java - Intel Macs
  "/usr/local/opt/openjdk"                                # Homebrew location for OpenJDK - Intel Macs
  "/opt/homebrew/Cellar/openjdk"                          # Homebrew location for Java - M1 Macs and greater
  "/opt/homebrew/opt/java"                                # Homebrew location for Java - M1 Macs and greater
  "/opt/homebrew/opt/openjdk"                             # Homebrew location for OpenJDK - M1 Macs and greater
)

# Check locations
echo_cyan "-----------------------------------"
echo_cyan "| Searching common Java locations |"
echo_cyan "-----------------------------------"

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

# ================== JAVA_HOME Search Locations ========================
declare -a shell_configs=(
  "$HOME/.bash_profile"
  "$HOME/.bashrc"
  "$HOME/.profile"
  "$HOME/.shell.pre-oh-my-zsh"
  "$HOME/.zprofile"
  "$HOME/.zshrc"
  "$HOME/etc/bashrc"
  "$HOME/etc/profile"
  "$HOME/etc/zshrc"
  "$HOME/etc/paths"
)

# Check locations for JAVA_HOME
echo
echo_cyan "-----------------------------------"
echo_cyan "| Searching for JAVA_HOME Configs |"
echo_cyan "-----------------------------------"

# Search for JAVA_HOME in each configuration file
for config in "${shell_configs[@]}"; do
  if [ -f "$config" ]; then
    if grep -q 'JAVA_HOME' "$config"; then
      echo_green "JAVA_HOME found in $config"
      while IFS= read -r line
      do
        if [[ "$line" == *"brew --prefix)/opt/openjdk"* ]]; then
          echo_green "$line"
        else
          echo_red "$line - (Warning, overrides /usr/libexec/java_home)"
        fi
      done < <(grep 'JAVA_HOME' "$config")
    else
      echo_yellow "JAVA_HOME not found in $config"
    fi
  else
    echo_yellow "$config file does not exist"
  fi
  echo ""
done

# ================== JAVA_HOME Search Locations ========================

# Check locations for JAVA_HOME
echo_cyan "-----------------------------------"
echo_cyan "|  Pointers and Aliases to Java   |"
echo_cyan "-----------------------------------"

echo
echo_yellow "JAVA_HOME is an environment variable that points to the \
installation location of Java. It is used by Java applications to \
find the Java installation. It is also used by tools like Maven, \
Ant, and Gradle to compile and run Java applications."
echo
echo_green "Check JAVA_HOME output"
java_home_result=$(echo $JAVA_HOME)
if [ -n "$java_home_result" ]; then
  echo_green "JAVA_HOME --> $java_home_result"
else
  echo_red "JAVA_HOME returning nothing"
fi

echo
echo_cyan "-------------------------"
echo

echo_yellow "It's important to check that the location of JAVA_HOME exists \
and that it is pointing to the correct Java version."
echo

echo_green "Check that the location of JAVA_HOME exists"
if [ -n "$java_home_result" ]; then
  java_home_exist_result=$(ls -la $java_home_result 2>/dev/null)
  if [ -n "$java_home_exist_result" ]; then
    echo_green "$java_home_result exists"
  else
    echo_red "$java_home_result does not exist. You must address this issue."
  fi
else
  echo_red "JAVA_HOME is not set. You must address this issue."
fi

echo
echo_cyan "-----------------------------------------------------------------------------------------"
echo_cyan ""
echo_cyan "Search complete."
echo_cyan ""