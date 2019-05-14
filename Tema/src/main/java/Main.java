import model.hotel.Hotel;
import model.hotel.Location;
import model.hotel.Room;
import model.person.Client;
import model.person.Employee;
import model.person.Gender;
import org.apache.log4j.Logger;
import repository.ClientRepository;
import repository.EmployeeRepository;
import repository.HotelRepository;
import service.ClientService;
import service.EmployeeService;
import service.HotelService;
import service.exception.ValidationException;


import java.io.*;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException {


        Client client1 = new Client("Silviu", "Miron", "SilviuMiron", "qwerty");
        Client client2 = new Client("Alexandru", "Popovici", "AlexPopovici",
                "12345678", new Location("Mihai Viteazu", 4, "Sibiu"));
        client1.setLocation(new Location("Eremia Grigorescu", 126, "Cluj"));
        client1.setGender(Gender.MALE);

        Hotel hilton = new Hotel("Hilton", new Location("Memo", 5, "Cluj"));
        hilton.setRoom(new Room(15, 25));
        Hotel magnolia = new Hotel("Magnolia", new Location("Grigorescu", 10, "Cluj"));
        magnolia.setRoom(new Room(15, 20));

        Employee employee1 = new Employee(hilton, "Cristian", "Avram", "Reception", 1500);

        logger.info(hilton.toString());
        logger.info(client1.toString());
        logger.info(client2.getAddress());

        HotelRepository hotelRepository = new HotelRepository();
        HotelService hotelService = new HotelService(hotelRepository);

        hotelService.validateAndAddHotel(hilton);
        hotelService.validateAndAddHotel(magnolia);

        for (Hotel hotel : hotelService.getHotels()) {
            logger.info(hotel.getName());
            logger.info(hotel.getFreeRooms());
        }

        hotelRepository.getHotelByCity("Cluj");

        hotelRepository.getHotelByCity("Sibiu");


        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        // Employee employee2 = null;
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


        try (BufferedWriter employeeIO = new BufferedWriter(new FileWriter("Employee.txt"))) {
            String[] in = new String[3];
            in[0] = employee1.getFirstName();
            in[1] = employee1.getLastName();
            in[2] = employee1.getPosition();

            for (int i = 0; i < 3; i++) {
                employeeIO.write(in[i]);
                employeeIO.write(", ");
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }


        FileWriter clientIO = null;

        try {
            clientIO = new FileWriter("out.txt");

            String[] in = new String[3];
            in[0] = client1.getFirstName();
            in[1] = client1.getLastName();
            in[2] = client1.getPassword();

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

        //        try {
//            clientService.validateAndAddClient(client3);
//        } catch (ValidationException e) {
//            logger.error(e.displayError(),e);
//        }


//        try {
//            //  BufferedOutputStream f = new BufferedOutputStream(new FileOutputStream("Client.txt"));
//            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Client.txt"));
//
//
//            o.writeObject(client1);
//
//            o.flush();
//            o.close();
//            // f.close();
//
//            //  BufferedInputStream fi = new BufferedInputStream(new FileInputStream("Client.txt"));
//            ObjectInputStream oi = new ObjectInputStream(new FileInputStream("Client.txt"));
//
//
//            Client clientReturn1 = (Client) oi.readObject();
//
//            oi.close();
//
//            System.out.println(clientReturn1.toString());
//
//
//
//            // fi.close();
//
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        } catch (IOException e) {
//            System.out.println("Error initializing stream");
//        } catch (ClassNotFoundException e) {
//
//            e.printStackTrace();
//        }


    }
}
