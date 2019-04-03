package Tema1.Person;

public class Client extends Person {

    private String userName;
    private String password;

    public Client(String firstName, String lastName, String userName, String password) {
        super(firstName, lastName);
        this.userName = userName;
        this.password = password;

    }

}
