# ================== Common Functions ==================
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )" # Get current script path
source "$SCRIPT_DIR/../common/color_functions.sh" # Include color functions
source "$SCRIPT_DIR/../common/parameter_checks.sh" # Parameter check and user prompts

# =============================================================================================================================================
# ============================================================== PATH - Begin =================================================================

path_value="\$PATH"
path_ref=""
path_result_raw=$PATH
path_len=${#path_result_raw}

# Inform the user about the installation        
echo_blue "------------------------------------------------------------"
echo_blue "PATH information about '$path_value'..."
echo_yellow "$path_value '$path_result_raw'"
echo_yellow
echo_yellow "$path_value Length $path_len"
echo_blue "------------------------------------------------------------"
echo_blue

# ============================================================== PATH - End ===================================================================
# =============================================================================================================================================