package framework.network;

/**
 * @file FW_IpDetails.java
 * @description A data class to hold GeoIP and ASN details for a single IP address.
 */
public class FW_IpDetails {

    private String countryCode;
    private String regionCode;
    private String city;
    private Double latitude;
    private Double longitude;
    private Integer asn;
    private String asnOrganization;

    // --- Getters and Setters ---
    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

    public String getRegionCode() { return regionCode; }
    public void setRegionCode(String regionCode) { this.regionCode = regionCode; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public Integer getAsn() { return asn; }
    public void setAsn(Integer asn) { this.asn = asn; }

    public String getAsnOrganization() { return asnOrganization; }
    public void setAsnOrganization(String asnOrganization) { this.asnOrganization = asnOrganization; }


    @Override
    public String toString() {
        return "FW_IpDetails{" +
                "countryCode='" + countryCode + '\'' +
                ", regionCode='" + regionCode + '\'' +
                ", city='" + city + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", asn=" + asn +
                ", asnOrganization='" + asnOrganization + '\'' +
                '}';
    }
} 
