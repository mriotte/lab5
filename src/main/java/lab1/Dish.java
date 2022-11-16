package lab1;

import java.util.Objects;
/*
*java docs
*
*
 */

public class Dish {
    enum Group{soup, meat, drink, fish, garnish, snack }

    private String dishName;
    private Group group;
    private float price;
    private float weight;

    private Dish(String dishName, Group group){
        this.dishName = dishName;
        this.group = group;
    }
    public Dish(DishBuilder dishBuilder){
        this.dishName = getDish_name();
    }

    public String getDish_name() {
        return dishName;
    }

    public void setDish_name(String dishName) {
        this.dishName = dishName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishName='" + dishName + '\'' +
                ", group=" + group +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Float.compare(dish.price, price) == 0 && Float.compare(dish.weight, weight) == 0 && dishName.equals(dish.dishName) && group == dish.group;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishName, group, price, weight);
    }

    //Builder Class
    public static class DishBuilder{

        // required parameters
        private String dishName;
        private Group group;
        private float weight;

        // optional parameters
        private float price;

        public DishBuilder(String dishName, Group group, float weight){
            this.dishName = dishName;
            this.group = group;
            this.weight = weight;
        }

        public DishBuilder setPrice(float value) {
            price = value;
            return this;
        }


        public Dish build(){
            return new Dish(this);
        }

    }

}

