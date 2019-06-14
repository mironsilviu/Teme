import booking.BookingThread;
import booking.HotelStatisticsThread;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import model.hotel.*;
import model.person.Client;
import model.person.Employee;
import model.person.Gender;
import model.person.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import java.lang.reflect.Array;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException, ParseException {


        Client client1 = new Client("Silviu", "Miron", 189072538, "qwerty");
        Client client2 = new Client("Alexandru", "Popovici", 189072538,
                "12345678", new Location("Mihai Viteazu", 4, "Sibiu"));
        client1.setLocation(new Location("Eremia Grigorescu", 126, "Cluj"));
        client1.setGender(Gender.MALE);
        Client client3 = new Client("djnas", "sdasmm", 17623851, "aaaaa");

        Location client3Location = new Location.LocationBuilder()
                .city("Cluj")
                .number(5)
                .street("djahs")
                .build();
        client3.setLocation(client3Location);

        Hotel hilton = new Hotel("Hilton", new Location("Memo", 5, "Cluj"));
        Room hiltonSingleRoom = new Room("Single Room", TypeOfRoom.SINGLE_ROOM);
        Room hiltonDoubleRoom = new Room("Double Room", TypeOfRoom.DOUBLE_ROOM);
        Hotel magnolia = new Hotel("Magnolia", new Location("Grigorescu", 10, "Cluj"));
        Room magnoliaSingleRoom = new Room("Single Room", TypeOfRoom.SINGLE_ROOM);

        LocalDateTime checkInDateClient1 = LocalDateTime.parse("2019-06-12T10:15:12");
        LocalDateTime checkInDateClient2 = LocalDateTime.parse("2019-07-25T13:12:25");
        LocalDateTime checkInDateClient3 = LocalDateTime.parse("2019-09-28T15:26:31");
        LocalDateTime checkOutDateClient1 = LocalDateTime.parse("2019-08-23T12:26:23");
        LocalDateTime checkOutDateClient2 = LocalDateTime.parse("2019-07-29T15:12:31");
        LocalDateTime checkOutDateClient3 = LocalDateTime.parse("2019-10-05T14:15:15");

        BookingDetails bookingDetailsClient1 =new BookingDetails(hilton,client1,checkInDateClient1,checkOutDateClient1,5);
        BookingDetails bookingDetailsClient2 =new BookingDetails(magnolia,client2,checkInDateClient2,checkOutDateClient2,2);
        BookingDetails bookingDetailsClient3 =new BookingDetails(hilton,client3,checkInDateClient3,checkOutDateClient3,3);

        HotelStatisticsThread hotelStatisticsThread = new HotelStatisticsThread();
        LocalDate date = LocalDate.parse("2019-06-12");
        hotelStatisticsThread.startStatistics(date);

        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
        BookingThread bookingThreadClient1 = new BookingThread(bookingDetailsClient1);
        service.schedule(bookingThreadClient1, 6, TimeUnit.SECONDS);

        BookingThread bookingThreadClient2 = new BookingThread(bookingDetailsClient2);
        service.schedule(bookingThreadClient2, 10, TimeUnit.SECONDS);

        BookingThread bookingThreadClient3 = new BookingThread(bookingDetailsClient3);
        service.schedule(bookingThreadClient3, 15, TimeUnit.SECONDS);




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

        logger.info(hilton.toString());
        logger.info(client1.toString());
        logger.info(client2.getAddress());

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
//
//        Function.hashSetClient();
//        Function.orderList();
//        Function.hotelMap();

        List<? super Person> anyPerson = new ArrayList<>();

        anyPerson.add(employee1);
        anyPerson.add(client1);


        Integer max = Stream.of(15, 12, 31, 51, 87, 9)
                .max(Comparator.comparing(Integer::valueOf))
                .get();

        Integer min = Stream.of(15, 12, 31, 51, 87, 9)
                .min(Comparator.comparing(Integer::valueOf))
                .get();

        System.out.println(min);
        System.out.println(max);
    }

}
