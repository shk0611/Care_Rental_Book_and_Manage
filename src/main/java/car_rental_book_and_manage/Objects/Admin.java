package car_rental_book_and_manage.Objects;

public class Admin extends User{

    private int adminId;

    public Admin( String username, String password, String firstName) {
        super(username, password, firstName);

    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int id) {
        this.adminId = id;
    }

    
    
}
