package lab1.comparators;

import lab1.classes.Employee;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getFullName().compareTo(e2.getFullName());
    }
}