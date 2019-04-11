package Tema1.Hotel;


import Tema1.Function;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private final String name;
    private int numberOfStars;
    private Room room;
    private final Location location;


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


    @Override
    public String toString() {
        return "Hotel: " + name + ", City " + location.getCity() + ", Street " + location.getStreet();
    }

    private static final List<Hotel> hotelList = new ArrayList<>();

    public static void addHotel(Hotel hotel) {
        hotelList.add(hotel);
    }

    public static void removeHotel(Hotel hotel) {
        hotelList.remove(hotel);
    }

}
