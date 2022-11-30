package service;

import lab1.classes.Employee;
import lab1.classes.Order;
import lab1.comparators.EmployeeBirthDateComparator;
import lab1.comparators.EmployeeComparator;
import lab1.comparators.EmployeePositionComparator;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    private Order order;

    public OrderService(Order ordering) {
        order = ordering;
    }

    public List<Employee> sortByFullName(){
        List<Employee> employees = new ArrayList<>();
        employees.addAll(order.getEmployees());
        Collections.sort(employees);
        employees.sort(new EmployeeComparator());
        return employees;
    }

    public List<Employee> sortByFullNameStream(){
        return order.getEmployees().stream().sorted(new EmployeeComparator()).collect(Collectors.toList());
    }
    public List<Employee>sortByDateOfBirth(){
        List<Employee> employees = new ArrayList<>();
        employees.addAll(order.getEmployees());
        Collections.sort(employees);
        employees.sort(new EmployeeBirthDateComparator());
        return employees;
    }

    public List<Employee> sortByDateOfBirthStream(){
        return order.getEmployees().stream().sorted(new EmployeeBirthDateComparator()).collect(Collectors.toList());
    }

    public List<Employee> sortByPosition(){
        List<Employee> employees = new ArrayList<>();
        employees.addAll(order.getEmployees());
        Collections.sort(employees);
        employees.sort(new EmployeePositionComparator());
        return employees;
    }
    public List<Employee> sortByPositionStream(){
        return order.getEmployees().stream().sorted(new EmployeePositionComparator()).collect(Collectors.toList());
    }
    public List<Employee> filterPosition(){
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : order.getEmployees()) {
            if (employee.getPosition() == "Waiter") {
                employees.add(employee);
            }
        }
        return employees;
    }
    public List<Employee> filterPositionStream(){
        return order.getEmployees().stream().filter(position -> position.getPosition().contains("Waiter")).collect(Collectors.toList());
    }

    public List<Employee> filterDate(){
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : order.getEmployees()) {
            if (employee.getBirthDate().getYear() > 2000) {
                employees.add(employee);
            }
        }
        return employees;
    }
    public List<Employee> filterDateStream(){
        return order.getEmployees().stream().filter(birthDate -> birthDate.getBirthDate().isAfter(LocalDate.of(1999, Month.DECEMBER, 31))).collect(Collectors.toList());
    }
}