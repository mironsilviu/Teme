package repository;

import model.hotel.Hotel;

import java.util.List;

public interface IHotelRepository {

    boolean add(Hotel hotel);

    boolean remove(Hotel hotel);

    List<Hotel> listHotels();

}
