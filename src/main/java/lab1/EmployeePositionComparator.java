package lab1;

import java.util.Comparator;

public class EmployeePositionComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee e1, Employee e2)
    {
        return e1.getPosition().compareTo(e2.getPosition());
    }
}