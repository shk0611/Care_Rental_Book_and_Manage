package car_rental_book_and_manage.Objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnector {

  public Connection connection;

  public DataConnector(String dbURL, String user, String password) {
    try {
      connection = DriverManager.getConnection(dbURL, user, password);
      System.out.println("Connected to the database");
    } catch (SQLException e) {
      System.err.println("Failed to connect to the database");
      e.printStackTrace();
    }
  }

  public boolean authenticateUser(String name,String password,String userType) {


    
    return false;
  }



}
