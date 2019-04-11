package Tema1.Person;

        import Tema1.Hotel.Location;

public class HotelManager extends Person {


    @Override
    public final void setLocation(Location location) {
        Person.location = location;
    }

    public HotelManager(String firstName, String lastName) {
        super(firstName, lastName);
    }

}
