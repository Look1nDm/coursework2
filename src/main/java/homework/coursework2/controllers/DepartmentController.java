package homework.coursework2.controllers;

import homework.coursework2.model.*;
import homework.coursework2.services.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public String getMaxDepartmentSalary(@RequestParam int departmentId) {
        return "Максимальная заработная плата в отделе №" + departmentId + " у сотрудника " +
                departmentService.getMaxDepartmentSalary(departmentId).toString();
    }

    @GetMapping(path = "/min-salary")
    public String getMinDepartmentSalary(@RequestParam int departmentId) {
        return "Минимальная заработная плата в отделе №" + departmentId + " у сотрудника " +
                departmentService.getMinDepartmentSalary(departmentId).toString();
    }

    @GetMapping(path = "/al")
    public List<Employee> departmentEmployee (@RequestParam int departmentId) {
        return departmentService.departmentEmployee(departmentId);
    }
    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> printAllEmployeeDepartment(){
        return departmentService.printAllEmployeeDepartment();
    }
}
