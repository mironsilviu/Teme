package service;

import model.person.Client;
import repository.ClientRepository;
import service.exception.ValidationException;
import service.exception.ValidationExceptionMessage;

import java.util.List;

public class ClientService {
    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public String validateAndAddClient(Client client) throws ValidationException {

        if (client == null) {
            throw new ValidationException(ValidationExceptionMessage.NO_CLIENT);
        }
        if (client.getLastName().length() < 3) {
            throw new ValidationException(ValidationExceptionMessage.NAME_TOO_SHORT);
        }

        clientRepository.add(client);
        return "Registered";
    }


    public String validateAndRemoveClient(Client client, String validPassword) throws ValidationException {
        if (client.getPassword().equals(validPassword)) {
            clientRepository.remove(client);
            return "Fired";
        } else {
            throw new ValidationException(ValidationExceptionMessage.INVALID_PASSWORD);
        }

    }

    public List<Client> getClient() {
        return clientRepository.listClient();
    }

}
