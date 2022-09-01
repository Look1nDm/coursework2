package homework.coursework2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private final Map<String,Employee> listEmployee;

    public EmployeeService() {
        this.listEmployee = new HashMap<>();
    }
    public Employee addEmployees(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
            if (listEmployee.containsKey(emp.getFullName())) {
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть в штате!");
            }
        listEmployee.put(emp.getFullName(),emp);
        return emp;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
                if (listEmployee.containsKey(emp.getFullName())) {
                    listEmployee.remove(emp.getFullName());
                } else {
                    throw new EmployeeNotFoundException("Сотрудник не найден!");
                }
        return emp;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
            if (listEmployee.containsKey(emp.getFullName())){
                return emp;
            } else {
                throw new EmployeeNotFoundException("Сотудник не найден!");
            }
    }

    public List<Employee> printEmployees(){
        return new ArrayList<>(listEmployee.values());
    }
}

