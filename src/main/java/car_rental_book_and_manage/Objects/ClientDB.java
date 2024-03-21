package car_rental_book_and_manage.Objects;

import car_rental_book_and_manage.Utility.DataManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDB implements ClientDAO {

  @Override
  public void save(Client client) {
    Connection connection = DataManager.getConnection();
    String sql =
        "INSERT INTO client (Client_username, Client_password, Client_firstname, Client_phoneno)"
            + " VALUES (?, ?, ?, ?)";

    try (PreparedStatement statement =
        connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      statement.setString(1, client.getUsername());
      statement.setString(2, client.getPassword());
      statement.setString(3, client.getFirstName());
      statement.setInt(4, client.getPhoneNo());

      // Execute the statement
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    System.out.println("saved new client data");
  }

  @Override
  public void update(Client client) {
    
  }

  @Override
  public void delete(Client client) {

  }

  @Override
  public Client get(String name) {
   return new Client();
  }

  @Override
  public List<Client> retrieveAllClients() {

    List<Client> clientList = new ArrayList<Client>();

    Connection connection = DataManager.getConnection();
    String sql = "SELECT * FROM client";
    try {
      PreparedStatement statement = connection.prepareStatement(sql);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        Client client = new Client();
        client.setClientId(resultSet.getInt("Client_id"));
        client.setUsername(resultSet.getString("Client_username"));
        client.setPassword(resultSet.getString("Client_password"));
        client.setPhoneNo(resultSet.getInt("Client_phoneno"));

        clientList.add(client);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return clientList;
  }
}
