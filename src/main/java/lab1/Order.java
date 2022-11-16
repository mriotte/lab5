package lab1;
/*
* java docs
*
*
 */
import java.time.LocalDateTime;
import java.util.Objects;

public class Order {
    enum Type{Online, Offline}
    
    private int code;
    private LocalDateTime createdAt;
    private int tableNumber;
    private Type type;
    private Employee employee;
    private Dish dish;

    private Order(int code, LocalDateTime createdAt, Employee employee){
        this.code = code;
        this.createdAt = createdAt;
    }
    public Order(OrderBuilder orderBuilder){
        this.code = 12345;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getTableNumber() {
        return tableNumber;
    }
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Dish getDish() {
        return dish;
    }
    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @Override
    public String toString() {
        return "Order{" +
                "code=" + code +
                ", createdAt=" + createdAt +
                ", tableNumber=" + tableNumber +
                ", type=" + type +
                ", employee=" + employee +
                ", dish=" + dish +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return code == order.code && createdAt.equals(order.createdAt) && type == order.type  && dish.equals(order.dish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, createdAt, tableNumber, type, dish);
    }

    //Builder Class
    public static class OrderBuilder{

        // required parameters
        private int code;
        private LocalDateTime createdAt;
        private int tableNumber;
        private Type type;
        private Employee employee;
        private Dish dish;

        // optional parameters

        public OrderBuilder(int code, LocalDateTime createdAt, int tableNumber, Type type, Employee employee, Dish dish){
            this.code = code;
            this.createdAt = createdAt;
            this.tableNumber = tableNumber;
            this.type = type;
            this.employee = employee;
            this.dish = dish;
        }



        public Order build(){
            return new Order(this);
        }

    }



}
