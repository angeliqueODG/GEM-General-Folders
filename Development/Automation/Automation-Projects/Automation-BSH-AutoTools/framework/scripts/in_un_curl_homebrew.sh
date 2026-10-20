# ================== Common Functions ==================
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )" # Get current script path
source "$SCRIPT_DIR/../common/color_functions.sh" # Include color functions
source "$SCRIPT_DIR/../common/parameter_checks.sh" # Parameter check and user prompts

# =============================================================================================================================================
# ============================================================== Homebrew - Begin =============================================================

app_name="Homebrew"
app_ref="https://brew.sh/"
app_installed="$(command -v brew > /dev/null && echo 'Installed' || echo '')" # Application installed?

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
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
    echo_green "Application '$app_name' installed"

    # Update .zshrc
    echo_green 'Updating shell .zshrc to reflect changes'
    # Udate for Intel Macs
    if [[ "$(uname -m)" == "x86_64" ]]; then
      if ! grep -q 'eval "$(/usr/local/Homebrew/bin/brew shellenv)"' ~/.zshrc ; then
        echo 'eval "$(/usr/local/Homebrew/bin/brew shellenv)"' >> ~/.zshrc # Add to ~/.zshrc
        echo_green ".zshrc updated"
      else
        echo_green ".zshrc already contains 'eval $\(/usr/local/Homebrew/bin/brew shellenv)'"
      fi
    # Udate for M1+ Macs
    elif [[ "$(uname -m)" == "arm64" ]]; then
      if ! grep -q 'eval "$(/opt/homebrew/bin/brew shellenv)"' ~/.zshrc ; then
        echo 'eval "$(/opt/homebrew/bin/brew shellenv)"' >> ~/.zshrc # Add to ~/.zshrc
        echo_green ".zshrc updated"
      else
        echo_green ".zshrc already contains 'eval $\(/opt/homebrew/bin/brew shellenv)'"
      fi
    fi
    echo_green 'Updated shell .zshrc to reflect changes'

    # Reload the shell
    echo_green 'Reloading shell...'
    source ~/.bashrc
    echo_green "Shell reloaded"

    # Confirmation
    app_ver="$(brew --version)"
    app_loc="$(command -v brew)"
    echo_green "Application '$app_name' version '$app_ver' installed at '$app_loc'."
  else
    app_ver="$(brew --version)"
    app_loc="$(command -v brew)"
    echo_blue
    echo_blue "------------------------------------------------------------"
    echo_blue "Preparing to install '$app_name'..."
    echo_yellow "Application '$app_name' version '$app_ver' already installed at '$app_loc'. No action taken."
  fi
  echo_blue "------------------------------------------------------------"
}

uninstall_app_with_verify() {
  # Check if app is already uninstalled
  if [[ $app_installed != "" ]]; then

    # Inform the user about the criticality of uninstallation
    echo_blue
    echo_blue "------------------------------------------------------------"
    echo_blue "Preparing to uninstall '$app_name'..."
    echo_blue

    # Verify uninstallation
    echo_yellow "You are about to uninstall '$app_name' which may cause dependency issues."
    echo_yellow "If you are sure you want to uninstall, type 'approve' within 60 seconds to proceed."
    read -t 60 -p "Approve uninstallation: " input
    if [[ $input == "approve" ]]; then
      echo_green "Uninstalling '$app_name'..."
      /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/uninstall.sh)"
      echo_green "Application '$app_name' uninstalled."
    else
      echo_red "Uninstallation of '$app_name' will not be performed."
    fi
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
    uninstall_app_with_verify
  elif [ "$action_mode" = "p" ]; then
    read -p "Choose selection - Uninstall $app_name? Yes (Y), No (N), or Exit (X): " -n 1 -r action_mode_response
    echo    # move to a new line
    if [[ $action_mode_response =~ ^[Xx]$ ]]; then
      exit
    elif [[ $action_mode_response =~ ^[Yy]$ ]]; then
      uninstall_app_with_verify
    else
      # Skip uninstallation
      echo_yellow "Skipping uninstallation of $app_name."
    fi
  fi

fi

# ============================================================== Homebrew - End ===============================================================
# =============================================================================================================================================