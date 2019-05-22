package repository;

import model.hotel.Hotel;

import java.util.List;

/**
 * The Hotel Repository help us to add, remove to the list of hotels and check the list of hotels
 */
public interface IHotelRepository {
    /**
     * this method help us to add a hotel to the list of hotels
     */
    boolean add(Hotel hotel);

    /**
     * this method help us to remove a hotel from the list of hotels
     */
    boolean remove(Hotel hotel);

    /**
     * this method help us to get the list of hotels
     */
    List<Hotel> listHotels();

}
