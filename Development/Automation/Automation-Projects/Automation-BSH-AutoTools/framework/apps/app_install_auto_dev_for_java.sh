#!/bin/bash
# auto_config.sh - Automation Configuration Checker
VERSION="1.1"
# -------------------------------------------------------

# ================== Common Variables ========================
TITLE="Auto Tools - Version $VERSION "
LANDMARK="Automation-Projects"
PROJECT_NAME="Automation-BSH-AutoTools"
SCRIPT_PATH="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )" # Get current script path
AUTOMATION_PROJECTS_PATH="${SCRIPT_PATH%%$LANDMARK*}$LANDMARK"
AUTOTOOLS_PATH="$AUTOMATION_PROJECTS_PATH/$PROJECT_NAME"

# ================== Load Functions ==================
source "$AUTOTOOLS_PATH/framework/common/color_functions.sh" # Include color functions

clear # Clear the terminal

echo_orange
echo_orange "================================================"
echo_orange "=   Configurator for Java Automation - Begin   ="
echo_orange "=            $(date +"%m-%d-%Y %I:%M:%S %p")            ="
echo_orange "================================================"

source $AUTOTOOLS_PATH/framework/common/parameter_checks.sh # Parameter check and user prompts


# =============================================================================================================================================
# ======================================================== Info - Begin =======================================================================

source $AUTOTOOLS_PATH/framework/scripts/info_user.sh # User Info

# ======================================================== Info - End =========================================================================
# =============================================================================================================================================


# =============================================================================================================================================
# ======================================================== PATH - Begin =======================================================================

source $AUTOTOOLS_PATH/framework/scripts/path_overall.sh # Overall PATH Info
source $AUTOTOOLS_PATH/framework/scripts/path_search_bin.sh # PATH search /bin
source $AUTOTOOLS_PATH/framework/scripts/path_search_sbin.sh # PATH search /sbin
source $AUTOTOOLS_PATH/framework/scripts/path_search_usr_bin.sh # PATH search /usr/bin
source $AUTOTOOLS_PATH/framework/scripts/path_search_usr_sbin.sh # PATH search /usr/sbin
source $AUTOTOOLS_PATH/framework/scripts/path_search_usr_local_bin.sh # PATH search /usr/local/bin

# ======================================================== PATH - End =========================================================================
# =============================================================================================================================================


# =============================================================================================================================================
# ======================================================== Directory - Begin ==================================================================

source $AUTOTOOLS_PATH/framework/scripts/dir_search_bin.sh # Directory search /bin
source $AUTOTOOLS_PATH/framework/scripts/dir_search_sbin.sh # Directory search /sbin
source $AUTOTOOLS_PATH/framework/scripts/dir_search_usr_bin.sh # Directory search /usr/bin
source $AUTOTOOLS_PATH/framework/scripts/dir_search_usr_sbin.sh # Directory search /usr/sbin
source $AUTOTOOLS_PATH/framework/scripts/dir_search_usr_local_libexec.sh # Directory search /usr/local/libexec
source $AUTOTOOLS_PATH/framework/scripts/dir_search_home_documents.sh # Directory search $home/Documents
source $AUTOTOOLS_PATH/framework/scripts/dir_search_home_documents_development.sh # Directory search $home/Documents/Development
source $AUTOTOOLS_PATH/framework/scripts/dir_search_home_documents_development_automation.sh # Directory search $home/Documents/Development/Automation
source $AUTOTOOLS_PATH/framework/scripts/dir_search_home_documents_development_automation_automation-projects.sh # Directory search $home/Documents/Development/Automation/Automation-Projects

# ======================================================== Directory - End ====================================================================
# =============================================================================================================================================


# =============================================================================================================================================
# ======================================================== Applications - Begin ===============================================================

# Install applications?
if [ "$action" = "i" ]; then
    source $AUTOTOOLS_PATH/framework/scripts/in_un_curl_homebrew.sh # Homebrew - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_bash.sh # BASH - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_zsh.sh # ZShell - Install/Uninstall
    #source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_zsh_syntax-highlighting.sh # ZShell - Syntax Highlighting - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_curl_ohmyzsh.sh # Oh My ZShell - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_openjdk21.sh # OpenJDK21 - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_maven.sh # Maven - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_allure.sh # Allure - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_cask_vscode.sh # Visual Studio Code - Install/Uninstall
    #source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_cask_eclipse-java.sh # Eclipse - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_speedtest-cli.sh # SpeedTest-CLI - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_cask_google-chrome.sh # Google Chrome - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_cask_chromedriver.sh # ChromeDriver - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_nodejs.sh # NodeJS - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_npm_electron.sh # Electron - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_npm_electron-builder.sh # Electron-Builder - Install/Uninstall
fi

# Uninstall applications?
if [ "$action" = "u" ]; then
    source $AUTOTOOLS_PATH/framework/scripts/in_un_npm_electron-builder.sh # Electron-Builder - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_npm_electron.sh # Electron - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_nodejs.sh # NodeJS - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_cask_chromedriver.sh # ChromeDriver - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_cask_google-chrome.sh # Google Chrome - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_speedtest-cli.sh # SpeedTest-CLI - Install/Uninstall
    #source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_cask_eclipse-java.sh # Eclipse - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_cask_vscode.sh # Visual Studio Code - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_allure.sh # Allure - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_maven.sh # Maven - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_openjdk21.sh # OpenJDK21 - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_curl_ohmyzsh.sh # Oh My ZShell - Install/Uninstall
    #source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_zsh_syntax-highlighting.sh # ZShell - Syntax Highlighting - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_zsh.sh # ZShell - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_brew_bash.sh # BASH - Install/Uninstall
    source $AUTOTOOLS_PATH/framework/scripts/in_un_curl_homebrew.sh # Homebrew - Install/Uninstall
fi

# ======================================================== Applications - End =================================================================
# =============================================================================================================================================

echo_orange
echo_orange "================================================"
echo_orange "=            $(date +"%m-%d-%Y %I:%M:%S %p")            ="
echo_orange "= Configurator for Java Automation - Completed ="
echo_orange "================================================"
echo_orange
