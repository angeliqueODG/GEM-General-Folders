package framework.http;

// ===============================================================
// @file: FW_Http.java
// @filepath: src/test/java/framework/http/FW_Http.java
// @version: 1.6.0
// @updated: 2025-11-13 19:00:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Comprehensive data structure for capturing, storing, and analyzing HTTP
// transactions. This class encapsulates all aspects of an HTTP request/response
// cycle including request details, response data, timing metrics, network
// information, and derived analysis results. Designed as a flat structure for
// simplicity and direct field access. Supports extensibility through metadata
// and extension maps. Integrates with FW_HttpUtils and FW_NetworkUtils for
// data population and analysis. Enhanced to support comprehensive audit data
// storage including finding counts, grades, detailed analysis metrics, and
// complete structured findings list for report generation.
//
// @dependencies:
// - java.util.Map
// - java.util.HashMap
// - java.util.List
// - java.util.ArrayList
// - java.util.UUID
// - framework.utilities.FW_HttpUtils
// - framework.utilities.FW_NetworkUtils
// - framework.utilities.FW_DateTimeUtils
//
// @methods:
// - Constructor: Initializes HTTP transaction with default values
// - isValid(): Validates essential fields are present
// - isSuccessful(): Checks if transaction completed successfully
// - hasRedirects(): Checks if any redirects occurred
// - addRedirectHop(): Adds a redirect hop to the chain
// - getHighSeverityFindings(): Extracts HIGH severity findings for reports
// - Full set of getters/setters for all properties
// - toString(): Returns formatted summary of HTTP transaction
//
// @tags: http, request, response, network, audit, analysis, redirect, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-21  G. Paskal       1.0.0    Initial implementation with mAi™ header
// 2025-01-21  G. Paskal       1.1.0    Added convenience fields, validation methods, vulnerability tracking
// 2025-09-24  G. Paskal       1.2.0    Enhanced redirect tracking with full chain details
// 2025-09-29  G. Paskal       1.3.0    Reordered fields logically, removed duplicate convenience fields
// 2025-10-06  G. Paskal       1.4.0    Added comprehensive audit fields: grades, finding counts, detailed analysis
// 2025-11-06  G. Paskal       1.5.0    Priority 4: Added 14 enhanced certificate fields for deep SSL/TLS analysis
// 2025-11-13  G. Paskal       1.6.0    Task 13.2: Added auditFindings list for structured finding storage
// ===============================================================

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a complete HTTP transaction including request, response, timings, and comprehensive audit analysis.
 */
public class FW_Http {

    // ========== SECTION 1: TRANSACTION IDENTITY ==========
    private String httpRefID;                    // Unique identifier for this HTTP transaction
    private String httpTimestamp;                // ISO 8601 timestamp when transaction occurred
    private String httpName;                     // Descriptive name or label for this transaction
    private String httpType;                     // Transaction type or category
    private String correlationId;                // Links related requests together
    private String parentId;                     // Parent request ID for request chains
    private String clientRefID;                  // Client reference identifier
    private String projectRefID;                 // Project reference identifier
    private String applicationRefID;             // Application reference identifier
    
    // ========== SECTION 2: REQUEST LIFECYCLE ==========
    private String requestMethod;                // HTTP method (GET, POST, PUT, DELETE, etc.)
    private String requestUrl;                   // Full URL of the request
    private String requestProtocol;              // HTTP protocol version (HTTP/1.1, HTTP/2, etc.)
    private String requestTimestamp;             // When request was sent
    private String requestHost;                  // Host from URL
    private String requestPath;                  // Path from URL
    private String requestQuery;                 // Query string from URL
    private Map<String, String> requestHeaders;  // Request headers
    private Map<String, String> requestCookies;  // Request cookies
    private String requestContentType;           // Content-Type header value
    private String requestCharset;               // Character encoding of request
    private String requestAuthentication;        // Authentication type used
    private byte[] requestBody;                  // Raw request body bytes
    private String requestBodyString;            // Request body as string
    private long requestBodySize;                // Size of request body in bytes
    
    // ========== SECTION 3: RESPONSE LIFECYCLE ==========
    private int responseStatusCode;              // HTTP status code
    private String responseStatusMessage;        // HTTP status message
    private String responseProtocol;             // Response protocol version
    private String responseTimestamp;            // When response was received
    private boolean responseComplete;            // Whether full response was received
    private Map<String, String> responseHeaders; // Response headers
    private Map<String, String> responseCookies; // Response cookies (from Set-Cookie headers)
    private String responseContentType;          // Content-Type header value
    private String responseCharset;              // Character encoding of response
    private String responseMimeType;             // Parsed MIME type (without charset)
    private String responseLanguage;             // Content-Language header value
    private String responseEncoding;             // Content-Encoding (gzip, deflate, etc.)
    private String responseETag;                 // ETag header value (for caching)
    private String responseLastModified;         // Last-Modified header value
    private String responseLocation;             // Location header value (for redirects)
    private String responseServer;               // Server header value
    private byte[] responseBody;                 // Raw response body bytes
    private String responseBodyString;           // Response body as string
    private long responseBodySize;               // Size of response body in bytes
    
    // ========== SECTION 4: NETWORK & CONNECTION ==========
    private String localIpAddress;               // Local IP address used
    private int localPort;                       // Local port used
    private String remoteIpAddress;              // Remote server IP address
    private int remotePort;                      // Remote server port
    private String remoteHostname;               // Remote hostname
    private String dnsResolvedIps;               // All IPs returned by DNS (comma-separated)
    private boolean isDnsLoadBalanced;           // Whether multiple IPs were returned
    private boolean isSecure;                    // HTTPS vs HTTP
    private String tlsVersion;                   // TLS version (if HTTPS)
    private String tlsCipherSuite;               // Cipher suite used (if HTTPS)
    private String certificateSubject;           // Server certificate subject (if HTTPS)
    private String certificateIssuer;            // Server certificate issuer (if HTTPS)
    private long certificateExpiryMs;            // Certificate expiry timestamp (if HTTPS)
    private long certificateDaysUntilExpiry;     // Days until certificate expires
    private String certificateValidFrom;         // Certificate valid from date
    private boolean hasValidCertificate;         // Certificate validation result
    
    // ========== ENHANCED CERTIFICATE DETAILS (Priority 4) ==========
    // Certificate Technical Details
    private String certificateSerialNumber;           // Serial number in hex format
    private String certificateSignatureAlgorithm;     // e.g., "SHA256withRSA", "SHA384withECDSA"
    private String certificatePublicKeyAlgorithm;     // e.g., "RSA", "EC" (Elliptic Curve)
    private int certificatePublicKeySize;             // Key size in bits (e.g., 2048, 4096)
    private int certificateVersion;                   // X.509 version (typically 3)
    private List<String> certificateSubjectAlternativeNames;  // SAN entries (DNS names, IPs)
    
    // Certificate Chain Information
    private int certificateChainLength;               // Number of certificates in chain
    private List<String> certificateChainIssuers;     // Issuer DN for each cert in chain
    private boolean certificateChainValid;            // Is chain properly formed and trusted
    
    // Certificate Security Analysis
    private boolean certificateWeakSignature;         // MD5 or SHA1 signature detected
    private boolean certificateSmallKeySize;          // Key size < 2048 bits (RSA) or < 256 bits (EC)
    private boolean certificateIsEV;                  // Extended Validation certificate
    private boolean certificateIsSelfSigned;          // Self-signed certificate detected
    private String certificateTrustLevel;             // "EV", "OV", "DV", "SELF_SIGNED"
    
    // ========== SECTION 5: PERFORMANCE METRICS ==========
    private long dnsLookupDurationMs;            // DNS resolution time
    private long connectionDurationMs;           // TCP connection establishment time
    private long tlsHandshakeDurationMs;         // TLS/SSL handshake time
    private long requestSendDurationMs;          // Time to send request
    private long responseWaitDurationMs;         // Time waiting for first byte (TTFB)
    private long responseReceiveDurationMs;      // Time to receive response body
    private long totalDurationMs;                // Total transaction duration
    private String totalDurationHR;              // Human readable duration (e.g., "1.234s")
    private int performanceScore;                // Performance assessment score (0-100)
    private String performanceGrade;             // Performance grade (A-F)
    private boolean isCompressed;                // Whether response was compressed
    private double compressionRatio;             // Compression efficiency ratio
    
    // ========== SECTION 6: REDIRECT HANDLING ==========
    private boolean hasRedirect;                 // True if any redirect occurred
    private int redirectCount;                   // Number of redirects followed
    private String finalUrl;                     // Final URL after redirects
    private List<String> redirectUrls;           // Full URLs in redirect sequence
    private List<Integer> redirectStatusCodes;   // Status codes for each redirect (301, 302, 307, 308)
    private List<String> redirectLocations;      // Location headers for each redirect
    private List<Long> redirectDurations;        // Duration in ms for each redirect hop
    private Map<String, Map<String, String>> redirectHeaders; // Headers from each redirect (key: url)
    private String redirectType;                 // Type classification: permanent, temporary, mixed
    private long redirectTotalDurationMs;        // Total time spent in all redirects
    private boolean redirectLoop;                // True if redirect loop detected
    private int maxRedirectsReached;             // Max number of redirects allowed (0 if not reached)
    private String redirectChain;                // Comma-separated list of redirect URLs (DEPRECATED - use redirectUrls)
    
    // ========== SECTION 7: ANALYSIS & SCORING ==========
    // Overall Assessment
    private int overallScore;                    // Overall audit score (0-100)
    private String overallGrade;                 // Overall grade (A-F)
    
    // Security Assessment
    private int securityScore;                   // Security assessment score (0-100)
    private String securityGrade;                // Security grade (A-F)
    private boolean hasSecurityHeaders;          // Whether required security headers present
    private boolean hasVulnerabilities;          // Whether known vulnerabilities detected
    private String vulnerabilityDetails;         // Details of any vulnerabilities found
    
    // Compliance Assessment
    private int complianceScore;                 // Standards compliance score (0-100)
    private String complianceGrade;              // Compliance grade (A-F)
    
    // Finding Counts by Severity
    private int criticalFindingsCount;           // Number of CRITICAL findings
    private int highFindingsCount;               // Number of HIGH findings
    private int mediumFindingsCount;             // Number of MEDIUM findings
    private int lowFindingsCount;                // Number of LOW findings
    private int infoFindingsCount;               // Number of INFO findings
    
    // Content & Cache Analysis
    private String contentValidation;            // Content validation result
    private boolean isCacheable;                 // Whether response can be cached
    private int cacheMaxAge;                     // Cache max-age in seconds
    private Map<String, String> cacheDirectives; // Parsed Cache-Control directives
    
    // API Detection
    private boolean isApiEndpoint;               // Whether this appears to be an API endpoint
    private String apiVersion;                   // API version if detected
    
    // Detailed Analysis Storage
    private String auditSummary;                 // Executive summary of audit
    private String remediationPriority;          // Prioritized list of fixes needed
    private List<Map<String, String>> auditFindings;  // Complete list of audit findings (severity, category, finding, remediation)
    
    // ========== SECTION 8: ERROR HANDLING ==========
    private boolean hasError;                    // Whether an error occurred
    private String errorType;                    // Type of error (network, timeout, parsing, etc.)
    private String errorMessage;                 // Error message
    private String errorStackTrace;              // Stack trace for debugging
    private int errorRetryCount;                 // Number of retry attempts
    
    // ========== SECTION 9: EXTENSIBILITY ==========
    private Map<String, Object> metadata;        // Custom metadata storage
    private Map<String, Object> extensions;      // Plugin/analyzer extensions
    
    /**
     * Constructs a new FW_Http instance with default values.
     */
    public FW_Http() {
        this.httpRefID = "http-" + java.util.UUID.randomUUID().toString();
        this.requestHeaders = new HashMap<>();
        this.requestCookies = new HashMap<>();
        this.responseHeaders = new HashMap<>();
        this.responseCookies = new HashMap<>();
        this.metadata = new HashMap<>();
        this.extensions = new HashMap<>();
        this.cacheDirectives = new HashMap<>();
        
        // Initialize redirect tracking collections
        this.redirectUrls = new ArrayList<>();
        this.redirectStatusCodes = new ArrayList<>();
        this.redirectLocations = new ArrayList<>();
        this.redirectDurations = new ArrayList<>();
        this.redirectHeaders = new HashMap<>();
        
        // Initialize boolean flags
        this.hasError = false;
        this.responseComplete = false;
        this.isSecure = false;
        this.hasSecurityHeaders = false;
        this.hasVulnerabilities = false;
        this.isCompressed = false;
        this.isCacheable = false;
        this.hasValidCertificate = false;
        this.isApiEndpoint = false;
        this.isDnsLoadBalanced = false;
        this.hasRedirect = false;
        this.redirectLoop = false;
        
        // Initialize numeric fields
        this.redirectCount = 0;
        this.redirectTotalDurationMs = 0;
        this.maxRedirectsReached = 0;
        this.errorRetryCount = 0;
        this.overallScore = -1;
        this.securityScore = -1;
        this.performanceScore = -1;
        this.complianceScore = -1;
        this.cacheMaxAge = -1;
        this.certificateDaysUntilExpiry = -1;
        this.criticalFindingsCount = 0;
        this.highFindingsCount = 0;
        this.mediumFindingsCount = 0;
        this.lowFindingsCount = 0;
        this.infoFindingsCount = 0;
        this.auditFindings = new ArrayList<>();
        
        // Priority 4: Initialize enhanced certificate fields
        this.certificateSerialNumber = null;
        this.certificateSignatureAlgorithm = null;
        this.certificatePublicKeyAlgorithm = null;
        this.certificatePublicKeySize = 0;
        this.certificateVersion = 0;
        this.certificateSubjectAlternativeNames = new ArrayList<>();
        this.certificateChainLength = 0;
        this.certificateChainIssuers = new ArrayList<>();
        this.certificateChainValid = false;
        this.certificateWeakSignature = false;
        this.certificateSmallKeySize = false;
        this.certificateIsEV = false;
        this.certificateIsSelfSigned = false;
        this.certificateTrustLevel = null;
    }
    
    /**
     * Validates that essential fields are present.
     *
     * @return true if the HTTP transaction has valid essential fields
     */
    public boolean isValid() {
        return requestUrl != null && !requestUrl.isEmpty() && 
               requestMethod != null && !requestMethod.isEmpty() &&
               responseStatusCode > 0;
    }
    
    /**
     * Checks if the HTTP transaction was successful.
     *
     * @return true if no errors occurred and status code is 2xx
     */
    public boolean isSuccessful() {
        return !hasError && responseStatusCode >= 200 && responseStatusCode < 300;
    }
    
    /**
     * Checks if any redirects occurred during the transaction.
     *
     * @return true if redirects were encountered
     */
    public boolean hasRedirects() {
        return hasRedirect && redirectCount > 0;
    }
    
    /**
     * Adds a redirect hop to the redirect chain.
     *
     * @param url The full URL being redirected to
     * @param statusCode The HTTP status code of the redirect
     * @param locationHeader The Location header value
     * @param durationMs The duration of this redirect hop in milliseconds
     * @param headers The response headers from this redirect
     */
    public void addRedirectHop(String url, int statusCode, String locationHeader, 
                               long durationMs, Map<String, String> headers) {
        this.hasRedirect = true;
        this.redirectCount++;
        this.redirectUrls.add(url);
        this.redirectStatusCodes.add(statusCode);
        this.redirectLocations.add(locationHeader);
        this.redirectDurations.add(durationMs);
        this.redirectTotalDurationMs += durationMs;
        
        if (headers != null) {
            this.redirectHeaders.put(url, new HashMap<>(headers));
        }
        
        // Update redirect chain string for backward compatibility
        if (this.redirectChain == null || this.redirectChain.isEmpty()) {
            this.redirectChain = url;
        } else {
            this.redirectChain += "," + url;
        }
    }
    
    // =================================================================================
    // ====================== Getters and Setters - Begin ==============================
    // =================================================================================
    
    // ===== SECTION 1: TRANSACTION IDENTITY =====
    public String getHttpRefID() {return httpRefID;}
    public void setHttpRefID(String httpRefID) {this.httpRefID = httpRefID;}
    public String getHttpTimestamp() {return httpTimestamp;}
    public void setHttpTimestamp(String httpTimestamp) {this.httpTimestamp = httpTimestamp;}
    public String getHttpName() {return httpName;}
    public void setHttpName(String httpName) {this.httpName = httpName;}
    public String getHttpType() {return httpType;}
    public void setHttpType(String httpType) {this.httpType = httpType;}
    public String getCorrelationId() {return correlationId;}
    public void setCorrelationId(String correlationId) {this.correlationId = correlationId;}
    public String getParentId() {return parentId;}
    public void setParentId(String parentId) {this.parentId = parentId;}
    public String getClientRefID() {return clientRefID;}
    public void setClientRefID(String clientRefID) {this.clientRefID = clientRefID;}
    public String getProjectRefID() {return projectRefID;}
    public void setProjectRefID(String projectRefID) {this.projectRefID = projectRefID;}
    public String getApplicationRefID() {return applicationRefID;}
    public void setApplicationRefID(String applicationRefID) {this.applicationRefID = applicationRefID;}
    
    // ===== SECTION 2: REQUEST LIFECYCLE =====
    public String getRequestMethod() {return requestMethod;}
    public void setRequestMethod(String requestMethod) {this.requestMethod = requestMethod;}
    public String getRequestUrl() {return requestUrl;}
    public void setRequestUrl(String requestUrl) {this.requestUrl = requestUrl;}
    public String getRequestProtocol() {return requestProtocol;}
    public void setRequestProtocol(String requestProtocol) {this.requestProtocol = requestProtocol;}
    public String getRequestTimestamp() {return requestTimestamp;}
    public void setRequestTimestamp(String requestTimestamp) {this.requestTimestamp = requestTimestamp;}
    public String getRequestHost() {return requestHost;}
    public void setRequestHost(String requestHost) {this.requestHost = requestHost;}
    public String getRequestPath() {return requestPath;}
    public void setRequestPath(String requestPath) {this.requestPath = requestPath;}
    public String getRequestQuery() {return requestQuery;}
    public void setRequestQuery(String requestQuery) {this.requestQuery = requestQuery;}
    public Map<String, String> getRequestHeaders() {return requestHeaders;}
    public void setRequestHeaders(Map<String, String> requestHeaders) {this.requestHeaders = requestHeaders;}
    public Map<String, String> getRequestCookies() {return requestCookies;}
    public void setRequestCookies(Map<String, String> requestCookies) {this.requestCookies = requestCookies;}
    public String getRequestContentType() {return requestContentType;}
    public void setRequestContentType(String requestContentType) {this.requestContentType = requestContentType;}
    public String getRequestCharset() {return requestCharset;}
    public void setRequestCharset(String requestCharset) {this.requestCharset = requestCharset;}
    public String getRequestAuthentication() {return requestAuthentication;}
    public void setRequestAuthentication(String requestAuthentication) {this.requestAuthentication = requestAuthentication;}
    public byte[] getRequestBody() {return requestBody;}
    public void setRequestBody(byte[] requestBody) {this.requestBody = requestBody;}
    public String getRequestBodyString() {return requestBodyString;}
    public void setRequestBodyString(String requestBodyString) {this.requestBodyString = requestBodyString;}
    public long getRequestBodySize() {return requestBodySize;}
    public void setRequestBodySize(long requestBodySize) {this.requestBodySize = requestBodySize;}
    
    // ===== SECTION 3: RESPONSE LIFECYCLE =====
    public int getResponseStatusCode() {return responseStatusCode;}
    public void setResponseStatusCode(int responseStatusCode) {this.responseStatusCode = responseStatusCode;}
    public String getResponseStatusMessage() {return responseStatusMessage;}
    public void setResponseStatusMessage(String responseStatusMessage) {this.responseStatusMessage = responseStatusMessage;}
    public String getResponseProtocol() {return responseProtocol;}
    public void setResponseProtocol(String responseProtocol) {this.responseProtocol = responseProtocol;}
    public String getResponseTimestamp() {return responseTimestamp;}
    public void setResponseTimestamp(String responseTimestamp) {this.responseTimestamp = responseTimestamp;}
    public boolean isResponseComplete() {return responseComplete;}
    public void setResponseComplete(boolean responseComplete) {this.responseComplete = responseComplete;}
    public Map<String, String> getResponseHeaders() {return responseHeaders;}
    public void setResponseHeaders(Map<String, String> responseHeaders) {this.responseHeaders = responseHeaders;}
    public Map<String, String> getResponseCookies() {return responseCookies;}
    public void setResponseCookies(Map<String, String> responseCookies) {this.responseCookies = responseCookies;}
    public String getResponseContentType() {return responseContentType;}
    public void setResponseContentType(String responseContentType) {this.responseContentType = responseContentType;}
    public String getResponseCharset() {return responseCharset;}
    public void setResponseCharset(String responseCharset) {this.responseCharset = responseCharset;}
    public String getResponseMimeType() {return responseMimeType;}
    public void setResponseMimeType(String responseMimeType) {this.responseMimeType = responseMimeType;}
    public String getResponseLanguage() {return responseLanguage;}
    public void setResponseLanguage(String responseLanguage) {this.responseLanguage = responseLanguage;}
    public String getResponseEncoding() {return responseEncoding;}
    public void setResponseEncoding(String responseEncoding) {this.responseEncoding = responseEncoding;}
    public String getResponseETag() {return responseETag;}
    public void setResponseETag(String responseETag) {this.responseETag = responseETag;}
    public String getResponseLastModified() {return responseLastModified;}
    public void setResponseLastModified(String responseLastModified) {this.responseLastModified = responseLastModified;}
    public String getResponseLocation() {return responseLocation;}
    public void setResponseLocation(String responseLocation) {this.responseLocation = responseLocation;}
    public String getResponseServer() {return responseServer;}
    public void setResponseServer(String responseServer) {this.responseServer = responseServer;}
    public byte[] getResponseBody() {return responseBody;}
    public void setResponseBody(byte[] responseBody) {this.responseBody = responseBody;}
    public String getResponseBodyString() {return responseBodyString;}
    public void setResponseBodyString(String responseBodyString) {this.responseBodyString = responseBodyString;}
    public long getResponseBodySize() {return responseBodySize;}
    public void setResponseBodySize(long responseBodySize) {this.responseBodySize = responseBodySize;}
    
    // ===== SECTION 4: NETWORK & CONNECTION =====
    public String getLocalIpAddress() {return localIpAddress;}
    public void setLocalIpAddress(String localIpAddress) {this.localIpAddress = localIpAddress;}
    public int getLocalPort() {return localPort;}
    public void setLocalPort(int localPort) {this.localPort = localPort;}
    public String getRemoteIpAddress() {return remoteIpAddress;}
    public void setRemoteIpAddress(String remoteIpAddress) {this.remoteIpAddress = remoteIpAddress;}
    public int getRemotePort() {return remotePort;}
    public void setRemotePort(int remotePort) {this.remotePort = remotePort;}
    public String getRemoteHostname() {return remoteHostname;}
    public void setRemoteHostname(String remoteHostname) {this.remoteHostname = remoteHostname;}
    public String getDnsResolvedIps() {return dnsResolvedIps;}
    public void setDnsResolvedIps(String dnsResolvedIps) {this.dnsResolvedIps = dnsResolvedIps;}
    public boolean isDnsLoadBalanced() {return isDnsLoadBalanced;}
    public void setIsDnsLoadBalanced(boolean isDnsLoadBalanced) {this.isDnsLoadBalanced = isDnsLoadBalanced;}
    public boolean isSecure() {return isSecure;}
    public void setSecure(boolean isSecure) {this.isSecure = isSecure;}
    public String getTlsVersion() {return tlsVersion;}
    public void setTlsVersion(String tlsVersion) {this.tlsVersion = tlsVersion;}
    public String getTlsCipherSuite() {return tlsCipherSuite;}
    public void setTlsCipherSuite(String tlsCipherSuite) {this.tlsCipherSuite = tlsCipherSuite;}
    public String getCertificateSubject() {return certificateSubject;}
    public void setCertificateSubject(String certificateSubject) {this.certificateSubject = certificateSubject;}
    public String getCertificateIssuer() {return certificateIssuer;}
    public void setCertificateIssuer(String certificateIssuer) {this.certificateIssuer = certificateIssuer;}
    public long getCertificateExpiryMs() {return certificateExpiryMs;}
    public void setCertificateExpiryMs(long certificateExpiryMs) {this.certificateExpiryMs = certificateExpiryMs;}
    public long getCertificateDaysUntilExpiry() {return certificateDaysUntilExpiry;}
    public void setCertificateDaysUntilExpiry(long certificateDaysUntilExpiry) {this.certificateDaysUntilExpiry = certificateDaysUntilExpiry;}
    public String getCertificateValidFrom() {return certificateValidFrom;}
    public void setCertificateValidFrom(String certificateValidFrom) {this.certificateValidFrom = certificateValidFrom;}
    public boolean hasValidCertificate() {return hasValidCertificate;}
    public void setHasValidCertificate(boolean hasValidCertificate) {this.hasValidCertificate = hasValidCertificate;}
    
    // ===== PRIORITY 4: ENHANCED CERTIFICATE GETTERS/SETTERS =====
    public String getCertificateSerialNumber() {return certificateSerialNumber;}
    public void setCertificateSerialNumber(String certificateSerialNumber) {this.certificateSerialNumber = certificateSerialNumber;}
    public String getCertificateSignatureAlgorithm() {return certificateSignatureAlgorithm;}
    public void setCertificateSignatureAlgorithm(String certificateSignatureAlgorithm) {this.certificateSignatureAlgorithm = certificateSignatureAlgorithm;}
    public String getCertificatePublicKeyAlgorithm() {return certificatePublicKeyAlgorithm;}
    public void setCertificatePublicKeyAlgorithm(String certificatePublicKeyAlgorithm) {this.certificatePublicKeyAlgorithm = certificatePublicKeyAlgorithm;}
    public int getCertificatePublicKeySize() {return certificatePublicKeySize;}
    public void setCertificatePublicKeySize(int certificatePublicKeySize) {this.certificatePublicKeySize = certificatePublicKeySize;}
    public int getCertificateVersion() {return certificateVersion;}
    public void setCertificateVersion(int certificateVersion) {this.certificateVersion = certificateVersion;}
    public List<String> getCertificateSubjectAlternativeNames() {return certificateSubjectAlternativeNames;}
    public void setCertificateSubjectAlternativeNames(List<String> certificateSubjectAlternativeNames) {this.certificateSubjectAlternativeNames = certificateSubjectAlternativeNames;}
    public int getCertificateChainLength() {return certificateChainLength;}
    public void setCertificateChainLength(int certificateChainLength) {this.certificateChainLength = certificateChainLength;}
    public List<String> getCertificateChainIssuers() {return certificateChainIssuers;}
    public void setCertificateChainIssuers(List<String> certificateChainIssuers) {this.certificateChainIssuers = certificateChainIssuers;}
    public boolean isCertificateChainValid() {return certificateChainValid;}
    public void setCertificateChainValid(boolean certificateChainValid) {this.certificateChainValid = certificateChainValid;}
    public boolean hasCertificateWeakSignature() {return certificateWeakSignature;}
    public void setCertificateWeakSignature(boolean certificateWeakSignature) {this.certificateWeakSignature = certificateWeakSignature;}
    public boolean hasCertificateSmallKeySize() {return certificateSmallKeySize;}
    public void setCertificateSmallKeySize(boolean certificateSmallKeySize) {this.certificateSmallKeySize = certificateSmallKeySize;}
    public boolean isCertificateEV() {return certificateIsEV;}
    public void setCertificateIsEV(boolean certificateIsEV) {this.certificateIsEV = certificateIsEV;}
    public boolean isCertificateSelfSigned() {return certificateIsSelfSigned;}
    public void setCertificateIsSelfSigned(boolean certificateIsSelfSigned) {this.certificateIsSelfSigned = certificateIsSelfSigned;}
    public String getCertificateTrustLevel() {return certificateTrustLevel;}
    public void setCertificateTrustLevel(String certificateTrustLevel) {this.certificateTrustLevel = certificateTrustLevel;}
    
    // ===== SECTION 5: PERFORMANCE METRICS =====
    public long getDnsLookupDurationMs() {return dnsLookupDurationMs;}
    public void setDnsLookupDurationMs(long dnsLookupDurationMs) {this.dnsLookupDurationMs = dnsLookupDurationMs;}
    public long getConnectionDurationMs() {return connectionDurationMs;}
    public void setConnectionDurationMs(long connectionDurationMs) {this.connectionDurationMs = connectionDurationMs;}
    public long getTlsHandshakeDurationMs() {return tlsHandshakeDurationMs;}
    public void setTlsHandshakeDurationMs(long tlsHandshakeDurationMs) {this.tlsHandshakeDurationMs = tlsHandshakeDurationMs;}
    public long getRequestSendDurationMs() {return requestSendDurationMs;}
    public void setRequestSendDurationMs(long requestSendDurationMs) {this.requestSendDurationMs = requestSendDurationMs;}
    public long getResponseWaitDurationMs() {return responseWaitDurationMs;}
    public void setResponseWaitDurationMs(long responseWaitDurationMs) {this.responseWaitDurationMs = responseWaitDurationMs;}
    public long getResponseReceiveDurationMs() {return responseReceiveDurationMs;}
    public void setResponseReceiveDurationMs(long responseReceiveDurationMs) {this.responseReceiveDurationMs = responseReceiveDurationMs;}
    public long getTotalDurationMs() {return totalDurationMs;}
    public void setTotalDurationMs(long totalDurationMs) {this.totalDurationMs = totalDurationMs;}
    public String getTotalDurationHR() {return totalDurationHR;}
    public void setTotalDurationHR(String totalDurationHR) {this.totalDurationHR = totalDurationHR;}
    public int getPerformanceScore() {return performanceScore;}
    public void setPerformanceScore(int performanceScore) {this.performanceScore = performanceScore;}
    public String getPerformanceGrade() {return performanceGrade;}
    public void setPerformanceGrade(String performanceGrade) {this.performanceGrade = performanceGrade;}
    public boolean isCompressed() {return isCompressed;}
    public void setCompressed(boolean isCompressed) {this.isCompressed = isCompressed;}
    public double getCompressionRatio() {return compressionRatio;}
    public void setCompressionRatio(double compressionRatio) {this.compressionRatio = compressionRatio;}
    
    // ===== SECTION 6: REDIRECT HANDLING =====
    public boolean hasRedirect() {return hasRedirect;}
    public void setHasRedirect(boolean hasRedirect) {this.hasRedirect = hasRedirect;}
    public int getRedirectCount() {return redirectCount;}
    public void setRedirectCount(int redirectCount) {this.redirectCount = redirectCount;}
    public String getFinalUrl() {return finalUrl;}
    public void setFinalUrl(String finalUrl) {this.finalUrl = finalUrl;}
    public List<String> getRedirectUrls() {return redirectUrls;}
    public void setRedirectUrls(List<String> redirectUrls) {this.redirectUrls = redirectUrls;}
    public List<Integer> getRedirectStatusCodes() {return redirectStatusCodes;}
    public void setRedirectStatusCodes(List<Integer> redirectStatusCodes) {this.redirectStatusCodes = redirectStatusCodes;}
    public List<String> getRedirectLocations() {return redirectLocations;}
    public void setRedirectLocations(List<String> redirectLocations) {this.redirectLocations = redirectLocations;}
    public List<Long> getRedirectDurations() {return redirectDurations;}
    public void setRedirectDurations(List<Long> redirectDurations) {this.redirectDurations = redirectDurations;}
    public Map<String, Map<String, String>> getRedirectHeaders() {return redirectHeaders;}
    public void setRedirectHeaders(Map<String, Map<String, String>> redirectHeaders) {this.redirectHeaders = redirectHeaders;}
    public String getRedirectType() {return redirectType;}
    public void setRedirectType(String redirectType) {this.redirectType = redirectType;}
    public long getRedirectTotalDurationMs() {return redirectTotalDurationMs;}
    public void setRedirectTotalDurationMs(long redirectTotalDurationMs) {this.redirectTotalDurationMs = redirectTotalDurationMs;}
    public boolean isRedirectLoop() {return redirectLoop;}
    public void setRedirectLoop(boolean redirectLoop) {this.redirectLoop = redirectLoop;}
    public int getMaxRedirectsReached() {return maxRedirectsReached;}
    public void setMaxRedirectsReached(int maxRedirectsReached) {this.maxRedirectsReached = maxRedirectsReached;}
    public String getRedirectChain() {return redirectChain;}
    public void setRedirectChain(String redirectChain) {this.redirectChain = redirectChain;}
    
    // ===== SECTION 7: ANALYSIS & SCORING =====
    // Overall Assessment
    public int getOverallScore() {return overallScore;}
    public void setOverallScore(int overallScore) {this.overallScore = overallScore;}
    public String getOverallGrade() {return overallGrade;}
    public void setOverallGrade(String overallGrade) {this.overallGrade = overallGrade;}
    
    // Security Assessment
    public int getSecurityScore() {return securityScore;}
    public void setSecurityScore(int securityScore) {this.securityScore = securityScore;}
    public String getSecurityGrade() {return securityGrade;}
    public void setSecurityGrade(String securityGrade) {this.securityGrade = securityGrade;}
    public boolean hasSecurityHeaders() {return hasSecurityHeaders;}
    public void setHasSecurityHeaders(boolean hasSecurityHeaders) {this.hasSecurityHeaders = hasSecurityHeaders;}
    public boolean hasVulnerabilities() {return hasVulnerabilities;}
    public void setHasVulnerabilities(boolean hasVulnerabilities) {this.hasVulnerabilities = hasVulnerabilities;}
    public String getVulnerabilityDetails() {return vulnerabilityDetails;}
    public void setVulnerabilityDetails(String vulnerabilityDetails) {this.vulnerabilityDetails = vulnerabilityDetails;}
    
    // Compliance Assessment
    public int getComplianceScore() {return complianceScore;}
    public void setComplianceScore(int complianceScore) {this.complianceScore = complianceScore;}
    public String getComplianceGrade() {return complianceGrade;}
    public void setComplianceGrade(String complianceGrade) {this.complianceGrade = complianceGrade;}
    
    // Finding Counts by Severity
    public int getCriticalFindingsCount() {return criticalFindingsCount;}
    public void setCriticalFindingsCount(int criticalFindingsCount) {this.criticalFindingsCount = criticalFindingsCount;}
    public int getHighFindingsCount() {return highFindingsCount;}
    public void setHighFindingsCount(int highFindingsCount) {this.highFindingsCount = highFindingsCount;}
    public int getMediumFindingsCount() {return mediumFindingsCount;}
    public void setMediumFindingsCount(int mediumFindingsCount) {this.mediumFindingsCount = mediumFindingsCount;}
    public int getLowFindingsCount() {return lowFindingsCount;}
    public void setLowFindingsCount(int lowFindingsCount) {this.lowFindingsCount = lowFindingsCount;}
    public int getInfoFindingsCount() {return infoFindingsCount;}
    public void setInfoFindingsCount(int infoFindingsCount) {this.infoFindingsCount = infoFindingsCount;}
    
    // Content & Cache Analysis
    public String getContentValidation() {return contentValidation;}
    public void setContentValidation(String contentValidation) {this.contentValidation = contentValidation;}
    public boolean isCacheable() {return isCacheable;}
    public void setCacheable(boolean isCacheable) {this.isCacheable = isCacheable;}
    public int getCacheMaxAge() {return cacheMaxAge;}
    public void setCacheMaxAge(int cacheMaxAge) {this.cacheMaxAge = cacheMaxAge;}
    public Map<String, String> getCacheDirectives() {return cacheDirectives;}
    public void setCacheDirectives(Map<String, String> cacheDirectives) {this.cacheDirectives = cacheDirectives;}
    
    // API Detection
    public boolean isApiEndpoint() {return isApiEndpoint;}
    public void setIsApiEndpoint(boolean isApiEndpoint) {this.isApiEndpoint = isApiEndpoint;}
    public String getApiVersion() {return apiVersion;}
    public void setApiVersion(String apiVersion) {this.apiVersion = apiVersion;}
    
    // Detailed Analysis Storage
    public String getAuditSummary() {return auditSummary;}
    public void setAuditSummary(String auditSummary) {this.auditSummary = auditSummary;}
    public String getRemediationPriority() {return remediationPriority;}
    public void setRemediationPriority(String remediationPriority) {this.remediationPriority = remediationPriority;}
    public List<Map<String, String>> getAuditFindings() {return auditFindings;}
    public void setAuditFindings(List<Map<String, String>> auditFindings) {this.auditFindings = auditFindings;}
    
    /**
     * Extracts HIGH severity findings from the audit findings list.
     * Convenience method for report generation to get priority actions.
     * 
     * @return List of HIGH severity finding descriptions
     */
    public List<String> getHighSeverityFindings() {
        List<String> highFindings = new ArrayList<>();
        if (auditFindings != null) {
            for (Map<String, String> finding : auditFindings) {
                String severity = finding.get("severity");
                if ("HIGH".equalsIgnoreCase(severity)) {
                    highFindings.add(finding.get("finding"));
                }
            }
        }
        return highFindings;
    }
    
    /**
     * Extracts CRITICAL severity findings from the audit findings list.
     * Convenience method for report generation to get critical issues.
     * 
     * @return List of CRITICAL severity finding descriptions
     */
    public List<String> getCriticalSeverityFindings() {
        List<String> criticalFindings = new ArrayList<>();
        if (auditFindings != null) {
            for (Map<String, String> finding : auditFindings) {
                String severity = finding.get("severity");
                if ("CRITICAL".equalsIgnoreCase(severity)) {
                    criticalFindings.add(finding.get("finding"));
                }
            }
        }
        return criticalFindings;
    }
    
    /**
     * Extracts findings by severity level from the audit findings list.
     * Generic convenience method for any severity level.
     * 
     * @param severityLevel Severity level to filter by (CRITICAL, HIGH, MEDIUM, LOW, INFO)
     * @return List of finding descriptions matching the severity level
     */
    public List<String> getFindingsBySeverity(String severityLevel) {
        List<String> findings = new ArrayList<>();
        if (auditFindings != null && severityLevel != null) {
            for (Map<String, String> finding : auditFindings) {
                String severity = finding.get("severity");
                if (severityLevel.equalsIgnoreCase(severity)) {
                    findings.add(finding.get("finding"));
                }
            }
        }
        return findings;
    }
    
    // ===== SECTION 8: ERROR HANDLING =====
    public boolean hasError() {return hasError;}
    public void setHasError(boolean hasError) {this.hasError = hasError;}
    public String getErrorType() {return errorType;}
    public void setErrorType(String errorType) {this.errorType = errorType;}
    public String getErrorMessage() {return errorMessage;}
    public void setErrorMessage(String errorMessage) {this.errorMessage = errorMessage;}
    public String getErrorStackTrace() {return errorStackTrace;}
    public void setErrorStackTrace(String errorStackTrace) {this.errorStackTrace = errorStackTrace;}
    public int getErrorRetryCount() {return errorRetryCount;}
    public void setErrorRetryCount(int errorRetryCount) {this.errorRetryCount = errorRetryCount;}
    
    // ===== SECTION 9: EXTENSIBILITY =====
    public Map<String, Object> getMetadata() {return metadata;}
    public void setMetadata(Map<String, Object> metadata) {this.metadata = metadata;}
    public Map<String, Object> getExtensions() {return extensions;}
    public void setExtensions(Map<String, Object> extensions) {this.extensions = extensions;}
    
    // =================================================================================
    // ====================== Getters and Setters - End ================================
    // =================================================================================
    
    /**
     * Returns a string representation of the FW_Http object.
     * Provides a summary without including potentially large body content.
     *
     * @return A formatted string representation of the HTTP transaction
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FW_Http Transaction Summary:\n");
        sb.append("  ID: ").append(httpRefID).append("\n");
        sb.append("  Name: ").append(httpName != null ? httpName : "N/A").append("\n");
        sb.append("  Request: ").append(requestMethod).append(" ").append(requestUrl).append("\n");
        sb.append("  Response: ").append(responseStatusCode).append(" ").append(responseStatusMessage).append("\n");
        sb.append("  Duration: ").append(totalDurationHR != null ? totalDurationHR : totalDurationMs + "ms").append("\n");
        sb.append("  Secure: ").append(isSecure).append("\n");
        
        // Add redirect information if present
        if (hasRedirect) {
            sb.append("  Redirects: ").append(redirectCount).append("\n");
            if (redirectUrls != null && !redirectUrls.isEmpty()) {
                sb.append("  Redirect Chain:\n");
                for (int i = 0; i < redirectUrls.size(); i++) {
                    sb.append("    ").append(i + 1).append(". ")
                      .append(redirectStatusCodes.get(i)).append(" → ")
                      .append(redirectUrls.get(i));
                    if (i < redirectDurations.size()) {
                        sb.append(" (").append(redirectDurations.get(i)).append("ms)");
                    }
                    sb.append("\n");
                }
            }
            sb.append("  Final URL: ").append(finalUrl != null ? finalUrl : "N/A").append("\n");
            sb.append("  Redirect Time: ").append(redirectTotalDurationMs).append("ms\n");
        }
        
        if (hasError) {
            sb.append("  Error: ").append(errorType).append(" - ").append(errorMessage).append("\n");
        }
        
        // Add comprehensive audit scores if available
        if (overallScore >= 0) {
            sb.append("  Overall Score: ").append(overallScore).append("/100");
            if (overallGrade != null) {
                sb.append(" (").append(overallGrade).append(")");
            }
            sb.append("\n");
        }
        
        if (securityScore >= 0) {
            sb.append("  Security Score: ").append(securityScore).append("/100");
            if (securityGrade != null) {
                sb.append(" (").append(securityGrade).append(")");
            }
            sb.append("\n");
        }
        
        if (performanceScore >= 0) {
            sb.append("  Performance Score: ").append(performanceScore).append("/100");
            if (performanceGrade != null) {
                sb.append(" (").append(performanceGrade).append(")");
            }
            sb.append("\n");
        }
        
        if (complianceScore >= 0) {
            sb.append("  Compliance Score: ").append(complianceScore).append("/100");
            if (complianceGrade != null) {
                sb.append(" (").append(complianceGrade).append(")");
            }
            sb.append("\n");
        }
        
        // Add finding counts if any exist
        int totalFindings = criticalFindingsCount + highFindingsCount + mediumFindingsCount + lowFindingsCount;
        if (totalFindings > 0) {
            sb.append("  Findings: ");
            if (criticalFindingsCount > 0) sb.append("Critical: ").append(criticalFindingsCount).append(" ");
            if (highFindingsCount > 0) sb.append("High: ").append(highFindingsCount).append(" ");
            if (mediumFindingsCount > 0) sb.append("Medium: ").append(mediumFindingsCount).append(" ");
            if (lowFindingsCount > 0) sb.append("Low: ").append(lowFindingsCount);
            sb.append("\n");
        }
        
        if (hasVulnerabilities && vulnerabilityDetails != null) {
            sb.append("  Vulnerabilities: ").append(vulnerabilityDetails).append("\n");
        }
        
        return sb.toString();
    }
}