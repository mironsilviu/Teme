package model.person;

import lombok.Getter;
import model.hotel.Location;


public abstract class Person {
    @Getter
    private String firstName;
    @Getter
    private String lastName;
    protected Location location;
    protected Gender gender;

    public abstract void setLocation(Location location);

    public abstract void setGender(Gender gender);

    public abstract String getAddress();

    public Person (){

    }

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
