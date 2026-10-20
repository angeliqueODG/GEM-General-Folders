# Automation Framework - Network Diagnostics

<!-- ===============================================================
@file: Doc-Network-Diagnostics.md
@filepath: src/test/java/framework/.docs/Doc-Network-Diagnostics.md
@version: 1.0.0
@updated: 2025-10-30 01:06:00 PM CDT
@author: Greg Paskal
@company: MissionWares

@description:
Comprehensive guide to the framework's network testing and diagnostic capabilities.
Documents ping testing, traceroute analysis, speed testing, and network performance
measurement tools. Covers FW_Audit_Ping, FW_Audit_Traceroute, FW_Audit_SpeedTest,
FW_NetworkDetails, and the TS_Network_JUnit test suite for comprehensive network
validation and troubleshooting.

@dependencies:
- framework.audits.FW_Audit_Ping
- framework.audits.FW_Audit_Traceroute
- framework.audits.FW_Audit_SpeedTest
- framework.network.FW_NetworkDetails
- framework.utilities.FW_NetworkUtils

@tags: network, diagnostics, ping, traceroute, speedtest, latency, bandwidth

@changeLog:
Date        Author          Version  Description
----------  --------------  -------  --------------------------
2025-10-30  G. Paskal       1.0.0    Initial network diagnostics documentation
=============================================================== -->

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Doc-Overview.md) | [Setup](Doc-Setup.md) | [Test](Doc-Test-Development.md) | [Diagrams](Diagrams.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

# Network Diagnostics

## Introduction

### What is Network Diagnostics?

The Network Diagnostics system provides comprehensive tools for testing, measuring, and analyzing network connectivity, performance, and routing paths. It enables automated validation of network infrastructure, identification of bottlenecks, measurement of bandwidth capabilities, and troubleshooting of connectivity issues.

**Core Capabilities:**
- **Ping Testing** - ICMP connectivity validation with RTT, jitter, packet loss
- **Traceroute Analysis** - Hop-by-hop routing path with geographic location
- **Speed Testing** - Bandwidth measurement for download/upload throughput
- **Network Details** - GeoIP enrichment with ISP, location, coordinates

### Why Network Diagnostics?

Modern web applications depend on reliable, fast network connectivity. Network diagnostics help:

**For QA Engineers:**
- Validate application accessibility from different locations
- Measure performance baseline for load testing
- Identify network-related test failures
- Document environmental conditions

**For DevOps:**
- Troubleshoot connectivity issues
- Validate infrastructure changes
- Monitor network performance trends
- Diagnose routing problems

**For Support Teams:**
- Reproduce customer network issues
- Identify geographic connectivity problems
- Measure actual vs. expected performance
- Provide data for troubleshooting

---

## Architecture Components

The network diagnostics system consists of 4 core components:

### 1. FW_Audit_Ping
**Purpose**: ICMP echo request/reply testing

**Capabilities:**
- Multi-ping execution (customizable count)
- RTT statistics (min/max/avg)
- Packet loss measurement
- Jitter calculation
- Standard deviation analysis
- GeoIP enrichment

**Metrics Collected:**
- Packet loss percentage
- Average RTT (Round-Trip Time)
- Minimum RTT
- Maximum RTT
- Jitter (variation between pings)
- Standard deviation

### 2. FW_Audit_Traceroute
**Purpose**: Network path analysis

**Capabilities:**
- Hop-by-hop route tracing
- Per-hop RTT measurement
- Geographic location per hop
- Packet loss per hop
- Early termination detection
- Platform-specific implementation (Windows/Unix)

**Metrics Collected:**
- Total hops count
- Unreachable hops
- Latency per hop (min/max/avg)
- Geographic path visualization
- ISP information per hop

### 3. FW_Audit_SpeedTest
**Purpose**: Bandwidth measurement

**Capabilities:**
- Download speed testing
- Upload speed testing
- Latency measurement
- Jitter calculation
- Quality score computation
- Regional server selection

**Metrics Collected:**
- Download speed (Mbps)
- Upload speed (Mbps)
- Latency (ms)
- Jitter (ms)
- Quality score (0-100)
- Quality rating (Excellent → Very Poor)

### 4. FW_NetworkDetails
**Purpose**: Network enrichment data

**Capabilities:**
- GeoIP lookup (IP → Location)
- ISP identification
- ASN (Autonomous System Number)
- Coordinates (latitude/longitude)
- Country/region/city resolution

---

## Ping Testing

### What is Ping Testing?

Ping uses ICMP (Internet Control Message Protocol) echo requests to verify network connectivity, measure round-trip time, and detect packet loss. Essential for:
- Validating host reachability
- Measuring network latency
- Detecting intermittent connectivity
- Establishing baseline performance

### Using FW_Audit_Ping

**Direct API Usage:**
```java
FW_Audit_Ping ping = FW_AuditManager.INSTANCE.getAuditPing();
Object result = ping.runAuditPing(
    "www.example.com",  // target host
    10,                  // ping count
    2,                   // timeout (seconds)
    true                 // verbose output
);
```

**Test Suite Usage:**
```java
@Test
@Tag("network")
@DisplayName("TC - Ping - Google DNS")
public void tc_ping_google_dns() {
    FW_CustomAssertJU.autoPass(
        FW_AuditManager.INSTANCE.getAuditPing()
            .runAuditPing("8.8.8.8", 5, 2, true)
    );
}
```

### Interpreting Ping Results

**Successful Ping Example:**
```
[Pass] - {0.045} - Ping successful: 'www.example.com' 
PacketLoss: 0.0%, AverageRTT: 45.2 ms, MinimumRTT: 42.1 ms, 
MaximumRTT: 48.7 ms, Jitter: 2.3 ms, StdDev: 1.8 ms
```

**Metrics Explained:**
- **PacketLoss: 0.0%** - No packets lost (good)
- **AverageRTT: 45.2 ms** - Average round-trip time
- **MinimumRTT: 42.1 ms** - Best case latency
- **MaximumRTT: 48.7 ms** - Worst case latency
- **Jitter: 2.3 ms** - Variation between pings (low is good)
- **StdDev: 1.8 ms** - Consistency metric (low is good)

### Ping Thresholds

**RTT (Round-Trip Time):**
- < 50ms: Excellent (local or nearby server)
- 50-100ms: Good (regional server)
- 100-200ms: Fair (cross-country)
- 200-500ms: Poor (international or congested)
- > 500ms: Very Poor (satellite or severe congestion)

**Packet Loss:**
- 0%: Perfect
- < 1%: Excellent
- 1-5%: Acceptable
- 5-10%: Concerning (investigate)
- > 10%: Critical (major issues)

**Jitter:**
- < 5ms: Excellent (stable connection)
- 5-20ms: Good
- 20-50ms: Fair (some variation)
- > 50ms: Poor (unstable connection)

### Use Cases

**Connectivity Validation:**
```java
// Verify target is reachable before running tests
@BeforeAll
public static void verifyConnectivity() {
    Object pingResult = FW_AuditManager.INSTANCE.getAuditPing()
        .runAuditPing("www.saucedemo.com", 3, 2, false);
    
    // Test suite proceeds only if ping succeeds
    assertTrue(pingResult.toString().contains("[Pass]"));
}
```

**Performance Baselining:**
```java
// Measure baseline network performance
@Test
public void measureNetworkBaseline() {
    Map<String, Object> baseline = new HashMap<>();
    
    // Test multiple endpoints
    for (String host : Arrays.asList("google.com", "github.com", "example.com")) {
        Object result = FW_AuditManager.INSTANCE.getAuditPing()
            .runAuditPing(host, 10, 2, false);
        baseline.put(host, result);
    }
    
    // Store baseline for comparison in future test runs
}
```

---

## Traceroute Analysis

### What is Traceroute?

Traceroute displays the network path (route) packets take from source to destination, showing each "hop" along the way with timing and location data. Critical for:
- Diagnosing routing issues
- Identifying network bottlenecks
- Understanding geographic path
- Troubleshooting latency spikes

### Using FW_Audit_Traceroute

**Direct API Usage:**
```java
FW_Audit_Traceroute traceroute = FW_AuditManager.INSTANCE.getAuditTraceroute();
Object result = traceroute.runAuditTraceroute(
    "www.example.com",  // target host
    120,                 // max duration (seconds)
    30,                  // max hops
    true                 // verbose output
);
```

**Test Suite Usage:**
```java
@Test
@Tag("network")
@DisplayName("TC - Traceroute - Production Server")
public void tc_traceroute_production() {
    FW_CustomAssertJU.autoPass(
        FW_AuditManager.INSTANCE.getAuditTraceroute()
            .runAuditTraceroute("prod.example.com", 120, 30, true)
    );
}
```

### Interpreting Traceroute Results

**Traceroute Output Example:**
```
Hop 1: 192.168.1.1 (gateway.local) - 2.1 ms
       [Location: Local Network - ISP: N/A]
       
Hop 2: 10.25.34.1 (isp-router.net) - 8.5 ms
       [Location: Chapel Hill, TN, US - ISP: AT&T]
       
Hop 3: 12.122.135.1 (core-router.att.net) - 15.3 ms
       [Location: Nashville, TN, US - ISP: AT&T]
       
Hop 4: 192.205.34.219 (peer.example.net) - 22.7 ms
       [Location: Atlanta, GA, US - ISP: Example Hosting]
       
Hop 5: 203.0.113.100 (www.example.com) - 28.4 ms  [DESTINATION]
       [Location: Atlanta, GA, US - ISP: Example CDN]

Total Hops: 5
Unreachable Hops: 0
Average Latency: 15.4 ms
```

**Understanding Hop Data:**
- **Hop Number**: Sequential order in path
- **IP Address**: Router/device IP
- **Hostname**: Reverse DNS resolution
- **RTT**: Round-trip time to that hop
- **Location**: Geographic location via GeoIP
- **ISP**: Internet Service Provider

### Traceroute Analysis Patterns

**Normal Pattern:**
- Gradual RTT increase per hop
- No packet loss
- Clear geographic progression
- Consistent ISP path

**Problem Patterns:**

**High Latency Hop:**
```
Hop 5: * * * - Request timeout
Hop 6: 203.0.113.50 - 450 ms  ← Problem here
Hop 7: 203.0.113.100 - 455 ms
```
→ Indicates congestion or routing issue at hop 6

**Routing Loop:**
```
Hop 8: 10.1.1.1 - 50 ms
Hop 9: 10.1.1.2 - 55 ms
Hop 10: 10.1.1.1 - 60 ms  ← Back to hop 8
Hop 11: 10.1.1.2 - 65 ms  ← Back to hop 9
```
→ Routing misconfiguration causing loop

**Geographic Inefficiency:**
```
Hop 3: Nashville, TN → 15 ms
Hop 4: Los Angeles, CA → 85 ms
Hop 5: Miami, FL → 125 ms
Hop 6: New York, NY → 150 ms (destination)
```
→ Inefficient routing (should go direct to New York)

### Use Cases

**Diagnose Connectivity Issues:**
```java
// Identify where connection fails
@Test
public void diagnoseConnectionFailure() {
    Object result = FW_AuditManager.INSTANCE.getAuditTraceroute()
        .runAuditTraceroute("unreachable-host.com", 60, 30, true);
    
    // Review output to see where path breaks
    // Last reachable hop indicates problem location
}
```

**Compare Routes:**
```java
// Compare different CDN endpoints
@Test
public void compareRoutingPaths() {
    String[] endpoints = {
        "cdn-east.example.com",
        "cdn-west.example.com",
        "cdn-eu.example.com"
    };
    
    for (String endpoint : endpoints) {
        FW_AuditManager.INSTANCE.getAuditTraceroute()
            .runAuditTraceroute(endpoint, 60, 20, false);
    }
    
    // Analyze which endpoint has optimal routing
}
```

---

## Speed Testing

### What is Speed Testing?

Speed testing measures network bandwidth capabilities by transferring data and measuring throughput. Essential for:
- Validating network infrastructure
- Establishing performance baselines
- Identifying bandwidth bottlenecks
- Comparing ISP performance

### Using FW_Audit_SpeedTest

**Direct API Usage:**
```java
FW_Audit_SpeedTest speedTest = FW_AuditManager.INSTANCE.getAuditSpeedTest();
Object result = speedTest.runAuditSpeedTest(true); // verbose
```

**Test Suite Usage:**
```java
@Test
@Tag("network")
@DisplayName("TC - Speed Test - Network Bandwidth")
public void tc_speedtest_bandwidth() {
    FW_CustomAssertJU.autoPass(
        FW_AuditManager.INSTANCE.getAuditSpeedTest()
            .runAuditSpeedTest(true)
    );
}
```

### Interpreting Speed Test Results

**Speed Test Example:**
```
[Pass] - {15.234} - Speed Test Results:
Download: 245.8 Mbps
Upload: 112.3 Mbps  
Latency: 12.4 ms
Jitter: 2.1 ms
Quality Score: 88/100 (Excellent)
Location: Chapel Hill, TN, US
ISP: AT&T
Server: Atlanta, GA (125 miles away)
```

**Metrics Explained:**
- **Download Speed**: Data transfer rate from server to client
- **Upload Speed**: Data transfer rate from client to server  
- **Latency**: Time for signal to reach server (ping time)
- **Jitter**: Variation in latency (consistency)
- **Quality Score**: Overall connection quality (0-100)
- **Quality Rating**: Excellent, Good, Fair, Poor, Very Poor

### Speed Thresholds

**Download Speed:**
- < 1 Mbps: Very Poor (dial-up era)
- 1-10 Mbps: Poor (basic browsing)
- 10-50 Mbps: Fair (HD streaming)
- 50-100 Mbps: Good (4K streaming, gaming)
- 100-500 Mbps: Excellent (multiple devices)
- > 500 Mbps: Exceptional (fiber, enterprise)

**Upload Speed:**
- < 1 Mbps: Very Poor
- 1-5 Mbps: Poor (basic uploads)
- 5-25 Mbps: Fair (video calls)
- 25-50 Mbps: Good (content creation)
- 50-100 Mbps: Excellent (streaming)
- > 100 Mbps: Exceptional

**Quality Score:**
- 80-100: Excellent connection
- 60-79: Good connection
- 40-59: Fair connection
- 20-39: Poor connection
- 0-19: Very poor connection

### Use Cases

**Baseline Measurement:**
```java
// Measure network capabilities before test suite
@BeforeAll
public static void measureNetworkBaseline() {
    Object speedResult = FW_AuditManager.INSTANCE.getAuditSpeedTest()
        .runAuditSpeedTest(false);
    
    // Store baseline for comparison
    // Adjust test parameters based on capabilities
}
```

**Performance Regression:**
```java
// Detect network degradation
@Test
public void detectNetworkRegression() {
    Object currentSpeed = FW_AuditManager.INSTANCE.getAuditSpeedTest()
        .runAuditSpeedTest(false);
    
    // Compare to historical baseline
    // Alert if significant degradation detected
}
```

---

## TS_Network_JUnit Test Suite

### Complete Test Examples

The `TS_Network_JUnit` test suite demonstrates all network diagnostic capabilities:

```java
package testsuites;

import org.junit.jupiter.api.*;
import framework.audits.FW_AuditManager;
import framework.junit.FW_CustomAssertJU;

public class TS_Network_JUnit {
    
    @BeforeAll
    public static void setupTestSuite() {
        FW_TestSuiteFormatter.beforeAll(
            TS_Network_JUnit.class.getSimpleName()
        );
        FW_ConfigMgr.getInstance();
    }
    
    @Test
    @Tag("network")
    @DisplayName("TC - Traceroute - SauceDemo")
    public void tc_traceroute_saucedemo() {
        FW_CustomAssertJU.autoPass(
            FW_AuditManager.INSTANCE.getAuditTraceroute()
                .runAuditTraceroute("www.saucedemo.com", 120, 30, true)
        );
    }
    
    @Test
    @Tag("network")
    @DisplayName("TC - Ping - Google DNS")
    public void tc_ping_google() {
        FW_CustomAssertJU.autoPass(
            FW_AuditManager.INSTANCE.getAuditPing()
                .runAuditPing("google.com", 4, 2, true)
        );
    }
    
    @Test
    @Tag("network")
    @DisplayName("TC - Speed Test")
    public void tc_speedtest() {
        FW_CustomAssertJU.autoPass(
            FW_AuditManager.INSTANCE.getAuditSpeedTest()
                .runAuditSpeedTest(true)
        );
    }
    
    @AfterAll
    public static void tearDownTestSuite() {
        FW_TestSuiteFormatter.afterAll(
            TS_Network_JUnit.class.getSimpleName()
        );
    }
}
```

### Running the Test Suite

**Maven Command:**
```bash
mvn test -Dtest=TS_Network_JUnit
```

**Specific Test:**
```bash
mvn test -Dtest=TS_Network_JUnit#tc_ping_google
```

**With Tags:**
```bash
mvn test -Dgroups="network"
```

### Configuration Options

Configure network diagnostics in `testConfig.properties`:

```properties
# Ping Configuration
network.ping.defaultCount=5
network.ping.defaultTimeout=2
network.ping.maxJitter=50

# Traceroute Configuration
network.traceroute.maxDuration=120
network.traceroute.maxHops=30
network.traceroute.probesPerHop=3
network.traceroute.probeDuration=5

# Speed Test Configuration
network.speedtest.duration=15
network.speedtest.uploadDuration=10
network.speedtest.bufferSize=2097152
network.speedtest.maxConnections=40

# GeoIP Configuration
network.geoip.enabled=true
network.geoip.provider=ip-api.com
```

---

## Best Practices

### For Test Writers

1. **Verify Connectivity First**: Run ping before expensive operations
2. **Set Appropriate Timeouts**: Adjust based on target location
3. **Handle Transient Failures**: Network tests can be flaky - implement retries
4. **Document Baselines**: Record expected performance for comparison
5. **Test from Multiple Locations**: Validate geographic distribution

### For DevOps

1. **Monitor Trends**: Track network metrics over time
2. **Set Alerts**: Configure alerts for degradation
3. **Compare Environments**: Ensure dev/staging/prod consistency
4. **Test After Changes**: Validate infrastructure modifications
5. **Document Routing**: Maintain expected traceroute paths

### For Troubleshooting

1. **Start with Ping**: Verify basic connectivity
2. **Use Traceroute**: Identify where problems occur
3. **Measure Bandwidth**: Rule out capacity issues
4. **Compare Times**: Test at different times of day
5. **Test Multiple Targets**: Isolate local vs. remote issues

---

## Troubleshooting

### Common Issues

**Issue**: "Host unreachable"
- **Cause**: Target offline, firewall blocking, DNS failure
- **Solution**: Verify host is online, check firewall rules, test DNS resolution

**Issue**: "High packet loss"
- **Cause**: Network congestion, routing issues, Wi-Fi problems
- **Solution**: Test wired connection, try different times, check router

**Issue**: "Traceroute timeout"
- **Cause**: ICMP blocked, firewall rules, network configuration
- **Solution**: Some routers block ICMP - this is expected for some hops

**Issue**: "Speed test fails"
- **Cause**: Firewall blocking, insufficient bandwidth, server overload
- **Solution**: Check firewall rules, verify network capacity, retry later

### Debugging Techniques

**Enable Verbose Output:**
```java
// Get detailed console output
FW_AuditManager.INSTANCE.getAuditPing()
    .runAuditPing(host, count, timeout, true);  // verbose = true
```

**Check Platform:**
```java
// Verify OS compatibility
System.out.println(System.getProperty("os.name"));
// Windows and Unix/Linux/Mac supported
```

**Validate Configuration:**
```java
// Check testConfig.properties loaded
String pingCount = FW_ConfigMgr.getVarVal("network.ping.defaultCount");
System.out.println("Ping count: " + pingCount);
```

---

## Related Documentation

- [HTTP Security Assessment](Doc-HTTP-Assessment.md) - HTTP audit tools
- [Test Development Guide](Doc-Test-Development.md) - Writing tests
- [Test Execution Guide](Doc-Test-Execution-VSCode.md) - Running tests
- [Architecture Diagram](Diagram-Architecture.md) - Layer 6 details
- [API Documentation](../../../../../target/site/index.html) - JavaDocs

---

**Version**: 1.0.0  
**Last Updated**: 2025-10-30 01:06:00 PM CDT  
**Copyright** © 2025 MissionWares. All Rights Reserved.