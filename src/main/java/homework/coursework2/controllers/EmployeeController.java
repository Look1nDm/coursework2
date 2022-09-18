package homework.coursework2.controllers;

import homework.coursework2.services.DepartmentService;
import homework.coursework2.services.EmployeeService;
import homework.coursework2.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam int department) {
        return employeeService.addEmployees(firstName, lastName,salary,department);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName,@RequestParam int salary,@RequestParam int department) {
        return employeeService.removeEmployee(firstName, lastName,salary,department);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName,@RequestParam int salary,@RequestParam int department) {
        return employeeService.findEmployee(firstName, lastName,salary,department);
    }

    @GetMapping(path = "/printEmployee")
    public String printEmployee() {
        return employeeService.printEmployees().toString();
    }
}