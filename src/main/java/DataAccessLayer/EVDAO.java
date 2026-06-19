
package DataAccessLayer;

import TransferObjects.EVDTO;
import java.util.List;


/**
 * Data Access Object (DAO) interface for Electric Vehicle (EV) data.
 * Defines methods used to retrieve EV information from the database.
 *
 * @author 
 */
public interface EVDAO {
    
    /**
     * Retrieves all electric vehicle records from the database.
     *
     * @return a list containing all electric vehicle records;
     *         returns an empty list if no records are found
    */
    List<EVDTO> getAllEVs();
}
