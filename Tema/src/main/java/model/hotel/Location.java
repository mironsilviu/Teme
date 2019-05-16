package model.hotel;

import lombok.Getter;

import java.io.Serializable;


@Getter
public class Location implements Serializable {

    private String street;

    private int number;

    private String city;


    public Location(String street, int number, String city) {
        this.street = street;
        this.number = number;
        this.city = city;

    }



}
