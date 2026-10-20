# Automation Framework - Diagram - Automation Completed to Google BigQuery

<!-- ===============================================================
@file: Diagram-Automation-completed-to-Google_BigData.md
@filepath: src/test/java/framework/.docs/Diagram-Automation-completed-to-Google_BigData.md
@version: 2.0.0
@updated: 2025-10-30 01:30:00 PM CDT
@author: Greg Paskal
@company: MissionWares

@description:
Detailed flowchart illustrating the post-test execution data pipeline that
transfers test results from local CSV files to Google BigQuery for analytics
and reporting. This diagram shows the complete flow from Maven's
post-integration-test phase through the BigQuery uploader component, including
credential management, schema validation, dataset/table creation, CSV parsing
with OpenCSV, batch insertion, and file archiving. Updated to reflect actual
implementation using FW_GoogleCloudUtils for data operations.

@dependencies:
- Google Cloud BigQuery API
- OpenCSV library for CSV parsing
- Maven post-integration-test phase
- FW_GoogleCloudBigQueryUploader.java
- FW_GoogleCloudUtils.java
- Mermaid diagram rendering support

@tags: bigquery, google-cloud, data-pipeline, flowchart, mermaid, csv-upload, mAi™

@changeLog:
Date        Author          Version  Description
----------  --------------  -------  --------------------------
2025-01-01  G. Paskal       1.0.0    Initial BigQuery flow diagram
2025-09-09  G. Paskal       1.1.0    Added mAi™ header and documentation
2025-10-30  G. Paskal       2.0.0    Complete rewrite to reflect actual implementation:
                                     - Updated to show OpenCSV parsing (not ByteBuffer streaming)
                                     - Added dataset/table validation and creation
                                     - Added archiveTestStepsCSV flow
                                     - Added FW_GoogleCloudUtils method calls
                                     - Updated configuration properties
                                     - Enhanced error handling details
=============================================================== -->

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Doc-Overview.md) | [Setup](Doc-Setup.md) | [Test](Doc-Test-Development.md) | [Diagrams](Diagrams.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

## Introduction

This diagram documents the complete data pipeline that transfers test execution results from local CSV files to Google BigQuery for long-term storage, analytics, and reporting. The pipeline is automatically triggered by Maven's `post-integration-test` phase after all tests complete.

**Pipeline Stages:**
1. Maven trigger and configuration validation
2. Google Cloud authentication
3. Dataset and table validation/creation
4. CSV parsing and data collection (OpenCSV)
5. Batch insertion to BigQuery
6. CSV file archiving

---

## Key Process Steps

### 1. Maven Trigger
**Phase**: `post-integration-test`  
**Execution**: Automatically triggered after test completion  
**Entry Point**: `FW_GoogleCloudBigQueryUploader.main()`

### 2. Configuration Validation
Validates all required properties from `testConfig.properties`:
- Google Cloud Project ID
- Service account credentials file
- Dataset and table names
- Schema file location
- CSV file paths

### 3. Authentication
- Loads service account JSON credentials
- Creates authenticated BigQuery client
- Verifies client connectivity

### 4. Dataset & Table Validation
- Checks if dataset exists (creates if missing)
- Checks if table exists (creates with schema if missing)
- Validates table schema against JSON definition

### 5. CSV Processing
- Parses CSV using OpenCSV library
- Reads header row (skipped - already in schema)
- Collects data rows into `List<RowToInsert>`
- Maps column names to values

### 6. Data Upload
- Batch insertion via `FW_GoogleCloudUtils.writeBigQueryTableRows()`
- Monitors job completion
- Handles timeout and retry logic

### 7. File Archiving
- Moves processed CSV to archive folder
- Appends timestamp to filename
- Confirms successful archive

---

## Complete Flow Diagram

```mermaid
flowchart TD
    Start([Maven Build<br/>post-integration-test]) --> CheckFlag{googleCloudBigQueryExport<br/>= true?}
    
    CheckFlag -->|No| Skip[Skip Export]
    CheckFlag -->|Yes| Main[FW_GoogleCloudBigQueryUploader<br/>main method]
    
    Main --> Upload[Call uploadTestStepsCSV]
    
    subgraph UploadFlow["uploadTestStepsCSV() Method"]
        
        U1[Start Upload Process]
        
        rect rgb(255, 245, 220)
            Note over U1: Configuration Validation
            U1 --> V1[Get googleCloudProjectId]
            V1 --> V1Check{Valid?}
            V1Check -->|No| V1Fail[ERROR: Exit]
            V1Check -->|Yes| V2[Get googleCloudServiceAccountJsonFile]
            
            V2 --> V2Check{Valid?}
            V2Check -->|No| V2Fail[ERROR: Exit]
            V2Check -->|Yes| V3[Get googleCloudProjectDataset]
            
            V3 --> V3Check{Valid?}
            V3Check -->|No| V3Fail[ERROR: Exit]
            V3Check -->|Yes| V4[Get googleCloudProjectDatasetTableTestSteps]
            
            V4 --> V4Check{Valid?}
            V4Check -->|No| V4Fail[ERROR: Exit]
            V4Check -->|Yes| V5[Get googleCloudProjectDatasetTableTestStepsSchema]
            
            V5 --> V5Check{Valid?}
            V5Check -->|No| V5Fail[ERROR: Exit]
            V5Check -->|Yes| V6[Get dataOutputPath]
            
            V6 --> V6Check{Valid?}
            V6Check -->|No| V6Fail[ERROR: Exit]
            V6Check -->|Yes| V7[Get dataTestStepsFilename]
            
            V7 --> V7Check{Valid?}
            V7Check -->|No| V7Fail[ERROR: Exit]
            V7Check -->|Yes| FileCheck[File Validation]
        end
        
        rect rgb(220, 240, 255)
            Note over FileCheck: File Existence Checks
            FileCheck --> F1[Check CSV file exists]
            F1 --> F1Check{Exists?}
            F1Check -->|No| F1Fail[ERROR: Exit]
            F1Check -->|Yes| F2[Check schema file exists]
            
            F2 --> F2Check{Exists?}
            F2Check -->|No| F2Fail[ERROR: Exit]
            F2Check -->|Yes| F3[Check service account file exists]
            
            F3 --> F3Check{Exists?}
            F3Check -->|No| F3Fail[ERROR: Exit]
            F3Check -->|Yes| ReadSchema[Read Schema]
        end
        
        rect rgb(255, 220, 220)
            Note over ReadSchema: Schema Loading
            ReadSchema --> S1[FW_GoogleCloudUtils.readSchemaFromFile]
            S1 --> S1Check{Success?}
            S1Check -->|No| S1Fail[ERROR: Exit]
            S1Check -->|Yes| AuthStart[Authentication]
        end
        
        rect rgb(220, 255, 220)
            Note over AuthStart: Google Cloud Authentication
            AuthStart --> A1[Load service account credentials<br/>from JSON file]
            A1 --> A2[Create GoogleCredentials]
            A2 --> A3[Create BigQuery client<br/>with credentials]
            A3 --> A3Check{Success?}
            A3Check -->|No| A3Fail[ERROR: Exit]
            A3Check -->|Yes| DatasetCheck[Dataset Validation]
        end
        
        rect rgb(255, 240, 255)
            Note over DatasetCheck: Dataset Validation & Creation
            DatasetCheck --> D1[FW_GoogleCloudUtils.checkBigQueryDatasetExist]
            D1 --> D1Check{Dataset<br/>exists?}
            D1Check -->|Yes| D1Skip[Dataset OK]
            D1Check -->|No| D2[FW_GoogleCloudUtils.createBigQueryDataset]
            D2 --> D2Check{Created?}
            D2Check -->|No| D2Fail[ERROR: Exit]
            D2Check -->|Yes| D1Skip
            D1Skip --> TableCheck[Table Validation]
        end
        
        rect rgb(240, 255, 240)
            Note over TableCheck: Table Validation & Creation
            TableCheck --> T1[FW_GoogleCloudUtils.checkBigQueryTableExist]
            T1 --> T1Check{Table<br/>exists?}
            T1Check -->|Yes| T1Skip[Table OK]
            T1Check -->|No| T2[FW_GoogleCloudUtils.createBigQueryTable<br/>with schema & time partitioning]
            T2 --> T2Check{Created?}
            T2Check -->|No| T2Fail[ERROR: Exit]
            T2Check -->|Yes| T1Skip
            T1Skip --> TableID[Create TableId]
        end
        
        rect rgb(255, 255, 220)
            Note over TableID: Write Configuration
            TableID --> TC1[Create TableId object]
            TC1 --> TC1Check{Valid?}
            TC1Check -->|No| TC1Fail[ERROR: Exit]
            TC1Check -->|Yes| WC1[Create WriteChannelConfiguration]
            WC1 --> WC2[Set FormatOptions.csv]
            WC2 --> WC3[Set Schema]
            WC3 --> WC4[Set WriteDisposition.WRITE_APPEND]
            WC4 --> WC5[Set maxBadRecords=10]
            WC5 --> WC6[Set ignoreUnknownValues=true]
            WC6 --> WC7[Set autodetect=false]
            WC7 --> WC7Check{Valid?}
            WC7Check -->|No| WC7Fail[ERROR: Exit]
            WC7Check -->|Yes| CSVParse[CSV Parsing]
        end
        
        rect rgb(220, 255, 255)
            Note over CSVParse: CSV Parsing with OpenCSV
            CSVParse --> CSV1[Create CSVParser<br/>separator=comma<br/>quote=double-quote<br/>escape=backslash]
            CSV1 --> CSV2[Create BufferedReader from CSV file]
            CSV2 --> CSV3[Create CSVReader with CSVParser]
            CSV3 --> CSV4[Initialize List&lt;RowToInsert&gt;]
            CSV4 --> CSV5[Read header row]
            CSV5 --> CSV5Check{Header<br/>exists?}
            CSV5Check -->|No| CSV5Fail[ERROR: Empty CSV]
            CSV5Check -->|Yes| CSV6[Skip header row<br/>Already in schema]
            CSV6 --> CSV7[Loop: Read next data row]
            CSV7 --> CSV8{More<br/>rows?}
            CSV8 -->|Yes| CSV9[Create Map&lt;String, Object&gt;]
            CSV9 --> CSV10[Loop through headers]
            CSV10 --> CSV11[Map header name to column value]
            CSV11 --> CSV12[Create RowToInsert from Map]
            CSV12 --> CSV13[Add RowToInsert to List]
            CSV13 --> CSV7
            CSV8 -->|No| WriteData[Write to BigQuery]
        end
        
        rect rgb(255, 220, 255)
            Note over WriteData: Batch Insert to BigQuery
            WriteData --> W1[FW_GoogleCloudUtils.writeBigQueryTableRows]
            W1 --> W2[Create InsertAllRequest]
            W2 --> W3[Add all RowToInsert objects]
            W3 --> W4[Execute batch insert]
            W4 --> W5[Monitor job with timeout]
            W5 --> W5Check{Success?}
            W5Check -->|No| W5Fail[ERROR: Insert failed]
            W5Check -->|Yes| W6[Upload Complete]
        end
        
        W6 --> Complete[Return from uploadTestStepsCSV]
    end
    
    Complete --> Archive[Call archiveTestStepsCSV]
    
    subgraph ArchiveFlow["archiveTestStepsCSV() Method"]
        
        Arch1[Start Archive Process]
        
        rect rgb(230, 230, 255)
            Note over Arch1: Archive CSV File
            Arch1 --> Arch2[Get dataOutputPath from config]
            Arch2 --> Arch3[Get dataTestStepsFilename from config]
            Arch3 --> Arch4[Get dataArchivePath from config]
            Arch4 --> Arch5[Generate current timestamp]
            Arch5 --> Arch6[Create archived filename<br/>TestStepsData_YYYY-MM-DD_HH-MM-SS.csv]
            Arch6 --> Arch7[Check CSV file exists]
            Arch7 --> Arch7Check{Exists?}
            Arch7Check -->|No| Arch7Fail[WARN: File not found]
            Arch7Check -->|Yes| Arch8[Move file to archive folder]
            Arch8 --> Arch8Check{Success?}
            Arch8Check -->|No| Arch8Fail[ERROR: Move failed]
            Arch8Check -->|Yes| Arch9[Archive Complete]
        end
        
        Arch9 --> Done[Return from archiveTestStepsCSV]
    end
    
    Archive --> End([Pipeline Complete])
    Skip --> End
    
    style Start fill:#e1f5ff
    style End fill:#e1ffe1
    style Main fill:#fff3e1
    style Upload fill:#ffe1ff
    style Archive fill:#e1e1ff
    style V1Fail fill:#ffcccc
    style V2Fail fill:#ffcccc
    style V3Fail fill:#ffcccc
    style V4Fail fill:#ffcccc
    style V5Fail fill:#ffcccc
    style V6Fail fill:#ffcccc
    style V7Fail fill:#ffcccc
    style F1Fail fill:#ffcccc
    style F2Fail fill:#ffcccc
    style F3Fail fill:#ffcccc
    style S1Fail fill:#ffcccc
    style A3Fail fill:#ffcccc
    style D2Fail fill:#ffcccc
    style T2Fail fill:#ffcccc
    style TC1Fail fill:#ffcccc
    style WC7Fail fill:#ffcccc
    style CSV5Fail fill:#ffcccc
    style W5Fail fill:#ffcccc
```

---

## Configuration Requirements

### Required Properties (testConfig.properties)

```properties
# Google Cloud Project Configuration
googleCloudProjectId=project-mw-automation-v01

# Service Account Credentials
googleCloudServiceAccountJsonFile=src/test/resources/.private/project-mw-automation-v01-50975042309d.json

# BigQuery Dataset & Tables
googleCloudProjectDataset=dataset_automation_01
googleCloudProjectDatasetTableTestSteps=table_teststeps_02
googleCloudProjectDatasetTableTestStepsSchema=src/test/java/framework/data/FW_GoogleCloudBigQueryTableTestStepsSchema.json

# CSV Data Files
dataOutputPath=target/data/
dataTestStepsFilename=TestStepsData.csv
dataArchivePath=target/data/archive/

# Export Control
googleCloudBigQueryExport=true

# Performance Settings
googleCloudBigQueryTimeout=10
googleCloudBigQueryMaxAttempts=10
```

### Required Files

| File | Purpose | Location |
|------|---------|----------|
| **CSV Data File** | Test step results | `target/data/TestStepsData.csv` |
| **Schema File** | BigQuery table definition | `src/test/java/framework/data/FW_GoogleCloudBigQueryTableTestStepsSchema.json` |
| **Service Account** | GCP authentication | `src/test/resources/.private/*.json` |
| **Properties File** | Configuration | `src/test/resources/testConfig.properties` |

---

## Schema Structure

The BigQuery table schema includes 26 columns for comprehensive test step tracking:

### Test Identification (11 columns)
- `clientRefID` - Client reference ID (STRING, REQUIRED)
- `projectRefID` - Project reference ID (STRING, REQUIRED)
- `applicationRefID` - Application reference ID (STRING, REQUIRED)
- `testRunRefID` - Test run reference ID (STRING, REQUIRED)
- `testSuiteRefID` - Test suite reference ID (STRING, REQUIRED)
- `testSuiteName` - Test suite name (STRING, NULLABLE)
- `testCaseRefID` - Test case reference ID (STRING, REQUIRED)
- `testCaseName` - Test case name (STRING, NULLABLE)
- `testCaseRepetition` - Current repetition number (INTEGER, NULLABLE)
- `testCaseRepetitions` - Total repetitions (INTEGER, NULLABLE)
- `testStepRefID` - Test step reference ID (STRING, REQUIRED)

### Test Execution (11 columns)
- `testStepTimestamp` - Execution timestamp (TIMESTAMP, REQUIRED) *[Partition Column]*
- `testStepRefOrder` - Step order (INTEGER, NULLABLE)
- `testStepPageObject` - Page object name (STRING, NULLABLE)
- `testStepMethod` - Method name (STRING, NULLABLE)
- `testStepParameters` - Method parameters (STRING, NULLABLE)
- `testStepResult` - Pass/Fail status (STRING, NULLABLE)
- `testStepResultDetails` - Result details (STRING, NULLABLE)
- `testStepResultMetricKey` - Metric name (STRING, NULLABLE)
- `testStepResultMetricNumber` - Numeric metric (FLOAT, NULLABLE)
- `testStepResultMetricString` - String metric (STRING, NULLABLE)
- `testStepExecuted` - Execution flag (BOOLEAN, NULLABLE)

### Assets & Performance (4 columns)
- `testStepScreenshotRef` - Screenshot URL (STRING, NULLABLE)
- `testStepScreenshotThumbRef` - Thumbnail URL (STRING, NULLABLE)
- `testStepDurationHR` - Duration in seconds (FLOAT, NULLABLE)
- `testStepDurationMS` - Duration in milliseconds (INTEGER, NULLABLE)

### Geolocation (9 columns)
- `locLatitude` - Latitude (FLOAT, NULLABLE)
- `locLongitude` - Longitude (FLOAT, NULLABLE)
- `locIPAddress` - IP address (STRING, NULLABLE)
- `locCountryCode` - Country code (STRING, NULLABLE)
- `locStateCode` - State code (STRING, NULLABLE)
- `locCityName` - City name (STRING, NULLABLE)
- `locASN` - Autonomous system number (INT64, NULLABLE)
- `locOrganizationName` - ISP/organization (STRING, NULLABLE)

**Table Features:**
- Time partitioning on `testStepTimestamp` column
- Write disposition: `WRITE_APPEND` (incremental loads)
- Max bad records: 10
- Ignore unknown values: true

---

## Data Flow Details

### 1. CSV Generation (Before Upload)
**Source**: Test execution results  
**Location**: `target/data/TestStepsData.csv`  
**Format**: CSV with header row  
**Generation**: `FW_TestStepDataProcessor` writes during test execution

### 2. CSV Parsing (During Upload)
**Library**: OpenCSV 5.x  
**Parser Configuration**:
```java
CSVParser parser = new CSVParserBuilder()
    .withSeparator(',')
    .withQuoteChar('"')
    .withEscapeChar('\\')
    .build();
```

**Reader Configuration**:
```java
CSVReader csvReader = new CSVReaderBuilder(reader)
    .withCSVParser(parser)
    .build();
```

### 3. Data Transformation
**Process**:
1. Read header row → Extract column names
2. Skip header (already defined in schema)
3. For each data row:
   - Create `Map<String, Object>`
   - Map each column name to its value
   - Create `RowToInsert` from map
   - Add to collection

**Example**:
```java
Map<String, Object> row = new HashMap<>();
for (int i = 0; i < headers.length; i++) {
    row.put(headers[i], record[i]);
}
rows.add(RowToInsert.of(row));
```

### 4. Batch Upload
**Method**: `FW_GoogleCloudUtils.writeBigQueryTableRows()`  
**Parameters**:
- `BigQuery bigquery` - Authenticated client
- `String dataset` - Dataset name
- `String table` - Table name
- `List<RowToInsert> rows` - Data to insert
- `int timeout` - Timeout in seconds

**Process**:
1. Create `InsertAllRequest` with rows
2. Execute batch insert
3. Wait for job completion (with timeout)
4. Validate success/failure
5. Return results

---

## Error Handling

The pipeline includes comprehensive error handling at each stage:

### Configuration Validation Errors
**Triggers**:
- Missing required properties in `testConfig.properties`
- Invalid file paths
- Empty or null values

**Action**:
- Log error with `FW_ConsoleColors.RED`
- Print error message to console
- Early return from method
- Pipeline exits gracefully

**Example Output**:
```
  - FAIL: googleCloudProjectId not configured in testConfig.properties
```

### File Existence Errors
**Triggers**:
- CSV file not found
- Schema JSON file not found
- Service account file not found

**Action**:
- File path validation using `Files.exists()`
- Detailed error message with expected path
- Early return from method

**Example Output**:
```
  - FAIL: CSV file does not exist at target/data/TestStepsData.csv
```

### Authentication Errors
**Triggers**:
- Invalid service account credentials
- Expired credentials
- Insufficient permissions

**Action**:
- Catch `IOException` during credential loading
- Log authentication failure
- Exit pipeline

**Example Output**:
```
  - FAIL: BigQuery client credentials failed. Error: Invalid credentials
```

### BigQuery Operation Errors
**Triggers**:
- Dataset creation failure
- Table creation failure
- Schema validation failure
- Insert operation failure

**Action**:
- Catch `BigQueryException`
- Log specific error message
- Rollback if necessary
- Exit pipeline

**Example Output**:
```
  - FAIL: Dataset creation failed.
  - FAIL: Table creation failed.
  - FAIL: Error writing data to BigQuery: [error details]
```

### CSV Parsing Errors
**Triggers**:
- Malformed CSV data
- Empty CSV file
- Missing header row
- Column mismatch

**Action**:
- Catch `IOException` and `CsvValidationException`
- Log parsing error details
- Skip malformed rows if possible
- Exit if critical error

**Example Output**:
```
  - FAIL: Error reading CSV file: Malformed CSV data at line 42
  - FAIL: CSV file is empty or missing a header row.
```

### Archive Errors
**Triggers**:
- File already exists in archive (shouldn't happen with timestamps)
- Insufficient permissions
- Disk space issues

**Action**:
- Catch during file move operation
- Log warning (non-fatal)
- CSV remains in output folder

**Example Output**:
```
  - FAIL: File 'TestStepsData.csv' failed to move to archive folder
```

---

## Performance Considerations

### Batch Insertion
**Benefit**: Reduces API calls and improves throughput  
**Implementation**: Collects all rows before single insert operation  
**Trade-off**: Higher memory usage for large CSV files

### Time Partitioning
**Column**: `testStepTimestamp`  
**Benefit**: Improved query performance for time-based queries  
**Cost Reduction**: Only scans relevant partitions

### Write Disposition
**Setting**: `WRITE_APPEND`  
**Benefit**: Incremental loads without overwriting  
**Use Case**: Continuous test execution results

### Timeout Configuration
**Default**: 10 seconds  
**Configurable**: Via `googleCloudBigQueryTimeout` property  
**Purpose**: Prevents hanging on slow network or large uploads

### File Archiving
**Timing**: After successful upload  
**Format**: `TestStepsData_2025-10-30_13-45-00.csv`  
**Benefit**: Historical record of uploads

---

## Integration with Maven

### POM Configuration

The upload process is triggered via the `exec-maven-plugin`:

```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>exec-maven-plugin</artifactId>
    <version>3.5.1</version>
    <executions>
        <execution>
            <phase>post-integration-test</phase>
            <id>google-cloud-export-data</id>
            <goals>
                <goal>java</goal>
            </goals>
            <configuration>
                <mainClass>framework.data.FW_GoogleCloudBigQueryUploader</mainClass>
                <classpathScope>test</classpathScope>
            </configuration>
        </execution>
    </executions>
</plugin>
```

### Maven Phases

The upload occurs in the standard Maven lifecycle:

1. `test` - Execute JUnit tests
2. `integration-test` - Run integration tests
3. **`post-integration-test`** - Upload to BigQuery ← **(This phase)**
4. `verify` - Verify results
5. `install` - Install artifacts

### Disabling Upload

To disable BigQuery upload, set in `testConfig.properties`:

```properties
googleCloudBigQueryExport=false
```

This causes the `main()` method to return immediately without processing.

---

## Related Components

### FW_GoogleCloudBigQueryUploader
**Location**: `src/test/java/framework/data/FW_GoogleCloudBigQueryUploader.java`  
**Purpose**: Main orchestration class for CSV upload  
**Key Methods**:
- `main(String[] args)` - Entry point
- `uploadTestStepsCSV()` - Upload orchestration
- `archiveTestStepsCSV()` - File archiving

### FW_GoogleCloudUtils
**Location**: `src/test/java/framework/utilities/FW_GoogleCloudUtils.java`  
**Purpose**: Reusable Google Cloud utility methods  
**Key Methods**:
- `readSchemaFromFile(Path)` - Parse JSON schema
- `checkBigQueryDatasetExist(BigQuery, String)` - Dataset validation
- `createBigQueryDataset(BigQuery, String)` - Dataset creation
- `checkBigQueryTableExist(BigQuery, String, String)` - Table validation
- `createBigQueryTable(BigQuery, String, String, String, Schema)` - Table creation
- `writeBigQueryTableRows(BigQuery, String, String, List<RowToInsert>, int)` - Batch insert

### FW_GoogleCloudStorageUploader
**Location**: `src/test/java/framework/data/FW_GoogleCloudStorageUploader.java`  
**Purpose**: Upload screenshots to Google Cloud Storage  
**Integration**: Runs in same `post-integration-test` phase

### FW_TestStepDataProcessor
**Location**: `src/test/java/framework/data/FW_TestStepDataProcessor.java`  
**Purpose**: Generates CSV file during test execution  
**Output**: Creates `TestStepsData.csv` that this pipeline uploads

---

## Monitoring & Validation

### Console Output

The upload process provides color-coded console output:

```
- - - - - Google Cloud - BigQuery Data Export - (Begin) - - - - -

- Check required testConfig.properties parameters exist...
  - PASS: googleCloudProjectId configured in testConfig.properties
  - PASS: googleCloudServiceAccountJsonFile configured in testConfig.properties
  - PASS: googleCloudProjectDataset configured in testConfig.properties
  - PASS: googleCloudProjectDatasetTableTestSteps configured in testConfig.properties
  - PASS: googleCloudProjectDatasetTableTestStepsSchema configured in testConfig.properties
  - PASS: dataOutputPath configured in testConfig.properties
  - PASS: dataTestStepsFilename configured in testConfig.properties

- Check required files exist...
  - PASS: CSV file exists at target/data/TestStepsData.csv
  - PASS: Schema file exists at src/test/java/framework/data/FW_GoogleCloudBigQueryTableTestStepsSchema.json
  - PASS: Service Account file exists at src/test/resources/.private/project-*.json

- Google Cloud - BigQuery - Read Schema...
  - PASS: Schema read successfully.

- Google Cloud - BigQuery - Access API Key...
  - PASS: BigQuery credentials are working. (Dataset:dataset_automation_01)

- Google Cloud - BigQuery - Verify Dataset...
  - PASS: Dataset already exists.

- Google Cloud - BigQuery - Verify Table...
  - PASS: Table already exists.

- Google Cloud - BigQuery - Create Write Channel Configuration...
  - PASS: Table ID created successfully.
  - PASS: WriteChannelConfiguration created successfully.

- Google Cloud - BigQuery - Read CSV File...
  - INFO: CSV Parser created.
  - INFO: CSV Reader created.
  - INFO: Skipping header row. (26 columns)

- Google Cloud - BigQuery - Load Data into BigQuery...
  - PASS: Data written to BigQuery successfully.

- - - - - Google Cloud - BigQuery Data Export - (End) - - - - -
```

### BigQuery Validation

After upload, verify data in BigQuery:

```sql
-- Count records in table
SELECT COUNT(*) as total_records
FROM `project-mw-automation-v01.dataset_automation_01.table_teststeps_02`;

-- View recent test steps
SELECT testStepTimestamp, testSuiteName, testCaseName, testStepResult
FROM `project-mw-automation-v01.dataset_automation_01.table_teststeps_02`
ORDER BY testStepTimestamp DESC
LIMIT 100;

-- Check for data quality issues
SELECT 
    COUNT(*) as total_rows,
    COUNT(DISTINCT testRunRefID) as unique_runs,
    COUNT(DISTINCT testSuiteRefID) as unique_suites,
    SUM(CASE WHEN testStepResult = 'Pass' THEN 1 ELSE 0 END) as passed_steps,
    SUM(CASE WHEN testStepResult = 'Fail' THEN 1 ELSE 0 END) as failed_steps
FROM `project-mw-automation-v01.dataset_automation_01.table_teststeps_02`
WHERE DATE(testStepTimestamp) = CURRENT_DATE();
```

---

## Troubleshooting

### Issue: "googleCloudProjectId not configured"
**Cause**: Missing or commented property in `testConfig.properties`  
**Solution**: Add `googleCloudProjectId=your-project-id`

### Issue: "CSV file does not exist"
**Cause**: Tests didn't generate CSV, or wrong output path  
**Solution**:
- Verify tests ran successfully
- Check `dataOutputPath` in properties
- Verify `FW_TestStepDataProcessor` is enabled

### Issue: "BigQuery client credentials failed"
**Cause**: Invalid service account file or permissions  
**Solution**:
- Verify JSON file path is correct
- Check service account has BigQuery Data Editor role
- Verify project ID matches

### Issue: "Dataset creation failed"
**Cause**: Insufficient permissions or invalid dataset name  
**Solution**:
- Grant BigQuery Admin role to service account
- Verify dataset name follows naming rules (lowercase, no spaces)

### Issue: "Error writing data to BigQuery"
**Cause**: Schema mismatch, quota exceeded, or network issues  
**Solution**:
- Verify CSV columns match schema exactly
- Check BigQuery quota limits
- Test network connectivity to `bigquery.googleapis.com`

### Issue: "File failed to move to archive folder"
**Cause**: Archive directory doesn't exist or permissions issue  
**Solution**:
- Create archive directory: `mkdir -p target/data/archive`
- Verify write permissions on directory

---

## Best Practices

### 1. Service Account Security
- Store credentials in `.private` folder (gitignored)
- Use least-privilege permissions
- Rotate credentials regularly
- Never commit credentials to version control

### 2. Schema Management
- Version control schema JSON files
- Test schema changes in non-prod dataset first
- Document schema evolution
- Use compatible field types for downstream analytics

### 3. Data Quality
- Validate CSV before upload in `FW_TestStepDataProcessor`
- Implement data quality checks in BigQuery
- Monitor for null values in required fields
- Set up alerts for upload failures

### 4. Performance Optimization
- Archive old CSV files regularly to prevent disk space issues
- Consider compressing archived CSVs
- Monitor BigQuery storage costs
- Use clustering in addition to partitioning for large tables

### 5. Error Recovery
- Implement retry logic for transient failures
- Keep archived CSVs for re-upload if needed
- Log all errors to file for troubleshooting
- Set up monitoring alerts for pipeline failures

---

## Related Documentation

- [Data Collection Flow](Diagram-Adding-data-to-datacollector.md) - How CSV is generated
- [Test Assets Scanner](Diagram-TestAssetsScanner.md) - Test discovery process
- [Maven to Test Case](Diagram-Maven-to-first-Test-Case.md) - Complete test execution flow
- [Google Cloud Storage Upload](../data/FW_GoogleCloudStorageUploader.java) - Screenshot uploads
- [Framework Overview](Doc-Overview.md) - Architecture overview

---

**Version**: 2.0.0  
**Last Updated**: 2025-10-30 01:30:00 PM CDT  
**Copyright** © 2025 MissionWares. All Rights Reserved.