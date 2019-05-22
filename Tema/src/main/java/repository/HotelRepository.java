package repository;

import model.hotel.Hotel;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
public class HotelRepository implements IHotelRepository, Search {

    private static Logger logger = Logger.getLogger(HotelRepository.class);
    private List<Hotel> hotelList = new ArrayList<>();

    /**
     * {@inheritDoc}
     *
     * @param hotel
     * @return a boolean if a hotel is added
     */
    @Override
    public boolean add(Hotel hotel) {
        hotelList.add(hotel);
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @param hotel
     * @return a boolean if a hotel is removed
     */
    @Override
    public boolean remove(Hotel hotel) {
        hotelList.remove(hotel);
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @return the list of hotels
     */
    @Override
    public List<Hotel> listHotels() {
        return hotelList;
    }

    @Override
    public void getHotelByCity(String citySearch) {

        for (Hotel hotel1 : hotelList) {

            if (hotel1.location.getCity().equals(citySearch)) {
                logger.debug(hotel1.getName());
            } else {
                logger.debug("NO HOTEL AVAILABLE IN THIS CITY");
            }

        }

    }
}
