package Tema1.Person;

import Tema1.Hotel.Location;

class Person extends Location {

    private String firstName;
    private String lastName;


    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
