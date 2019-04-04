package Tema1.Person;

import Tema1.Hotel.Location;

class Person {

    private String firstName;
    private String lastName;
    private Location location;

    public void setLocation(Location location) {
        this.location = location;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, Location location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
    }

}
