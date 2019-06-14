package booking;

import model.hotel.BookingDetails;
import model.hotel.Hotel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.BookingRepository;
import service.BookingService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class HotelStatisticsThread extends Thread {

    private static Logger logger = LogManager.getLogger(HotelStatisticsThread.class);
    private Map<UUID, List<BookingDetails>> bookingDetailsMap = new HashMap<>();
    private Map<UUID, HotelStatistics> hotelStatisticsMap = new HashMap<>();
    private LocalDate dateToDisplayStatistics;

    @Override
    public void run() {
        while (true) {
            BookingRepository bookingRepository = new BookingRepository();
            BookingService bookingService = new BookingService(bookingRepository);
            ConcurrentLinkedQueue<BookingDetails> bookingDetailsQueue = bookingService.getBookingDetailsQueue();
            while (bookingDetailsQueue != null && !bookingDetailsQueue.isEmpty()) {
                BookingDetails bookingDetails = bookingDetailsQueue.poll();
                Hotel hotel = bookingDetails.getHotel();
                List<BookingDetails> bookingDetailsHotel = bookingDetailsMap.get(hotel.getUuid());
                if (bookingDetailsHotel == null) {
                    bookingDetailsHotel = new ArrayList<>();
                    bookingDetailsMap.put(hotel.getUuid(), bookingDetailsHotel);
                }
                bookingDetailsHotel.add(bookingDetails);
                HotelStatistics hotelStatistics = hotelStatisticsMap.get(hotel.getUuid());
                if (hotelStatistics == null) {
                    hotelStatistics = new HotelStatistics();
                    hotelStatistics.hotel = hotel;
                    hotelStatisticsMap.put(hotel.getUuid(), hotelStatistics);
                }
                hotelStatistics.addBooking(bookingDetails);

            }
            showStatisticsForDay(this.dateToDisplayStatistics);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public void startStatistics(LocalDate date) {
        this.dateToDisplayStatistics = date;
        start();
    }

    public void showStatisticsForDay(LocalDate date) {
        hotelStatisticsMap.forEach((key, value) -> {
            Hotel hotel = value.hotel;
            String hotelName = hotel.getName();
            int numberOfClientsForDate = value.numberOfClientsForDate(date);
            int numberOfClientsForDateBeforeTwelve = value.numberOfClientsForDateBeforeTwelve(date);
            logger.info("Hotel: " + hotelName + " has for: " + date + " a number of: "
                    + numberOfClientsForDate + " clients from which "
                    + numberOfClientsForDateBeforeTwelve + " arrived before twelve");
        });
    }

    public class HotelStatistics {
        private Hotel hotel;
        private Map<LocalDate, List<BookingDetails>> clients = new HashMap<>();

        public void addBooking(BookingDetails bookingDetails) {
            LocalDateTime checkInDateWithTime = bookingDetails.getCheckInDate();
            LocalDate checkInDate = checkInDateWithTime.toLocalDate();
            List<BookingDetails> bookingList = clients.get(checkInDate);
            if (bookingList == null) {
                bookingList = new ArrayList<>();
                clients.put(checkInDate, bookingList);
            }
            bookingList.add(bookingDetails);

        }

        public int numberOfClientsForDate(LocalDate localDate) {
            List<BookingDetails> bookingDetailsForDate = clients.get(localDate);
            int numberOfPersonForDate = 0;
            if (bookingDetailsForDate != null && !bookingDetailsForDate.isEmpty()) {
                numberOfPersonForDate = bookingDetailsForDate.stream()
                        .mapToInt(BookingDetails::getNumberOfPerson)
                        .sum();

            }
            return numberOfPersonForDate;
        }

        public int numberOfClientsForDateBeforeTwelve(LocalDate localDate) {
            LocalDateTime localDateTime = localDate.atTime(12, 0, 0);

            List<BookingDetails> bookingDetailsForDate = clients.get(localDate);
            int numberOfPersonForDateTime = 0;
            if (bookingDetailsForDate != null && !bookingDetailsForDate.isEmpty()) {
                numberOfPersonForDateTime = bookingDetailsForDate.stream()
                        .filter(e -> {
                            return localDateTime.isAfter(e.getCheckInDate());
                        })
                        .mapToInt(BookingDetails::getNumberOfPerson)
                        .sum();

            }
            return numberOfPersonForDateTime;
        }
    }
}
