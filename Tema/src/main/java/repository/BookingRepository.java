package repository;

import model.hotel.BookingDetails;

import java.util.concurrent.ConcurrentLinkedQueue;

public class BookingRepository {
    static ConcurrentLinkedQueue<BookingDetails> bookingDetailsQueue = new ConcurrentLinkedQueue<>();

    public void add(BookingDetails bookingDetails){
        bookingDetailsQueue.add(bookingDetails);
    }
    public void remove(BookingDetails bookingDetails){
        bookingDetailsQueue.remove(bookingDetails);
    }
    public ConcurrentLinkedQueue<BookingDetails> getBookingDetailsQueue(){
        return bookingDetailsQueue;
    }
}
