package homework.coursework2.services;

import homework.coursework2.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getMinDepartmentSalary(int department) {
        return employeeService.printEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt((Employee::getSalary))).orElseThrow();
    }
    public Employee getMaxDepartmentSalary(int department) {
        return employeeService.printEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary)).orElseThrow();
    }
    public Map<Integer, List<Employee>> printAllEmployeeDepartment() {
        return employeeService.printEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
    public List<Employee> departmentEmployee(int department) {
        return employeeService.printEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
}
