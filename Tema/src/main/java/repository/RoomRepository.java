package repository;

import model.hotel.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomRepository implements IRoomRepository {

    private List<Room> rooms = new ArrayList<>();

    @Override
    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public void removeRoom(int index) {
        rooms.remove(index);
    }

    @Override
    public List<Room> listRooms() {
        return rooms;
    }
}
