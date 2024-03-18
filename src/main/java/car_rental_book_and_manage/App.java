package car_rental_book_and_manage;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import car_rental_book_and_manage.Controllers.Controller;
import car_rental_book_and_manage.Utility.SceneManager;
import car_rental_book_and_manage.Utility.SceneManager.Scenes;

/** JavaFX App */
public class App extends Application {

    private static Scene scene;

  @Override
  public void start(Stage stage) throws IOException {
    SceneManager.addController(SceneManager.Scenes.LOGIN, null);
    SceneManager.addUi(SceneManager.Scenes.LOGIN, loadFXML("login"));

    SceneManager.addController(SceneManager.Scenes.HI, null);
    SceneManager.addUi(SceneManager.Scenes.HI, loadFXML("hi"));
    
    
    Parent root = SceneManager.getUiRoot(Scenes.LOGIN);

    scene = new Scene(root, 900, 600);
    stage.setScene(scene);
    stage.setResizable(false);
    stage.show();
    root.requestFocus();


  }

  static void setRoot(String fxml) throws IOException {
    scene.setRoot(loadFXML(fxml));
  }

  /**
   * Change the scene to the input scene using the scenemanager map of scenes.
   *
   * @param newUi - The scene to change to.
   */
  public static void setUi(Scenes newUi) {

    scene.setRoot(SceneManager.getUiRoot(newUi));
    SceneManager.setActiveController(SceneManager.getController(newUi));

  }

  private static Parent loadFXML(String fxml) throws IOException {
    return new FXMLLoader(App.class.getResource("/fxml/" + fxml + ".fxml")).load();
  }

  public static void main(String[] args) {
    launch();
  }
}
