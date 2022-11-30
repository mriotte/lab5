package serialization;

import lab1.classes.Employee;

import java.util.List;

public interface Serializer {
    List<Employee> listFromFile(String filename);

    Employee fromFile(String fileName);

    void toFile(Employee Employee, String fileName);

    void listToFile(List<Employee> Employee, String fileName);
}

