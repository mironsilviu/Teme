package service;

import model.hotel.Hotel;
import model.hotel.Location;
import model.hotel.Room;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import repository.HotelRepository;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;


@RunWith(MockitoJUnitRunner.class)
public class HotelServiceTest {

    private HotelService hotelService;

    @Mock
    private HotelRepository hotelRepository;

    @Before
    public void setup() {
        hotelService = new HotelService(hotelRepository);
    }

    @Test
    public void should_ValidateAndAddHotel_ForValidData() {

        Hotel hotel = new Hotel("Magnolia", new Location("Grigorescu", 10, "Cluj"));
        hotel.setRoom(new Room(15, 20));

        doReturn(true).when(hotelRepository).add(any(Hotel.class));

        String response = hotelService.validateAndAddHotel(hotel);

        assertEquals("ADDED", response);


    }
    @Test(expected = NullPointerException.class)
    public void shouldNot_ValidateAndAddHotel_ForNullHotel(){

        Hotel hotel = null;

        assertNull(hotel.getName());

    }

    @Test
    public void shouldNot_ValidateAndAddHotel_ForNullRoom() {

        Hotel hotel = new Hotel("Magnolia", new Location("Grigorescu", 10, "Cluj"));


       // doReturn(false).when(hotelRepository).add(any(Hotel.class));

        String response = hotelService.validateAndAddHotel(hotel);

        assertEquals("SET NUMBER OF ROOM", response);


    }

    @Test
    public void shouldNot_ValidateAndAddHotel_ForNumberOfRoom0() {

        Hotel hotel = new Hotel("Magnolia", new Location("Grigorescu", 10, "Cluj"));
        hotel.setRoom(new Room(0, 0));

      //  doReturn(true).when(hotelRepository).add(any(Hotel.class));

        String response = hotelService.validateAndAddHotel(hotel);

        assertEquals("SHOULD HAVE AT LEAST ONE ROOM", response);


    }
}
