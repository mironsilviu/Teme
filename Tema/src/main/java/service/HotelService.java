package service;

import model.hotel.Hotel;
import org.apache.log4j.Logger;
import repository.HotelRepository;
import java.util.List;

/**
 * The Hotel Service Class help us to add or remove a hotel to the list and to check the list
 */

public class HotelService {
    private static Logger logger = Logger.getLogger(HotelService.class);
    HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    /**
     * This method will validate and add hotel to the list if the hotel is valid
     * @param hotel - the hotel that will be add to the list if all the condition are verified
     * @return
     */

    public String validateAndAddHotel(Hotel hotel) {
        try {
            hotel.getName();
        }catch (NullPointerException e){
            logger.debug("CREATE HOTEL FIRST",e);
        }
        if (hotel.getName().equals("")) {
            return "EMPTY STRING";
        }
        if (hotel.getName().length() < 3) {
            return "NAME TOO SHORT";
        }
        if (hotel.room == null) {
            return "SET NUMBER OF ROOM";
        }

        if (hotel.room.getNumberOfDoubleRoom() < 1 && hotel.room.getNumberOfTripleRoom() < 1) {
            return "SHOULD HAVE AT LEAST ONE ROOM";
        }
        boolean responsFromRepository = hotelRepository.add(hotel);
        if (responsFromRepository) {
            return "ADDED";
        }
        return "SOMETHIG WENT WRONG";
    }

    private final String removeHotelPassword = "qwerty";

    /**
     * This method will validate and remove hotel from the list if the password is valid
     * @param hotel  - the hotel that will be removed
     * @param validPassword - password used by the user
     * @return
     */

    public String validateAndRemoveHotel(Hotel hotel, String validPassword) {
        if (removeHotelPassword.equals(validPassword)) {
            hotelRepository.remove(hotel);
            return "REMOVED";
        } else {
            return "INVALID PASSWORD";
        }

    }

    /**
     * This will return the list of hotels
     */


    public List<Hotel> getHotels() {
        return hotelRepository.listHotels();
    }

}
