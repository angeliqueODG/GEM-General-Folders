# Automation Framework - Diagram - Automation completed to Google BigData

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Overview.md) | [Setup](Setup.md) | [Test](Test.md) | [Diagrams](Diagrams.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

## Description
This diagram covers the flow at the point the automated testing has completed and Maven kicks off the process to move the test data into Google BigQuery.

```mermaid
flowchart TD

    subgraph POM
        P1[post-integration-test
        FW_BigQueryUploader]
    end

    subgraph FW_BigQueryUploader
        P1 --> BQU1[main]
        BQU1 <--> uploadTestStepsCSV
            
        subgraph uploadTestStepsCSV
            BQU-UTSCVS1[Get testConfig.properties parameters] --> BQU-UTSCVS2
            BQU-UTSCVS2[Check CSV file exists] --> BQU-UTSCVS3
            BQU-UTSCVS3[Check schema file exists] --> BQU-UTSCVS4
            BQU-UTSCVS4[Check service account file exists] --> BQU-UTSCVS5
            BQU-UTSCVS5[Set service account credentials] --> BQU-UTSCVS6
            BQU-UTSCVS6[Get service account credentials] --> BQU-UTSCVS7
            BQU-UTSCVS7[Create BigQuery client with account credentials] --> BQU-UTSCVS8
            BQU-UTSCVS8[Create a table ID] --> BQU-UTSCVS9
            BQU-UTSCVS9[Read schema JSON file] --> BQU-UTSCVS10
            BQU-UTSCVS10[Create WriteChannelConfiguration - Include Options] --> BQU-UTSCVS11
            BQU-UTSCVS11[Create TableDataWriteChannel] --> BQU-UTSCVS12
            BQU-UTSCVS12[Write CSV to WritableByteChannel] --> WriteCSVtoWritableByteChannel

                subgraph WriteCSVtoWritableByteChannel
                    BQU-UTSCVS13[Setup ByteBuffer] --> BQU-UTSCVS14
                    BQU-UTSCVS14[Create File Input Stream] --> BQU-UTSCVS15
                    BQU-UTSCVS15[Read File Input Stream] --> BQU-UTSCVS16
                    BQU-UTSCVS16[Read First Stream Row] --> BQU-UTSCVS17
                    BQU-UTSCVS17[Skip First Stream Row] --> BQU-UTSCVS18
                    BQU-UTSCVS18[Read and Write Remaining Stream Rows]
                end

            WriteCSVtoWritableByteChannel --> BQU-UTSCVS19
            BQU-UTSCVS19[Wait for job to complete]
        end
    end