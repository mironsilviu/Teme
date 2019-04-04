package Tema1.Person;

import Tema1.Hotel.Location;

public class Employee extends Person {

    private String pozition;
    private int salary;

    public Employee(String firstName, String lastName, String pozition, int salary) {
        super(firstName, lastName);
        this.pozition = pozition;
        this.salary = salary;

    }

    @Override
    public void setLocation(Location location) {
        super.setLocation(location);
    }
}
