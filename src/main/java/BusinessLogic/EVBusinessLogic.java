/*
Student:            Chen Jiaying
No. :               041191259
Class & Section:    CST8288 section 013
Description:        lab 1
*/
package BusinessLogic;

import DataAccessLayer.EVDAO;
import DataAccessLayer.EVDAOImpl;
import TransferObjects.EVDTO;
import java.util.List;

/**
 * Business Logic Layer (BLL) class responsible for coordinating
 * operations between the presentation layer and the data access layer.
 *
 * This class acts as an intermediary between the user interface and
 * database operations.
 *
 * @author Chen Jiaying
 */
public class EVBusinessLogic {

    //Data access object used to retrieve EV data.
    private EVDAO evDAO = new EVDAOImpl();
    
    /**
     * Retrieves all electric vehicle data from the data access layer.
     *
     * @return ReportDTO containing EV records and metadata
     */
    public List<EVDTO> getAllEvs(){
        return evDAO.getAllEVs();
    }
}
