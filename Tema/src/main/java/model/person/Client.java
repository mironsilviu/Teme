package model.person;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.hotel.Location;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Client extends Person {

    private long cnp;
    private static final long serialVersionUID = 1L;
    private boolean accommodated;
    private String password;
    private int personID;
    private String postingDate;

    public Client(int personID, String firstName, String lastName, int cnp, boolean accommodated, String postingDate) {
        super(firstName, lastName);
        this.personID = personID;
        this.cnp = cnp;
        this.accommodated = accommodated;
        this.postingDate = postingDate;
    }

    public Client(String firstName, String lastName, long cnp, String password) {
        super(firstName, lastName);
        this.cnp = cnp;
        this.password = password;

    }

    public Client(String firstName, String lastName, long cnp, String password, Location addLocation) {
        super(firstName, lastName, addLocation);
        this.cnp = cnp;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return cnp == client.cnp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnp);
    }

    @Override
    public final void setLocation(Location location) {
        super.location = location;
    }

    @Override
    public void setGender(Gender gender) {
        super.gender = gender;
    }

    @Override
    public String getAddress() {
        return "Street " + location.getStreet() + ", number " + location.getNumber() + ", City " + location.getCity();
    }

    @Override
    public String toString() {
        return "ID: " + personID + " Name: " + getFirstName() + " " + getLastName() + ", cnp: " + cnp + ", accommodated: "
                + accommodated + ", accommodation date :" + postingDate;
    }
}
