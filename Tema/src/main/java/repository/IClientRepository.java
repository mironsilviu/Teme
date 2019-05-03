package repository;

import model.person.Client;

import java.util.List;

public interface IClientRepository {

    void add(Client client);

    void remove(Client client);

    List<Client> listClient();

}
