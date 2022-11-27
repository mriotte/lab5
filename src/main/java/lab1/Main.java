package lab1;

import service.OrderService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) {
        Employee e1 = new Employee.Builder()
                .setFullName("Mariia Venhryniuk")
                .setBirthDate(LocalDate.of(2003, 10, 14))
                .setGender(Employee.Gender.valueOf("female"))
                .setPosition("Director").build();
        Employee e2 = new Employee.Builder()
                .setFullName("Angelina Jolie")
                .setBirthDate(LocalDate.of(1997, 5, 18))
                .setGender(Employee.Gender.valueOf("female"))
                .setPosition("Administrator").build();
        Employee e3 = new Employee.Builder()
                .setFullName("Melice Moreau")
                .setBirthDate(LocalDate.of(2001, 1, 1))
                .setGender(Employee.Gender.valueOf("male"))
                .setPosition("Waitress").build();
        Employee e4 = new Employee.Builder()
                .setFullName("Jonny Depp")
                .setBirthDate(LocalDate.of(1899, 11, 12))
                .setGender(Employee.Gender.valueOf("male"))
                .setPosition("Waiter").build();
        Employee e5 = new Employee.Builder()
                .setFullName("Bred Pitt")
                .setBirthDate(LocalDate.of(1991, 4, 8))
                .setGender(Employee.Gender.valueOf("male"))
                .setPosition("Waiter").build();

        List<Employee>employees = new ArrayList<Employee>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        Order o1 = new Order.OrderBuilder()
                .setEmployeesList(employees)
                .setTableNumber(9).build();

        OrderService service = new OrderService(o1);

        System.out.println("Employees sorted by full name:");
        System.out.println(service.sortByFullName());

        System.out.println("\nEmployees sorted by full name (Stream):");
        System.out.println(service.sortByFullNameStream());

        System.out.println("\nEmployees sorted by birth date: ");
        System.out.println(service.sortByDateOfBirth());

        System.out.println("\nEmployees sorted by birth date (Stream): ");
        System.out.println(service.sortByDateOfBirthStream());

        System.out.println("\nEmployees sorted by position: ");
        System.out.println(service.sortByPosition());

        System.out.println("\nEmployees sorted by position (Stream): ");
        System.out.println(service.sortByPositionStream());

        System.out.println("\nEmployees filtered by position (Waiters): ");
        System.out.println(service.filterPosition());

        System.out.println("\nEmployees filtered by position (Waiters) (Stream): ");
        System.out.println(service.filterPositionStream());

        System.out.println("\nEmployees filtered by date (Who was born after 2000): ");
        System.out.println(service.filterDate());

        System.out.println("\nEmployees filtered by date (Who was born after 2000) (Stream): ");
        System.out.println(service.filterDateStream());

    }

}

