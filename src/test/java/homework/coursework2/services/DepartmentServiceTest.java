package homework.coursework2.services;

import homework.coursework2.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentService departmentService;

    @BeforeEach
    public void setUp() {
        List<Employee> list = new ArrayList<>(List.of(
                new Employee("Ivan", "Ivanov", 40000, 1),
                new Employee("Daria", "Petrova", 24020, 2),
                new Employee("Julia", "Sidoriva", 24100, 3),
                new Employee("Vitaliy", "Prosov", 24300, 4),
                new Employee("Maria", "Minina", 24000, 1),
                new Employee("Vika", "Zolotova", 26000, 2),
                new Employee("Vasiliy", "Serov", 36000, 3)));
        Mockito.when(employeeService.printEmployees()).thenReturn(list);
    }

    @Test
    public void employeesByDepartment() {
        assertThat(departmentService.departmentEmployee(5).isEmpty());
    }

    @Test
    public void minDepartmentSalary() {
        Employee employeeExcepted = new Employee("Maria", "Minina", 24000, 1);
        Employee employeeActual = departmentService.getMinDepartmentSalary(1);
        assertTrue(() -> employeeExcepted.equals(employeeActual));
    }

    @Test
    public void maxDepartmentSalary() {
        Employee employeeExcepted = new Employee("Ivan", "Ivanov", 40000, 1);
        Employee employeeActual = departmentService.getMaxDepartmentSalary(1);
        assertTrue(() -> employeeExcepted.equals(employeeActual));
    }

    @Test
    public void printAllEmployeeByDepartment() {
        Map<Integer, List<Employee>> mapExcepted = new HashMap<>(Map.of(
                1, List.of(
                        new Employee("Ivan", "Ivanov", 40000, 1),
                        new Employee("Maria", "Minina", 24000, 1)),
                2, List.of(
                        new Employee("Daria", "Petrova", 24020, 2),
                        new Employee("Vika", "Zolotova", 26000, 2)),
                3, List.of(
                        new Employee("Julia", "Sidoriva", 24100, 3),
                        new Employee("Vasiliy", "Serov", 36000, 3)),
                4, List.of(
                        new Employee("Vitaliy", "Prosov", 24300, 4)))
        );
        assertTrue(()->mapExcepted.equals(departmentService.printAllEmployeeDepartment()));
    }
    @Test
    public void printEmployeesByDepartment(){
        List<Employee> listExcepted = List.of(new Employee("Ivan", "Ivanov", 40000, 1),
                new Employee("Maria", "Minina", 24000, 1));
        assertTrue(()->listExcepted.equals(departmentService.departmentEmployee(1)));
    }
}
