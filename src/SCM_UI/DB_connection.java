/**
 * @author Warren Elliott
 */
package SCM_UI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

public class DB_connection {
    public final static void connect(){
        //Establish connection with the database SCM_SYSTEM
        Connection myConObj = null; //create a connection
        Statement myStatObj = null; //allows Java to execute SQL statements
        ResultSet myResObj = null; //represent the data
        //String query="";
        
        try{
            myConObj = DriverManager.getConnection("jdbc:derby://localhost:1527/SCM_SYSTEM");
            myStatObj = myConObj.createStatement();
            myResObj=myStatObj.executeQuery("");
            
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
}
