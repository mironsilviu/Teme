package model.hotel;

import lombok.Getter;

@Getter
public class Room {

    private String nameOfTheRoom;
    private TypeOfRoom typeOfRoom;

    public Room(String nameOfTheRoom, TypeOfRoom typeOfRoom) {
        this.nameOfTheRoom = nameOfTheRoom;
        this.typeOfRoom = typeOfRoom;
    }

    @Override
    public String toString() {
        return "Room{" +
                "nameOfTheRoom='" + nameOfTheRoom + '\'' +
                ", typeOfRoom=" + typeOfRoom +
                '}';
    }
}
