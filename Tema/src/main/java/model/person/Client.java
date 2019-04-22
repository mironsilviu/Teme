package model.person;

import model.hotel.Location;

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
    public final void setLocation(Location location) {
        super.location = location;
    }

    @Override
    public String getAddress() {
        return "Street " + location.getStreet() + ", number " + location.getNumber() + ", City " + location.getCity();
    }

    @Override
    public String toString() {
        return "Name: " + getFirstName() + " " + getLastName();
    }
}
