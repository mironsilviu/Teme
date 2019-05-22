package model.person;

import lombok.Getter;
import model.hotel.Location;

import java.util.Objects;


public class Client extends Person {

    private long cnp;
    private static final long serialVersionUID = 1L;

    @Getter
    private final String password;

    public Client(String firstName, String lastName, long cnp, String password) {
        super(firstName, lastName);
        this.cnp = cnp;
        this.password = password;

    }

    public Client(String firstName, String lastName, long cnp, String password, Location addLocation) {
        super(firstName, lastName, addLocation);
        this.cnp = cnp;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return cnp == client.cnp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnp);
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
