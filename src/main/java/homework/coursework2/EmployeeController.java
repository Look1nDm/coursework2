package homework.coursework2;

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

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName,@RequestParam int salary,@RequestParam int department) {
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

    @GetMapping(path = "/departments/max-salary")
    public String getMaxDepartmentSalary(@RequestParam int departmentId) {
        return "Максимальная заработная плата в отделе №" + departmentId + " у сотрудника " + employeeService.getMaxDepartmentSalary(departmentId).toString();
    }

    @GetMapping(path = "departments/min-salary")
    public String getMinDepartmentSalary(@RequestParam int departmentId) {
        return "Минимальная заработная плата в отделе №" + departmentId + " у сотрудника " + employeeService.getMinDepartmentSalary(departmentId).toString();
    }

    @GetMapping(path = "/departments/al")
    public List<Employee> departmentEmployee (@RequestParam int departmentId) {
        return employeeService.departmentEmployee(departmentId);
    }
    @GetMapping(path = "/departments/all")
    public Map<Integer, List<Employee>> printAllEmployeeDepartment(){
        return employeeService.printAllEmployeeDepartment();
    }
}