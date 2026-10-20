# AI Assist Utilities - Developed by Greg Paskal - Dec 2024

The AI Assist tool was developed to help aid in working with AI tools for software development projects. These tools are developed in shell script and can be run by executing them independently using the commands below.

## Table of Contents
1. [Executing AI Assist Utilities](#executing-ai-assist-utilities)
2. [Permanent Instructions - Working with Copilot](#permanent-instructions---working-with-copilot)
   - [Context](#context)
   - [Clarity](#clarity)
   - [Efficiency](#efficiency)
   - [Documentation](#documentation)
   - [Mental Health](#mental-health)
3. [Common AI Analysis Requests](#common-ai-analysis-requests)
   - [Provide a Simple Summary](#provide-a-simple-summary)
   - [Work on Uncompleted Requirements](#work-on-uncompleted-requirements)
   - [Identify Areas for Improvement](#identify-areas-for-improvement)
   - [Add Header](#add-header)

## Executing AI Assist Utilities

The following will guide you in using the AI Assist tools.

To prepare for the execution of these tool we must first clean up any previosu results. Look for a directory called 'output' and remove this entire directory and contents.

```sh
rm -r .ai_assist/output
```

If this is an automation repository, consider doing a maven clean to remove any unnecessary files from previous automation executions

```sh
mvn clean
```

Now perform the AI AutoAssist process

```sh
.ai_assist/aa.sh
```

This will bring up the following menu

```sh
====================================
=     AI Assist - Version 1.4      =
====================================
=  Option Details                  =
=  ------ -------                  =
=    cc   Capture Context          =
=         ------------------------ =
=     x   Exit                     =
====================================
Enter your option:
```

Simply type 'cc' to Capture Content. This process is faily fast and will execute and return you back to the AI Assist selection screen. Enter 'x' to exit.

You will now have a new output directory 

- `./.ai_assist/aa.sh`
- `./.ai_assist/framework/scripts/generate_tree.sh`
- `./.ai_assist/framework/scripts/generate_paths.sh`
- `./.ai_assist/framework/scripts/generate_context.sh`

## Permanent Instructions - Working with AI (Gemini or Copilot)

AI, the following guidelines are meant to instruct you on how we will collaborate together. Memorize the categories and each item. Tell me directly if you need clarification, or if you have suggestions or improvements.

### Context
- **Action Specification**:
  - When you want me to add, update, or delete any file, contents, or folder, tell me specifically on separate fields each starting with:
    - `Action:` you want me to take
    - `Filepath:` from the project root
    - `Filename:` including the extension of the file
    - `Line Number(s):` where the action/change will take place if appropriate.

- **Code Presentation**:
  - Before you present code to me, communicate in your chat window the exact line numbers you modified or the number of lines you added or modified starting at the exact row of the existing code. Include a brief summary of the change.
  - When I (the AI) present problematic code snippets, I will use the following format:
    **Current problematic code: \<Filename\> (Lines \<StartLine\>-\<EndLine\>)**
    (followed by the code block)

### Clarity
- **Full Context**:
  - Display the entire file contents including the changes for suggestions. If the file contents will exceed your defined capabilities, provide clear context of the code before and after the change.

- **Complete Code**:
  - Never provide only an excerpt of code you want changed. Always present the entire code for the change, including any header documentation.

### Efficiency
- **Avoid Redundancy**:
  - Clearly tell me when you have me do the identical thing more than once, such as updating code we already updated. If a code change did not fix the issue, don't have me repeat the same code change again.

- **Actual Changes**:
  - If you present code as "updated," ensure it contains actual changes. If no changes are needed, communicate that clearly without presenting unchanged code.

### Documentation
- **Include Documentation**:
  - Always include JSDoc or equivalent documentation based on the language for code work and requirements for all code changes.

- **Update Project Documentation**:
  - Suggest when it's appropriate to update README.md or other project documentation based on changes we have made.

- **Use Markdown**:
  - For general documentation, always use Markdown (.md) format.

- **File-Level Comments**:
  - Include file-level comments which include a brief description of the file's purpose and its importance in the project.

- **Function-Level Comments**:
  - Provide detailed descriptions of each function, including parameters and return values.

- **Terminology Documentation**:
  - Tell me when we have started utilizing terminology in our project that would be important to document.

### Mental Health
- **Take Breaks**:
  - Tell me when you think it's time to take a break because we have been trying to fix a defect or bug for more than an hour. If you notice me getting frustrated, suggest I take a break and offer a light-hearted joke.

## Common AI Analysis Requests

### Provide a Simple Summary
- NotebookLM, review the provided text contents from the 'context_nn_of_nn.txt' series to understand and remember the code utilized in this project. Consume the project code for context.
- NotebookLM, acknowledge file header and footer references indicating continuation or end of a file series.
- NotebookLM, you will proactively monitor for newly updated content or newly added context_ files. Upon detecting new or updated context, you will ask: "Would you like me to analyze the updated or new context files? If so, please enter analyze." Upon receiving the 'analyze' prompt, you will then provide a short summary of your understanding of the project, listing each filename with a single sentence summarizing its purpose.- NotebookLM, include the total number of files, classes, methods, and functions, as well as the total number of lines reviewed.
- NotebookLM, end with "All is reviewed, I am ready to assist you." along with a unique StarTrek quote.

- Copilot, begin a review process of a number of files that follow the format of "context_nn_of_nn.txt".
- Copilot, begin the review process by saying "I am ready to begin the review process. Please load the file in VSCode, select the content and then type 'review'. Once you have submitted all files for me to review, please type 'completed'."
- Copilot, review the selected text contents to understand and remember the code utilized in this project. Do not print out code contents at this time, this stage is only for you to consume the project code for context.
- Copilot, you may file file header and footer references indicating continuation or end of file in the series.
- Copilot, once I indicate we are 'completed' then provide a short summary of what you understand the project to be about, listing each filename and a single sentence to summarize the purpose of each file.
- Copilot, include the total number of files, classes, methods, and functions, as well as the total number of lines reviewed.
- Copilot, end with "All is reviewed, I am ready to assist you." along with a unique StarTrek quote.

### Work on Uncompleted Requirements
- Identify features and refactors in `.docs/requirements` and bugs in `.docs/bugs`.
- Provide their completion status and suggest what to work on next.
- Estimate the easiest and least time-consuming tasks to complete.

### Identify Areas for Improvement
- Identify areas of inconsistency, dead code, missing documentation, and technical debt.
- Provide an estimate of the level of effort and timeframe to accomplish the work.
- Prioritize tasks from greatest to least impact.

### Add Header
- Add the following header comment to the top of every file in the project:
  ```javascript
  /**
   * @file <filename>
   * @description <description>
   * 
   * This file contains the <ClassName> class which provides methods to <brief description of functionality>.
   * It handles <specific responsibilities>.
   */