package framework.data;

// ===============================================================
// @file: FW_TestStepDataCollector.java
// @filepath: src/test/java/framework/data/FW_TestStepDataCollector.java
// @version: 1.2.0
// @updated: 2025-09-09 04:50:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// A central hub for collecting and queuing test step data for asynchronous processing.
// This class uses a thread-safe queue to buffer test steps, decoupling test execution
// from data processing. The processor is automatically triggered when a specified
// batch size is reached or can be invoked manually to process any remaining items.
//
// @methods:
// - collect(FW_TestStep) - Adds a new test step to the queue
// - processRemainingTestSteps() - Processes all test steps left in the queue
//
// @dependencies:
// - framework.junit.FW_TestStep
// - java.util.concurrent.ConcurrentLinkedQueue
//
// @tags: data-collection, async-processing, thread-safe, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-09  G. Paskal       1.0.0    Initial creation
// 2025-01-09  G. Paskal       1.1.0    Added batch processing capability
// 2025-09-09  G. Paskal       1.2.0    Updated header to mAi™ standard format
// ===============================================================

import framework.junit.FW_TestStep;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * A central hub for collecting and queuing test step data for asynchronous processing.
 * This class uses a thread-safe queue to buffer test steps, decoupling test execution
 * from data processing. The processor is automatically triggered when a specified
 * batch size is reached or can be invoked manually to process any remaining items.
 */
public class FW_TestStepDataCollector {

    // A thread-safe queue for buffering collected test steps.
    private static ConcurrentLinkedQueue<FW_TestStep> testStepQueue = new ConcurrentLinkedQueue<>();

    // The processor responsible for handling batches of test steps.
    private static FW_TestStepDataProcessor dataProcessor = new FW_TestStepDataProcessor(true, 1);

    /**
     * Collects a new test step and adds it to the queue for processing.
     *
     * <p>The processor is automatically triggered if the queue size meets or exceeds
     * the configured batch size, or if batch processing is disabled.
     *
     * @param testStep The test step to be collected.
     */
    public static void collect(FW_TestStep testStep) {
        try {
            // Add the test step to the queue.
            testStepQueue.add(testStep);

            // Process the queue if the batch size is met or if batch processing is off.
            if (dataProcessor.isBatchProcessing() == false || testStepQueue.size() >= dataProcessor.getBatchSize()) {
                // Process the test steps from the queue.
                dataProcessor.processTestSteps(testStepQueue);
            }
        } catch (Exception e) {
            System.err.println("Error while collecting or processing test step: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Processes any remaining test steps in the queue.
     *
     * <p>This method should be called at the end of a test run to ensure all
     * buffered test steps are processed and persisted.
     */
    public static void processRemainingTestSteps() {
        try {
            if (testStepQueue.isEmpty() == false) {
                dataProcessor.processTestSteps(testStepQueue);
            }
        } catch (Exception e) {
            System.err.println("Error while processing remaining test steps: " + e.getMessage());
            e.printStackTrace();
        }
    }
}