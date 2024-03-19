package car_rental_book_and_manage.Controllers;

import car_rental_book_and_manage.App;
import car_rental_book_and_manage.Utility.SceneManager;
import car_rental_book_and_manage.Utility.SceneManager.Scenes;
import car_rental_book_and_manage.Utility.SelectUser;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController extends Controller {

  @FXML private Button loginBtn;

  @FXML private PasswordField password;

  @FXML private ComboBox<String> selectUserComboBox;

  @FXML private Button signUpBtn;

  @FXML private TextField username;

  public void initialize() {
    SceneManager.setController(Scenes.LOGIN, this);
    userSelect();
  }

  @FXML
  public void switchLoginPortal() {
    String selectedItem = selectUserComboBox.getSelectionModel().getSelectedItem();
    if (selectedItem != null) {
      switch (selectedItem) {
        case "admin portal":
          setPromptText("Admin");
          break;
        case "client portal":
          setPromptText("Client");
          break;
        default:
          // Handle other cases if needed
          break;
      }
    }
  }

  private void setPromptText(String userRole) {
    username.setPromptText(userRole + " Username");
    password.setPromptText(userRole + " Password");
  }

  @FXML
  public void onLogIn(MouseEvent event) {
    App.setUi(Scenes.HI);
  }

  public void userSelect() {

    List<String> UserList = new ArrayList<>();

    for (String user : SelectUser.users) {
      UserList.add(user);
    }

    ObservableList<String> dataList = FXCollections.observableArrayList(UserList);
    selectUserComboBox.setItems(dataList);
  }
}
