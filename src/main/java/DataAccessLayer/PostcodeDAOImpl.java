package DataAccessLayer;

import TransferObjects.PostcodeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implementation of the {@link PostcodeDAO} interface.
 *
 * <p>This class retrieves postal code information from the
 * database using JDBC. Query results are mapped to
 * {@code PostcodeDTO} objects and returned to the business layer.</p>
 *
 * @author 
 */
public class PostcodeDAOImpl implements PostcodeDAO {
    
    /**
     * Retrieves postal code information for a specified
     * Forward Sortation Area (FSA).
     *
     * <p>This method executes a parameterized SQL query using a
     * {@code PreparedStatement} and maps the result to a
     * {@code PostcodeDTO} object.</p>
     *
     * @param queryFsa the FSA to search for
     * @return a {@code PostcodeDTO} containing the matching
     *         postal code information; returns an empty DTO if
     *         no matching record is found
    */
    
    @Override
    public PostcodeDTO getPostcodeByFsa(String queryFsa) {
        PostcodeDTO pcDTO = new PostcodeDTO();
        
        // JDBC objects
        Connection connection = null;

        try {
            // get data from mysql
            connection = DataSource.getConnection();
            String query = "SELECT * FROM evontario.ottawapostalcodes "
                            + "WHERE Fsa = ?";
            
            try(
                PreparedStatement prepStatement = connection.prepareStatement(query);
 
            ){
                prepStatement.setString(1, queryFsa);
                ResultSet resultSet = prepStatement.executeQuery();  
                
                while (resultSet.next()) {

                    pcDTO.setFsa(resultSet.getNString("fsa"));
                    pcDTO.setCity(resultSet.getNString("city"));
                    pcDTO.setProvince(resultSet.getNString("Province"));
                    pcDTO.setLongitude(resultSet.getDouble("Longitude"));
                    pcDTO.setLatitude(resultSet.getDouble("Latitude"));

                }
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } 

        return pcDTO;
    }; 

}
