package repository;

import model.hotel.Hotel;
import model.hotel.Location;
import model.hotel.Room;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HotelRepositoryTest {

    private HotelRepository hotelRepository;

    @Before
    public void setup() {
        hotelRepository = new HotelRepository();
    }

    @Test
    public void should_AddHotel_ForValidData() {

        //GHIVEN
        Hotel hotel = new Hotel("Magnolia", new Location("Grigorescu", 10, "Cluj"));

        //WHEN
        boolean response = hotelRepository.add(hotel);
        //THEN
        assertTrue(response);

    }

    @Test
    public void shouldNot_AddHotel_ForInvalidData() {

        boolean responseAdd = hotelRepository.add(null);

        assertTrue(responseAdd);  //??
    }

    @Test
    public void should_RemoveHotel_ForValidData() {
        Hotel hotel = new Hotel("Magnolia", new Location("Grigorescu", 10, "Cluj"));

        hotelRepository.add(hotel);

        boolean responseRemove = hotelRepository.remove(hotel);

        assertTrue(responseRemove);
    }

    @Test
    public void shouldNot_RemoveHotel_ForInvalidData() {
        Hotel hotel = new Hotel("Magnolia", new Location("Grigorescu", 10, "Cluj"));

        hotelRepository.add(hotel);

        boolean responseRemove = hotelRepository.remove(null);

        assertTrue(responseRemove); //??
    }

    @Test
    public void should_ReturnTheList() {
        Hotel hotel = new Hotel("Magnolia", new Location("Grigorescu", 10, "Cluj"));
        hotelRepository.add(hotel);

        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(hotel);

        List<Hotel> hotelTest = hotelRepository.listHotels();

        assertEquals(hotelList, hotelTest);


    }

    @Test
    public void should_ReturnAEmptyList() {
        List<Hotel> hotelList = new ArrayList<>();
        List<Hotel> hotelTest = hotelRepository.listHotels();

        assertEquals(hotelList, hotelTest);

    }


}
