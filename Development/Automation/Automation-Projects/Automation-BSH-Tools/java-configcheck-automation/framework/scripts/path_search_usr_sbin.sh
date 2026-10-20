# ================== Common Functions ==================
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )" # Get current script path
source "$SCRIPT_DIR/../common/color_functions.sh" # Include color functions
source "$SCRIPT_DIR/../common/parameter_checks.sh" # Parameter check and user prompts

# =============================================================================================================================================
# ============================================================== PATH - /usr/sbin - Begin =================================================================

path_value="usr/sbin"
path_ref=""
path_result_raw=$PATH
path_search_result=${path_result_raw%%$path_value*}

# Inform the user about the installation        
echo_blue "------------------------------------------------------------"
echo_blue "PATH search for '$path_value'..."
if [ "$path_search_result" != "$path_result_raw" ]; then
echo_green "\$PATH Value '$path_value' found."
else
echo_red "\$PATH Value '$path_value' not found."
fi
echo_blue "------------------------------------------------------------"
echo_blue

# ============================================================== PATH - /usr/sbin - End ===================================================================
# =============================================================================================================================================