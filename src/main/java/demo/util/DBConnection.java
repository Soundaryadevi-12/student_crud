package demo.util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class DBConnection {
    private final static String URL = "jdbc:mysql://localhost:3306/student_management_system";
    private final static String USER="root";
    private final static String PWD="Sound@1431";

    public static Connection getConnection()  {
        Connection connection =null;
        try{
      // Ensure JDBC driver is loaded (helps on some runtimes)
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
      } catch (ClassNotFoundException e) {
        // Driver not found on classpath — print warning and continue, DriverManager may still auto-load
        e.printStackTrace();
      }
      connection=DriverManager.getConnection(URL, USER, PWD);
        }catch(SQLException e){
            e.printStackTrace();
    }
    return connection;
}
}