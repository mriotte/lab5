package database;

public class OrderService {

        private DBManager dbManager;

        public OrderService(DBManager dbManager){
            this.dbManager = dbManager;
        }
        public void createDish(){
            dbManager.executeUpdate("CREATE TABLE Dish " +
                    "(id INTEGER AUTO_INCREMENT PRIMARY KEY, " +
                    "dishName VARCHAR(60) NOT NULL, " +
                    "dishGroup VARCHAR(50) NOT NULL, " +
                    "price INTEGER NOT NULL, " +
                    "weight INTEGER NOT NULL, " +
                    "CONSTRAINT UNIQUE (dishName, dishGroup, price, weight))");
        }
    public void createEmployee(){
        dbManager.executeUpdate("CREATE TABLE Employee " +
                "(id INTEGER AUTO_INCREMENT PRIMARY KEY, " +
                "fullName VARCHAR(100) NOT NULL, " +
                "birthDate DATE NOT NULL, " +
                "gender VARCHAR(10) NOT NULL, " +
                "position VARCHAR(50) NOT NULL," +
                "CONSTRAINT UNIQUE (fullName, birthDate, gender, position))");
    }
    public void createOrder(){
        dbManager.executeUpdate("CREATE TABLE Orders " +
                "(id INTEGER AUTO_INCREMENT PRIMARY KEY, " +
                "createdAt TIMESTAMP NOT NULL, " +
                "tableNumber INTEGER NOT NULL, " +
                "type VARCHAR(10) NOT NULL, " +
                "employee INTEGER NOT NULL, " +
                "dish INTEGER NOT NULL, " +
                "FOREIGN KEY (employee) REFERENCES Employee (id), " +
                "FOREIGN KEY (dish) REFERENCES Dish (id), " +
                "CONSTRAINT UNIQUE (createdAt, tableNumber, type, employee, dish))");
    }

        public void createTables() {
            createEmployee();
            createDish();
            createOrder();
        }

        public void dropOrder(){
            dbManager.executeUpdate("DROP TABLE Orders;");
        }
        public void dropEmployee(){
        dbManager.executeUpdate("DROP TABLE Employee;");
        }
        public void dropDish(){
        dbManager.executeUpdate("DROP TABLE Dish;");
        }
        public void dropTables(){

            dropOrder();
            dropEmployee();
            dropDish();
        }


    }

