package service;

import model.hotel.Hotel;
import model.hotel.Location;
import model.hotel.Room;
import model.hotel.TypeOfRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.HotelRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)

public class HotelServiceTest {

    private HotelService hotelService;

    @Mock
    private HotelRepository hotelRepository;

    @BeforeEach
    public void setup() {
        hotelService = new HotelService(hotelRepository);
    }

    @Test
    public void should_ValidateAndAddHotel_ForValidData() {

        Hotel hotel = new Hotel("Magnolia", new Location("Grigorescu", 10, "Cluj"));
        Room hiltonSingleRoom = new Room("Single Room", TypeOfRoom.SINGLE_ROOM);
        List<Room> room = new ArrayList<>();
        room.add(hiltonSingleRoom);
        hotel.setRooms(room);

        doReturn(true).when(hotelRepository).add(any(Hotel.class));

        String response = hotelService.validateAndAddHotel(hotel);

        assertEquals("ADDED", response);
    }

    @Test
    public void shouldNot_ValidateAndAddHotel_ForNullRoom() {

        Hotel hotel = new Hotel("Magnolia", new Location("Grigorescu", 10, "Cluj"));

        String response = hotelService.validateAndAddHotel(hotel);

        assertEquals("SET ROOM FIRST", response);
    }

}
