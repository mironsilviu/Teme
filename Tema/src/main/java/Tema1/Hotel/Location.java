package Tema1.Hotel;

public class Location {

    private String street;
    private int number;
    private String city;


    public Location(String street, int number, String city) {
        this.street = street;
        this.number = number;
        this.city = city;

    }

    String getStreet() {
        return street;
    }

    String getCity() {
        return city;
    }


}
