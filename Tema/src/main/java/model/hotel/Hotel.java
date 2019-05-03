package model.hotel;

import model.Function;

public class Hotel {

    private final String name;
    private int numberOfStars;
    public Room room;
    public final Location location;




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
