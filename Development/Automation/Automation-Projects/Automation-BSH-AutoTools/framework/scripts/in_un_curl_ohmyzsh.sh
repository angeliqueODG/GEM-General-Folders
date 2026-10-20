# ================== Common Functions ==================
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )" # Get current script path
source "$SCRIPT_DIR/../common/color_functions.sh" # Include color functions
source "$SCRIPT_DIR/../common/parameter_checks.sh" # Parameter check and user prompts

# =============================================================================================================================================
# ============================================================== Oh-My-Zsh - Begin =============================================================

app_name="Oh-My-Zsh"
app_ref="https://ohmyz.sh/"
app_installed="$( [ -d ~/.oh-my-zsh ] && echo 'Installed' || echo '')" # Application installed?

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
    sh -c "$(curl -fsSL https://raw.github.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
    echo_green "Application '$app_name' installed"

    # Confirmation
    app_ver="$(zsh --version)"
    app_loc="$(command -v zsh)"
    echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'."
  else
    app_ver="$(zsh --version)"
    app_loc="$(command -v zsh)"
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
    rm -rf ~/.oh-my-zsh
    echo_green "Application '$app_name' uninstalled"

    # Update the default shell
    echo_green 'Updating default shell to reflect changes'
    # Udate for Intel Macs
    if [[ "$(uname -m)" == "x86_64" ]]; then
      sed -i '' '/export ZSH="$HOME\/.oh-my-zsh"/d' ~/.zshrc
      sed -i '' '/source $ZSH/.oh-my-zsh"/d' ~/.zshrc
    # Udate for M1+ Macs
    elif [[ "$(uname -m)" == "arm64" ]]; then
      sed -i '' '/export ZSH="$HOME\/.oh-my-zsh"/d' ~/.zshrc
      sed -i '' '/source $ZSH/.oh-my-zsh"/d' ~/.zshrc
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

# ============================================================== Oh-My-Zsh - End ===============================================================
# =============================================================================================================================================