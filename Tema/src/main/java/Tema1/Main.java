package Tema1;

import Tema1.Hotel.Hotel;
import Tema1.Hotel.Room;
import Tema1.Person.Client;

public class Main {

    public static void main(String[] args) {
        Client client1 = new Client();
client1.adress("balcescu", 4,"sibiu");
client1.setName("Alex","Miron");



Hotel hilton = new Room("Hilton", 5 , 15, 25);
hilton.adress("muzeu", 5, "cluj");



    }
}
