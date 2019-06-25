package model.hotel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * This class will help us to set a hotel with all the details that a hotel need in order to be added to the list of hotels
 */

public class Hotel implements Serializable {

    @Getter
    private final String name;
    @Setter
    private int numberOfStars;
    @Setter
    @Getter
    private List<Room> rooms = new ArrayList<>();
    @Getter
    private UUID uuid = UUID.randomUUID();
    public final Location location;
    //   private static final long serialVersionUID = 1L;

    public Hotel(String name, Location location) {
        this.location = location;
        this.name = name;
    }

    @Override
    public String toString() {
        return "hotel: " + name + ", City " + location.getCity() + ", Street " + location.getStreet();
    }


}
