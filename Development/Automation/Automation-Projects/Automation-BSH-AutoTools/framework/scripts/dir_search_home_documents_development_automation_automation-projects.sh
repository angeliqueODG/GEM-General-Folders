# ================== Common Functions ==================
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )" # Get current script path
source "$SCRIPT_DIR/../common/color_functions.sh" # Include color functions
source "$SCRIPT_DIR/../common/parameter_checks.sh" # Parameter check and user prompts

# =============================================================================================================================================
# ============================================================== Directory Search - $home/Documents/Development/Automation/Automation-Projects - Begin ===================================

home=~
dir_value="$home/Documents/Development/Automation/Automation-Projects"
dir_ref=""

# Inform the user about home directory      
echo_blue "------------------------------------------------------------"
echo_blue "Directory search for '$dir_value'..."
if [ -d $dir_value ]; then
    echo_green "Directory '$dir_value' exists."
else
    echo_red "Directory '$dir_value' does not exists. (Error)"
fi
echo_blue "------------------------------------------------------------"
echo_blue

# ============================================================== Directory Search - $home/Documents/Development/Automation/Automation-Projects - End =====================================
# =============================================================================================================================================