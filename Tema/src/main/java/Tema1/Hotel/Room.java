package Tema1.Hotel;

public class Room {

    private int numberOfDoubleRoom;
    private int numberOfTripleRoom;
    private static final int numberOfPersonInADoubleRoom = 2;
    private static final int numberOfPersonTripleRoom = 3;

    public Room(int numberOfDoubleRoom, int numberOfTripleRoom) {
        if (numberOfDoubleRoom < 1 || numberOfTripleRoom < 1) {
            System.out.println("Valoarea nu poate fii mai mica de 1");
        } else {
            this.numberOfTripleRoom = numberOfTripleRoom;
            this.numberOfDoubleRoom = numberOfDoubleRoom;
        }
    }

    private int doubleRoom() {
        return numberOfDoubleRoom * numberOfPersonInADoubleRoom;
    }

    private int tripleRoom() {
        return numberOfTripleRoom * numberOfPersonTripleRoom;
    }

    int capacity = doubleRoom() + tripleRoom();

    public int getNumberOfDoubleRoom() {
        return numberOfDoubleRoom;
    }

    public int getNumberOfTripleRoom() {
        return numberOfTripleRoom;
    }
}
