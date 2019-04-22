package repository;

import model.hotel.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelRepository implements IHotelRepository {

    private List<Hotel> hotels = new ArrayList<>();

    @Override
     public boolean add(Hotel hotel) {
        hotels.add(hotel);
        return true;
    }

    @Override
    public boolean remove(Hotel hotel) {
        hotels.remove(hotel);
        return true;
    }

    @Override
    public List<Hotel> listHotels() {
        return hotels;
    }
}
