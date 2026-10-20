# Maven Verify Process to First Test Case Execution

```mermaid
graph TB
    subgraph Terminal
        T1[Run Command: mvn verify]
    end
    T1 --> M1[Maven]
    subgraph Maven
        M1[Maven Initialization]
        M1 --> M2[Validate Phase]
        M2 --> M3[Compile Phase]
        M3 --> M4[Test Phase]
        M4 --> M5[Surefire Plugin Execution]
        M5 --> M6[Test Execution]
    end
    M6 --> TS1[TS_SwagLabs_JUnit Execution]
    subgraph TS_SwagLabs_JUnit
        TS1 --> TS2a[BeforeAll: setupTestSuite]
        subgraph BeforeAll
            TS2a[Create anonymous object and get class name]
            TS2a --> TS2b[Call FW_TestSuiteFormatter.beforeAll with class name]
            TS2b --> TS2c[Load testConfig.properties]
        end
        TS2c --> TS3a[BeforeEach: setupTestCase]
        subgraph BeforeEach
            TS3a[Call FW_TestSuiteFormatter.beforeEach with testInfo]
            TS3a --> TS3b[Instantiate FW_Audit_Connectivity]
            TS3b --> TS3c[Instantiate FW_Audit_Sandbox]
            TS3c --> TS3d[Instantiate FW_Network]
            TS3d --> TS3e[Create WebDriver]
            TS3e --> TS3f[Instantiate Page Objects]
        end
        TS3f --> TS4[First Test Case: TC - SwagLabs - Missing Username and Password]
    end

    subgraph FW_TestSuiteFormatter
        TS2b <--> TSF1[beforeAll: ]
        TSF1 --> TSF2[Get Suites,Cases & Steps totals]
        TSF2 --> TSF3[Print test details to terminal]
        TS3a <--> TSF3[beforeEach: ]
    end

    subgraph FW_TestRunTracker
        TSF1 <--> TRT1[getInstance: FW_TestRunTracker singlton]
    end

    subgraph FW_ConfigMgr
        TS2c <--> CM1[getInstance: FW_ConfigMgr]
    end
    