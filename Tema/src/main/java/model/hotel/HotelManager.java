package model.hotel;

import model.person.Gender;
import model.person.Person;

public class HotelManager extends Person {


    @Override
    public final void setLocation(Location location) {
        super.location = location;
    }

    @Override
    public void setGender(Gender gender) {
        super.gender = gender;
    }

    @Override
    public String toString() {
        return "Name: " + getFirstName() + " " + getLastName();
    }

    @Override
    public String getAddress() {
        return "Street " + location.getStreet() + ", number " + location.getNumber() + ", City " + location.getCity();
    }

    public HotelManager(String firstName, String lastName) {
        super(firstName, lastName);
    }

}
