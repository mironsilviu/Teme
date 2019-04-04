package Tema1.Hotel;

public class Hotel {

    private String name;
    private int numberOfStars;
    private Room room;
    private Location location;


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
}
