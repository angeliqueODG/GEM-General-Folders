package framework.junit;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the details and metrics of a test suite.
 */
public class FW_TestSuite {
    private String suiteName;
    private int totalTestCount;
    private int executedTestCount;
    private int repeatingTestCount;
    private int disabledTestCount;
    private List<FW_TestCase> testCases;

    /**
     * Constructs a new FW_TestSuite with the specified suite name.
     *
     * @param suiteName the name of the test suite
     */
    public FW_TestSuite(String suiteName) {
        this.suiteName = suiteName;
        this.testCases = new ArrayList<>();
    }

    // Getters and setters
    public String getSuiteName() {
        return suiteName;
    }

    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }

    public int getTotalTestCount() {
        return totalTestCount;
    }

    public void setTotalTestCount(int totalTestCount) {
        this.totalTestCount = totalTestCount;
    }

    public int getExecutedTestCount() {
        return executedTestCount;
    }

    public void setExecutedTestCount(int executedTestCount) {
        this.executedTestCount = executedTestCount;
    }

    public int getRepeatingTestCount() {
        return repeatingTestCount;
    }

    public void setRepeatingTestCount(int repeatingTestCount) {
        this.repeatingTestCount = repeatingTestCount;
    }

    public int getDisabledTestCount() {
        return disabledTestCount;
    }

    public void setDisabledTestCount(int disabledTestCount) {
        this.disabledTestCount = disabledTestCount;
    }

    public List<FW_TestCase> getTestCases() {
        return testCases;
    }

    public void addTestCase(FW_TestCase testCase) {
        this.testCases.add(testCase);
    }

    @Override
    public String toString() {
        return "FW_TestSuite{" +
                "suiteName='" + suiteName + '\'' +
                ", totalTestCount=" + totalTestCount +
                ", executedTestCount=" + executedTestCount +
                ", repeatingTestCount=" + repeatingTestCount +
                ", disabledTestCount=" + disabledTestCount +
                ", testCases=" + testCases +
                '}';
    }
}