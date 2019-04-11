package Tema1.Person;

import Tema1.Hotel.Location;


abstract class Person {

    private String firstName;
    private String lastName;
    static Location location;

    abstract public void setLocation(Location location);

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Person(String firstName, String lastName, Location location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }


}
