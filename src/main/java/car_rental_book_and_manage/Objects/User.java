package car_rental_book_and_manage.Objects;

public class User {

    protected String username,password,firstName;

    public User(String username,String password,String firstName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }



}
