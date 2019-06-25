package model.person;

import lombok.Getter;
import lombok.Setter;
import model.hotel.Location;

import java.io.Serializable;
@Getter
@Setter
public abstract class Person implements Serializable {

    private String firstName;
    private String lastName;
    protected Location location;
    protected Gender gender;

    protected Person() {
    }

    public abstract void setLocation(Location location);

    public abstract void setGender(Gender gender);

    public abstract String getAddress();

    protected Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Person(String firstName, String lastName, Location location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
    }

}
