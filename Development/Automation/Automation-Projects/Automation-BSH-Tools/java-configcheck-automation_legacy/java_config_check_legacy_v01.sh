#!/bin/bash
# auto_config.sh - Automation Configuration Checker
# -------------------------------------------------------

# ================== Common Functions ==================

# Colors for reporting
reset=$(tput sgr0)
red=$(tput setaf 1)
green=$(tput setaf 2)
yellow=$(tput setaf 3)
blue=$(tput setaf 4)
magenta=$(tput setaf 5)
cyan=$(tput setaf 6)
white=$(tput setaf 7)

echo_red() { message=$@; echo "${red}$message${reset}"; }
echo_green() { message=$@; echo "${green}$message${reset}"; }
echo_yellow() { message=$@; echo "${yellow}$message${reset}"; }
echo_blue() { message=$@; echo "${blue}$message${reset}"; }
echo_magenta() { message=$@; echo "${magenta}$message${reset}"; }
echo_cyan() { message=$@; echo "${cyan}$message${reset}"; }
echo_white() { message=$@; echo "${white}$message${reset}"; }

# =============================================================================================================================================
# ============================================================= User Prompt - Begin ===========================================================

while true; do

  # Clear the terminal
  clear

  echo
  echo "================================================"
  echo "=   Automation Configurator for Java - Begin   ="
  echo "=            $(date +"%m-%d-%Y %I:%M:%S %p")            ="
  echo "================================================"
  echo

  # Prompt to Install or Uninstall components
  read -p "Choose selection - Install (I), Uninstall (U), or Exit (X): " action

  # Convert response to lowercase if necessary
  action=${action,,}

    # Ensure valid input
    if [[ "$action" == "i" || "$action" == "u" || "$action" == "x" ]]; then
        echo "Performing '$action' action."
    else
        echo "'$action' is an invalid response. Please try again."
        continue
    fi

    # Check for exit condition
    if [[ "$action" == "x" ]]; then
        echo "Exiting the script."
        echo
        echo "================================================"
        echo "=            $(date +"%m-%d-%Y %I:%M:%S %p")            ="
        echo "= Automation Configurator for Java - Exited    ="
        echo "================================================"
        echo
        exit 0
    fi

  # Prompt to perform action automatically or with prompts
  read -p "Perform each action Automatically (A) or with Prompt (P) for confirmation? Exit (X): " perform_action

  # Convert reperform_actionsponse to lowercase if necessary
  perform_action=${perform_action,,}

  # Ensure valid input
  if [[ "$perform_action" == "p" || "$perform_action" == "a" || "$perform_action" == "x" ]]; then
      echo "Performing '$action' action."
      # Valid inputs, break out of loop
      break
  else
      echo "'$perform_action' is an invalid response. Please try again."
  fi
done

# ============================================================= User Prompt - End =============================================================
# =============================================================================================================================================

# =============================================================================================================================================
# ============================================================= Install - Begin ===============================================================
if [ "$action" = "i" ]; then

  # # Validate User
  # echo "Validate \$USER"
  # echo "------------------------------------"
  # user=$USER
  # echo_green "\$USER '$user'"

  # echo

  # # Validate Path
  # echo "Validate \$PATH"
  # echo "------------------------------------"
  # path=$PATH
  # path_len=${#path}
  # echo_green "\$PATH '$path'"
  # echo_green "\$PATH Length $path_len"

  # # Validate Path Value /bin
  # path_value="/bin"
  # path_ref="Edit your \$PATH"
  # path_search_result=${path%%$path_value*}
  # if [ "$path_search_result" != "$path" ]; then
  #   echo_green "\$PATH Value '$path_value' found."
  # else
  #   echo_red "\$PATH Value '$path_value' not found. Ref:$path_ref"
  # fi

  # # Validate Path Value /sbin
  # path_value="/sbin"
  # path_ref="Edit your \$PATH"
  # path_search_result=${path%%$path_value*}
  # if [ "$path_search_result" != "$path" ]; then
  #   echo_green "\$PATH Value '$path_value' found."
  # else
  #   echo_red "\$PATH Value '$path_value' not found. Ref:$path_ref"
  # fi

  # # Validate Path Value /usr/bin
  # path_value="/usr/bin"
  # path_ref="Edit your \$PATH"
  # path_search_result=${path%%$path_value*}
  # if [ "$path_search_result" != "$path" ]; then
  #   echo_green "\$PATH Value '$path_value' found."
  # else
  #   echo_red "\$PATH Value '$path_value' not found. Ref:$path_ref"
  # fi

  # # Validate Path Value /usr/sbin
  # path_value="/usr/sbin"
  # path_ref="Edit your \$PATH"
  # path_search_result=${path%%$path_value*}
  # if [ "$path_search_result" != "$path" ]; then
  #   echo_green "\$PATH Value '$path_value' found."
  # else
  #   echo_red "\$PATH Value '$path_value' not found. Ref:$path_ref"
  # fi

  # # Validate Path Value /usr/local/bin
  # path_value="/usr/local/bin"
  # path_ref="Edit your \$PATH"
  # path_search_result=${path%%$path_value*}
  # if [ "$path_search_result" != "$path" ]; then
  #   echo_green "\$PATH Value '$path_value' found."
  # else
  #   echo_red "\$PATH Value '$path_value' not found. Ref:$path_ref"
  # fi

  # #required for proxy driver setup
  # path_value="/Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home"
  # path_ref="Install a JRE and edit your \$JAVA_HOME"
  # path_search_result=${JAVA_HOME}
  # if [ "$path_search_result" != "$path" ]; then
  #   echo_green "\$JAVA_HOME Value '$path_value' found."
  # else
  #   echo_red "\$JAVA_HOME Value '$path_value' not found. $path_ref"
  # fi

  # echo

  # Validate Required Directories
  # echo "Validate Required Directories"
  # echo "------------------------------------"
  # dir="/bin" && [ -d $dir ] && echo_green "Directory '$dir' exists." || echo_red "Directory '$dir' does not exists. (Error)" # Validate directory exists /bin 
  # dir="/sbin" && [ -d $dir ] && echo_green "Directory '$dir' exists." || echo_red "Directory '$dir' does not exists. (Error)" # Validate directory exists /sbin 
  # dir="/usr/bin" && [ -d $dir ] && echo_green "Directory '$dir' exists." || echo_red "Directory '$dir' does not exists. (Error)" # Validate directory exists /usr/bin
  # dir="/usr/sbin" && [ -d $dir ] && echo_green "Directory '$dir' exists." || echo_red "Directory '$dir' does not exists. (Error)" # Validate directory exists /usr/sbin
  # dir="/usr/local/bin" && [ -d $dir ] && echo_green "Directory '$dir' exists." || echo_red "Directory '$dir' does not exists. (Error)" # Validate directory exists /usr/local/bin
  # home=~ && echo_green "Directory '$home' exists"
  # dir="$home/Documents" && [ -d $dir ] && echo_green "Directory '$dir' exists." || echo_red "Directory '$dir' does not exists. (Error)" # Validate directory exists /~/Documents

  # echo

  # Validate Required Files
  echo "Validate Required Files"
  echo "------------------------------------"
  # file="$home/.zprofile" && [ -f $file ] && echo_green "File '$file' exists." || echo_red "File '$file' does not exists please create one manually. (Error)"
  file="$home/.zshrc" && [ -f $file ] && echo_green "File '$file' exists." || echo_red "File '$file' does not exists please create one manually. (Error)"

  echo

  echo "Validate Required File Contents"
  echo "------------------------------------"
  file="$home/.zprofile"
  file_contents=$(cat $file)
  needed_path="export PATH=\"/opt/homebrew/bin:\$PATH\""

  if [[ $file_contents == $needed_path ]]; then
    echo_green "File '$file' has the correct contents '$file_contents'."
  else
    echo_red "File '$file' does not have the contents '$file_contents' added, please add '$needed_path' to file."
  fi

  echo

  # Validate Required Applications
  echo "Validate Required Applications"
  echo "------------------------------------"

  # # Check and install Homebrew if not installed
  # app_name="Homebrew"
  # app_ref="https://brew.sh/"
  # app_loc="$(command -v brew)"
  # if [[ $app_loc != "" ]]; then
  #   app_ver="$(brew --version)"
  #   echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc' - $app_ref"
  # else
  #   echo_red "Application '$app_name' not installed. Ref:$app_ref"
  #   read -p "Do you want to install $app_name? (y/n) " -n 1 -r
  #   echo    # move to a new line
  #   if [[ $REPLY =~ ^[Yy]$ ]]
  #   then
  #     echo "Installing $app_name..."
  #     /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
  #     echo 'Adding Homebrew to shell environment...'
  #     echo 'eval "$(/opt/homebrew/bin/brew shellenv)"' >> ~/.zprofile
  #     echo 'eval "$(/opt/homebrew/bin/brew shellenv)"'
  #   fi
  # fi

  # # Check and install bash
  # app_name="bash"
  # app_ref="https://formulae.brew.sh/formula/bash"
  # app_installed="$(brew info $app_name | grep 'Not installed' > /dev/null && echo '' || echo 'Installed')" # Check if application is installed using a more advanced approach.
  # if [[ $app_installed != "" ]]; then
  #   app_ver="$(brew list --versions $app_name)"
  #   app_loc="$(brew --prefix $app_name)"
  #   echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'"
  # else
  #   echo_red "Application '$app_name' not installed. Ref:$app_ref"
  #   read -p "Do you want to install $app_name? (y/n) " -n 1 -r
  #   echo    # move to a new line
  #   if [[ $REPLY =~ ^[Yy]$ ]]
  #   then
  #     # Install application
  #     echo "Installing $app_name..."
  #     brew install $app_name # (--cask not required)

  #     # Update the default shell
  #     echo 'Updating default shell to reflect updated BASH...'
  #     echo 'export PATH="/usr/local/opt/'"$app_name"':$PATH"' >> ~/.zprofile # Add to ~/.zprofile

  #     # Reload the shell
  #     echo 'Reloading shell...'
  #     source ~/.zprofile
  #     echo "BASH has been installed to the latest version."
  #   fi
  # fi

  # # Check and install openjdk@21 if not installed
  # app_name="openjdk@21"
  # app_ref="https://formulae.brew.sh/formula/openjdk#default"
  # app_installed="$(brew info $app_name | grep 'Not installed' > /dev/null && echo '' || echo 'Installed')" # Check if application is installed using a more advanced approach.
  # if [[ $app_installed != "" ]]; then
  #   app_ver="$(brew list --versions $app_name)"
  #   app_loc="$(brew --prefix $app_name)"
  #   echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'"
  # else
  #   echo_red "Application '$app_name' not installed. Ref:$app_ref"
  #   read -p "Do you want to install $app_name? (y/n) " -n 1 -r
  #   echo    # move to a new line
  #   if [[ $REPLY =~ ^[Yy]$ ]]
  #   then
  #     # Install application
  #     echo "Installing $app_name..."
  #     brew install $app_name # (--cask not required)

  #     # Update environment variable
  #     echo 'Updating environment variable JAVA_HOME...'
  #     echo 'export JAVA_HOME="$(brew --prefix '"$app_name"')"' >> ~/.zprofile # Add JAVA_HOME to ~/.zprofile

  #     # Reload the shell
  #     echo 'Reloading shell...'
  #     source ~/.zprofile
  #     echo "Updated environment variable JAVA_HOME = $JAVA_HOME"
  #   fi
  # fi

  # # Check and install speedtest-cli if not installed
  # app_name="speedtest-cli"
  # app_ref="https://formulae.brew.sh/formula/speedtest-cli"
  # app_installed="$(brew list --formula | grep $app_name)" # Check if application is installed
  # if [[ $app_installed != "" ]]; then
  #   app_ver="$(brew list --versions $app_name)"
  #   app_loc="$(brew --prefix $app_name)"
  #   echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'"
  # else
  #   echo_red "Application '$app_name' not installed. Ref:$app_ref"
  #   read -p "Do you want to install $app_name? (y/n) " -n 1 -r
  #   echo    # move to a new line
  #   if [[ $REPLY =~ ^[Yy]$ ]]
  #   then
  #     # Install application
  #     echo "Installing $app_name..."
  #     brew install $app_name # Install application
  #   fi
  # fi

  # # Check and install eclipse-java (--cask) if not installed
  # app_name="eclipse-java"
  # app_ref="https://formulae.brew.sh/cask/eclipse-java"
  # app_installed="$(brew list --cask | grep $app_name)" # Check if application is installed (using --cask)
  # if [[ $app_installed != "" ]]; then
  #   app_ver="$(brew list --cask --version eclipse-java)" # Get application version (using --cask)
  #   app_loc="$(brew list --cask $app_name)" # Get application location (using --cask)
  #   echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'"
  # else
  #   echo_red "Application '$app_name' not installed. Ref:$app_ref"
  #   read -p "Do you want to install $app_name? (y/n) " -n 1 -r
  #   echo    # move to a new line
  #   if [[ $REPLY =~ ^[Yy]$ ]]
  #   then
  #     # Install application
  #     echo "Installing $app_name..."
  #     brew install --cask $app_name # Install application (using --cask)
  #   fi
  # fi

  # # Check and install maven if not installed
  # app_name="maven"
  # app_ref="https://formulae.brew.sh/formula/maven"
  # app_installed="$(brew list --formula | grep $app_name)" # Check if application is installed
  # if [[ $app_installed != "" ]]; then
  #   app_ver="$(brew list --versions $app_name)"
  #   app_loc="$(brew --prefix $app_name)"
  #   echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'"
  # else
  #   echo_red "Application '$app_name' not installed. Ref:$app_ref"
  #   read -p "Do you want to install $app_name? (y/n) " -n 1 -r
  #   echo    # move to a new line
  #   if [[ $REPLY =~ ^[Yy]$ ]]
  #   then
  #     # Install application
  #     echo "Installing $app_name..."
  #     brew install $app_name # Install application
  #   fi
  # fi

  # # Check and install allure if not installed
  # app_name="allure"
  # app_ref="https://formulae.brew.sh/formula/allure"
  # app_installed="$(brew list --formula | grep $app_name)" # Check if application is installed
  # if [[ $app_installed != "" ]]; then
  #   app_ver="$(brew list --versions $app_name)"
  #   app_loc="$(brew --prefix $app_name)"
  #   echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'"
  # else
  #   echo_red "Application '$app_name' not installed. Ref:$app_ref"
  #   read -p "Do you want to install $app_name? (y/n) " -n 1 -r
  #   echo    # move to a new line
  #   if [[ $REPLY =~ ^[Yy]$ ]]
  #   then
  #     # Install application
  #     echo "Installing $app_name..."
  #     brew install $app_name # Install application
  #   fi
  # fi

  # # Check and install google-chrome (--cask) if not installed
  # app_name="google-chrome"
  # app_ref="https://formulae.brew.sh/cask/google-chrome"
  # app_installed="$(brew list --cask | grep $app_name)" # Check if application is installed (using --cask)
  # if [[ $app_installed != "" ]]; then
  #   app_ver="$(brew list --cask --version eclipse-java)" # Get application version (using --cask)
  #   app_loc="$(brew list --cask $app_name)" # Get application location (using --cask)
  #   echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'"
  # else
  #   echo_red "Application '$app_name' not installed. Ref:$app_ref"
  #   read -p "Do you want to install $app_name? (y/n) " -n 1 -r
  #   echo    # move to a new line
  #   if [[ $REPLY =~ ^[Yy]$ ]]
  #   then
  #     # Install application
  #     echo "Installing $app_name..."
  #     brew install --cask $app_name # Install application (using --cask)

  #     # Remove quarantine attribute
  #     echo_green "Removing quarantine for '$app_name'..."
  #     xattr -d com.apple.quarantine /Applications/Google\ Chrome.app
  #   fi
  # fi

  # # Check and install chromedriver (--cask) if not installed
  # app_name="chromedriver"
  # app_ref="https://formulae.brew.sh/cask/chromedriver"
  # app_installed="$(brew list --cask | grep $app_name)" # Check if application is installed (using --cask)
  # if [[ $app_installed != "" ]]; then
  #   app_ver="$(brew list --cask --version eclipse-java)" # Get application version (using --cask)
  #   app_loc="$(brew list --cask $app_name)" # Get application location (using --cask)
  #   echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'"
  # else
  #   echo_red "Application '$app_name' not installed. Ref:$app_ref"
  #   read -p "Do you want to install $app_name? (y/n) " -n 1 -r
  #   echo    # move to a new line
  #   if [[ $REPLY =~ ^[Yy]$ ]]
  #   then
  #     # Install application
  #     echo "Installing $app_name..."
  #     brew install --cask $app_name # Install application (using --cask)

  #     # Remove quarantine attribute
  #     echo_green "Removing quarantine for '$app_name'..."
  #     xattr -d com.apple.quarantine /usr/local/bin/chromedriver
  #   fi
  # fi

  app_name="zsh - Terminal Shell"
  app_ref="https://www.sitepoint.com/zsh-tips-tricks/"
  app_loc="$(command -v zsh)"
  app_ver="$(command zsh --version)"
  if [[ $app_loc != "" ]]; then
    echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'"
  else
    echo_red "Application '$app_name' not installed. Ref:$app_ref"
  fi

  app_name="ohmyzsh - Terminal Shell Enhancement"
  app_ref="https://ohmyz.sh/"
  app_loc="$HOME/.zshrc"
  if [[ -f $app_loc ]]; then
    echo_green "Application '$app_name' installed at '$app_loc'"
  else
    echo_red "Application '$app_name' not installed. Ref:$app_ref"
  fi

  echo
  # Validate Required Language(s)
  echo "Validate Required Language(s)"
  echo "------------------------------------"

  lang_name="Java"
  lang_ref="https://docs.oracle.com/goldengate/1212/gg-winux/GDRAD/java.htm#BGBFJHAB"
  lang_loc="$(command which java)"
  lang_ver="$(command java -version)"
  if [[ $lang_loc != "" ]]; then
    echo_green "Language '$lang_name' version '$lang_ver' installed at '$lang_loc'"
  else
    echo_red "Language '$lang_name' not installed. Please install Ref:$lang_ref"
  fi

  echo
  # Validate Operating System Version
  echo "Validate Operating System Version"
  echo "------------------------------------"

  mac_model=$(sysctl -n hw.model)
  echo_yellow "Mac model: $mac_model | Lookup Here: https://support.apple.com/en-us/102869"

  cpu_info=$(sysctl -n machdep.cpu.brand_string)
  echo_yellow "CPU: $cpu_info"

  total_ram=$(sysctl -n hw.memsize)
  total_ram_in_gb=$(echo "scale=2; $total_ram/(1024^3)" | bc)
  echo_yellow "Total RAM: $total_ram_in_gb GB"

  app_name="Mac OS"
  app_ref="https://www.digitalcitizen.life/macos-version"
  app_ver="$(command sw_vers -productVersion)"
  echo_yellow "Mac OS Version: $app_ver"

  last_update=$(softwareupdate --history | head -2 | tail -1 | awk '{print $1 " " $2 " " $3}')
  echo_yellow "Mac OS last updated: $last_update"

  total_storage=$(df -h / | awk 'NR==2{print $2}')
  main_storage_free=$(df -h / | awk 'NR==2{print $4}')
  main_storage_usage=$(df -h / | awk 'NR==2{print $3}')

  echo_yellow "Storage: $total_storage | Free: $main_storage_free | Used: $main_storage_usage"

  echo
  # Validate Internet Speed
  echo "Validate Internet Speed"
  echo "------------------------------------"

  # Check if speedtest-cli is installed
  if ! command -v speedtest-cli > /dev/null; then
    echo_red "speedtest-cli is not installed. Install it with 'pip install speedtest-cli'"
    exit 1
  fi

  # Run speed test and capture output
  speed_test=$(speedtest-cli --simple)

  # Print speed test result
  echo_yellow "Speed Test Result:"
  echo "$speed_test"

fi
# ============================================================= Install - End =================================================================
# =============================================================================================================================================

# =============================================================================================================================================
# ============================================================= Uninstall - Begin =============================================================
if [ "$action" = "u" ]; then

  # # Check and uninstall Speedtest-CLI if it is installed
  # app_name="Speedtest-CLI"
  # app_ref="https://formulae.brew.sh/formula/speedtest-cli"
  # app_loc="$(brew list --version speedtest-cli)"
  # if [[ $app_loc != "" ]]; then
  #   app_ver="$(brew list --version speedtest-cli)"
  #   echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'"
  #   echo_green "Uninstalling $app_name..."
  #   brew uninstall speedtest-cli
  #   echo_green "Application '$app_name' uninstalled"
  # else
  #   echo_green "Application '$app_name' not installed."
  # fi

  # # Check and uninstall Eclipse IDE if it is installed
  # app_name="Eclipse IDE"
  # app_ref="https://formulae.brew.sh/cask/eclipse-java"
  # app_loc="$(brew list --cask --version eclipse-java)"
  # if [[ $app_loc != "" ]]; then
  #   app_ver="$(brew list --cask --version eclipse-java)"
  #   echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'"
  #   echo_green "Uninstalling $app_name..."
  #   brew uninstall --cask eclipse-java
  #   echo_green "Application '$app_name' uninstalled"
  # else
  #   echo_green "Application '$app_name' not installed."
  # fi

  # # Check and uninstall Allure if it is installed
  # app_name="allure"
  # app_ref="https://formulae.brew.sh/formula/allure"
  # app_loc="$(brew list --version allure)"
  # if [[ $app_loc != "" ]]; then
  #   app_ver="$(brew list --version mavallureen)"
  #   echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'"
  #   echo_green "Uninstalling $app_name..."
  #   brew uninstall allure
  #   echo_green "Application '$app_name' uninstalled"
  # else
  #   echo_green "Application '$app_name' not installed."
  # fi

  # # Check and uninstall Maven if it is installed
  # app_name="Maven"
  # app_ref="https://formulae.brew.sh/formula/maven"
  # app_loc="$(brew list --version maven)"
  # if [[ $app_loc != "" ]]; then
  #   app_ver="$(brew list --version maven)"
  #   echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'"
  #   echo_green "Uninstalling $app_name..."
  #   brew uninstall maven
  #   echo_green "Application '$app_name' uninstalled"
  # else
  #   echo_green "Application '$app_name' not installed."
  # fi

  # # Check and uninstall Chromedriver if it is installed
  # app_name="ChromeDriver"
  # app_ref="https://formulae.brew.sh/cask/chromedriver"
  # app_loc="$(brew list --cask --version chromedriver)"
  # if [[ $app_loc != "" ]]; then
  #   app_ver="$(brew list --cask --version chromedriver)"
  #   echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'"
  #   echo_green "Uninstalling $app_name..."
  #   brew uninstall --cask chromedriver
  #   echo_green "Application '$app_name' uninstalled"
  # else
  #   echo_green "Application '$app_name' not installed."
  # fi

  # # Check and uninstall Google Chrome if it is installed
  # app_name="Google Chrome"
  # app_loc="$(brew list --cask --version google-chrome)"
  # if [[ $app_loc != "" ]]; then
  #   app_ver="$(brew list --cask --version google-chrome)"
  #   echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'"
  #   echo_green "Uninstalling $app_name..."
  #   brew uninstall --cask google-chrome
  #   echo_green "Application '$app_name' uninstalled"
  # else
  #   echo_green "Application '$app_name' not installed."
  # fi

  # # Check and uninstall openjdk@21 if it is installed
  # app_name="openjdk@21"
  # app_ref="https://formulae.brew.sh/formula/openjdk#default"
  # app_installed="$(brew info $app_name | grep 'Not installed' > /dev/null && echo '' || echo 'Installed')" # Check if application is installed using a more advanced approach.
  # if [[ $app_installed != "" ]]; then
  #   app_ver="$(brew list --versions $app_name)"
  #   app_loc="$(brew --prefix $app_name)"
  #   echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'"

  #   # Uninstall application
  #   echo_green "Uninstalling $app_name..."
  #   brew uninstall $app_name
  #   echo_green "Application '$app_name' uninstalled"

  #   # Removing environment variable
  #   echo 'Updating environment variable JAVA_HOME ...'
  #   sed -i '' '/export JAVA_HOME="$(brew --prefix '"$app_name"')"/d' ~/.zprofile

  #   # Reload the shell
  #   echo 'Reloading shell...'
  #   source ~/.zprofile
  #   echo "Updated environment variable JAVA_HOME = $JAVA_HOME"
  # else
  #   echo_green "Application '$app_name' not installed."
  # fi

  # # Check and uninstall BASH if it is installed
  # app_name="bash"
  # app_ref="https://formulae.brew.sh/formula/bash"
  # app_installed="$(brew info $app_name | grep 'Not installed' > /dev/null && echo '' || echo 'Installed')" # Check if application is installed using a more advanced approach.
  # if [[ $app_installed != "" ]]; then
  #   app_ver="$(brew list --versions $app_name)"
  #   app_loc="$(brew --prefix $app_name)"
  #   echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'"

  #   # Uninstall application
  #   echo_green "Uninstalling $app_name..."
  #   brew uninstall $app_name
  #   echo_green "Application '$app_name' uninstalled"

  #   # Removing environment variable
  #   echo 'Updating environment variable JAVA_HOME ...'
  #   sed -i '' 'export PATH="/usr/local/opt/'"$app_name"':$PATH"' ~/.zprofile

  #   # Reload the shell
  #   echo 'Reloading shell...'
  #   source ~/.zprofile
  #   echo "BASH has been uninstall and restored to the default version."
  # else
  #   echo_green "Application '$app_name' not installed."
  # fi

fi
# ============================================================= Uninstall - End =============================================================
# =============================================================================================================================================

echo
echo "================================================"
echo "=            $(date +"%m-%d-%Y %I:%M:%S %p")            ="
echo "= Automation Configurator for Java - Completed ="
echo "================================================"
echo

# ================== Configuration Checking (End) ==================

# Helpful Links

# Shell introduction
# https://developer.apple.com/library/archive/documentation/OpenSource/Conceptual/ShellScripting/shell_scripts/shell_scripts.html

# Shell Terminal Commands:
# https://www.makeuseof.com/tag/mac-terminal-commands-cheat-sheet/

# BASH String Commands
# https://landoflinux.com/linux_bash_scripting_substring_tests.html
# https://linuxize.com/post/bash-functions/

# Directory Exist:
# https://www.cyberciti.biz/faq/howto-check-if-a-directory-exists-in-a-bash-shellscript/

# Mac Home Dir:
# https://stackoverflow.com/questions/11161793/mac-shell-script-get-home-directory

# Homebrew:
# https://dev.to/code2bits/homebrew---basics--cheatsheet-3a3n
# https://stackoverflow.com/questions/21577968/how-to-tell-if-homebrew-is-installed-on-mac-os-x

# How to change colors:
# https://stackoverflow.com/questions/5947742/how-to-change-the-output-color-of-echo-in-linux

# Ansible:
# https://opensource.com/article/18/3/manage-workstation-ansible
# https://intellipaat.com/blog/tutorial/devops-tutorial/ansible-tutorial/

# https://www.plugin-dev.com/plugins/bashsupport/

# https://kb.iu.edu/d/admm
