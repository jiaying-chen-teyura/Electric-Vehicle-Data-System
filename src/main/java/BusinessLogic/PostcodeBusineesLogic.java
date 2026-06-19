
package BusinessLogic;


import DataAccessLayer.PostcodeDAO;
import DataAccessLayer.PostcodeDAOImpl;

import TransferObjects.PostcodeDTO;


/**
 * Business logic class for postal code operations.
 *
 * <p>This class acts as an intermediary between the presentation layer
 * and the data access layer. It provides access to postal code data
 * retrieved from the database.</p>
 *
 * @author 
 */
public class PostcodeBusineesLogic {
    private PostcodeDAO pcDAO = new PostcodeDAOImpl();
    
    
    /**
     * Retrieves postal code information for a specified FSA
     *
     * @param queryFsa the FSA to search for
     * @return the postal code record matching the specified FSA;
     *         returns {@code null} if no matching record is found
     */
    public PostcodeDTO getPostcodeByFsa(String queryFsa){
        return pcDAO.getPostcodeByFsa(queryFsa);
    }
    

}
