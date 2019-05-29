package model.hotel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
@NoArgsConstructor
public class Location implements Serializable {

    private String street;

    private int number;

    private String city;

    public Location(String street, int number, String city) {
        this.street = street;
        this.number = number;
        this.city = city;

    }

    public static class LocationBuilder {
        private int number;
        private String street;
        private String city;

        public LocationBuilder number(int number) {
            this.number = number;
            return this;
        }

        public LocationBuilder street(String street) {
            this.street = street;
            return this;
        }

        public LocationBuilder city(String city) {
            this.city = city;
            return this;
        }


        public Location build() {

            Location location = new Location();
            location.setNumber(this.number);
            location.setStreet(this.street);
            location.setCity(this.city);

            return location;
        }
    }
}