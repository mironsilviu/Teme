package repository;

import model.person.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements IClientRepository {

    private List<Client> clientList = new ArrayList<>();

    @Override
    public void add(Client client) {
        clientList.add(client);
    }

    @Override
    public void remove(Client client) {
        clientList.remove(client);
    }

    @Override
    public List<Client> listClient() {
        return clientList;
    }
}
