# FW_TestStepDataCollector Class Flow

```mermaid
sequenceDiagram
    participant Test Step Completed
    participant FW_CustomAssertJU
    participant FW_TestStepDataCollector
    participant testStepQueue
    participant dataProcessor
    participant csvWriterUtil
    participant dataConfig

    Note over FW_CustomAssertJU: File: FW_CustomAssertJU.java
    Note over FW_TestStepDataCollector: File: FW_TestStepDataCollector.java
    Note over dataProcessor: File: FW_DataProcessor.java
    Note over csvWriterUtil: File: FW_CSVWriterUtil.java
    Note over dataConfig: File: FW_DataConfig.java

    Test Step Completed->>FW_CustomAssertJU: autoPass(testStep)

    FW_CustomAssertJU->>FW_CustomAssertJU: Adjust counts testStep completed/remaining
    FW_CustomAssertJU->>FW_CustomAssertJU: Analyze and set testStep result
    FW_CustomAssertJU->>FW_CustomAssertJU: Udate testStep with new details
    FW_CustomAssertJU->>FW_TestStepDataCollector: collect(testStepObj)
    
    FW_TestStepDataCollector->>testStepQueue: add(testStepObj)
    alt Batch processing enabled
        FW_TestStepDataCollector->>FW_TestStepDataCollector: Check if testStepQueue size >= batch size
        alt Queue size >= batch size
            FW_TestStepDataCollector->>dataProcessor: processTestSteps(testStepQueue)
            dataProcessor->>csvWriterUtil: writeTestSteps(data)
        else Queue size < batch size
            FW_TestStepDataCollector->>FW_TestStepDataCollector: Wait for more test steps
        end
    else Batch processing disabled
        FW_TestStepDataCollector->>dataProcessor: processTestSteps(testStepQueue)
        dataProcessor->>csvWriterUtil: writeTestSteps(data)
    end
    csvWriterUtil->>dataConfig: getOutputPath()