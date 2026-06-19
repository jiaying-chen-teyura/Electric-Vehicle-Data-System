package TransferObjects;

/**
 *
 * Data Transfer Object (DTO) representing a postal code record.
 *
 * <p>
 * This class encapsulates postal code information retrieved from the database
 * and transfers it between the data access layer and business layer.</p>
 *
 * @author Your Name
 */
public class PostcodeDTO {

    private String Fsa;
    private String City;
    private String Province;
    private Double Latitude;
    private Double Longitude;

    /**
     *
     * Returns the Forward Sortation Area (FSA) code.
     *
     * @return the FSA code
     */
    public String getFsa() {
        return Fsa;
    }

    /**
     *
     * Sets the Forward Sortation Area (FSA) code.
     *
     * @param Fsa the FSA code
     */
    public void setFsa(String Fsa) {
        this.Fsa = Fsa;
    }

    /**
     *
     * Returns the city associated with the FSA.
     *
     * @return the city name
     */
    public String getCity() {
        return City;
    }

    /**
     *
     * Sets the city associated with the FSA.
     *
     * @param City the city name
     */
    public void setCity(String City) {
        this.City = City;
    }

    /**
     *
     * Returns the province associated with the FSA.
     *
     * @return the province name
     */
    public String getProvince() {
        return Province;
    }

    /**
     *
     * Sets the province associated with the FSA.
     *
     * @param Province the province name
     */
    public void setProvince(String Province) {
        this.Province = Province;
    }

    /**
     *
     * Returns the latitude coordinate.
     *
     * @return the latitude value
     */
    public Double getLatitude() {
        return Latitude;
    }

    /**
     *
     * Sets the latitude coordinate.
     *
     * @param Latitude the latitude value
     */
    public void setLatitude(Double Latitude) {
        this.Latitude = Latitude;
    }

    /**
     *
     * Returns the longitude coordinate.
     *
     * @return the longitude value
     */
    public Double getLongitude() {
        return Longitude;
    }

    /**
     *
     * Sets the longitude coordinate.
     *
     * @param Longitude the longitude value
     */
    public void setLongitude(Double Longitude) {
        this.Longitude = Longitude;
    }

}
