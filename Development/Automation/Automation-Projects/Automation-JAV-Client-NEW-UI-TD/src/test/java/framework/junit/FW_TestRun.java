package framework.junit;

/**
 * Represents the summary metrics of a test run.
 */
public class FW_TestRun {
    // Total counts
    private int totalTestSuites;
    private int totalTestCases;
    private int totalTestSteps;

    // Executable counts
    private int executableTestCases;
    private int executableTestSteps;

    // Repeating counts
    private int repeatingTestCases;
    private int repeatingTestSteps;

    // Disabled counts
    private int disabledTestCases;
    private int disabledTestSteps;

    // Completed counts
    private int completedTestSuites;
    private int completedTestCases;
    private int completedTestSteps;

    // Remaining counts
    private int remainingTestSuites;
    private int remainingTestCases;
    private int remainingTestSteps;

    // Passed counts
    private int passedTestSuites;
    private int passedTestCases;
    private int passedTestSteps;

    // Failed counts
    private int failedTestSuites;
    private int failedTestCases;
    private int failedTestSteps;

    // Total run time
    private long totalRunTime;

    // Getters and setters for each field

    // Total counts
    public int getTotalTestSuites() {
        return totalTestSuites;
    }

    public void setTotalTestSuites(int totalTestSuites) {
        this.totalTestSuites = totalTestSuites;
    }

    public int getTotalTestCases() {
        return totalTestCases;
    }

    public void setTotalTestCases(int totalTestCases) {
        this.totalTestCases = totalTestCases;
    }

    public int getTotalTestSteps() {
        return totalTestSteps;
    }

    public void setTotalTestSteps(int totalTestSteps) {
        this.totalTestSteps = totalTestSteps;
    }

    // Executable counts
    public int getExecutableTestCases() {
        return executableTestCases;
    }

    public void setExecutableTestCases(int executableTestCases) {
        this.executableTestCases = executableTestCases;
    }

    public int getExecutableTestSteps() {
        return executableTestSteps;
    }

    public void setExecutableTestSteps(int executableTestSteps) {
        this.executableTestSteps = executableTestSteps;
    }

    // Repeating counts
    public int getRepeatingTestCases() {
        return repeatingTestCases;
    }

    public void setRepeatingTestCases(int repeatingTestCases) {
        this.repeatingTestCases = repeatingTestCases;
    }

    public int getRepeatingTestSteps() {
        return repeatingTestSteps;
    }

    public void setRepeatingTestSteps(int repeatingTestSteps) {
        this.repeatingTestSteps = repeatingTestSteps;
    }

    // Disabled counts
    public int getDisabledTestCases() {
        return disabledTestCases;
    }

    public void setDisabledTestCases(int disabledTestCases) {
        this.disabledTestCases = disabledTestCases;
    }

    public int getDisabledTestSteps() {
        return disabledTestSteps;
    }

    public void setDisabledTestSteps(int disabledTestSteps) {
        this.disabledTestSteps = disabledTestSteps;
    }

    // Completed counts
    public int getCompletedTestSuites() {
        return completedTestSuites;
    }

    public void setCompletedTestSuites(int completedTestSuites) {
        this.completedTestSuites = completedTestSuites;
    }

    public int getCompletedTestCases() {
        return completedTestCases;
    }

    public void setCompletedTestCases(int completedTestCases) {
        this.completedTestCases = completedTestCases;
    }

    public int getCompletedTestSteps() {
        return completedTestSteps;
    }

    public void setCompletedTestSteps(int completedTestSteps) {
        this.completedTestSteps = completedTestSteps;
    }

    // Remaining counts
    public int getRemainingTestSuites() {
        return remainingTestSuites;
    }

    public void setRemainingTestSuites(int remainingTestSuites) {
        this.remainingTestSuites = remainingTestSuites;
    }

    public int getRemainingTestCases() {
        return remainingTestCases;
    }

    public void setRemainingTestCases(int remainingTestCases) {
        this.remainingTestCases = remainingTestCases;
    }

    public int getRemainingTestSteps() {
        return remainingTestSteps;
    }

    public void setRemainingTestSteps(int remainingTestSteps) {
        this.remainingTestSteps = remainingTestSteps;
    }

    // Passed counts
    public int getPassedTestSuites() {
        return passedTestSuites;
    }

    public void setPassedTestSuites(int passedTestSuites) {
        this.passedTestSuites = passedTestSuites;
    }

    public int getPassedTestCases() {
        return passedTestCases;
    }

    public void setPassedTestCases(int passedTestCases) {
        this.passedTestCases = passedTestCases;
    }

    public int getPassedTestSteps() {
        return passedTestSteps;
    }

    public void setPassedTestSteps(int passedTestSteps) {
        this.passedTestSteps = passedTestSteps;
    }

    // Failed counts
    public int getFailedTestSuites() {
        return failedTestSuites;
    }

    public void setFailedTestSuites(int failedTestSuites) {
        this.failedTestSuites = failedTestSuites;
    }

    public int getFailedTestCases() {
        return failedTestCases;
    }

    public void setFailedTestCases(int failedTestCases) {
        this.failedTestCases = failedTestCases;
    }

    public int getFailedTestSteps() {
        return failedTestSteps;
    }

    public void setFailedTestSteps(int failedTestSteps) {
        this.failedTestSteps = failedTestSteps;
    }

    // Total run time
    public long getTotalRunTime() {
        return totalRunTime;
    }

    public void setTotalRunTime(long totalRunTime) {
        this.totalRunTime = totalRunTime;
    }

    @Override
    public String toString() {
        return "FW_TestRun{" +
                "totalTestSuites=" + totalTestSuites +
                ", totalTestCases=" + totalTestCases +
                ", executableTestCases=" + executableTestCases +
                ", repeatingTestCases=" + repeatingTestCases +
                ", disabledTestCases=" + disabledTestCases +
                ", completedTestCases=" + completedTestCases +
                ", remainingTestCases=" + remainingTestCases +
                ", passedTestCases=" + passedTestCases +
                ", failedTestCases=" + failedTestCases +
                ", totalRunTime=" + totalRunTime +
                ", totalTestSteps=" + totalTestSteps +
                ", executableTestSteps=" + executableTestSteps +
                ", repeatingTestSteps=" + repeatingTestSteps +
                ", disabledTestSteps=" + disabledTestSteps +
                ", completedTestSteps=" + completedTestSteps +
                ", remainingTestSteps=" + remainingTestSteps +
                ", passedTestSteps=" + passedTestSteps +
                ", failedTestSteps=" + failedTestSteps +
                ", completedTestSuites=" + completedTestSuites +
                ", remainingTestSuites=" + remainingTestSuites +
                ", passedTestSuites=" + passedTestSuites +
                ", failedTestSuites=" + failedTestSuites +
                '}';
    }
}