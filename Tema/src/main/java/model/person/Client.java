package model.person;

import lombok.Getter;
import model.hotel.Location;

import java.io.Serializable;

public class Client extends Person implements Serializable {

    private String userName;
    private static final String serialVersionUID = "UTF-8";

    @Getter
    private String password;

    public Client() {

    }

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
    public void setGender(Gender gender) {
        super.gender = gender;
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
