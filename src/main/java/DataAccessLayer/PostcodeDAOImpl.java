package DataAccessLayer;

import TransferObjects.PostcodeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class PostcodeDAOImpl implements PostcodeDAO {
    @Override
    public PostcodeDTO getPostcodeByFsa(String queryFsa) {
        PostcodeDTO pcDTO = new PostcodeDTO();
        Scanner sc = new Scanner(System.in);
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
    }
; // end of getAllEVs

}
