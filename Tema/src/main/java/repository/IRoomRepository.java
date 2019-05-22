package repository;

import model.hotel.Room;

import java.util.List;

public interface IRoomRepository {
    void addRoom(Room room);

    void removeRoom(int index);

    List<Room> listRooms();
}
