package homework.coursework2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping (path = "/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName){
        return employeeService.addEmployees(firstName,lastName);
    }
    @GetMapping (path = "/remove")
    public Employee removeEmployee (@RequestParam String firstName, @RequestParam String lastName){
        return employeeService.removeEmployee(firstName,lastName);
    }
    @GetMapping (path = "/find")
    public  Employee findEmployee (@RequestParam String firstName, @RequestParam String lastName){
        return employeeService.findEmployee(firstName,lastName);
    }
    @GetMapping (path = "/printEmployee")
    public List<Employee> printEmployee (){
        return employeeService.printEmployees();
    }
}
