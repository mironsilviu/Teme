package repository;

import model.person.Employee;

import java.util.List;

public interface IEmployeeRepository {
    void add(Employee employee);

    void remove(Employee employee);

    List<Employee> listEmployee();

}
