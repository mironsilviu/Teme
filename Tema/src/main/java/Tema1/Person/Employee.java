package Tema1.Person;

public class Employee extends Person {

    private String pozition;
    private int salary;

    public Employee(String firstName, String lastName, String pozition, int salary) {
        super(firstName, lastName);
        this.pozition = pozition;
        this.salary = salary;

    }


}
