/*
Student:            Chen Jiaying
No. :               041191259
Class & Section:    CST8288 section 013
Description:        lab 1
*/
package transferObjects;

/**
 * Data Transfer Object (DTO) representing Electric Vehicle statistics
 * for a specific city.
 *
 * @author Chen Jiaying
 */
public class EVDTO {
    private String city;
    private String fsa;
    private Integer bev;
    private Integer phev;
    private Integer totalEv;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    
    
    public String getFsa() {
        return fsa;
    }

    public void setFsa(String fsa) {
        this.fsa = fsa;
    }

    public Integer getBev() {
        return bev;
    }

    public void setBev(Integer bev) {
        this.bev = bev;
    }

    public Integer getPhev() {
        return phev;
    }

    public void setPhev(Integer phev) {
        this.phev = phev;
    }

    public Integer getTotalEv() {
        return totalEv;
    }

    public void setTotalEv(Integer totalEv) {
        this.totalEv = totalEv;
    }
    

}
