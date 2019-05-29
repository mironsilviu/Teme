package model;

import model.hotel.Hotel;
import model.hotel.Location;
import model.hotel.Room;
import model.hotel.TypeOfRoom;
import model.person.Client;
import model.person.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Function {

    private static Logger logger = LogManager.getLogger(Function.class);

    public static void addClientToFile(Client client) throws IOException {
        FileWriter clientIO = null;

        try {
            clientIO = new FileWriter("out.txt");

            String[] in = new String[3];
            in[0] = client.getFirstName();
            in[1] = client.getLastName();
            in[2] = client.getPassword();

            for (int i = 0; i < 3; i++) {
                clientIO.write(in[i]);
                clientIO.write(", ");
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } finally {
            if (clientIO != null) {
                clientIO.close();
            }
        }
    }

    public static void addEmployeeToFile(Employee employee) throws IOException {
        try (BufferedWriter employeeIO = new BufferedWriter(new FileWriter("Employee.txt"))) {
            String[] in = new String[3];
            in[0] = employee.getFirstName();
            in[1] = employee.getLastName();
            in[2] = employee.getPosition();

            for (int i = 0; i < 3; i++) {
                employeeIO.write(in[i]);
                employeeIO.write(", ");
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }


    public static void addClientToSerializedFile(Client client) {

        try {

            FileOutputStream f = new FileOutputStream("Client.obj");
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(client);

            o.flush();
            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            logger.info("File not found");
        } catch (IOException e) {
            logger.info("Error initializing stream");
        }
    }

    public static void readClientFromSerializedFile() {

        try {

            FileInputStream fi = new FileInputStream("Client.obj");
            ObjectInputStream oi = new ObjectInputStream(fi);

            Client clientReturn1 = (Client) oi.readObject();

            oi.close();
            fi.close();

            System.out.println(clientReturn1.toString());

        } catch (FileNotFoundException e) {
            logger.info("File not found");
        } catch (IOException e) {
            logger.info("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void hashSetClient() {
        HashSet<Client> clientHashSet = new HashSet<>();

        Client client1 = new Client("Silviu", "Miron", 189072538, "qwerty");
        Client client2 = new Client("Alexandru", "Popovici", 189072538, "12345678");
        Client client3 = new Client("Andrei", "Miron", 189472538, "qwerty");
        Client client4 = new Client("Vlad", "Miron", 189075538, "qwerty");
        Client client5 = new Client("Alex", "Miron", 189072578, "qwerty");
        Client client6 = new Client("Cristi", "Miron", 129072538, "qwerty");
        Client client7 = new Client("Vio", "Miron", 184072538, "qwerty");
        Client client8 = new Client("Andreea", "Miron", 186072538, "qwerty");
        Client client9 = new Client("Claudiu", "Miron", 189092538, "qwerty");
        Client client10 = new Client("Diana", "Miron", 199072538, "qwerty");
        Client client11 = new Client("Alexandra", "Miron", 189074538, "qwerty");
        Client client12 = new Client("Ioana", "Miron", 189074538, "qwerty");
        Client client13 = new Client("Tibi", "Miron", 189372538, "qwerty");
        Client client14 = new Client("Alexandru", "Miron", 119072538, "qwerty");
        Client client15 = new Client("Petre", "Miron", 119072538, "qwerty");
        Client client16 = new Client("Claudia", "Miron", 189012138, "qwerty");
        Client client17 = new Client("Mihaela", "Miron", 189072531, "qwerty");
        Client client18 = new Client("Elena", "Miron", 189072534, "qwerty");
        Client client19 = new Client("Vetuta", "Miron", 189072536, "qwerty");
        Client client20 = new Client("Lucian", "Miron", 189072539, "qwerty");


        clientHashSet.add(client1);
        clientHashSet.add(client2);
        clientHashSet.add(client3);
        clientHashSet.add(client4);
        clientHashSet.add(client5);
        clientHashSet.add(client6);
        clientHashSet.add(client7);
        clientHashSet.add(client8);
        clientHashSet.add(client9);
        clientHashSet.add(client10);
        clientHashSet.add(client11);
        clientHashSet.add(client12);
        clientHashSet.add(client13);
        clientHashSet.add(client14);
        clientHashSet.add(client15);
        clientHashSet.add(client16);
        clientHashSet.add(client17);
        clientHashSet.add(client18);
        clientHashSet.add(client19);
        clientHashSet.add(client20);

        logger.info(clientHashSet.size());
    }

    public static void orderList() {
        List<Room> roomOrderdList = new ArrayList<>();

        Room hiltonSingleRoom = new Room("Single Room", TypeOfRoom.SINGLE_ROOM);
        Room hiltonDoubleRoom = new Room("Double Room", TypeOfRoom.DOUBLE_ROOM);
        Room magnoliaSingleRoom = new Room("Single Room", TypeOfRoom.SINGLE_ROOM);
        Room magnoliaDoubleRoom = new Room("Double Room", TypeOfRoom.DOUBLE_ROOM);
        Room magnoliaTripleRoom = new Room("Triple Room", TypeOfRoom.TRIPLE_ROOM);
        Room magnoliaKingRoom = new Room("Kingsize Double Room", TypeOfRoom.DOUBLE_ROOM);
        Room magnoliaApartmentRoom = new Room("Double Room Apartment", TypeOfRoom.DOUBLE_ROOM);
        Room grandDoubleRoom = new Room("Double Room", TypeOfRoom.DOUBLE_ROOM);
        Room grandSuiteRoom = new Room("Suite Double Room", TypeOfRoom.DOUBLE_ROOM);
        Room magnoliaSuiteRoom = new Room("Suite Double Room", TypeOfRoom.DOUBLE_ROOM);

        roomOrderdList.add(hiltonDoubleRoom);
        roomOrderdList.add(hiltonSingleRoom);
        roomOrderdList.add(magnoliaApartmentRoom);
        roomOrderdList.add(magnoliaDoubleRoom);
        roomOrderdList.add(magnoliaKingRoom);
        roomOrderdList.add(magnoliaSingleRoom);
        roomOrderdList.add(magnoliaSuiteRoom);
        roomOrderdList.add(magnoliaTripleRoom);
        roomOrderdList.add(grandDoubleRoom);
        roomOrderdList.add(grandSuiteRoom);

        Optional<Room> bigestRoom = roomOrderdList.stream()
                .reduce((room1, room2) ->
                        room1.getTypeOfRoom().getPersonInARoom() > room2.getTypeOfRoom().getPersonInARoom() ? room1 : room2);

        bigestRoom.ifPresent(room -> logger.info(room.getNameOfTheRoom()));

        Comparator<Room> sortByNameAscending = (Room room1, Room room2) -> room1.getNameOfTheRoom().compareTo(room2.getNameOfTheRoom());

        List<Room> roomStream = roomOrderdList.stream()
                .filter(room -> room.getNameOfTheRoom().contains("e"))
                .sorted(sortByNameAscending)
                .collect(Collectors.toList());
        roomStream.forEach(room -> logger.info(room.getNameOfTheRoom()));

        List<Room> roomSortedList = roomOrderdList;
        roomSortedList.sort(sortByNameAscending);
        logger.info("Ascending: ");
        roomSortedList.forEach(room -> logger.info(room.getNameOfTheRoom()));
        Comparator<Room> sortByNameDescending = (Room room1, Room room2) -> room2.getNameOfTheRoom().compareTo(room1.getNameOfTheRoom());
        roomSortedList.sort(sortByNameDescending);
        logger.info("Descending");
        roomSortedList.forEach(room -> logger.info(room.getNameOfTheRoom()));
    }

    public static void hotelMap() {
        HashMap<UUID, List<Room>> hotelMap = new HashMap<>();

        Hotel hilton = new Hotel("Hilton", new Location("Memo", 5, "Cluj"));
        Hotel magnolia = new Hotel("Magnolia", new Location("Grigorescu", 10, "Cluj"));
        Hotel grand = new Hotel("Grand", new Location("Bunaziua", 7, "Cluj"));

        List<Room> hiltonRooms = new ArrayList<>();
        List<Room> magnoliaRooms = new ArrayList<>();
        List<Room> grandRooms = new ArrayList<>();

        Room hiltonSingleRoom = new Room("Single Room", TypeOfRoom.SINGLE_ROOM);
        Room hiltonDoubleRoom = new Room("Double Room", TypeOfRoom.DOUBLE_ROOM);
        Room magnoliaSingleRoom = new Room("Single Room", TypeOfRoom.SINGLE_ROOM);
        Room magnoliaDoubleRoom = new Room("Double Room", TypeOfRoom.DOUBLE_ROOM);
        Room magnoliaTripleRoom = new Room("Triple Room", TypeOfRoom.TRIPLE_ROOM);
        Room magnoliaKingRoom = new Room("Kingsize Double Room", TypeOfRoom.DOUBLE_ROOM);
        Room magnoliaApartmentRoom = new Room("Double Room Apartment", TypeOfRoom.DOUBLE_ROOM);
        Room grandDoubleRoom = new Room("Double Room", TypeOfRoom.DOUBLE_ROOM);
        Room grandSuiteRoom = new Room("Suite Double Room", TypeOfRoom.DOUBLE_ROOM);
        Room magnoliaSuiteRoom = new Room("Suite Double Room", TypeOfRoom.DOUBLE_ROOM);

        hiltonRooms.add(hiltonDoubleRoom);
        hiltonRooms.add(hiltonSingleRoom);
        magnoliaRooms.add(magnoliaApartmentRoom);
        magnoliaRooms.add(magnoliaDoubleRoom);
        magnoliaRooms.add(magnoliaKingRoom);
        magnoliaRooms.add(magnoliaSingleRoom);
        magnoliaRooms.add(magnoliaTripleRoom);
        magnoliaRooms.add(magnoliaSuiteRoom);
        grandRooms.add(grandDoubleRoom);
        grandRooms.add(grandSuiteRoom);

        hotelMap.put(hilton.getUuid(), hiltonRooms);
        hotelMap.put(magnolia.getUuid(), magnoliaRooms);
        hotelMap.put(grand.getUuid(), grandRooms);

        logger.info(hotelMap);
    }
}
