package database;

public class Main {
    public static void main(String[] args) {
        DBManager dbManager = new DBManager("jdbc:mysql://localhost:3306/appjava", "marie", "1410");
        OrderService orderService = new OrderService(dbManager);

        orderService.createTables();

        orderService.dropTables();

        dbManager.close();
    }

}