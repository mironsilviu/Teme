package service;

import model.hotel.Room;
import model.hotel.TypeOfRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.RoomRepository;
import service.exception.ValidationException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
public class RoomServiceTest {
    RoomService roomService;

    @Mock
    private RoomRepository roomRepository;

    @BeforeEach
    public void setup() {
        roomService = new RoomService(roomRepository);
    }

    @Test
    public void should_ValidateAndAddRoom_ForValidData() {
        Room hiltonSingleRoom = new Room("Single Room", TypeOfRoom.SINGLE_ROOM);
        String response = null;
        try {
            response = roomService.validateAndAddRoom(hiltonSingleRoom, 2);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
        assertThat("Added", is(equalTo(response)));
    }
}
