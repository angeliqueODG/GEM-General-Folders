#!/bin/bash
# auto_config.sh - Automation Configuration Checker
# -------------------------------------------------------

clear # Clear the terminal

# ================== Common Functions ==================
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )" # Get current script path
source "$SCRIPT_DIR/framework/common/color_functions.sh" # Include color functions

echo_orange
echo_orange "================================================"
echo_orange "=   Configurator for Java Automation - Begin   ="
echo_orange "=            $(date +"%m-%d-%Y %I:%M:%S %p")            ="
echo_orange "================================================"

source "$SCRIPT_DIR/framework/common/parameter_checks.sh" # Parameter check and user prompts


# =============================================================================================================================================
# ======================================================== Info - Begin =======================================================================

source framework/scripts/info_user.sh # User Info

# ======================================================== Info - End =========================================================================
# =============================================================================================================================================


# =============================================================================================================================================
# ======================================================== PATH - Begin =======================================================================

source framework/scripts/path_overall.sh # Overall PATH Info
source framework/scripts/path_search_bin.sh # PATH search /bin
source framework/scripts/path_search_sbin.sh # PATH search /sbin
source framework/scripts/path_search_usr_bin.sh # PATH search /usr/bin
source framework/scripts/path_search_usr_sbin.sh # PATH search /usr/sbin
source framework/scripts/path_search_usr_local_bin.sh # PATH search /usr/local/bin

# ======================================================== PATH - End =========================================================================
# =============================================================================================================================================


# =============================================================================================================================================
# ======================================================== Directory - Begin ==================================================================

source framework/scripts/dir_search_bin.sh # Directory search /bin
source framework/scripts/dir_search_sbin.sh # Directory search /sbin
source framework/scripts/dir_search_usr_bin.sh # Directory search /usr/bin
source framework/scripts/dir_search_usr_sbin.sh # Directory search /usr/sbin
source framework/scripts/dir_search_usr_local_bin.sh # Directory search /usr/local/bin
source framework/scripts/dir_search_home_documents.sh # Directory search $home/Documents
source framework/scripts/dir_search_home_documents_development.sh # Directory search $home/Documents/Development
source framework/scripts/dir_search_home_documents_development_automation.sh # Directory search $home/Documents/Development/Automation
source framework/scripts/dir_search_home_documents_development_automation_automation-projects.sh # Directory search $home/Documents/Development/Automation/Automation-Projects

# ======================================================== Directory - End ====================================================================
# =============================================================================================================================================


# =============================================================================================================================================
# ======================================================== Applications - Begin ===============================================================

# Install applications?
if [ "$action" = "i" ]; then
    source framework/scripts/in_un_curl_homebrew.sh # Homebrew - Install/Uninstall
    source framework/scripts/in_un_brew_bash.sh # BASH - Install/Uninstall
    source framework/scripts/in_un_brew_allure.sh # Allure - Install/Uninstall
    source framework/scripts/in_un_brew_maven.sh # Maven - Install/Uninstall
    source framework/scripts/in_un_brew_cask_eclipse-java.sh # Eclipse - Install/Uninstall
    source framework/scripts/in_un_brew_openjdk21.sh # OpenJDK21 - Install/Uninstall
    source framework/scripts/in_un_brew_speedtest-cli.sh # SpeedTest-CLI - Install/Uninstall
    source framework/scripts/in_un_brew_cask_google-chrome.sh # Google Chrome - Install/Uninstall
    source framework/scripts/in_un_brew_cask_chromedriver.sh # ChromeDriver - Install/Uninstall
    source framework/scripts/in_un_brew_nodejs.sh # NodeJS - Install/Uninstall
    source framework/scripts/in_un_npm_electron.sh # Electron - Install/Uninstall
    source framework/scripts/in_un_npm_electron-builder.sh # Electron-Builder - Install/Uninstall
fi

# Uninstall applications?
if [ "$action" = "u" ]; then
    source framework/scripts/in_un_npm_electron-builder.sh # Electron-Builder - Install/Uninstall
    source framework/scripts/in_un_npm_electron.sh # Electron - Install/Uninstall
    source framework/scripts/in_un_brew_nodejs.sh # NodeJS - Install/Uninstall
    source framework/scripts/in_un_brew_cask_chromedriver.sh # ChromeDriver - Install/Uninstall
    source framework/scripts/in_un_brew_cask_google-chrome.sh # Google Chrome - Install/Uninstall
    source framework/scripts/in_un_brew_speedtest-cli.sh # SpeedTest-CLI - Install/Uninstall
    source framework/scripts/in_un_brew_openjdk21.sh # OpenJDK21 - Install/Uninstall
    source framework/scripts/in_un_brew_cask_eclipse-java.sh # Eclipse - Install/Uninstall
    source framework/scripts/in_un_brew_maven.sh # Maven - Install/Uninstall
    source framework/scripts/in_un_brew_allure.sh # Allure - Install/Uninstall
    source framework/scripts/in_un_brew_bash.sh # BASH - Install/Uninstall
    source framework/scripts/in_un_curl_homebrew.sh # Homebrew - Install/Uninstall
fi

# ======================================================== Applications - End =================================================================
# =============================================================================================================================================

echo_orange
echo_orange "================================================"
echo_orange "=            $(date +"%m-%d-%Y %I:%M:%S %p")            ="
echo_orange "= Configurator for Java Automation - Completed ="
echo_orange "================================================"
echo_orange
