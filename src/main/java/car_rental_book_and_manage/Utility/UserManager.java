package car_rental_book_and_manage.Utility;

import car_rental_book_and_manage.Objects.Admin;
import car_rental_book_and_manage.Objects.Client;
import java.util.ArrayList;
import java.util.HashSet;

public class UserManager {

  private static HashSet<Client> clientList = new HashSet<Client>();
  private static HashSet<Admin> adminList = new HashSet<Admin>();
  private static final ArrayList<String> userList = new ArrayList<>();

  static {
    userList.add("admin portal");
    userList.add("client portal");
  }

  public static ArrayList<String> getUserList() {
    return userList;
  }

  public static HashSet<Client> getClientList() {
    return clientList;
  }

  public static void setClientList(HashSet<Client> clientList) {
    UserManager.clientList = clientList;
  }

  public static HashSet<Admin> getAdminList() {
    return adminList;
  }

  public static void setAdminList(HashSet<Admin> adminList) {
    UserManager.adminList = adminList;
  }

  // Method to add a client to the clientList HashSet
  public static void addClient(Client client) {
    clientList.add(client);
  }

  // Method to remove a client from the clientList HashSet
  public static void removeClient(Client client) {
    clientList.remove(client);
  }

  // Method to add a client to the clientList HashSet
  public static void addAdmin(Admin admin) {
    adminList.add(admin);
  }

  // Method to remove a client from the clientList HashSet
  public static void removeClient(Admin admin) {
    adminList.remove(admin);
  }
}
