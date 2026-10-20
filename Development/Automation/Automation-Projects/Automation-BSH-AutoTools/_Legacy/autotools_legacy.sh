#!/bin/bash
# autotools.sh - Automation Tools
# -------------------------------------------------------

clear # Clear the terminal

# ================== Common Functions ==================
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )" # Get current script path
source "$SCRIPT_DIR/framework/common/color_functions.sh" # Include color functions

echo_orange
echo_orange "================================================"
echo_orange "=              AutoTools - Begin               ="
echo_orange "=            $(date +"%m-%d-%Y %I:%M:%S %p")            ="
echo_orange "================================================"

source "$SCRIPT_DIR/framework/common/parameter_checks.sh" # Parameter check and user prompts

# =============================================================================================================================================
# ======================================================== Info - Begin =======================================================================

source framework/scripts/info_user.sh # User Info

# ======================================================== Info - End =========================================================================
# =============================================================================================================================================

echo_orange
echo_orange "================================================"
echo_orange "=            $(date +"%m-%d-%Y %I:%M:%S %p")            ="
echo_orange "=            AutoTools - Completed             ="
echo_orange "================================================"
echo_orange
