/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;


import DataAccessLayer.PostcodeDAO;
import DataAccessLayer.PostcodeDAOImpl;

import TransferObjects.PostcodeDTO;


/**
 *
 * @author Teyura
 */
public class PostcodeBusineesLogic {
    private PostcodeDAO pcDAO = new PostcodeDAOImpl();
    
    
    /**
     * Retrieves all electric vehicle data from the data access layer.
     *
     * @return ReportDTO containing EV records and metadata
     */
    public PostcodeDTO getPostcodeByFsa(String queryFsa){
        return pcDAO.getPostcodeByFsa(queryFsa);
    }
    

}
