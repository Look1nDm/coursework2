package homework.coursework2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
    private final List<Employee> listEmployee = new ArrayList<>(10);

    public Employee addEmployees(String firstName, String lastName) {
        return new Employee(firstName,lastName);
    }
    public Employee removeEmployee(String firstName, String lastName){
        listEmployee.removeIf(emp -> emp.getFirstName().equals(firstName) && emp.getLastName().equals(lastName));
    }
    public void findEmployee(String firstName, String lastName){

    }
}

