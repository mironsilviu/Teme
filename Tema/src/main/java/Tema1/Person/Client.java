package Tema1.Person;

import Tema1.Hotel.Location;

public class Client extends Person {

    private String userName;
    private String password;

    public Client(String firstName, String lastName, String userName, String password) {
        super(firstName, lastName);
        this.userName = userName;
        this.password = password;

    }

    public Client(String firstName, String lastName, String userName, String password, Location addLocation) {
        super(firstName, lastName, addLocation);
        this.userName = userName;
        this.password = password;
    }

    @Override
    public void setLocation(Location location) {
        Person.location = location;
    }

    @Override
    public String toString() {
        return "Name: " + getFirstName() + " " + getLastName();
    }
}
