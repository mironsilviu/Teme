package Tema1;

import Tema1.Hotel.Hotel;
import Tema1.Hotel.Location;
import Tema1.Hotel.Room;
import Tema1.Person.Client;

public class Main {


    public static void main(String[] args) {

        Client client1 = new Client("Silviu", "Miron", "SilviuMiron", "qwerty");
        Client client2 = new Client("Alexandru", "Popovici", "AlexPopovici", "12345678", new Location("Mihai Viteazu", 4, "Sibiu"));
        client1.setLocation(new Location("Eremia Grigorescu", 126, "Cluj"));

        Hotel hilton = new Hotel("Hilton", new Location("Memo", 5, "Cluj"));
        hilton.setRoom(new Room(15, 25));
        Hotel magnoloia = new Hotel("Magnolia", new Location("Grigorescu", 10, "Cluj"));
        magnoloia.setRoom(new Room(15, 20));


        System.out.println(hilton.toString());
        System.out.println(client1.toString());

        Hotel.addHotel(hilton);
        System.out.println(magnoloia.getFreeRooms());
        System.out.println(hilton.getFreeRooms());


    }
}
