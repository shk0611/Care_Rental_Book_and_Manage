package car_rental_book_and_manage.Controllers;

import car_rental_book_and_manage.App;
import car_rental_book_and_manage.Objects.Client;
import car_rental_book_and_manage.Objects.ClientDB;
import car_rental_book_and_manage.Utility.AlertManager;
import car_rental_book_and_manage.Utility.SceneManager;
import car_rental_book_and_manage.Utility.SceneManager.Scenes;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SignUpController extends Controller {

  @FXML private Button createAccBtn;

  @FXML private Button logInBtn;

  @FXML private PasswordField signUpPassword;

  @FXML private TextField signUpUsername;

  @FXML private TextField nameField;

  @FXML private TextField phoneNoTxt;

  public void initialize() {
    SceneManager.setController(Scenes.SIGNUP, this);
  }

  @FXML
  public void onCreateAccount(MouseEvent event) {
    Client client = new Client();
    String name = nameField.getText();
    String password = signUpPassword.getText();
    String username = signUpUsername.getText();
    String phoneNo = phoneNoTxt.getText();

    if (name.isEmpty() || password.isEmpty() || username.isEmpty() || phoneNo.isEmpty()) {
        AlertManager.showAlert(
            AlertType.WARNING, "Required Fields", "Please Enter All Missing Fields");
    }
    else if (phoneNo.length() != 7 || !isNumeric(phoneNo)) {
      AlertManager.showAlert(
          AlertType.WARNING, "Invalid Phone Number", "Please Check Your Phone Number Format");
    } else if (checkIfUsernameExists(username)) {
      AlertManager.showAlert(
          AlertType.WARNING,
          "Username Already Exists",
          "Please Come Up With Another Username");
    } else {
      client.setFirstName(name);
      client.setUsername(username);
      client.setPassword(password);
      client.setPhoneNo(Integer.parseInt(phoneNo));

      ClientDB clientdb = new ClientDB();
      clientdb.save(client);
      App.getClientList().add(client);

      // Clear text and password fields
      nameField.clear();
      signUpPassword.clear();
      signUpUsername.clear();
      phoneNoTxt.clear();
      AlertManager.showAlert(AlertType.CONFIRMATION, "Sign Up", "Account Created Successfully");
    }
  }

  public boolean checkIfUsernameExists(String username) {
    List<Client> clientList = App.getClientList();

    for (Client c : clientList) {
      if (c.getUsername().equals(username)) {
        return true;
      }
    }
    return false;
  }

  private boolean isNumeric(String str) {
    if (str == null || str.isEmpty()) {
      return false;
    }
    for (char c : str.toCharArray()) {
      if (!Character.isDigit(c)) {
        return false;
      }
    }
    return true;
  }

  @FXML
  public void onLogIn(MouseEvent event) {
    App.setUi(Scenes.LOGIN);
  }
}
