package model.hotel;

public class Location {

    private String street;
    private int number;
    private String city;


    public Location(String street, int number, String city) {
        this.street = street;
        this.number = number;
        this.city = city;

    }

    public int getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }


}
