package repository;

import model.hotel.Location;
import model.person.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class ClientRepositoryTest {

    private ClientRepository clientRepository;

    @BeforeEach
    public void setup(){
        clientRepository = new ClientRepository();
    }
    @Test
    public void should_AddClient_ForValidData(){
        Client client = new Client("aa", "bb", 89,
                "ddddd", new Location("qqqqq", 5, "Cluj"));

        clientRepository.add(client);

    }


}
