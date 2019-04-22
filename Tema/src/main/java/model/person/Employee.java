package model.person;

import model.hotel.Location;

public class Employee extends Person {

    private String position;
    private int salary;

    public Employee(String firstName, String lastName, String position, int salary) {
        super(firstName, lastName);
        this.position = position;
        this.salary = salary;

    }

    @Override
    public final void setLocation(Location location) {
        super.location = location;
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
