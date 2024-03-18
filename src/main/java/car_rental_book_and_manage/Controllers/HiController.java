package car_rental_book_and_manage.Controllers;

import car_rental_book_and_manage.Utility.SceneManager;
import car_rental_book_and_manage.Utility.SceneManager.Scenes;

public class HiController extends Controller{
    
      public void initialize() {
    SceneManager.setController(Scenes.LOGIN, this);
  }
}
