module car_rental_book_and_manage {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive java.sql; 

    opens car_rental_book_and_manage to javafx.fxml;
    opens car_rental_book_and_manage.Controllers to javafx.fxml;
    exports car_rental_book_and_manage;
    exports car_rental_book_and_manage.Controllers;
    exports car_rental_book_and_manage.Utility;
    exports car_rental_book_and_manage.Objects;

    //exports car_rental_book_and_manage.Objects;
}
