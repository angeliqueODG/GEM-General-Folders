# ================== Common Functions ==================
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )" # Get current script path
source "$SCRIPT_DIR/../common/color_functions.sh" # Include color functions

# =============================================================================================================================================
# ============================================================= User Prompt - Begin ===========================================================

# ================== Install/Uninstall - Begin ==================
while true; do

  # Check if the action variable exists
  if [ -z "${action}" ]; then
    # Check if action parameter is passed
    if [ -n "$1" ]; then
      action="$1"
      shift # Remove the first parameter
    else
      # Prompt for action paramerter
      echo # move to a new line
      read -p "Choose selection - Install (I), Uninstall (U), or Exit (X): " -n 1 -r action
      echo # move to a new line
    fi

    # Convert action to lowercase if necessary
    action=$(echo "$action" | tr '[:upper:]' '[:lower:]')

    # Ensure action is valid
    if [[ "$action" != "i" && "$action" != "u" && "$action" != "x" ]]; then
        echo_red "Sorry, '$action' is an invalid option. Please try again."
        # Clear the action variable so the loop will prompt again
        action=""
        continue
    fi

    # Check for exit condition
    if [[ "$action" == "x" ]]; then
        echo_orange
        echo_orange "Exiting the script."
        echo_orange
        echo_orange "================================================"
        echo_orange "=            $(date +"%m-%d-%Y %I:%M:%S %p")            ="
        echo_orange "=              AutoTools - Exited              ="
        echo_orange "================================================"
        echo_orange
        exit 0
    fi
  fi

  # If a valid action was entered, break the loop
  break

done
# ================== Install/Uninstall - End ==================

# ================== Automatically/Prompt - Begin ==================
while true; do

  # Check if the action_mode variable exists
  if [ -z "${action_mode}" ]; then
    # Check if install action mode parameter is passed
    if [ -n "$1" ]; then
      action_mode="$1"
      shift # Remove the second parameter
    else
      # Prompt for action_mode paramerter
      echo # move to a new line
      read -p "Choose selection - Perform actions Automatically (A) or Prompt (P) to confirm? Exit (X): " -n 1 -r action_mode
      echo # move to a new line
    fi

    # Convert action_mode to lowercase if necessary
    action_mode=$(echo "$action_mode" | tr '[:upper:]' '[:lower:]')

    # Ensure valid input
    if [[ "$action_mode" != "p" && "$action_mode" != "a" && "$action_mode" != "x" ]]; then
        echo_red "Sorry, '$action_mode' is an invalid option. Please try again."
        # Clear the action variable so the loop will prompt again
        action_mode=""
        continue
    fi

    # Check for exit condition
    if [[ "$action_mode" == "x" ]]; then
        echo_orange
        echo_orange "Exiting the script."
        echo_orange
        echo_orange "================================================"
        echo_orange "=            $(date +"%m-%d-%Y %I:%M:%S %p")            ="
        echo_orange "=              AutoTools - Exited              ="
        echo_orange "================================================"
        echo_orange
        exit 0
    fi
  fi

  # If a valid action_mode was entered, break the loop
  break

done
# ================== Automatically/Prompt - End ==================

# ============================================================= User Prompt - End =============================================================
# =============================================================================================================================================
