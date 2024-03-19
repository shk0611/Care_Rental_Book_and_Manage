package car_rental_book_and_manage.Controllers;

import car_rental_book_and_manage.App;
import car_rental_book_and_manage.Objects.Client;
import car_rental_book_and_manage.Utility.SceneManager;
import car_rental_book_and_manage.Utility.SceneManager.Scenes;
import car_rental_book_and_manage.Utility.UserManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SignUpController extends Controller {

  @FXML private Button createAccBtn;

  @FXML private Button logInBtn;

  @FXML private PasswordField signUpPassword;

  @FXML private TextField signUpUsername;

  @FXML private TextField nameField;

  @FXML private Label authenticationLbl;

  public void initialize() {
    SceneManager.setController(Scenes.SIGNUP, this);
  }

  @FXML
  public void onCreateAccount(MouseEvent event) {
    String name = nameField.getText();
    String password = signUpPassword.getText();
    String username = signUpUsername.getText();

    if (name.isEmpty() || password.isEmpty() || username.isEmpty()) {
      authenticationLbl.setText("Input all information");
    } else {
      Client client = new Client(username, password, name);
      UserManager.addClient(client);
      App.getDataConnector().saveClientIntoDB(client);
      authenticationLbl.setText("Account successfully created");
    }
  }

  @FXML
  public void onLogIn(MouseEvent event) {
    App.setUi(Scenes.LOGIN);
  }
}
