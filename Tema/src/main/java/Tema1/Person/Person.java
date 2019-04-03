package Tema1.Person;

import Tema1.Hotel.Location;

public class Person extends Location {

    String firstName;
    String lastName;


    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
