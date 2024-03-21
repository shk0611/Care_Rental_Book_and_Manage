package car_rental_book_and_manage.Objects;

import java.util.List;

public interface ClientDAO {

    public void save(Client client);

    public void update(Client client);

    public void delete(Client client);

    public Client get(String name);

    public List<Client> retrieveAllClients();



    
}
