package DBConnection;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBReading {

    @Test
    public void fecthDataFromDatabase() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Connection con= DriverManager.getConnection("jdbc.mysql:/loca")
    }
}
