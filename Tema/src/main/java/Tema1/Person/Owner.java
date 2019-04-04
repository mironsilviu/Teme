package Tema1.Person;

import Tema1.Hotel.Location;

public class Owner extends Person {


    public Owner(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void setLocation(Location location) {
        super.setLocation(location);
    }
}
