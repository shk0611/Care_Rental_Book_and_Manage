package car_rental_book_and_manage.Controllers;

import car_rental_book_and_manage.App;
import car_rental_book_and_manage.Objects.Client;
import car_rental_book_and_manage.Utility.AlertManager;
import car_rental_book_and_manage.Utility.SceneManager;
import car_rental_book_and_manage.Utility.SceneManager.Scenes;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController extends Controller {

  @FXML private Button loginBtn;

  @FXML private PasswordField password;

  @FXML private Button signUpBtn;

  @FXML private Button adminBtn;

  @FXML private TextField username;

  @FXML private Label authenticationLbl;

  public void initialize() {
    SceneManager.setController(Scenes.LOGIN, this);
  }

  @FXML
  public void onSignUp(MouseEvent event) {
    App.setUi(Scenes.SIGNUP);
  }

  @FXML
  public void onAdmin(MouseEvent event) {
    App.setUi(Scenes.ADMIN);
  }

  @FXML
  public void onLogIn(MouseEvent event) {

    String enteredUsername = username.getText();
    String enteredPassword = password.getText();

    List<Client> clientList = App.getClientList();
    boolean authenticated = false;

    if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
      AlertManager.showAlert(
          AlertType.WARNING, "Login Unsuccessful", "Please Enter Your Information");
    } else {
      for (Client client : clientList) {
        if (client.getUsername().equals(enteredUsername)
            && client.getPassword().equals(enteredPassword)) {
          authenticated = true;
          break;
        }
      }
      if (authenticated) {
        AlertManager.showAlert(
            AlertType.CONFIRMATION, "Login Successful", "You Are Now Logging In");
        App.setUi(Scenes.CLIENT);
      } else {
        AlertManager.showAlert(
            AlertType.WARNING, "Login Unsuccessful", "Wrong Username or Password");
      }
    }
  }
}
