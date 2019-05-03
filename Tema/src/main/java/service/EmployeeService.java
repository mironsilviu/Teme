package service;

import model.person.Employee;
import repository.EmployeeRepository;
import service.exception.ValidationException;
import service.exception.ValidationExceptionMessage;

import java.util.List;

public class EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String validateAndAddEmployee(Employee employee) throws ValidationException {
        if (employee == null) {
            throw new ValidationException(ValidationExceptionMessage.NO_EMPLOYEE);
        }
        if (employee.getLastName().length() < 3) {
            throw new ValidationException(ValidationExceptionMessage.NAME_TOO_SHORT);
        }

        employeeRepository.add(employee);
        return "Hired";

    }

    private final String removeEmployeePassword = "qwerty";

    public String validateAndRemoveEmployee(Employee employee, String validPassword) throws ValidationException {
        if (removeEmployeePassword.equals(validPassword)) {
            employeeRepository.remove(employee);
            return "Fired";
        } else {
            throw new ValidationException(ValidationExceptionMessage.INVALID_PASSWORD);
        }

    }

    public List<Employee> getEmployees() {
        return employeeRepository.listEmployee();
    }


}
