/*
Student:            Chen Jiaying
No. :               041191259
Class & Section:    CST8288 section 013
Description:        lab 1
*/
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
 * Manages database connectivity for the application.
 * Uses a singleton-style approach to maintain a single database connection.
 *
 * @author Chen Jiaying
 */
public class DataSource {
    /** Shared database connection object. */
    private static volatile Connection cnt = null;
    
    /** Private constructor prevents instantiation. */
    private DataSource(){};
    
    /**
     * Retrieves the database connection.
     * If a connection does not exist, one is created using
     * properties loaded from the configuration file.
     *
     * @return active database connection
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
 
            }else{
                System.out.println("Cannot create new connection, using existing one");
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
    
    
}
