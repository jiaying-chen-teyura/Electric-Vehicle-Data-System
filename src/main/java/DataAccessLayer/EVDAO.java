/*
Student:            Chen Jiaying
No. :               041191259
Class & Section:    CST8288 section 013
Description:        lab 1
*/
package DataAccessLayer;

import TransferObjects.EVDTO;
import java.util.List;


/**
 * Data Access Object (DAO) interface for Electric Vehicle (EV) data.
 * Defines methods used to retrieve EV information from the database.
 *
 * @author Chen Jiaying
 */
public interface EVDAO {
    List<EVDTO> getAllEVs();
}
