package car_rental_book_and_manage.Objects;

public class Client{

    private String username,password,firstName;
    private int clientId;
    private int phoneNo;

    public Client() {
        
    }

    public Client(String username, String password, String firstName,int clientId,int phoneNo) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.clientId = clientId;
        this.phoneNo = phoneNo;
    }

    public Client(String username, String password, String firstName,int phoneNo) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.phoneNo = phoneNo;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int id) {
        this.clientId = id;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phone) {
        this.phoneNo = phone;
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
