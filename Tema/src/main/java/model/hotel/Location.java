package model.hotel;

import lombok.Getter;


@Getter
public class Location {

    private String street;

    private int number;

    private String city;


    public Location(String street, int number, String city) {
        this.street = street;
        this.number = number;
        this.city = city;

    }



}
