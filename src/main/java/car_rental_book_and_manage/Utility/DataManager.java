package car_rental_book_and_manage.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataManager {

  private static Connection connection;
  private static final String url = "jdbc:mysql://localhost:3306/management_booking";
  private static final String user = "root";
  private static final String password = "w4ldleeK03";


  public static Connection getConnection() {
    try {
      connection = DriverManager.getConnection(url, user, password);
      System.out.println("Connected to the database");
    } catch (SQLException e) {
      System.out.println("Failed to connect to the database");
      e.printStackTrace();
    }
    return connection;
  }

  public static void disconnect() throws SQLException {
    if (connection != null && !connection.isClosed()) {
      connection.close();
    }
    
}

}
