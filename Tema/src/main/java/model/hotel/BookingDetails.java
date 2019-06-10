package model.hotel;

import lombok.Getter;
import model.person.Client;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class BookingDetails {

    private Hotel hotel;
    private Client client;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private int numberOfPerson;

    public BookingDetails(Hotel hotel, Client client, LocalDateTime checkInDate, LocalDateTime checkOutDate, int numberOfPerson) {
        this.hotel = hotel;
        this.client = client;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfPerson = numberOfPerson;
    }

    @Override
    public String toString() {
        return "BookingDetails{" +
                "hotel=" + hotel +
                ", client=" + client +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", numberOfPerson=" + numberOfPerson +
                '}';
    }
}
