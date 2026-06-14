/*
Student:            Chen Jiaying
No. :               041191259
Class & Section:    CST8288 section 013
Description:        lab 1
*/
package TransferObjects;

public class PostcodeDTO {
    private String Fsa;
    private String City;
    private String Province;
    private Double Latitude;
    private Double Longitude;

    public String getFsa() {
        return Fsa;
    }

    public void setFsa(String Fsa) {
        this.Fsa = Fsa;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String Province) {
        this.Province = Province;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double Latitude) {
        this.Latitude = Latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double Longitude) {
        this.Longitude = Longitude;
    }
    
    
    
}
