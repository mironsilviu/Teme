package service;

import model.hotel.BookingDetails;
import repository.BookingRepository;

import java.util.concurrent.ConcurrentLinkedQueue;

public class BookingService {
    BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    public void add(BookingDetails bookingDetails){

        bookingRepository.add(bookingDetails);

    }
    public void remove(BookingDetails bookingDetails){
        bookingRepository.remove(bookingDetails);
    }
    public ConcurrentLinkedQueue<BookingDetails> getBookingDetailsQueue(){

        return bookingRepository.getBookingDetailsQueue();

    }
}
