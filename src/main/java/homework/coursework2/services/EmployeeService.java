package homework.coursework2.services;

import homework.coursework2.exceptions.EmployeeAlreadyAddedException;
import homework.coursework2.exceptions.EmployeeNotFoundException;
import homework.coursework2.exceptions.NotValException;
import homework.coursework2.model.Employee;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    final Map<String, Employee> listEmployee;
    public EmployeeService() {
        this.listEmployee = new HashMap<>(Map.of("one",
                new Employee("Ivan","Ivanov",40000,2),"two",
                new Employee("Vasiliy","Petor", 30000,1),"three",
                new Employee("Maria","Rumianceva",35000,3)
        ));
    }

    public Employee addEmployees(String firstName, String lastName, int salary, int department) {
        Employee emp = new Employee(firstName, lastName, salary, department);
        if (!checkStrings(firstName,lastName)){
            throw new NotValException("Неверно указаны ФИО");
        }
        if (listEmployee.containsKey(emp.getFullName())) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть в штате!");
        }
        listEmployee.put(emp.getFullName(), emp);
        return emp;
    }

    boolean checkStrings(String firstName, String lastName) {
        return StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName);
    }

    public Employee removeEmployee(String firstName, String lastName, int salary, int department) {
        Employee emp = new Employee(firstName, lastName, salary, department);
        if (!checkStrings(firstName,lastName)){
            throw new NotValException("Неверно указаны ФИО");
        }
        if (listEmployee.containsKey(emp.getFullName())) {
            listEmployee.remove(emp.getFullName());
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден!");
        }
        return emp;
    }

    public Employee findEmployee(String firstName, String lastName, int salary, int department) {
        Employee emp = new Employee(firstName, lastName, salary, department);
        if (!checkStrings(firstName,lastName)){
            throw new NotValException("Неверно указаны ФИО");
        }
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
        for (Map.Entry<String, Employee> entry : listEmployee.entrySet())
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
        for (Map.Entry<String, Employee> entry : listEmployee.entrySet()) {
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
        for (Map.Entry<String, Employee> entry : listEmployee.entrySet()) {
            System.out.println((entry.getValue().getSalary()) + entry.getValue().getSalary() / 100 * index);
        }
    }
}

