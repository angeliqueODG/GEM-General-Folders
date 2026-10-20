# ================== Common Functions ==================
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )" # Get current script path
source "$SCRIPT_DIR/../common/color_functions.sh" # Include color functions
source "$SCRIPT_DIR/../common/parameter_checks.sh" # Parameter check and user prompts

# =============================================================================================================================================
# ============================================================== $USER - Begin =================================================================

system_info="\$USER"
system_ref=""
system_result=$USER

# Inform the user about the installation
echo_blue
echo_blue "------------------------------------------------------------"
echo_blue "System information about '$system_info'..."
echo_yellow "$system_info '$system_result'"
echo_blue "------------------------------------------------------------"
echo_blue

# ============================================================== $USER - End ===================================================================
# =============================================================================================================================================