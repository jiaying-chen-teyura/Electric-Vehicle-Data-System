
package DataAccessLayer;

import TransferObjects.PostcodeDTO;

/**
 * Data Access Object (DAO) interface for postal code data.
 *
 * <p>Defines the database operations available for retrieving
 * postal code information from the database.</p>
 *
 * @author 
 */
public interface PostcodeDAO {
    PostcodeDTO getPostcodeByFsa(String queryFsa);
}
