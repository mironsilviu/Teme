package model.person;


import model.hotel.Hotel;
import model.hotel.Location;

public class Employee extends Person {

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

//    public void setWorkDetails(Hotel hotel) {
//        this.workDetails = hotel;
//    }
}
