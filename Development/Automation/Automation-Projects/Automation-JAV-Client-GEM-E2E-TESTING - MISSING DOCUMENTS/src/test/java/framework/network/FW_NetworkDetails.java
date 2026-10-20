package framework.network;

// ===============================================================
// @file: FW_NetworkDetails.java
// @filepath: src/test/java/framework/network/FW_NetworkDetails.java
// @version: 2.0.0
// @updated: 2025-01-10 12:35:00 PM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Represents a comprehensive data model for all network and geographic
// information related to a specific host or IP address. This class serves
// as a standardized container for network metadata including hostname
// resolution, IP details, geolocation data, ASN information, and anycast
// detection. Designed to be a lightweight, reusable data structure that
// can be populated by various network analysis tools and integrated with
// test step location tracking for enhanced test reporting.
//
// @dependencies:
// None (pure data model class)
//
// @methods:
// - Constructor: Creates FW_NetworkDetails with initial host
// - toString(): Returns formatted string representation
// - Full set of getters/setters for all network properties
//
// @properties:
// - Identification: host, hostname, ip, anycast details
// - Geolocation: city, region, country, coordinates
// - Network: ASN, organization
//
// @tags: network, data-model, geolocation, ip-details, anycast, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-08-19  G. Paskal       1.0.0    Initial implementation
// 2025-01-10  G. Paskal       2.0.0    Added mAi™ header and enhanced documentation
// ===============================================================

/**
 * Represents a consolidated data container for network and geographic details
 * for a target host.
 */
public class FW_NetworkDetails {

    // Identification
    private String host;                // The original host (https://example.com or IP) provided by the user.
    private String hostname;            // The resolved hostname (e.g., example.com)
    private String ip;                  // The resolved IP address (e.g., 192.0.2.1)
    private Boolean isAnycast;          // Whether this IP uses anycast routing
    private String anycastConfidence;   // Confidence level of anycast detection (high/medium/low)

    // Geolocation
    private String city;                // The city of the resolved IP address (e.g., San Francisco)
    private String region;              // The region of the resolved IP address (e.g., California)
    private String country;             // The country of the resolved IP address (e.g., United States)
    private String countryCode;         // The country code of the resolved IP address (e.g., US)
    private String continent;           // The continent of the resolved IP address (e.g., North America)
    private Double latitude;            // The latitude of the resolved IP address (e.g., 37.7749)
    private Double longitude;           // The longitude of the resolved IP address (e.g., -122.4194)
    private Integer asn;                // The Autonomous System Number (ASN) of the resolved IP address (e.g., 15169)
    private String asnOrganization;     // The organization associated with the ASN (e.g., Google

    /**
     * Constructs a new, empty FW_NetworkDetails instance with the initial target.
     * This constructor is lightweight and does not perform network operations.
     *
     * @param host The initial host or IP address string. (e.g.,https://example.com)
     */
    public FW_NetworkDetails(String host) {
        this.host = host;

        // Initialize all other fields to default values
        this.hostname = "";
        this.ip = "";
        this.isAnycast = null;
        this.anycastConfidence = "";
        this.city = "";
        this.region = "";
        this.country = "";
        this.countryCode = "";
        this.continent = "";
        this.latitude = 0.0;
        this.longitude = 0.0;
        this.asn = null;
        this.asnOrganization = "";
    }

    /**
     * Returns a string representation of the FW_NetworkDetails object.
     * This method is overridden to provide a detailed and readable representation.
     *
     * @return A string representation of the FW_NetworkDetails object.
     */
    @Override
    public String toString() {

        return "FW_NetworkDetails {" +
                "host='" + host + '\'' +
                ", hostname='" + hostname + '\'' +
                ", ip='" + ip + '\'' +
                ", isAnycast=" + isAnycast +
                ", anycastConfidence='" + anycastConfidence + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", continent='" + continent + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", asn=" + asn +
                ", asnOrganization='" + asnOrganization + '\'' +
                '}';
    }

    // =================================================================================
    // ====================== Class - Getters and Setters - Begin ======================

    // Identification
    public String getHost() {return host;}
    public void setHost(String host) {this.host = host;}
    public String getHostname() {return hostname;}
    public void setHostname(String hostname) {this.hostname = hostname;}
    public String getIp() {return ip;}
    public void setIp(String ip) {this.ip = ip;}
    public Boolean getIsAnycast() {return isAnycast;}
    public void setIsAnycast(Boolean isAnycast) {this.isAnycast = isAnycast;}
    public String getAnycastConfidence() {return anycastConfidence;}
    public void setAnycastConfidence(String anycastConfidence) {this.anycastConfidence = anycastConfidence;}

    // Geolocation
    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}
    public String getRegion() {return region;}
    public void setRegion(String region) {this.region = region;}
    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}
    public String getCountryCode() {return countryCode;}
    public void setCountryCode(String countryCode) {this.countryCode = countryCode;}
    public String getContinent() {return continent;}
    public void setContinent(String continent) {this.continent = continent;}
    public Double getLatitude() {return latitude;}
    public void setLatitude(Double latitude) {this.latitude = latitude;}
    public Double getLongitude() {return longitude;}
    public void setLongitude(Double longitude) {this.longitude = longitude;}
    public Integer getAsn() {return asn;}
    public void setAsn(Integer asn) {this.asn = asn;}
    public String getAsnOrganization() {return asnOrganization;}
    public void setAsnOrganization(String asnOrganization) {this.asnOrganization = asnOrganization;}

    // ====================== Class - Getters and Setters - End ======================
    // ===============================================================================

}