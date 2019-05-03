package repository;

import model.hotel.Location;
import model.person.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClientRepositoryTest {

    private ClientRepository clientRepository;

    @Before
    public void setup(){
        clientRepository = new ClientRepository();
    }
    @Test
    public void should_AddClient_ForValidData(){
        Client client = new Client("aa", "bb", "ccccc",
                "ddddd", new Location("qqqqq", 5, "Cluj"));

        clientRepository.add(client);

    }


}
