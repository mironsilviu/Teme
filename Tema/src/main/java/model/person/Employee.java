package model.person;


import lombok.Getter;
import model.hotel.Hotel;
import model.hotel.Location;

public class Employee extends Person {
@Getter
    private String position;
    private int salary;
    Hotel workDetails;


    @Deprecated
    public Employee(String firstName, String lastName, String position, int salary) {
        super(firstName, lastName);
        this.position = position;
        this.salary = salary;

    }
    public Employee(Hotel workDetails, String firstName, String lastName, String position, int salary) {
        super(firstName, lastName);
        this.position = position;
        this.salary = salary;
        this.workDetails = workDetails;

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
