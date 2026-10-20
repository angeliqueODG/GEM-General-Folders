package framework.junit;

/**
 * Represents the details of a test case within a test suite.
 */
public class FW_TestCase {
    private String suiteName;
    private String testCaseName;
    private String displayName;
    private String tags;
    private boolean isDisabled;
    private int repetitions;
    private int testSteps; // Refactored field for test steps

    /**
     * Constructs a new FW_TestCase with the specified details.
     *
     * @param suiteName    the name of the test suite
     * @param testCaseName the name of the test case
     * @param displayName  the display name of the test case
     * @param tags         the tags associated with the test case, comma-separated
     * @param isDisabled   whether the test case is disabled
     * @param repetitions  the number of repetitions for the test case
     */
    public FW_TestCase(String suiteName, String testCaseName, String displayName, String tags, boolean isDisabled, int repetitions) {
        this.suiteName = suiteName;
        this.testCaseName = testCaseName;
        this.displayName = displayName;
        this.tags = tags;
        this.isDisabled = isDisabled;
        this.repetitions = repetitions;
        this.testSteps = 0; // Initialize test steps
    }

    // Getters and setters
    public String getSuiteName() {
        return suiteName;
    }

    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public int getTestSteps() {
        return testSteps;
    }

    public void setTestSteps(int testSteps) {
        this.testSteps = testSteps;
    }

    /**
     * Updates the status of a test step.
     *
     * @param stepName the name of the test step
     * @param passed   whether the test step passed
     */
    public void updateStepStatus(String stepName, boolean passed) {
        // Implement logic to update step status
        // This is a placeholder implementation
        System.out.println("Updating step '" + stepName + "' to " + (passed ? "passed" : "failed"));
    }

    @Override
    public String toString() {
        return "FW_TestCase{" +
                "suiteName='" + suiteName + '\'' +
                ", testCaseName='" + testCaseName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", tags='" + tags + '\'' +
                ", isDisabled=" + isDisabled +
                ", repetitions=" + repetitions +
                ", testSteps=" + testSteps +
                '}';
    }
}