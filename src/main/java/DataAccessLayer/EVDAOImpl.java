/*
Student:            Chen Jiaying
No. :               041191259
Class & Section:    CST8288 section 013
Description:        lab 1
*/
package DataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import TransferObjects.EVDTO;
import TransferObjects.MetaDTO;
import TransferObjects.ReportDTO;


/**
 * Implementation of the EVDAO interface.
 * Responsible for retrieving EV data and metadata from the database.
 *
 * @author Chen Jiaying
 */
public class EVDAOImpl implements EVDAO {
    
    /**
     * Retrieves all EV records from the database and stores them
     * in a ReportDTO object along with metadata information.
     *
     * @return ReportDTO containing EV data and column metadata
     */
    @Override
    public ReportDTO getAllEVs(){
        // DTOs
        ReportDTO report = new ReportDTO();
        ArrayList<EVDTO> EVs = null;
        ArrayList<MetaDTO> metas = null;

        // JDBC objects
        Connection connection = null;
        PreparedStatement prepStatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData meta = null;
        
        try{
            // get data from mysql
            connection = DataSource.getConnection();
            String query = "SELECT o.CITY, c.Fsa, c.Bev, c.Phev, c.TotalEv\n" +
                            "FROM evontario.evcounts AS c\n" +
                            "JOIN evontario.ottawapostalcodes AS o\n" +
                            "WHERE c.Fsa = o.Fsa";
            prepStatement = connection.prepareStatement(query);
            resultSet = prepStatement.executeQuery();
            meta = resultSet.getMetaData();
            
            // adding metaDTO to meta list
            metas = new ArrayList<>();
            int numsOfColumns = meta.getColumnCount();
        
            for(int i = 1; i <= numsOfColumns; i++){
                MetaDTO metadata = new MetaDTO();
                metadata.setColumnName(meta.getColumnName(i));
                metadata.setSqlType(meta.getColumnTypeName(i));
                metadata.setClassName(meta.getColumnClassName(i));
                metas.add(metadata);
            }

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
            
            // adding report list
            report.setEvs(EVs);
            report.setMetas(metas);
        }catch(SQLException se){
            se.printStackTrace();
        }finally{

            try {
                // Release JDBC resources
                resultSet.close();
                prepStatement.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }// end of finally
        
        return  report;
    }; // end of getAllEVs
    
}
