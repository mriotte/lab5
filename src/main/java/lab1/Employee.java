package lab1;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
/**
 * class "Employee" with fields: fullName, birthDate, gender, position
 * @author User
 * @version 1.0
 */

public class Employee {
    public enum Gender{male, female}

    private String fullName;
    private LocalDate birthDate;
    private Gender gender;
    private String position;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    /**
     *  Overridden function of obtaining a string representation of
     *  an instance of a class "Employee"
     *  @return returns the string representation
     */
    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", position='" + position + '\'' +
                '}';
    }
    /**
     * Overridden function of comparison an instance of
     * the class "Employee" and an instance of the class "Object"
     * @return returns the boolean value of the comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return fullName.equals(employee.fullName) && birthDate.equals(employee.birthDate) && gender == employee.gender && position.equals(employee.position);
    }
    /**
     * Overridden function of obtaining the hash code
     * @return returns the numeric value of the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(fullName, birthDate, gender, position);
    }

    /**
     * Class "Builder" with fields: employee
     * @author User
     * @version 1.0
     */
    public static class Builder{
        private Employee employee;
        public Builder(){
            employee = new Employee();
        }
        /**
         * Setter name designation
         * @param fullName - employee full name
         * @return returns current object
         */
        public Builder setFullName(String fullName){
            employee.fullName = fullName;
            return this;
        }
        /**
         * Setter name designation
         * @param birthDate - date of birth
         * @return returns current object
         */
        public Builder setBirthDate(LocalDate birthDate){
            employee.birthDate = birthDate;
            return this;
        }
        /**
         * Setter name designation
         * @param gender - employee gender
         * @return returns current object
         */
        public Builder setGender(Gender gender){
            employee.gender = gender;
            return this;
        }
        /**
         * Setter name designation
         * @param position - employee position
         * @return returns current object
         */
        public Builder setPosition(String position){
            employee.position = position;
            return this;
        }
        /**
         * Function of creating an object of class "Employee"
         * @return returns new object of class "Employee"
         */
        public Employee build(){
            return employee;
        }
    }
    public static void main(String args[]) {
    }
}
