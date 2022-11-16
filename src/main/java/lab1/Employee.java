package lab1;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
/*
*
*
* java docs
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

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return fullName.equals(employee.fullName) && birthDate.equals(employee.birthDate) && gender == employee.gender && position.equals(employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, birthDate, gender, position);
    }

    //Builder Class
    public static class Builder{
        private Employee employee;
        public Builder(){
            employee = new Employee();
        }

        public Builder setFullName(String fullName){
            employee.fullName = fullName;
            return this;
        }

        public Builder setBirthDate(LocalDate birthDate){
            employee.birthDate = birthDate;
            return this;
        }
        public Builder setGender(Gender gender){
            employee.gender = gender;
            return this;
        }

        public Builder setPosition(String position){
            employee.position = position;
            return this;
        }

        public Employee build(){
            return employee;
        }
    }
}
