
package DataAccessLayer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
* Provides access to the application's database connection.
*
* <p>This class implements the Singleton Design Pattern to ensure that
* only one database connection instance exists throughout the lifetime
* of the application. The connection is created lazily when first
* requested and is shared by all data access objects.</p>
*
* <p>Thread safety is achieved using the double-checked locking
* pattern together with a {@code volatile} connection reference.</p>
*
* @author 
* @version 1.0
*/

public class DataSource {
    // Shared database connection object. 
    
    private static volatile Connection cnt = null;
    
    /** Private constructor prevents instantiation. */
    private DataSource(){};
    
    /**
     * Returns the shared database connection.
     * If a connection does not exist, one is created using
     * properties loaded from the configuration file.
     *
     * @return the shared database connection
     */
    public static Connection getConnection(){
        String[] connectionInfo = openPropsFile();

        try{
            if(cnt == null){
                synchronized(DataSource.class){
                    if(cnt == null){
                        cnt = DriverManager.getConnection(connectionInfo[0],connectionInfo[1],connectionInfo[2]);
                    }
                }
 
            }
            
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        
        return cnt;
    }//end of getConnection
    
    
    /**
     * Reads database connection settings from the properties file.
     *
     * @return String array containing:
     *         [0] JDBC URL,
     *         [1] username,
     *         [2] password
     */
    private static String[] openPropsFile(){
        Properties props = new Properties();
        
        try(
            InputStream in = Files.newInputStream(Paths.get("src/main/java/database.properties"));
                
        ){
            props.load(in);
        }catch(IOException e){
            e.printStackTrace();
        }
        
        // Retrieve connection settings
        String connectionString = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
        String[] info = new String[3];
       
        info[0] = connectionString;
        info[1] = username;
        info[2] = password;
       
       return info;
    }
    
    /**

  * Closes the shared database connection if it is open.
  *
  * <p>This method should be called when the application terminates
  * to release database resources.</p>
    */
    public static void closeConnection() {
        if (cnt != null) {
            try {
                if (!cnt.isClosed()) {
                    cnt.close();
                    
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
