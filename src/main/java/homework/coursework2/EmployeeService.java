package homework.coursework2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> listEmployee = new ArrayList<>(10);

    public Employee addEmployees(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
        try {
            if (listEmployee.size() == 10) {
                throw new EmployeeStorageIsFullException("Список сотрудников переполнен!");
            }
            if (listEmployee.contains(emp)) {
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть в штате!");
            }
        } catch (EmployeeStorageIsFullException | EmployeeAlreadyAddedException e) {
            System.out.println(e.getMessage());
            //тут же не нужно приравнивать emp к null???? ведь когда метод закончит работу ссылка потеряется и ее соберет сборщик мусора????
        }
        listEmployee.add(emp);
        return emp;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
        for (Employee employee : listEmployee) {
            try {
                if (employee.equals(emp)) {
                    listEmployee.remove(employee);
                } else {
                    throw new EmployeeNotFoundException("Сотрудник не найден!");
                }
            } catch (EmployeeNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return emp;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
        try {
            if (listEmployee.contains(emp)){
                return emp;
            } else {
                throw new EmployeeNotFoundException("Сотудник не найден!");
            }
        } catch (EmployeeNotFoundException e){
            System.out.println(e.getMessage());
        }
        return emp;
    }

    public List<Employee> printEmployees(){
        return listEmployee;
    }
}

