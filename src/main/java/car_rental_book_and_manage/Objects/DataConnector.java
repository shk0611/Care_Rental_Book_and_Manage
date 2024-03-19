package car_rental_book_and_manage.Objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataConnector {

  private Connection connection;
  private boolean authenticated = false;
  private String url;
  private String user;
  private String password;

  public DataConnector(String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.password = password;
  }

  public void connect() {
    try {
      connection = DriverManager.getConnection(url, user, password);
      System.out.println("Connected to the database");
    } catch (SQLException e) {
      System.err.println("Failed to connect to the database");
      e.printStackTrace();
    }
  }

  public void disconnect() throws SQLException {
    if (connection != null && !connection.isClosed()) {
      connection.close();
    }
  }

  public void saveClientIntoDB(User user) {
    String sql = "INSERT INTO client (Client_username, Client_password, Client_firstname) VALUES (?, ?, ?)";

    try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getFirstName());
        
        // Execute the statement
        statement.executeUpdate();
        
        // Retrieve the auto-generated ID (if needed)
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int generatedId = generatedKeys.getInt(1);
            // Optionally, you can set the generated ID back to your user object
            ((Client)user).setClientId(generatedId);
        } else {
            System.out.println("Failed to retrieve the auto-generated ID.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
