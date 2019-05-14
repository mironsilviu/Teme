package model.hotel;

import model.Function;

import java.io.Serializable;

/**
 * This class will help us to set a hotel with all the details that a hotel need in order to be added to the list of hotels
 */

public class Hotel implements Serializable {

    private final String name;
    private int numberOfStars;
    public Room room;
    public final Location location;
    private static final long serialVersionUID = 1L;

    public Hotel(String name, Location location) {
        this.location = location;
        this.name = name;
    }

    public void setNumberOfStars(int numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getFreeRooms() {

        int[] freeRooms = Function.freeRooms(this.room);
        return freeRooms.length;
    }


    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "hotel: " + name + ", City " + location.getCity() + ", Street " + location.getStreet();
    }

}
