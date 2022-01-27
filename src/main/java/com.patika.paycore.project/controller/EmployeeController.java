package com.patika.paycore.project.controller;

import com.patika.paycore.project.model.Employee;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private List<Employee> employeeList = new ArrayList<>();
    {
        employeeList.add(new Employee(1, "Ali", "Yilmaz", "IT Team Leader", "ayilmaz@gmail.com", 5362222222L, 'M', LocalDate.of(1978, 1, 1), 1, 13000.0));
        employeeList.add(new Employee(2, "Mehmet", "Solmaz", "IT Senior Engineer", "msolmaz@gmail.com", 5361111111L, 'M', LocalDate.of(1992, 2, 1), 1, 11000.0));
        employeeList.add(new Employee(3, "Cansu", "Durmus", "IT Senior Engineer", "cdurmus@gmail.com", 5343333333L, 'F', LocalDate.of(1988, 3, 1), 1, 12000.0));
        employeeList.add(new Employee(4, "Elif", "Tokgoz", "IT Associate Engineer", "etokgoz@gmail.com", 5364444444L, 'F', LocalDate.of(1995, 4, 1), 1, 7000.0));
        employeeList.add(new Employee(5, "Rıfat", "Cakir", "IT Associate Engineer", "rcakir@gmail.com", 5372222222L, 'M', LocalDate.of(1998, 5, 1), 1, 6000.0));

    }

    @GetMapping(path = "/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeList.get(id-1);
    }

    @GetMapping(path = "/getAll")
    public List<Employee> getAllEmployee(){
        return employeeList;
    }

    @PostMapping(path = "/add")
    public Employee addEmployee(@RequestBody Employee employee){
        employeeList.add(employee);
        return employee;
    }

    @PutMapping(path = "/{id}")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeList.set(employee.getId()-1,employee);
        return employee;
    }

    @DeleteMapping(path = "/{id}")
    public Employee deleteEmployee(@PathVariable int id){
        return employeeList.remove(id-1);
    }

}
