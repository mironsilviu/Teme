package model.hotel;

import lombok.Getter;

public enum TypeOfRoom {

    SINGLE_ROOM(1),
    DOUBLE_ROOM(2),
    TRIPLE_ROOM(3);
    @Getter
    private int personInARoom;

    TypeOfRoom(int personInARoom) {
        this.personInARoom = personInARoom;

    }

}
