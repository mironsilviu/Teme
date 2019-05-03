package repository;


import model.person.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository{

    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public void add(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void remove(Employee employee) {
        employeeList.remove(employee);
    }

    @Override
    public List<Employee> listEmployee() {
        return employeeList;
    }
}
