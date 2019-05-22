package service;

import model.hotel.Location;
import model.person.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.ClientRepository;
import service.exception.ValidationException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;


@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @BeforeEach
    public void setup() {
        clientService = new ClientService(clientRepository);
    }

    @Test
    public void should_ValidateAndAddClient_ForValidData() {

        Client client = new Client("aaaaa", "bbbbb", 89,
                "ddddd", new Location("qqqqq", 5, "Cluj"));

        doNothing().when(clientRepository).add(any(Client.class));
        String response = null;
        try {
            response = clientService.validateAndAddClient(client);
        } catch (ValidationException e) {
            e.printStackTrace();
        }

        assertEquals("Registered", response);

    }

    @Test
    public void should_NotValidateAndAddClient_ForNullClient() {

        Client client = null;

        try {
            clientService.validateAndAddClient(client);
        } catch (ValidationException e) {
            assertEquals("An error has occured with the code : 1 with the message :Set client first", e.displayError());
        }

    }

    @Test
    public void should_NotValidateAndAddClient_NameTooShort() {

        Client client = new Client("aa", "bb", 89,
                "ddddd", new Location("qqqqq", 5, "Cluj"));

        try {
            clientService.validateAndAddClient(client);
        } catch (ValidationException e) {
            assertEquals("An error has occured with the code : 2 with the message :Name is too short", e.displayError());
        }

    }
}
