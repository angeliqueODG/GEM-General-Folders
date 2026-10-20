package framework.data;

import java.util.concurrent.ConcurrentLinkedQueue;
import framework.junit.FW_TestStep;

/**
 * @file FW_TestStepDataCollector.java
 * @description Collects test step data and triggers processing.
 * 
 * This file contains the FW_TestStepDataCollector class which provides methods to collect test step data and trigger its processing.
 * It includes functionalities to add test steps to a queue and initiate the processing of these test steps based on batch size or immediate processing.
 * 
 * The FW_TestStepDataCollector class offers functionalities to:
 * - Collect test step data and add it to a queue.
 * - Trigger the processing of test steps when the batch size is reached or immediate processing is required.
 * 
 * This class is designed to facilitate the collection and processing of test step data, ensuring that test results are efficiently managed and processed.
 * 
 * @version 1.1
 * @since 2025-01-09
 */

public class FW_TestStepDataCollector {

    // A queue to store test steps because we can collect multiple test steps before processing them
    private static ConcurrentLinkedQueue<FW_TestStep> testStepQueue = new ConcurrentLinkedQueue<>();

    // Data processor once the batch size is reached (10 in this case)
    private static FW_TestStepDataProcessor dataProcessor = new FW_TestStepDataProcessor(true, 1);

    /**
     * Collects test step data and triggers processing.
     * 
     * @param testStep The test step to be collected.
     */
    public static void collect(FW_TestStep testStep) {
        try {
            // Add the test step to the queue
            testStepQueue.add(testStep);

            // Process the test steps if the batch size is reached process the queue.
            if (!dataProcessor.isBatchProcessing() || testStepQueue.size() >= dataProcessor.getBatchSize()) {
                
                // Process the test steps queue
                dataProcessor.processTestSteps(testStepQueue);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Consider logging the exception or handling it appropriately
        }
    }

    /**
     * Processes any remaining test steps in the queue.
     */
    public static void processRemainingTestSteps() {
        try {
            if (!testStepQueue.isEmpty()) {
                dataProcessor.processTestSteps(testStepQueue);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Consider logging the exception or handling it appropriately
        }
    }

}