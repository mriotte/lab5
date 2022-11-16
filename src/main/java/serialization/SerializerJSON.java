package serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lab1.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;




public class SerializerJSON implements Serializer{
    private ObjectMapper objectMapper;
    public SerializerJSON(){
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
    @Override
    public List<Employee> listFromFile(String fileName) {
        try {
            return objectMapper.readValue(new File(fileName), new TypeReference<>() {
            });
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }
    @Override
    public Employee fromFile(String fileName){
        try {
            return objectMapper.readValue(new File(fileName), Employee.class);
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public void toFile(Employee employee, String fileName){
        try {
            objectMapper.writeValue(new File(fileName), employee);
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }
    @Override
    public void listToFile(List<Employee> employees, String fileName){
        try {
            objectMapper.writeValue(new File(fileName), employees);
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    public static void main(String args[]) {

        Employee employee = new Employee();
        employee.setFullName("Mariia Venhryniuk");
        employee.setPosition("administrator");
        employee.setGender(Employee.Gender.female);
        employee.setBirthDate(LocalDate.of(2003, 10, 14));
        Serializer serializer = new SerializerJSON();
        serializer.toFile(employee, "employeeJSON");

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employee = new Employee();
        employee.setFullName("Mariia");
        employee.setPosition("Director");
        employee.setGender(Employee.Gender.female);
        employee.setBirthDate(LocalDate.of(2003, 10, 14));
        employees.add(employee);
        serializer.listToFile(employees, "employeesJSON");

        employee = serializer.fromFile("employeeJSON");
        System.out.println(employee);
        employees = serializer.listFromFile("employeesJSON");
        System.out.println(employees);
    }
}