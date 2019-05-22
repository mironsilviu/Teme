package repository;

import model.hotel.Room;
import model.hotel.TypeOfRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoomRepositoryTest {
    private RoomRepository roomRepository;

    @BeforeEach
    public void setup() {
        roomRepository = new RoomRepository();
    }

    @Test
    public void should_addRoom() {
        Room room = new Room("Single Room", TypeOfRoom.SINGLE_ROOM);
        roomRepository.addRoom(room);
    }

    @Test
    public void should_removeRoom() {
        Room room = new Room("Single Room", TypeOfRoom.SINGLE_ROOM);
        roomRepository.addRoom(room);
        roomRepository.removeRoom(0);
    }

    @Disabled
    @Test
    public void emptyList_RemoveRoom() {
        Room room = new Room("Single Room", TypeOfRoom.SINGLE_ROOM);

        roomRepository.removeRoom(0);
    }

    @Test()
    public void emptyList_RemoveRoomException() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    Room room = new Room("Single Room", TypeOfRoom.SINGLE_ROOM);
                    roomRepository.removeRoom(0);
                });
    }

    @Test
    public void should_getList() {
        Room room = new Room("Single Room", TypeOfRoom.SINGLE_ROOM);
        roomRepository.listRooms();
    }

}
