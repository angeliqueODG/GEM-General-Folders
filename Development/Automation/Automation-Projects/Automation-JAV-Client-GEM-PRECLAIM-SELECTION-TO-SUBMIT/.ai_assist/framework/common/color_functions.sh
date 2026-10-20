# Colors for reporting
reset=$(tput sgr0)
black=$(tput setaf 0)
red=$(tput setaf 1)
orange=$(tput setaf 208)
green=$(tput setaf 2)
yellow=$(tput setaf 3)
blue=$(tput setaf 4)
magenta=$(tput setaf 5)
cyan=$(tput setaf 6)
white=$(tput setaf 7)

echo_black() { message=$@; echo "${black}$message${reset}"; }
echo_red() { message=$@; echo "${red}$message${reset}"; }
echo_orange() { message=$@; echo "${orange}$message${reset}"; }
echo_green() { message=$@; echo "${green}$message${reset}"; }
echo_yellow() { message=$@; echo "${yellow}$message${reset}"; }
echo_blue() { message=$@; echo "${blue}$message${reset}"; }
echo_magenta() { message=$@; echo "${magenta}$message${reset}"; }
echo_cyan() { message=$@; echo "${cyan}$message${reset}"; }
echo_white() { message=$@; echo "${white}$message${reset}"; }