package database;

import database.DBManager;
import lab1.classes.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee.Builder().setEmployeeId(1).setFullName("Mariia Venhryniuk").setBirthDate(LocalDate.of(2003, 10, 14))
                .setGender(Employee.Gender.valueOf("female")).setPosition("Administrator")
                .build();
        Employee employee2 = new Employee.Builder().setEmployeeId(2).setFullName("Alice Depp").setBirthDate(LocalDate.of(2002, 12, 4))
                .setGender(Employee.Gender.valueOf("female")).setPosition("Waitress")
                .build();
        Employee employee3 = new Employee.Builder().setEmployeeId(3).setFullName("Bred Pitt").setBirthDate(LocalDate.of(1997, 5, 15))
                .setGender(Employee.Gender.valueOf("male")).setPosition("Waiter")
                .build();
        Employee employee4 = new Employee.Builder().setEmployeeId(4).setFullName("Alan Deon").setBirthDate(LocalDate.of(2001, 1, 1))
                .setGender(Employee.Gender.valueOf("male")).setPosition("Waiter")
                .build();

        Dish dish1 = new Dish.DishBuilder().setDishId(1).setDishName("French soup").setGroup(Dish.Group.valueOf("soup")).setPrice(120).setWeight(300)
                .build();
        Dish dish2 = new Dish.DishBuilder().setDishId(2).setDishName("Coca cola").setGroup(Dish.Group.valueOf("drink")).setPrice(50).setWeight(500)
                .build();
        Dish dish3 = new Dish.DishBuilder().setDishId(3).setDishName("Salmon").setGroup(Dish.Group.valueOf("fish")).setPrice(220).setWeight(250)
                .build();
        Dish dish4 = new Dish.DishBuilder().setDishId(4).setDishName("French Fries").setGroup(Dish.Group.valueOf("garnish")).setPrice(75).setWeight(350)
                .build();

        Order order1 = new Order.OrderBuilder().setEmployeesList(Arrays.asList(employee2)).setCode(1)
                .setCreatedAt(LocalDateTime.parse("November 21, 2022 12:01 AM",
                        DateTimeFormatter.ofPattern("MMMM d',' yyyy hh':'mm a", Locale.US)))
                .setTableNumber(1).setType(Order.Type.valueOf("Offline")).setEmployeeId(2).setDishId(1).build();
        Order order2 = new Order.OrderBuilder().setEmployeesList(Arrays.asList(employee4)).setCode(2)
                .setCreatedAt(LocalDateTime.parse("November 21, 2022 12:12 AM",
                        DateTimeFormatter.ofPattern("MMMM d',' yyyy hh':'mm a", Locale.US)))
                .setTableNumber(1).setType(Order.Type.valueOf("Offline")).setEmployeeId(2).setDishId(1).build();
        Order order3 = new Order.OrderBuilder().setEmployeesList(Arrays.asList(employee3)).setCode(3)
                .setCreatedAt(LocalDateTime.parse("November 21, 2022 12:05 AM",
                        DateTimeFormatter.ofPattern("MMMM d',' yyyy hh':'mm a", Locale.US)))
                .setTableNumber(5).setType(Order.Type.valueOf("Offline")).setEmployeeId(3).setDishId(3).build();


        DBManager dbManager = new DBManager("jdbc:mysql://localhost:3306/dbrestaurant", "marie", "1410");

        dbManager.setData("CREATE TABLE Dish " +
                "(id INTEGER PRIMARY KEY, " +
                "dishName TEXT NOT NULL, " +
                "dishGroup TEXT NOT NULL, " +
                "price INTEGER NOT NULL, " +
                "weight INTEGER NOT NULL)");

        dbManager.setData("CREATE TABLE Employee " +
                "(id INTEGER PRIMARY KEY, " +
                "fullName TEXT NOT NULL, " +
                "birthDate DATE NOT NULL, " +
                "gender TEXT NOT NULL, " +
                "position TEXT NOT NULL)");

        dbManager.setData("CREATE TABLE Orders " +
                "(id INTEGER PRIMARY KEY, " +
                "createdAt TIMESTAMP NOT NULL, " +
                "tableNumber INTEGER NOT NULL, " +
                "type TEXT NOT NULL, " +
                "employee INTEGER NOT NULL, " +
                "dish INTEGER NOT NULL, " +
                "FOREIGN KEY (employee) REFERENCES Employee (id), " +
                "FOREIGN KEY (dish) REFERENCES Dish (id))");

        dbManager.setData("INSERT INTO Orders (id, createdAt, tableNumber, type, employee, dish) " +
                "VALUES (" + getOrderInfo(order1) + ");");
        dbManager.setData("INSERT INTO Orders (id, createdAt, tableNumber, type, employee, dish) " +
                "VALUES (" + getOrderInfo(order2) + ");");
        dbManager.setData("INSERT INTO Orders (id, createdAt, tableNumber, type, employee, dish) " +
                "VALUES (" + getOrderInfo(order3) + ");");

        for (Employee employee : order1.getEmployees()) {
            dbManager.setData("INSERT INTO Employee (id, fullName, birthDate, gender, position)" +
                    "VALUES (" + getEmployeeInfo(employee) + ");");
        }
        for (Employee employee : order2.getEmployees()) {
            dbManager.setData("INSERT INTO Employee (id, fullName, birthDate, gender, position)" +
                    "VALUES (" + getEmployeeInfo(employee) + ");");
        }
        for (Employee employee : order3.getEmployees()) {
            dbManager.setData("INSERT INTO Employee (id, fullName, birthDate, gender, position)" +
                    "VALUES (" + getEmployeeInfo(employee) + ");");
        }
        dbManager.setData("INSERT INTO Dish (id, dishName, dishGroup, price, weight) " +
                "VALUES (" + getDishInfo(dish1) + ");");
        dbManager.setData("INSERT INTO Dish (id, dishName, dishGroup, price, weight) " +
                "VALUES (" + getDishInfo(dish2) + ");");
        dbManager.setData("INSERT INTO Dish (id, dishName, dishGroup, price, weight) " +
                "VALUES (" + getDishInfo(dish3) + ");");
        dbManager.setData("INSERT INTO Dish (id, dishName, dishGroup, price, weight) " +
                "VALUES (" + getDishInfo(dish4) + ");");

        dbManager.close();
    }

    public static String getEmployeeInfo(Employee employee) {
        return String.format("'%d', '%s', '%d-%d-%d', '%s', '%s'",
                employee.getEmployeeId(), employee.getFullName(), employee.getBirthDate().getYear(),
                employee.getBirthDate().getMonthValue(), employee.getBirthDate().getDayOfMonth(), employee.getGender(), employee.getPosition());
    }
    public static String getDishInfo(Dish dish) {
        return String.format("'%d', '%s', '%s', '%d', '%d'",
                dish.getDishId(), dish.getDish_name(), dish.getGroup(), dish.getPrice(), dish.getWeight());
    }
    public static String getOrderInfo(Order order) {
        return String.format("'%d', '%d-%d-%d %d:%d:00', '%d', '%s', '%d', '%d'",
                order.getCode(), order.getCreatedAt().getYear(), order.getCreatedAt().getMonthValue(), order.getCreatedAt().getDayOfMonth(),
                order.getCreatedAt().getHour(), order.getCreatedAt().getMinute(),
                order.getTableNumber(), order.getType(), order.getEmployeeId(),
                order.getDishId());
    }

}