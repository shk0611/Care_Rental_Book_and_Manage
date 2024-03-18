package car_rental_book_and_manage.Controllers;

import car_rental_book_and_manage.App;
import car_rental_book_and_manage.Utility.SceneManager;
import car_rental_book_and_manage.Utility.SceneManager.Scenes;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class LoginController extends Controller{

  public void initialize() {
    SceneManager.setController(Scenes.LOGIN, this);
  }

  @FXML private Button loginBtn;

  @FXML
  void onLogIn(MouseEvent event) {
    App.setUi(Scenes.ADMIN);
  }
}
