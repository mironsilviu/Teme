import model.Function;
import model.hotel.Hotel;
import model.hotel.Location;
import model.hotel.Room;
import model.hotel.TypeOfRoom;
import model.person.Client;
import model.person.Employee;
import model.person.Gender;
import model.person.Person;
import org.apache.log4j.Logger;
import repository.ClientRepository;
import repository.EmployeeRepository;
import repository.HotelRepository;
import repository.RoomRepository;
import service.ClientService;
import service.EmployeeService;
import service.HotelService;
import service.RoomService;
import service.exception.ValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException {


        Client client1 = new Client("Silviu", "Miron", 189072538, "qwerty");
        Client client2 = new Client("Alexandru", "Popovici", 189072538,
                "12345678", new Location("Mihai Viteazu", 4, "Sibiu"));
        client1.setLocation(new Location("Eremia Grigorescu", 126, "Cluj"));
        client1.setGender(Gender.MALE);

        Hotel hilton = new Hotel("Hilton", new Location("Memo", 5, "Cluj"));
        Room hiltonSingleRoom = new Room("Single Room", TypeOfRoom.SINGLE_ROOM);
        Room hiltonDoubleRoom = new Room("Double Room", TypeOfRoom.DOUBLE_ROOM);
        Hotel magnolia = new Hotel("Magnolia", new Location("Grigorescu", 10, "Cluj"));
        Room magnoliaSingleRoom = new Room("Single Room", TypeOfRoom.SINGLE_ROOM);

        RoomRepository roomRepository = new RoomRepository();
        RoomService roomServiceHilton = new RoomService(roomRepository);
        try {
            roomServiceHilton.validateAndAddRoom(hiltonSingleRoom, 2);
        } catch (ValidationException e) {
            logger.error(e.displayError(), e);
        }
        try {
            roomServiceHilton.validateAndAddRoom(hiltonDoubleRoom, 2);
        } catch (ValidationException e) {
            logger.error(e.displayError(), e);
        }
        hilton.setRooms(roomServiceHilton.getList());
        Employee employee1 = new Employee(hilton, "Cristian", "Avram", "Reception", 1500);

//        logger.info(hilton.toString());
//        logger.info(client1.toString());
//        logger.info(client2.getAddress());

        HotelRepository hotelRepository = new HotelRepository();
        HotelService hotelService = new HotelService(hotelRepository);

        hotelService.validateAndAddHotel(hilton);
        //hotelService.validateAndAddHotel(magnolia);

//        for (Hotel hotel : hotelService.getHotels()) {
//            logger.info(hotel.getName());
//        }

        hotelRepository.getHotelByCity("Cluj");
        hotelRepository.getHotelByCity("Sibiu");

        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);

        try {
            employeeService.validateAndAddEmployee(employee1);
        } catch (ValidationException e) {
            logger.error(e.displayError(), e);
        }
        ClientRepository clientRepository = new ClientRepository();
        ClientService clientService = new ClientService(clientRepository);
        try {
            clientService.validateAndAddClient(client1);
        } catch (ValidationException e) {
            logger.error(e.displayError(), e);
        }
        try {
            clientService.validateAndAddClient(client2);
        } catch (ValidationException e) {
            logger.error(e.displayError(), e);
        }
        try {
            clientService.validateAndRemoveClient(client1, "qwerty");
        } catch (ValidationException e) {
            logger.error(e.displayError());
        }

//        Function.addEmployeeToFile(employee1);
//        Function.addClientToFile(client1);
//        Function.addClientToSerializedFile(client1);
//        Function.readClientFromSerializedFile();

        Function.hashSetClient();
        Function.orderList();
        Function.hotelMap();

        List<? super Person> anyPerson = new ArrayList<>();

        anyPerson.add(employee1);
        anyPerson.add(client1);

    }

}
