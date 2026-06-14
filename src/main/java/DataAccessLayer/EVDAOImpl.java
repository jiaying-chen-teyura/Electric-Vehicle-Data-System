
package DataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import TransferObjects.EVDTO;
import java.util.List;


/**
 * Implementation of the EVDAO interface.
 * Responsible for retrieving EV data and metadata from the database.
 *
 * @author Chen Jiaying
 */
public class EVDAOImpl implements EVDAO {
    

    @Override
    public List<EVDTO> getAllEVs(){
        // DTOs
        ArrayList<EVDTO> EVs = null;
        
        // JDBC objects
        Connection connection = null;
        
        try{
            // get data from mysql
            connection = DataSource.getConnection();
            String query = "SELECT o.CITY, c.Fsa, c.Bev, c.Phev, c.TotalEv\n" +
                            "FROM evontario.evcounts AS c\n" +
                            "JOIN evontario.ottawapostalcodes AS o\n" +
                            "WHERE c.Fsa = o.Fsa";
            try(
                
                PreparedStatement prepStatement = connection.prepareStatement(query);
                ResultSet resultSet = prepStatement.executeQuery();
            ){
                // adding EVDTO to ev list
                EVs = new ArrayList<>();
                while(resultSet.next()){
                    EVDTO ev = new EVDTO();
                    ev.setCity(resultSet.getNString("city"));
                    ev.setFsa(resultSet.getNString("fsa"));
                    ev.setBev(resultSet.getInt("Bev"));
                    ev.setPhev(resultSet.getInt("Phev"));
                    ev.setTotalEv(resultSet.getInt("TotalEv"));
                    EVs.add(ev);  
                }
            }
            
        }catch(SQLException se){
            se.printStackTrace();
        }
        
        return  EVs;
    }; // end of getAllEVs
    
}
