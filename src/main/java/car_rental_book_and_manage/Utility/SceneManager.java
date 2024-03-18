package car_rental_book_and_manage.Utility;

import car_rental_book_and_manage.Controllers.Controller;
import java.util.HashMap;
import javafx.scene.Parent;

public class SceneManager {

  /** All the different Scenes in the system. */
  public enum Scenes {
    LOGIN,
    CLIENT,
    ADMIN
  }


  private static Controller activeController;
  private static HashMap<Scenes, Controller> controllerMap = new HashMap<>();
  private static HashMap<Scenes, Parent> sceneMap = new HashMap<>();

  /**
   * Add a scene to the scene map.
   *
   * @param appUi - The scene to add
   * @param uiRoot - The loaded scene
   */
  public static void addUi(Scenes appUi, Parent uiRoot) {
    sceneMap.put(appUi, uiRoot);
  }

  /**
   * Get a scene from the scene map and set the active controller.
   *
   * @param appUi - The scene to get
   * @return - The loaded scene
   */
  public static Parent getUiRoot(Scenes appUi) {
    activeController = controllerMap.get(appUi);
    return sceneMap.get(appUi);
  }

  /**
   * Set the currently active controller.
   *
   * @param controller - The controller to set as active
   */
  public static void setActiveController(Controller controller) {
    activeController = controller;
  }

  /**
   * Get the currently active controller.
   *
   * @return - The active controller
   */
  public static Controller getActiveController() {
    return activeController;
  }

  /**
   * Add a controller to the controller map.
   *
   * @param appUi - The scene of the controller
   * @param controller - The controller to add
   */
  public static void addController(Scenes appUi, Controller controller) {
    controllerMap.put(appUi, controller);
  }

  /**
   * Get a controller from the controller map.
   *
   * @param appUi - The scene of the controller
   * @return - The controller
   */
  public static Controller getController(Scenes appUi) {
    return controllerMap.get(appUi);
  }

    /**
   * Replace a controller in the controller map.
   *
   * @param appUi - The scene of the controller
   * @param controller - The new controller
   */
  public static void setController(Scenes appUi, Controller controller) {
    controllerMap.replace(appUi, controller);
  }



}
