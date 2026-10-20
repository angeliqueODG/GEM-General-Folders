# ================== Common Functions ==================
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )" # Get current script path
source "$SCRIPT_DIR/../common/color_functions.sh" # Include color functions
source "$SCRIPT_DIR/../common/parameter_checks.sh" # Parameter check and user prompts

# =============================================================================================================================================
# ============================================================== npm package electron-builder - Begin =========================================

app_name="electron-builder"
app_ref="https://www.npmjs.com/package/electron-builder"
app_installed="$(npm list -g $app_name --depth=0 | grep 'empty' > /dev/null && echo '' || echo 'Installed')" # npm module installed?

install_app() {
  # Check if app is not already installed
  if [[ $app_installed == "" ]]; then

    # Inform the user about the installation
    echo_blue
    echo_blue "------------------------------------------------------------"
    echo_blue "Preparing to install npm module '$app_name'..."
    echo_blue

    # Install npm module
    echo_green "Installing npm module '$app_name'..."
    npm install -g $app_name
    echo_green "npm module '$app_name' installed"

    # Confirmation
    app_ver="$(npm list -g $app_name --depth=0 | grep -o "@.*" | cut -d' ' -f1 | cut -d'@' -f2)"
    app_loc="$(npm root -g)/$app_name"
    echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'."
  else
    app_ver="$(npm list -g $app_name --depth=0 | grep -o "@.*" | cut -d' ' -f1 | cut -d'@' -f2)"
    app_loc="$(npm root -g)/$app_name"
    echo_blue
    echo_blue "------------------------------------------------------------"
    echo_blue "Preparing to install npm module '$app_name'..."
    echo_yellow "npm module '$app_name' version '$app_ver' already installed at '$app_loc'. No action taken."
  fi
  echo_blue "------------------------------------------------------------"
}

uninstall_app() {
  # Check if app is already uninstalled
  if [[ $app_installed != "" ]]; then

    # Inform the user about the uninstallation
    echo_blue
    echo_blue "------------------------------------------------------------"
    echo_blue "Preparing to uninstall npm module '$app_name'..."
    echo_blue

    # Uninstall npm module
    echo_green "Uninstalling npm module '$app_name'..."
    npm uninstall -g $app_name
    echo_green "npm module '$app_name' uninstalled"

  else
    echo_blue
    echo_blue "------------------------------------------------------------"
    echo_blue "Preparing to uninstall npm module '$app_name'..."
    echo_yellow "npm package '$app_name' is not installed. No action taken."
  fi
  echo_blue "------------------------------------------------------------"
}

# Install application?
if [ "$action" = "i" ]; then

  if [ "$action_mode" = "a" ]; then
    install_app
  elif [ "$action_mode" = "p" ]; then
    read -p "Choose selection - Install $app_name? Yes (Y), No (N), or Exit (X): " -n 1 -r action_mode_response
    echo    # move to a new line
    if [[ $action_mode_response =~ ^[Xx]$ ]]; then
      exit
    elif [[ $action_mode_response =~ ^[Yy]$ ]]; then
      install_app
    else
      # Skip installation
      echo_yellow "Skipping installation of $app_name."
    fi
  fi

# Uninstall application?
else

  if [ "$action_mode" = "a" ]; then
    uninstall_app
  elif [ "$action_mode" = "p" ]; then
    read -p "Choose selection - Uninstall $app_name? Yes (Y), No (N), or Exit (X): " -n 1 -r action_mode_response
    echo    # move to a new line
    if [[ $action_mode_response =~ ^[Xx]$ ]]; then
      exit
    elif [[ $action_mode_response =~ ^[Yy]$ ]]; then
      uninstall_app
    else
      # Skip uninstallation
      echo_yellow "Skipping uninstallation of $app_name."
    fi
  fi

fi

# ============================================================== npm package electron-builder - End ===========================================
# =============================================================================================================================================