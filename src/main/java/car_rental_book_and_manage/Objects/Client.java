package car_rental_book_and_manage.Objects;

public class Client extends User{

    private int clientId;
    private int phoneNo;

    public Client(String username, String password, String firstName,int clientId,int phoneNo) {
        super(username, password, firstName);
        this.clientId = clientId;
        this.phoneNo = phoneNo;
    }

    public Client(String username, String password, String firstName) {
        super(username, password, firstName);
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

    
}
