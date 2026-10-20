# ================== Common Functions ==================
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )" # Get current script path
source "$SCRIPT_DIR/../common/color_functions.sh" # Include color functions
source "$SCRIPT_DIR/../common/parameter_checks.sh" # Parameter check and user prompts

# =============================================================================================================================================
# ============================================================== OpenJDK21 - Begin ============================================================

app_name="openjdk@21"
app_ref="https://formulae.brew.sh/formula/openjdk#default"
app_installed="$(brew info $app_name | grep 'Not installed' > /dev/null && echo '' || echo 'Installed')" # Application installed?

install_app() {
  # Check if app is not already installed
  if [[ $app_installed == "" ]]; then

    # Inform the user about the installation
    echo_blue
    echo_blue "------------------------------------------------------------"
    echo_blue "Preparing to install '$app_name'..."
    echo_blue

    # Install application
    echo_green "Installing '$app_name'..."
    brew install "$app_name" # (--cask not required)
    echo_green "Application '$app_name' installed"

    # Update the default shell
    echo_green 'Updating default shell to reflect changes'
    echo 'export JAVA_HOME="$(brew --prefix '"$app_name"')"' >> ~/.zprofile # Add to ~/.zprofile
    echo_green "Default shell updated"

    # Reload the shell
    echo_green 'Reloading shell...'
    source ~/.zprofile
    echo_green "Shell reloaded"

    # Confirmation
    app_ver="$(brew list --versions $app_name)"
    app_loc="$(brew --prefix $app_name)"
    echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'."
  else
    app_ver="$(brew list --versions $app_name)"
    app_loc="$(brew --prefix $app_name)"
    echo_blue
    echo_blue "------------------------------------------------------------"
    echo_blue "Preparing to install '$app_name'..."
    echo_yellow "Application '$app_name' version '$app_ver' already installed at '$app_loc'. No action taken."
  fi
  echo_blue "------------------------------------------------------------"
}

uninstall_app() {
  # Check if app is already uninstalled
  if [[ $app_installed != "" ]]; then

    # Inform the user about the uninstallation
    echo_blue
    echo_blue "------------------------------------------------------------"
    echo_blue "Preparing to uninstall '$app_name'..."
    echo_blue

    # Uninstall application
    echo_green "Uninstalling '$app_name'..."
    brew uninstall "$app_name"
    echo_green "Application '$app_name' uninstalled"

    # Update the default shell
    echo_green 'Updating default shell to reflect changes'
    sed -i '' '/export JAVA_HOME="$(brew --prefix '"$app_name"')"/d' ~/.zprofile
    echo_green "Default shell updated"

    # Reload the shell
    echo_green 'Reloading shell...'
    source ~/.zprofile
    echo_green "Shell reloaded"

    # Confirmation
    echo_green "Application '$app_name' uninstalled"
  else
    echo_blue
    echo_blue "------------------------------------------------------------"
    echo_blue "Preparing to uninstall '$app_name'..."
    echo_yellow "Application '$app_name' is not installed. No action taken."
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

# ============================================================== OpenJDK21 - End ==============================================================
# =============================================================================================================================================