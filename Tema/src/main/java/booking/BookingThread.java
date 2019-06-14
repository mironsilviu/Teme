package booking;

import model.hotel.BookingDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.BookingRepository;
import service.BookingService;


public class BookingThread extends Thread {

    private static Logger logger = LogManager.getLogger(BookingThread.class);
    BookingDetails bookingDetails;

    public BookingThread(BookingDetails bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    @Override
    public void run() {
        if (bookingDetails == null) {
            logger.error("Booking details is null");
            return;
        }
        if (bookingDetails.getCheckInDate().isAfter(bookingDetails.getCheckOutDate())) {
            logger.error("Check in date is after check out date: " + bookingDetails);
            return;
        }
        logger.info("Booking details received: {}", bookingDetails);
        BookingRepository bookingRepository = new BookingRepository();
        BookingService bookingService = new BookingService(bookingRepository);
        bookingService.add(bookingDetails);

    }
}
