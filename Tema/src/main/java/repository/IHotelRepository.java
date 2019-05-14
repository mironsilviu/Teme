package repository;
import model.hotel.Hotel;
import java.util.List;

/**
 *  The Hotel Repository help us to add, remove to the list of hotels and check the list of hotels
 */

public interface IHotelRepository {

    boolean add(Hotel hotel);

    boolean remove(Hotel hotel);

    List<Hotel> listHotels();

}
