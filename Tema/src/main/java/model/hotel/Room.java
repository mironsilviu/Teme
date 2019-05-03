package model.hotel;

import org.apache.log4j.Logger;

public class Room {

    private int numberOfDoubleRoom;
    private int numberOfTripleRoom;
    private static final int NUMBER_OF_PERSON_IN_A_DOUBLE_ROOM = 2;
    private static final int NUMBER_OF_PERSON_IN_A_TRIPLE_ROOM = 3;
    private static Logger logger = Logger.getLogger(Room.class);

    public Room(int numberOfDoubleRoom, int numberOfTripleRoom) {
        if (numberOfDoubleRoom < 1 && numberOfTripleRoom < 1) {
            logger.debug("Shoud enter at least one room");
        } else {
            this.numberOfTripleRoom = numberOfTripleRoom;
            this.numberOfDoubleRoom = numberOfDoubleRoom;
        }
    }

    private int getMaxPeopleInDoubleRooms() {
        return numberOfDoubleRoom * NUMBER_OF_PERSON_IN_A_DOUBLE_ROOM;
    }

    private int getMaxPeopleinTripleRooms() {
        return numberOfTripleRoom * NUMBER_OF_PERSON_IN_A_TRIPLE_ROOM;
    }

    int capacity = getMaxPeopleInDoubleRooms() + getMaxPeopleinTripleRooms();

    public int getNumberOfDoubleRoom() {
        return numberOfDoubleRoom;
    }

    public int getNumberOfTripleRoom() {
        return numberOfTripleRoom;
    }
}
