package Tema1.Hotel;

public class Room extends Hotel{
    private int numberOfDoubleRoom;
    private int numberOfTripleRoom;
    private final int numberOfPersonInADoubleRoom = 2;
    private final int numberOfPersonTripleRoom = 3;


    public Room(String name, int numberOfStars, int numberOfDoubleRoom, int numberOfTripleRoom) {
        super(name, numberOfStars);
        this.numberOfTripleRoom = numberOfTripleRoom;
        this.numberOfDoubleRoom = numberOfDoubleRoom;
    }

    private int doubleRoom() {
        return numberOfDoubleRoom * numberOfPersonInADoubleRoom;
    }

    private int tripleRoom() {
        return numberOfTripleRoom * numberOfPersonTripleRoom;
    }

    int capacity = doubleRoom() + tripleRoom();


}
