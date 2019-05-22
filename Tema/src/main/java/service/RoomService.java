package service;

import model.hotel.Room;
import repository.RoomRepository;
import service.exception.ValidationException;
import service.exception.ValidationExceptionMessage;

import java.util.List;

public class RoomService {

    RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public String validateAndAddRoom(Room room, int numberOfRooms) throws ValidationException {

        if (room == null) {
            throw new ValidationException(ValidationExceptionMessage.NO_ROOM);
        }
        if (numberOfRooms < 1) {
            throw new ValidationException(ValidationExceptionMessage.NR_OF_ROOM);
        }

        for (int i = 0; i < numberOfRooms; i++) {
            roomRepository.addRoom(room);
        }
        return "Added";

    }

    public String validateAndRemoveRoom(Room room, int index) throws ValidationException {
        List<Room> roomList = getList();
        if (room == null) {
            throw new ValidationException(ValidationExceptionMessage.NO_ROOM);
        }
        if (room.getTypeOfRoom() != roomList.get(index).getTypeOfRoom()) {
            throw new ValidationException(ValidationExceptionMessage.WRONG_TYPE);
        }
        if (room.equals(roomList.get(index))) {
            roomRepository.removeRoom(index);
        }
        return "Removed";
    }


    public List<Room> getList() {
        return roomRepository.listRooms();
    }


}
