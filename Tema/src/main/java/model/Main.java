package model;

import model.hotel.Hotel;
import model.hotel.Location;
import model.hotel.Room;
import model.person.Client;
import repository.HotelRepository;
import service.HotelService;

public class Main {


    public static void main(String[] args) {

        Client client1 = new Client("Silviu", "Miron", "SilviuMiron", "qwerty");
        Client client2 = new Client("Alexandru", "Popovici", "AlexPopovici", "12345678", new Location("Mihai Viteazu", 4, "Sibiu"));
        client1.setLocation(new Location("Eremia Grigorescu", 126, "Cluj"));

        Hotel hilton = new Hotel("Hilton", new Location("Memo", 5, "Cluj"));
        hilton.setRoom(new Room(15, 25));
        Hotel magnoloia = new Hotel("Magnolia", new Location("Grigorescu", 10, "Cluj"));
        magnoloia.setRoom(new Room(0, 0));


        System.out.println(hilton.toString());
        System.out.println(client1.toString());
        System.out.println(client2.getAddress());
        HotelRepository hotelRepository = new HotelRepository();
        HotelService hotelService = new HotelService(hotelRepository);

        hotelService.validateAndAddHotel(hilton);
        hotelService.validateAndAddHotel(magnoloia);

        for (Hotel hotel : hotelService.getHotels()){
            System.out.println(hotel.getName());
        }
        for (Hotel hotel : hotelService.getHotels()){
            System.out.println(hotel.getFreeRooms());
        }

//        System.out.println(magnoloia.getFreeRooms());
//        System.out.println(hilton.getFreeRooms());


    }
}
