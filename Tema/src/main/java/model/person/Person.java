package model.person;

import model.hotel.Location;


public abstract class Person {

    private String firstName;
    private String lastName;
    protected Location location;
    protected Gender gender;

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

    protected String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
