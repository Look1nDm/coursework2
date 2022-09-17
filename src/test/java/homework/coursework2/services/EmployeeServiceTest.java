package homework.coursework2.services;

import homework.coursework2.model.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    private final EmployeeService employeeService;

    private final Employee emp1 = new Employee("ivan","ivanov",40000,2);

    public EmployeeServiceTest() {
        this.employeeService = new EmployeeService();
    }


    @Test
    public void removeEmployeeFromServiceTest(){
        assertEquals(employeeService.addEmployees
                (emp1.getFirstName(),emp1.getLastName(),emp1.getSalary(),emp1.getDepartment()), emp1);
    }
    @Test
    public void deleteEmployeeFromServiceTest(){
        Map<String,Employee> map = new HashMap<>(
                Map.of("one",emp1));
        map.put(emp1.getFullName(), emp1);

        assertEquals(emp1,map.remove(emp1.getFullName()));
        assertThrows(RuntimeException.class,()->employeeService.removeEmployee(emp1.getFirstName(),
                emp1.getLastName(),emp1.getSalary(),emp1.getDepartment()));
    }
    @Test
    public void findEmployeeFromServiceTest(){
        Map<String,Employee> map = new HashMap<>(
                Map.of("one",emp1));
        map.put(emp1.getFullName(), emp1);

        assertEquals(emp1,map.get(emp1.getFullName()));
        assertThrows(RuntimeException.class,()->employeeService.findEmployee(emp1.getFirstName(),
                emp1.getLastName(),emp1.getSalary(),emp1.getDepartment()));
    }
    @Test
    public void printEmployeeFromServiceTest(){
        Map<String, Employee> listEmployeeExcepted = new HashMap<>(Map.of("one",
                new Employee("Ivan","Ivanov",40000,2),"two",
                new Employee("Vasiliy","Petor", 30000,1),"three",
                new Employee("Maria","Rumianceva",35000,3)
        ));
        List<Employee> listActual = employeeService.printEmployees();
        assertEquals(new ArrayList<>(listEmployeeExcepted.values()),listActual);
    }
}