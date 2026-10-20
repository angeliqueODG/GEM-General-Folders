# Automation Framework - Setup

<!-- ===============================================================
@file: Doc-Setup.md
@filepath: src/test/java/framework/.docs/Doc-Setup.md
@version: 1.2.0
@updated: 2025-10-30 11:52:00 AM CDT
@author: Greg Paskal
@company: MissionWares

@description:
Setup and installation guide for the automation framework. This document provides
step-by-step instructions for both automated and manual installation of the
framework and its dependencies. Covers prerequisites, environment configuration,
tool installation, and verification steps. Designed primarily for macOS with
Apple Silicon (M1/M2/M3) processors but adaptable to other platforms.

@dependencies:
- macOS 15.x or greater
- Apple Silicon processor (M1 or newer)
- Automation-BSH-AutoTools repository
- Git, Maven, Java 23, Chrome browser

@tags: setup, installation, configuration, autotools, environment, mAiâ„¢

@changeLog:
Date        Author          Version  Description
----------  --------------  -------  --------------------------
2025-01-01  G. Paskal       1.0.0    Initial setup documentation
2025-09-09  G. Paskal       1.1.0    Added mAiâ„¢ header and expanded content
2025-10-30  G. Paskal       1.2.0    Updated for advanced features
=============================================================== -->

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Doc-Overview.md) | [Setup](Doc-Setup.md) | [Test](Doc-Test-Development.md) | [Diagrams](Diagrams.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

# Setup Instructions

The following steps provide both automated and manual installation options for setting up the automation framework environment. The automated approach uses the Automation-BSH-AutoTools repository for streamlined setup.

## Prerequisites

### Hardware Requirements
- **Processor**: Apple Silicon (M1, M2, M3) or Intel processor
- **Memory**: Minimum 8GB RAM (16GB recommended)
- **Storage**: At least 10GB free disk space

### Software Requirements
- **Operating System**: macOS 15.x (Sequoia) or greater
- **Administrator Access**: Required for tool installation

## Automated Installation (Recommended)

The AutoTools script handles the complete environment setup automatically.

### 1. Create Project Directory Structure

Ensure the Automation-Projects directory exists:
```sh
mkdir -p ~/Documents/Development/Automation/Automation-Projects
```

### 2. Clone AutoTools Repository

Clone the Automation-BSH-AutoTools repository:
```sh
git clone git@github.com:MurahoTech/Automation-BSH-AutoTools.git \
    ~/Documents/Development/Automation/Automation-Projects/Automation-BSH-AutoTools
```

### 3. Launch AutoTools

Execute the AutoTools setup script:
```sh
~/Documents/Development/Automation/Automation-Projects/Automation-BSH-AutoTools/autotools.sh
```

### 4. What AutoTools Installs

The automated script will install and configure:
- **Homebrew**: Package manager for macOS
- **Git**: Version control system
- **Java 23**: OpenJDK via Homebrew
- **Maven**: Build and dependency management
- **Chrome**: Browser for test execution
- **ChromeDriver**: WebDriver for Chrome automation
- **Allure**: Test reporting framework
- **VSCode**: Recommended IDE with extensions

## Manual Installation

If you prefer manual installation or need to troubleshoot, follow these steps:

### 1. Install Homebrew

```sh
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

### 2. Install Java 23

```sh
brew install openjdk@23
brew link --force openjdk@23
```

Verify installation:
```sh
java -version
```

### 3. Install Maven

```sh
brew install maven
```

Verify installation:
```sh
mvn -version
```

### 4. Install Git

```sh
brew install git
```

Configure Git:
```sh
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"
```

### 5. Install Chrome Browser

Download from [Google Chrome](https://www.google.com/chrome/) or via Homebrew:
```sh
brew install --cask google-chrome
```

### 6. Install Allure Report

```sh
brew install allure
```

### 7. Install VSCode (Optional but Recommended)

```sh
brew install --cask visual-studio-code
```

## Project Setup

### 1. Clone the Test Automation Project

```sh
cd ~/Documents/Development/Automation/Automation-Projects
git clone [your-automation-project-repository]
```

### 2. Install Maven Dependencies

Navigate to project directory and run:
```sh
mvn clean install -DskipTests
```

### 3. Verify Setup

Run a simple test to verify everything is working:
```sh
mvn test -Dtest=TS_Authentication_JUnit#testValidLogin
```

## Environment Variables

Add these to your `~/.zshrc` or `~/.bash_profile`:

```sh
# Java Home
export JAVA_HOME=/opt/homebrew/opt/openjdk@23
export PATH="$JAVA_HOME/bin:$PATH"

# Maven Options
export MAVEN_OPTS="-Xmx2048m -XX:MaxPermSize=512m"

# Chrome Driver (if manually installed)
export PATH="/usr/local/bin/chromedriver:$PATH"
```

Reload your shell configuration:
```sh
source ~/.zshrc
```

## Verification Checklist

- [ ] Java 23 installed and accessible
- [ ] Maven installed and configured
- [ ] Git installed and configured
- [ ] Chrome browser installed
- [ ] Project cloned successfully
- [ ] Maven dependencies downloaded
- [ ] Sample test executes successfully
- [ ] Allure report generates properly

## Troubleshooting

### Common Issues

1. **Java Version Mismatch**
   - Ensure Java 23 is the active version
   - Use `java -version` to verify

2. **Maven Build Failures**
   - Clear Maven cache: `rm -rf ~/.m2/repository`
   - Re-run: `mvn clean install`

3. **ChromeDriver Issues**
   - Ensure Chrome browser is up to date
   - ChromeDriver version must match Chrome version

4. **Permission Errors**
   - May need to allow apps in System Preferences > Security & Privacy

## Next Steps

Once your environment is set up, explore these framework capabilities:

- Review [Framework Overview](Doc-Overview.md) for architecture and components
- Learn about [Test Development](Doc-Test-Development.md) for writing tests
- Understand [Test Execution](Doc-Test-Execution-VSCode.md) for running tests
- Explore [Architecture Diagrams](Diagram-Architecture.md) for visual understanding
- Try [HTTP Security Assessment](Doc-HTTP-Assessment.md) for automated security audits
- Experiment with [Network Diagnostics](Doc-Network-Diagnostics.md) for connectivity testing
- Discover [mAi Advisorâ„¢](Doc-mAi-Advisor.md) for intelligent recommendations

## Support

For additional help:
- Check project README.md
- Review [API Documentation](../../../../../target/site/index.html)
- Contact framework maintainers

---

**Version**: 1.2.0  
**Last Updated**: 2025-10-30 11:52:00 AM CDT  
**Copyright** Â© 2025 MissionWares. All Rights Reserved.