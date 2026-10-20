AI Assist - Overview and Requirements

Overview and Requirements - Begin

Overview
- This document outlines the requirements and usage of various shell scripts and configuration files in the AI Assist project developed by Greg Paskal.

User Interface
- The aa.sh script should provide a clear and user-friendly menu interface.
- Menu options should be easily navigable and self-explanatory.
- Any AI Assist "app" should be added to the AI Assist shell menu along with a shortcut (2 letters) to execute the script.
- There should be a maintenance option on the menu to clear out all output files, which will be recreated including the output directory if necessary.

Configuration Management
- Configuration files should be centralized into aa_config.yaml using the YAML format for easy editing and documentation.
- The scripts should validate the configuration file and provide meaningful error messages if there are issues.

Dependency Management
- The scripts should check for required dependencies (tree, jq) and prompt the user to install them if they are missing.
- Provide clear instructions for installing dependencies.

Output Management
- Generated files (project trees, paths, context) should be saved in a structured and organized manner.
- The scripts should support both timestamped and non-timestamped versions of output files.
- A script should generate a non-timestamped version of its output in a folder to be determined and have an option to also store a timestamped version of the same content for historical purposes.
- Evolve the AI Assist to leverage AI tools as they become avaliable and mature.

Error Handling
- The scripts should handle errors gracefully and provide clear, actionable error messages.
- Include logging for debugging purposes.

Extensibility
- The framework should be designed to allow easy addition of new scripts and utilities.
- Provide guidelines for adding new functionality.
- Apps will live in the apps directory located in ai_assist/framework/apps directory.
- Apps are made up of scripts and essentially strung together to form a process automation. Each script should stand on its own although it may have requirements on the output of other scripts.

Documentation
- Comprehensive documentation should be provided for each script and configuration file.
- Include examples and usage scenarios.

Security
- Ensure that the scripts handle sensitive information securely.
- Validate user input to prevent injection attacks.

Performance
- The scripts should be optimized for performance, especially when handling large projects.
- Provide feedback to the user during long-running operations.

Integration
- The scripts should integrate seamlessly with other tools and workflows.
- Provide APIs or hooks for integration with external systems.
- It should be possible to call the aa.sh script with a parameter that matches the same two letters at the menu options. This should allow automatic execution and potentially return a response code or result.

AI Assistance
- AI Assist is focused on providing output to assist AI tools like NotebookLM, Gemini and Copilot in understanding the context of all project files.
- Utilize header summaries to best fulfill this on each file within the project.
- Header summaries will follow a format resembling the following.
  /**
   * @file: actor.js
   * @path: myProjectRoot/js/actors/configs/basicFile.js
   * @description: Represents an actor in the stage.
   * 
   * @details: This file contains the Actor class which provides methods to create, update, and render actors on the stage.
   * It handles the setup of the actor, movement, interactions, and rendering.
   */
- If the header is missing for any file, it should be suggested and provided based on the file contents and format above.
- This header should follow the appropriate comment format for the language being used, typically noted by the file extension.

Code Provision
- When utilizing AI tools like NotebookLM and Copilot, the code provided by the AI tool should come in the following format.
- The AI Tool should provide the problematic code to be changed with the opening and closing headers (beginning with  ##############)
- The code itself should be in a fixed font face that is often used to separate code from other text.
- The code should adhere to adding line breaks at the end of each line.

  ############## Code to be replaced or problematic - Begin ##############
  (Provide the code that is to be replaced or problematic here)
  ############## Code to be replaced or problematic - End ##############

- The AI Tool should then provide the new code to add or replace the problematic code in the following format.

  ############## New or Replacement Code - Begin ##############
  (Provide the new or replacement code here)
  ############## New or Replacement Code - End ##############

Overview and Requirements - End

Scripts and Configuration Files - Begin

1. aa.sh
- Description: Provides a menu-driven interface for launching AI Assist tools and utilities.
- Usage: 
  - Displays a menu with options to capture context, exit, and other utilities.
  - Handles user input and executes corresponding commands.
- Dependencies: 
  - color_functions.sh for colored output.
  - aa_config.yaml for configuration.

2. aa_config.yaml
- Description: Centralized configuration file for all AI Assist scripts.
- Usage: 
  - Stores settings and parameters for all scripts in the AI Assist project.
  - Uses YAML format to allow inline comments and documentation.
- Example:
  # Configuration for aa.sh
  menu_items:
    - key: "1"
      value: "Capture Context"
    - key: "2"
      value: "Exit"

  # Configuration for generate_tree.sh
  generate_tree:
    destination_directory: "generated_trees"
    ignore_patterns: "target|extensions"
    save_timestamped_version: true
    output_format: "txt"

  # Configuration for generate_paths.sh
  generate_paths:
    destination_directory: "generated_paths"
    output_file: "paths.txt"
    ignore_patterns: "target|extensions|.git|.gitignore|.vscode|.ai_assist_utils|.sftpignore|.DS_Store"
    save_timestamped_version: false
    exclude_directories: true

  # Configuration for generate_context.sh
  generate_context:
    destination_directory: "generated_contexts"
    generated_paths_directory: "../paths/generated_paths"
    generated_paths_file: "paths.txt"
    maximum_line_length: "7000"

3. generate_tree.sh
- Description: Generates a project tree and saves it to a file.
- Usage: 
  - Reads configuration from aa.cfg.
  - Generates a timestamped file with the project tree.
  - Includes a header with a human-friendly timestamp and instructions for AI Assistant (Copilot).
- Dependencies: 
  - tree and jq must be installed.

4. generate_paths.sh
- Description: Generates the paths of the project files.
- Usage: 
  - Reads configuration from aa.cfg.
  - Generates a text file with the project paths.
- Dependencies: 
  - tree and jq must be installed.

5. generate_context.sh
- Description: Gathers the content of specified project files and outputs them to a file with a timestamp.
- Usage: 
  - Reads the list of files from the output of generate_paths.sh.
  - Outputs the content to a timestamped file.
- Dependencies: 
  - jq must be installed.

6. parameter_checks.sh
- Description: Handles user prompts for actions and modes.
- Usage: 
  - Prompts the user for action (Install, Uninstall, Exit) and action mode (Automatically, Prompt, Exit).
- Dependencies: 
  - color_functions.sh for colored output.

7. color_functions.sh
- Description: Defines functions for colored output in the terminal.
- Usage: 
  - Provides functions to print messages in different colors.

8. app_capture_context.sh
- Description: (To be implemented) Likely intended to capture the context of the project or specific files.
- Usage: 
  - Expected to interact with other utilities or configuration files to perform its tasks.

Scripts and Configuration Files - End

Execution Instructions
- Ensure all dependencies are installed (tree, jq).
- Run the scripts as specified in their descriptions.
- Use the configuration file aa_config.yaml to customize the behavior of the scripts.

Collaboration with Copilot
- Follow the guidelines provided in the AA_User_Guide.md for efficient collaboration with Copilot.
- Ensure clear and complete communication of code changes and actions.

Conclusion
This document serves as a comprehensive guide to the AI Assist project, detailing the purpose and usage of each script and configuration file. Follow the instructions and guidelines to effectively utilize these tools in your development workflow.