package car_rental_book_and_manage.Controllers;

import car_rental_book_and_manage.Utility.SceneManager;
import car_rental_book_and_manage.Utility.SceneManager.Scenes;

public class AdminController extends Controller{

      public void initialize() {
    SceneManager.setController(Scenes.ADMIN, this);
  }
    
}
