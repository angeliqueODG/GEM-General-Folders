# DevOps Engineer's Guide - mAi Automation Framework

<!-- ===============================================================
@file: Guide-For-DevOps.md
@filepath: src/test/java/framework/.docs/Guide-For-DevOps.md
@version: 1.0.0
@created: 2025-10-30 02:15:00 PM CDT
@updated: 2025-10-30 02:15:00 PM CDT
@author: Greg Paskal
@company: MissionWares

@description:
Focused reading guide for DevOps Engineers and Infrastructure specialists. This
guide provides a streamlined path through documentation relevant to CI/CD
integration, cloud configuration, monitoring, and operational concerns. Skips
test writing details to focus on deployment, integration, and infrastructure.

@audience: DevOps Engineers, Site Reliability Engineers, Infrastructure Engineers

@purpose:
Get DevOps engineers productive in 75 minutes by focusing on:
- CI/CD integration (Maven, Jenkins, GitHub Actions)
- Google Cloud setup (BigQuery, Cloud Storage)
- Configuration management
- Monitoring and reporting
- Troubleshooting operational issues

@dependencies:
- Framework documentation files
- Cloud access (if using Google Cloud features)

@tags: devops, ci-cd, cloud-integration, infrastructure, guide, role-based, mAi™

@changeLog:
Date        Author          Version  Description
----------  --------------  -------  --------------------------
2025-10-30  G. Paskal       1.0.0    Initial DevOps engineer's guide
=============================================================== -->

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Doc-Overview.md) | [Reading Guide](Guide-Reading-Order.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

# ⚙️ DevOps Engineer's Guide

**Target Audience**: DevOps Engineers, SRE, Infrastructure Engineers  
**Reading Time**: 75 minutes  
**Goal**: Deploy and integrate framework in CI/CD pipeline  
**Skill Level**: Intermediate to Advanced

---

## Welcome DevOps Engineers! 👋

This guide gets you integrating the framework into your CI/CD pipeline **FAST**. We skip test writing details and focus on what you need:
- ✅ Maven lifecycle and phases
- ✅ CI/CD integration patterns
- ✅ Google Cloud setup
- ✅ Configuration management
- ✅ Monitoring and reporting

**Skip to**: [Quick CI/CD Setup](#quick-cicd-setup-10-minutes) if you're in a hurry!

---

## Table of Contents

### **ESSENTIAL** (Must Read - 45 min)
1. [Quick CI/CD Setup](#quick-cicd-setup-10-minutes) (10 min) 🚀
2. [Maven Lifecycle](#maven-lifecycle-10-minutes) (10 min) 🚀
3. [Configuration Management](#configuration-management-15-minutes) (15 min) 🚀
4. [Report Generation](#report-generation-10-minutes) (10 min) 🚀

### **IMPORTANT** (Read Soon - 30 min)
5. [Google Cloud Setup](#google-cloud-setup-15-minutes) (15 min)
6. [CI/CD Integration Examples](#cicd-integration-examples-15-minutes) (15 min)

### **REFERENCE** (Use When Needed)
7. [Troubleshooting](#troubleshooting)
8. [Configuration Reference](#configuration-reference)
9. [Security Best Practices](#security-best-practices)

### **OPTIONAL**
10. [Architecture Overview](#architecture-overview) (For context)

---

# ESSENTIAL READING

---

## Quick CI/CD Setup (10 Minutes)

**Goal**: Run tests in CI pipeline

### GitHub Actions Example

**File**: `.github/workflows/test.yml`

```yaml
name: Automated Tests

on:
  push:
    branches: [ main, develop ]
  pull_request:
    branches: [ main ]
  schedule:
    - cron: '0 9 * * *'  # Daily at 9 AM

jobs:
  test:
    runs-on: ubuntu-latest
    
    steps:
      - name: Checkout code
        uses: actions/checkout@v3
      
      - name: Set up JDK 23
        uses: actions/setup-java@v3
        with:
          java-version: '23'
          distribution: 'temurin'
      
      - name: Cache Maven packages
        uses: actions/cache@v3
        with:
          path: ~/.m2
          key: ${{ runner.os }}-m2-${{ hashFiles('**/pom.xml') }}
      
      - name: Run tests
        run: mvn clean verify -Dheadless=true
      
      - name: Generate Allure Report
        if: always()
        run: |
          curl -o allure-2.24.0.tgz -L https://github.com/allure-framework/allure2/releases/download/2.24.0/allure-2.24.0.tgz
          tar -zxf allure-2.24.0.tgz
          ./allure-2.24.0/bin/allure generate target/allure-results -o allure-report
      
      - name: Upload Allure Report
        if: always()
        uses: actions/upload-artifact@v3
        with:
          name: allure-report
          path: allure-report
      
      - name: Upload Test Results
        if: always()
        uses: actions/upload-artifact@v3
        with:
          name: test-results
          path: target/surefire-reports
```

### Jenkins Pipeline Example

**File**: `Jenkinsfile`

```groovy
pipeline {
    agent any
    
    tools {
        maven 'Maven 3.9'
        jdk 'JDK 23'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/your-org/automation-framework.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn verify -Dheadless=true'
            }
        }
        
        stage('Report') {
            steps {
                allure includeProperties: false, 
                       jdk: '', 
                       results: [[path: 'target/allure-results']]
            }
        }
    }
    
    post {
        always {
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/screenshots/**/*.png', 
                             allowEmptyArchive: true
        }
    }
}
```

### GitLab CI Example

**File**: `.gitlab-ci.yml`

```yaml
image: maven:3.9-eclipse-temurin-23

stages:
  - test
  - report

variables:
  MAVEN_OPTS: "-Dmaven.repo.local=.m2/repository"

cache:
  paths:
    - .m2/repository

test:
  stage: test
  script:
    - mvn clean verify -Dheadless=true
  artifacts:
    when: always
    reports:
      junit: target/surefire-reports/TEST-*.xml
    paths:
      - target/allure-results
      - target/screenshots
    expire_in: 1 week

report:
  stage: report
  image: allure/allure-cli:latest
  script:
    - allure generate target/allure-results -o allure-report
  artifacts:
    paths:
      - allure-report
  only:
    - main
```

---

## Maven Lifecycle (10 Minutes)

**Goal**: Understand Maven execution phases

### Complete Lifecycle

```
mvn verify
  ↓
1. validate      - Validate project structure
  ↓
2. compile       - Compile source code
  ↓
3. test-compile  - Compile test code
  ↓
4. test          - Run unit tests (Surefire plugin)
  ↓
5. integration-test - Run integration tests
  ↓
6. post-integration-test - CLOUD UPLOADS HERE ✅
  ↓  ├─ BigQuery data export
  ↓  ├─ Cloud Storage screenshot upload
  ↓  └─ Allure report generation
  ↓
7. verify        - Verify results
  ↓
8. install       - Install to local Maven repo
  ↓
9. deploy        - Deploy to remote Maven repo
```

### Key Plugin Executions

**post-integration-test Phase**:
```xml
<!-- From pom.xml -->
<execution>
    <phase>post-integration-test</phase>
    <id>allure-report-generation</id>
    <goals><goal>java</goal></goals>
    <configuration>
        <mainClass>framework.reporting.FW_AllureReportGenerator</mainClass>
    </configuration>
</execution>

<execution>
    <phase>post-integration-test</phase>
    <id>google-cloud-export-data</id>
    <goals><goal>java</goal></goals>
    <configuration>
        <mainClass>framework.data.FW_GoogleCloudBigQueryUploader</mainClass>
    </configuration>
</execution>

<execution>
    <phase>post-integration-test</phase>
    <id>google-cloud-export-screenshots</id>
    <goals><goal>java</goal></goals>
    <configuration>
        <mainClass>framework.data.FW_GoogleCloudStorageUploader</mainClass>
    </configuration>
</execution>
```

### Common Commands

```bash
# Clean and run all tests
mvn clean verify

# Skip tests (build only)
mvn clean install -DskipTests

# Run specific test
mvn test -Dtest=TS_Smoke_JUnit

# Parallel execution
mvn verify -Dthreads=4

# Headless mode
mvn verify -Dheadless=true

# Generate site (JavaDocs)
mvn site
```

---

## Configuration Management (15 Minutes)

**Goal**: Manage environment-specific configuration

### Configuration File

**Location**: `src/test/resources/testConfig.properties`

### Environment-Specific Configs

**Strategy**: Use Maven profiles or environment variables

#### Option 1: Maven Profiles

**pom.xml**:
```xml
<profiles>
    <profile>
        <id>dev</id>
        <properties>
            <env>dev</env>
        </properties>
    </profile>
    <profile>
        <id>staging</id>
        <properties>
            <env>staging</env>
        </properties>
    </profile>
    <profile>
        <id>production</id>
        <properties>
            <env>prod</env>
        </properties>
    </profile>
</profiles>
```

**Usage**:
```bash
mvn verify -Pdev
mvn verify -Pstaging
mvn verify -Pproduction
```

#### Option 2: Environment Variables

**testConfig.properties**:
```properties
# Use ${env.VAR_NAME} for environment variables
baseURL=${env.BASE_URL}
browser=${env.BROWSER:chrome}  # Default to chrome
googleCloudProjectId=${env.GCP_PROJECT_ID}
```

**CI/CD Usage**:
```bash
export BASE_URL="https://staging.example.com"
export BROWSER="chrome"
export GCP_PROJECT_ID="project-staging-123"
mvn verify
```

#### Option 3: Multiple Config Files

```
src/test/resources/
├── testConfig.properties           # Default
├── testConfig.dev.properties       # Dev environment
├── testConfig.staging.properties   # Staging
└── testConfig.prod.properties      # Production
```

### Critical Configuration Properties

**Browser & Execution**:
```properties
browser=chrome
headless=false
parallelExecution=false
parallelExecutionThreads=1
implicitWait=10
pageLoadTimeout=30
```

**Screenshot & Reporting**:
```properties
takeScreenshots=true
screenCaptureFormat=png
screenCaptureQuality=85
screenCapturePath=target/screenshots/
```

**Data Collection**:
```properties
dataOutputPath=target/data/
dataTestStepsFilename=TestStepsData.csv
dataArchivePath=target/data/archive/
```

**Google Cloud** (Optional):
```properties
googleCloudBigQueryExport=true
googleCloudStorageExport=true
googleCloudProjectId=your-project-id
googleCloudServiceAccountJsonFile=src/test/resources/.private/credentials.json
```

### Secrets Management

**NEVER commit secrets to git!**

**.gitignore**:
```
src/test/resources/.private/
src/test/resources/testConfig.prod.properties
*.json  # Service account keys
```

**Best Practices**:
1. Store credentials in CI/CD secrets
2. Use service account JSON files (not user credentials)
3. Rotate credentials regularly
4. Use least-privilege IAM roles
5. Encrypt secrets at rest

---

## Report Generation (10 Minutes)

**Goal**: Understand report outputs

### Allure Report

**Location**: `target/allure-results/`  
**Generation**: Automatic during `post-integration-test`  
**Viewing**:
```bash
allure serve target/allure-results
```

**CI/CD Integration**:
```bash
# Generate static report
allure generate target/allure-results -o allure-report

# Publish to web server
scp -r allure-report/* user@server:/var/www/html/reports/
```

**Report Contents**:
- Test results (Pass/Fail/Skip)
- Test duration
- Screenshots on failure
- Test steps
- Categories and suites
- Trends (if historical data available)

### JUnit XML Reports

**Location**: `target/surefire-reports/TEST-*.xml`  
**Format**: JUnit XML (compatible with Jenkins, GitLab, GitHub)

**Integration**:
```yaml
# GitHub Actions
- name: Publish Test Results
  uses: EnricoMi/publish-unit-test-result-action@v2
  if: always()
  with:
    files: |
      target/surefire-reports/*.xml

# GitLab CI
reports:
  junit: target/surefire-reports/TEST-*.xml
```

### Test Data CSV

**Location**: `target/data/TestStepsData.csv`  
**Contents**: Every test step with 26 fields

**Uploaded to**: Google BigQuery (if configured)

**Schema**: 
- Test identification (11 fields)
- Execution details (11 fields)
- Assets and performance (4 fields)

### Screenshots

**Location**: `target/screenshots/`  
**Format**: PNG  
**Naming**: `screenshot_<timestamp>_<test>.png`

**Uploaded to**: Google Cloud Storage (if configured)

**Cleanup**:
```bash
# Archive old screenshots
tar -czf screenshots-$(date +%Y%m%d).tar.gz target/screenshots/
mv screenshots-*.tar.gz archive/

# Clean up
rm -rf target/screenshots/*
```

---

# IMPORTANT READING

---

## Google Cloud Setup (15 Minutes)

**Goal**: Configure BigQuery and Cloud Storage

### Prerequisites

1. **Google Cloud Project**
2. **Service Account** with roles:
   - BigQuery Data Editor
   - BigQuery Job User
   - Storage Object Creator

### Step 1: Create Service Account

```bash
# Set project
gcloud config set project YOUR_PROJECT_ID

# Create service account
gcloud iam service-accounts create automation-framework \
    --display-name="Automation Framework Service Account"

# Grant BigQuery permissions
gcloud projects add-iam-policy-binding YOUR_PROJECT_ID \
    --member="serviceAccount:automation-framework@YOUR_PROJECT_ID.iam.gserviceaccount.com" \
    --role="roles/bigquery.dataEditor"

gcloud projects add-iam-policy-binding YOUR_PROJECT_ID \
    --member="serviceAccount:automation-framework@YOUR_PROJECT_ID.iam.gserviceaccount.com" \
    --role="roles/bigquery.jobUser"

# Grant Storage permissions
gcloud projects add-iam-policy-binding YOUR_PROJECT_ID \
    --member="serviceAccount:automation-framework@YOUR_PROJECT_ID.iam.gserviceaccount.com" \
    --role="roles/storage.objectCreator"

# Create and download key
gcloud iam service-accounts keys create credentials.json \
    --iam-account=automation-framework@YOUR_PROJECT_ID.iam.gserviceaccount.com
```

### Step 2: Create BigQuery Dataset

```bash
# Create dataset
bq mk --dataset --location=US YOUR_PROJECT_ID:dataset_automation_01

# Or via Console:
# https://console.cloud.google.com/bigquery
# Create Dataset → dataset_automation_01
```

### Step 3: Create Cloud Storage Bucket

```bash
# Create bucket
gsutil mb -l US -c STANDARD gs://your-automation-screenshots/

# Set lifecycle (auto-delete after 90 days)
cat > lifecycle.json << EOF
{
  "lifecycle": {
    "rule": [
      {
        "action": {"type": "Delete"},
        "condition": {"age": 90}
      }
    ]
  }
}
EOF

gsutil lifecycle set lifecycle.json gs://your-automation-screenshots/
```

### Step 4: Configure Framework

**testConfig.properties**:
```properties
# Enable exports
googleCloudBigQueryExport=true
googleCloudStorageExport=true

# Project configuration
googleCloudProjectId=YOUR_PROJECT_ID
googleCloudServiceAccountJsonFile=src/test/resources/.private/credentials.json

# BigQuery
googleCloudProjectDataset=dataset_automation_01
googleCloudProjectDatasetTableTestSteps=table_teststeps_02
googleCloudProjectDatasetTableTestStepsSchema=src/test/java/framework/data/FW_GoogleCloudBigQueryTableTestStepsSchema.json
googleCloudBigQueryTimeout=10

# Cloud Storage
googleCloudStorageBucket=your-automation-screenshots
googleCloudStorageBaseURL=https://storage.googleapis.com/
```

### Step 5: Store Credentials Securely

**GitHub Actions**:
```yaml
- name: Setup Google Cloud credentials
  env:
    GCP_CREDENTIALS: ${{ secrets.GCP_CREDENTIALS }}
  run: |
    echo "$GCP_CREDENTIALS" > src/test/resources/.private/credentials.json
```

**Jenkins**:
```groovy
withCredentials([file(credentialsId: 'gcp-service-account', variable: 'GCP_KEY')]) {
    sh 'cp $GCP_KEY src/test/resources/.private/credentials.json'
}
```

**GitLab CI**:
```yaml
before_script:
  - mkdir -p src/test/resources/.private
  - echo "$GCP_CREDENTIALS" | base64 -d > src/test/resources/.private/credentials.json
```

### Step 6: Verify Setup

```bash
# Run with cloud export enabled
mvn verify -DgoogleCloudBigQueryExport=true

# Check BigQuery
bq query "SELECT COUNT(*) FROM \`YOUR_PROJECT_ID.dataset_automation_01.table_teststeps_02\`"

# Check Cloud Storage
gsutil ls gs://your-automation-screenshots/
```

---

## CI/CD Integration Examples (15 Minutes)

### Jenkins Complete Example

```groovy
pipeline {
    agent {
        docker {
            image 'maven:3.9-eclipse-temurin-23'
        }
    }
    
    parameters {
        choice(name: 'ENVIRONMENT', choices: ['dev', 'staging', 'prod'], description: 'Environment to test')
        choice(name: 'BROWSER', choices: ['chrome', 'firefox', 'edge'], description: 'Browser to use')
        booleanParam(name: 'PARALLEL', defaultValue: false, description: 'Run tests in parallel')
    }
    
    environment {
        GCP_PROJECT = 'automation-project-123'
    }
    
    stages {
        stage('Setup') {
            steps {
                // Setup Google Cloud credentials
                withCredentials([file(credentialsId: 'gcp-service-account', variable: 'GCP_KEY')]) {
                    sh 'mkdir -p src/test/resources/.private'
                    sh 'cp $GCP_KEY src/test/resources/.private/credentials.json'
                }
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                script {
                    def parallelFlag = params.PARALLEL ? '-DparallelExecution=true' : ''
                    sh "mvn verify -Dheadless=true -Dbrowser=${params.BROWSER} ${parallelFlag}"
                }
            }
        }
        
        stage('Report') {
            steps {
                allure includeProperties: false, results: [[path: 'target/allure-results']]
            }
        }
        
        stage('Notify') {
            steps {
                script {
                    def status = currentBuild.result == null ? 'SUCCESS' : currentBuild.result
                    slackSend(
                        color: status == 'SUCCESS' ? 'good' : 'danger',
                        message: "${env.JOB_NAME} - Build #${env.BUILD_NUMBER} ${status}"
                    )
                }
            }
        }
    }
    
    post {
        always {
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/screenshots/**/*.png', allowEmptyArchive: true
            cleanWs()
        }
        failure {
            emailext (
                subject: "Failed: ${env.JOB_NAME} - Build #${env.BUILD_NUMBER}",
                body: "Check console output at ${env.BUILD_URL}",
                to: 'qa-team@example.com'
            )
        }
    }
}
```

### GitHub Actions with Matrix

```yaml
name: Cross-Browser Tests

on:
  push:
    branches: [ main ]
  schedule:
    - cron: '0 2 * * *'  # Nightly at 2 AM

jobs:
  test:
    runs-on: ubuntu-latest
    strategy:
      matrix:
        browser: [chrome, firefox]
        environment: [staging, production]
    
    steps:
      - uses: actions/checkout@v3
      
      - name: Set up JDK 23
        uses: actions/setup-java@v3
        with:
          java-version: '23'
          distribution: 'temurin'
      
      - name: Setup Google Cloud
        env:
          GCP_CREDENTIALS: ${{ secrets.GCP_CREDENTIALS }}
        run: |
          mkdir -p src/test/resources/.private
          echo "$GCP_CREDENTIALS" > src/test/resources/.private/credentials.json
      
      - name: Run Tests
        run: |
          mvn verify \
            -Dheadless=true \
            -Dbrowser=${{ matrix.browser }} \
            -Denvironment=${{ matrix.environment }}
      
      - name: Upload Results
        if: always()
        uses: actions/upload-artifact@v3
        with:
          name: results-${{ matrix.browser }}-${{ matrix.environment }}
          path: |
            target/allure-results
            target/surefire-reports
```

---

# REFERENCE SECTIONS

---

## Troubleshooting

### BigQuery Upload Failures

**Problem**: "CSV file does not exist"  
**Solution**: Verify `dataOutputPath` in testConfig.properties

**Problem**: "BigQuery credentials failed"  
**Solution**:
- Check service account file path
- Verify file is valid JSON
- Check service account has required permissions

**Problem**: "Dataset creation failed"  
**Solution**: Grant `roles/bigquery.admin` to service account

### CI/CD Failures

**Problem**: Tests timeout in CI but pass locally  
**Solution**:
- Increase timeouts in testConfig.properties
- Use headless mode
- Check CI system resources

**Problem**: ChromeDriver version mismatch  
**Solution**:
```dockerfile
# Use specific Chrome version in Docker
FROM selenium/standalone-chrome:120.0
```

**Problem**: Tests fail randomly in CI  
**Solution**:
- Increase implicit/explicit waits
- Disable parallel execution
- Check network stability

### Cloud Upload Issues

**Problem**: "Permission denied" on Cloud Storage  
**Solution**: Grant `roles/storage.objectCreator` to service account

**Problem**: Screenshots not uploading  
**Solution**:
- Verify `googleCloudStorageExport=true`
- Check bucket name is correct
- Verify bucket exists

---

## Configuration Reference

### Complete testConfig.properties Template

```properties
############### Browser Configuration ###############
browser=chrome
headless=false
chromeDriverPath=
firefoxDriverPath=
edgeDriverPath=

############### Test Execution ###############
parallelExecution=false
parallelExecutionThreads=1
implicitWait=10
pageLoadTimeout=30
scriptTimeout=30

############### Screenshot Configuration ###############
takeScreenshots=true
screenCaptureFormat=png
screenCaptureQuality=85
screenCapturePath=target/screenshots/
screenCaptureArchivePath=target/screenshots/archive/

############### Data Collection ###############
dataOutputPath=target/data/
dataTestStepsFilename=TestStepsData.csv
dataArchivePath=target/data/archive/

############### Google Cloud Configuration ###############
googleCloudProjectId=your-project-id
googleCloudServiceAccountJsonFile=src/test/resources/.private/credentials.json

# BigQuery
googleCloudBigQueryExport=true
googleCloudBigQueryTimeout=10
googleCloudBigQueryMaxAttempts=10
googleCloudProjectDataset=dataset_automation_01
googleCloudProjectDatasetTableTestSteps=table_teststeps_02
googleCloudProjectDatasetTableTestStepsSchema=src/test/java/framework/data/FW_GoogleCloudBigQueryTableTestStepsSchema.json

# Cloud Storage
googleCloudStorageExport=true
googleCloudStorageBaseURL=https://storage.googleapis.com/
googleCloudStorageBucket=your-bucket-name

############### mAi Advisor ###############
maiAdvisorEnabled=true
maiAdvisorAudiences=Developer,QA,DevOps,Security,PM,Executive

############### Network Configuration ###############
httpTimeout=30000
httpFollowRedirects=true
httpUserAgent=mAi-Automation-Framework/2.0
```

---

## Security Best Practices

### Credentials Management

1. **NEVER commit credentials**:
```bash
# Add to .gitignore
src/test/resources/.private/
*.json
testConfig.prod.properties
```

2. **Use CI/CD secrets**:
- GitHub: Repository Settings → Secrets
- Jenkins: Credentials Plugin
- GitLab: CI/CD Settings → Variables

3. **Rotate regularly**:
```bash
# Rotate service account key
gcloud iam service-accounts keys create new-key.json \
    --iam-account=automation-framework@PROJECT.iam.gserviceaccount.com

# Delete old key
gcloud iam service-accounts keys delete OLD_KEY_ID \
    --iam-account=automation-framework@PROJECT.iam.gserviceaccount.com
```

### IAM Best Practices

1. **Least Privilege**: Grant minimum required permissions
2. **Service Accounts**: Use service accounts (not user accounts)
3. **Separate Environments**: Different service accounts per environment
4. **Audit**: Enable Cloud Audit Logs
5. **Monitoring**: Set up alerts for unusual activity

### Network Security

1. **VPN/Private Network**: Run tests from private network if possible
2. **IP Whitelist**: Restrict BigQuery/Storage access by IP
3. **VPC Service Controls**: Use for sensitive data
4. **Encryption**: Enable encryption at rest and in transit

---

## Architecture Overview

**File**: [Diagram-Architecture.md](Diagram-Architecture.md)

### 8 Layers (Quick Reference)

1. **Test Foundation** - JUnit 5 tests
2. **Page Objects** - Selenium WebDriver
3. **Framework Core** - Assertions, drivers
4. **Utilities** - Date, file, HTTP
5. **Data Management** - CSV generation
6. **Audits** - HTTP, Network
7. **Advisor** - mAi™ recommendations
8. **Cloud Integration** - BigQuery, Storage

**For full details**: See [Complete Reading Guide](Guide-Reading-Order.md)

---

# Quick Reference Card

**Print this section!**

### CI/CD Commands
```bash
mvn clean verify -Dheadless=true          # Run all tests
mvn verify -P<profile>                     # Use profile
mvn verify -Dtest=TS_Smoke_JUnit          # Run smoke tests
allure generate target/allure-results      # Generate report
```

### Cloud Operations
```bash
# BigQuery
bq query "SELECT * FROM dataset.table LIMIT 10"
bq ls dataset_automation_01

# Cloud Storage
gsutil ls gs://bucket-name/
gsutil cp file.png gs://bucket-name/
```

### Troubleshooting
```bash
# Check Java version
java -version  # Need 23+

# Check Maven
mvn -version

# Validate pom.xml
mvn validate

# Clean everything
mvn clean
rm -rf target/
```

### Environment Variables
```bash
export BASE_URL="https://staging.example.com"
export BROWSER="chrome"
export GCP_PROJECT_ID="project-id"
export HEADLESS="true"
```

---

# Next Steps

**You've completed the DevOps Engineer's Guide!** 🎉

**Now**:
1. ✅ Set up CI/CD pipeline
2. ✅ Configure Google Cloud (if needed)
3. ✅ Test pipeline with smoke tests
4. ✅ Monitor and optimize

**Need More?**
- [Complete Reading Guide](Guide-Reading-Order.md) - Full documentation
- [Test Writer's Guide](Guide-For-Test-Writers.md) - Test development
- [Framework Maintainer Guide](Guide-For-Framework-Maintainers.md) - Framework internals

---

**Version**: 1.0.0  
**Last Updated**: 2025-10-30 02:15:00 PM CDT  
**Copyright** © 2025 MissionWares. All Rights Reserved.