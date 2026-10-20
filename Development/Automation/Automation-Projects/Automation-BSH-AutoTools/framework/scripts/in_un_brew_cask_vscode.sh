# ================== Common Functions ==================
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )" # Get current script path
source "$SCRIPT_DIR/../common/color_functions.sh" # Include color functions
source "$SCRIPT_DIR/../common/parameter_checks.sh" # Parameter check and user prompts

# =============================================================================================================================================
# ============================================================== VSCode - Begin =========================================================

app_name="visual-studio-code"
app_ref="https://formulae.brew.sh/cask/visual-studio-code"
brew_installed="$(command -v brew > /dev/null && echo 'Installed' || echo '')"
if [[ $brew_installed == "Installed" ]]; then
  app_installed="$(brew list --cask | grep $app_name)" # Application installed?
else
  app_installed=""
fi

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
    brew install --cask "$app_name" # (--cask required)
    echo_green "Application '$app_name' installed"

    # Update PATH
    echo_green 'Updating shell PATH to reflect changes'
    # Udate for Intel Macs
    if [[ "$(uname -m)" == "x86_64" ]]; then
      if ! grep -q 'export PATH="/Applications/Visual Studio Code.app/Contents/Resources/app/bin:$PATH"' ~/.zshrc ; then
        echo 'export PATH="/Applications/Visual Studio Code.app/Contents/Resources/app/bin:$PATH"' >> ~/.zshrc
        echo_green "Shell PATH updated"
      else
        echo_green "PATH already contains '/usr/local/opt/$app_name'"
      fi
    # Udate for M1+ Macs
    elif [[ "$(uname -m)" == "arm64" ]]; then
      if ! grep -q 'export PATH="/opt/homebrew/opt/'"$app_name"':$PATH"' ~/.zshrc ; then
        echo 'export PATH="$PATH:/opt/homebrew/Caskroom/visual-studio-code/latest/Visual\ Studio\ Code.app/Contents/Resources/app/bin:$PATH"' >> ~/.zshrc
        echo_green "Shell PATH updated"
      else
        echo_green "PATH already contains '/opt/homebrew/opt/$app_name'"
      fi
    fi

    # Reload the shell
    echo_green 'Reloading shell...'
    source ~/.bashrc
    echo_green "Shell reloaded"

    # Confirmation
    app_ver="$(brew list --cask --versions $app_name)"
    app_loc="$(brew list --cask $app_name)"
    echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'."
  else
    app_ver="$(brew list --cask --versions $app_name)"
    app_loc="$(brew list --cask $app_name)"
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
    brew uninstall --cask "$app_name"
    echo_green "Application '$app_name' uninstalled"

    # Update the default shell
    echo_green 'Updating default shell to reflect changes'
    # Udate for Intel Macs
    if [[ "$(uname -m)" == "x86_64" ]]; then
      sed -i '' '/export PATH="\/usr\/local\/opt\/'"$app_name"'":$PATH/d' ~/.zshrc
    # Udate for M1+ Macs
    elif [[ "$(uname -m)" == "arm64" ]]; then
      sed -i '' '/export PATH="\/opt\/homebrew\/opt\/'"$app_name"'":$PATH/d' ~/.zshrc
    fi
    echo_green "Default shell updated"

    # Reload the shell
    echo_green 'Reloading shell...'
    source ~/.bashrc
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

# ============================================================== VSCode - End ===========================================================
# =============================================================================================================================================