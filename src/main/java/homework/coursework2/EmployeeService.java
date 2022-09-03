package homework.coursework2;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<String, Employee> listEmployee;

    public EmployeeService() {
        this.listEmployee = new HashMap<>();
    }

    public Employee addEmployees(String firstName, String lastName,int salary,int department) {
        Employee emp = new Employee(firstName, lastName, salary, department);
        if (listEmployee.containsKey(emp.getFullName())) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть в штате!");
        }
        listEmployee.put(emp.getFullName(), emp);
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
        if (listEmployee.containsKey(emp.getFullName())) {
            return emp;
        } else {
            throw new EmployeeNotFoundException("Сотудник не найден!");
        }
    }
    public List<Employee> printEmployees() {
        return new ArrayList<>(listEmployee.values());
    }
    //=============================================================================================
    public int getSumSalary() {
        int sumSalary = 0;
        for (Map.Entry<String,Employee> entry: listEmployee.entrySet())
            sumSalary += entry.getValue().getSalary();
        return sumSalary;
    }
    public int minSalary() {
        int min = Integer.MIN_VALUE;
        for (Map.Entry<String, Employee> entry : listEmployee.entrySet()) {
            if (entry.getValue().getSalary() < min) {
                min = entry.getValue().getSalary();
            }
            min = entry.getValue().getSalary();
        }
        return min;
    }
    public int maxSalary() {
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String,Employee> entry: listEmployee.entrySet()) {
            if (entry.getValue().getSalary() > max) {
                max = entry.getValue().getSalary();
            }
        }
        return max;
    }
    public double middleSalary() {
        return (double) getSumSalary() / listEmployee.size();
    }
    public void FIO() {
        System.out.println(listEmployee.keySet());
    }
    public void index(int index) {
        for (Map.Entry<String,Employee> entry: listEmployee.entrySet()) {
            System.out.println((entry.getValue().getSalary())+entry.getValue().getSalary()/100*index);
        }
    }
    //=======РАБОТА С ОТДЕЛАМИ==================

    // возвращает сотрудников нужного нам отдела
    public List <Employee> departmentEmployee(int department) {
        return listEmployee.values().stream()
                .filter(e->e.getDepartment() == department)
                .collect(Collectors.toList());
    }
    // ищем минимальную зарплату в отделе
    public Optional<Employee> getMinDepartmentSalary(int department) {
        List<Employee> list = departmentEmployee(department);
        return list.stream().reduce((a1, a2)->a1.getSalary() < a2.getSalary()?a1:a2);
    }
    // ищем максимальную зарплату в отделе
    public Optional<Employee> getMaxDepartmentSalary(int department) {
        List<Employee> list = departmentEmployee(department);
        return list.stream().reduce((a1, a2)->a1.getSalary() > a2.getSalary()?a1:a2);
    }
    // находим сумму заработных плат сотрудников в отделе
        public void getSumSalaryDepartment(int department) {
        List<Employee> list = departmentEmployee(department);
        int sum = list.stream().map(Employee::getSalary).reduce((a1,a2)->a1+a2).get();
        System.out.println("Сумма затрат на заработную плату в отделе №" + department + " равна - " + sum);
    }
   // метод выводит средную заработную плату в указанном отделе
    void getMiddleSalaryDepartment(int department) {
        List<Employee> list = departmentEmployee(department);
        double midSalary = list.stream().mapToInt(Employee::getSalary).average().getAsDouble();
        System.out.println("Средняя заработная плата по отделу №" + department + " равна - " + midSalary);
    }
    public List<Integer> getIndexSalaryDepartment(int department, int index) {
        List<Employee> list = departmentEmployee(department);
        return list.stream().map(Employee::getSalary).map(e->e+(e/100)*index).collect(Collectors.toList());
    }
    public Map<Integer, List<Employee>> printAllEmployeeDepartment(){
        return printEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }
}

