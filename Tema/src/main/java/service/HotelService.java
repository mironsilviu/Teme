package service;

import model.hotel.Hotel;
import repository.HotelRepository;

import java.util.List;

public class HotelService {
    HotelRepository hotelRepository;

   public HotelService(HotelRepository hotelRepository){
       this.hotelRepository = hotelRepository;
   }

    public String validateAndAddHotel(Hotel hotel) {
        if (hotel.getName().equals("")) {
            return "EMPTY STRING";
        }
        if (hotel.getName().length() < 3) {
            return "NAME TOO SHORT";
        }
        if (hotel.room == null){
            return "SET NUMBER OF ROOM";
        }
        if (hotel == null){
            return "CREATE HOTEL FIRST";
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
private static final String removeHotelPassword = "qwerty";
    public String validateAndRemoveHotel(Hotel hotel, String validPassword) {
        if (removeHotelPassword.equals(validPassword)) {
            hotelRepository.remove(hotel);
            return "REMOVED";
        } else {
            return "INVALID PASSWORD";
        }

    }
public List<Hotel> getHotels(){
        return hotelRepository.listHotels();
}

}
