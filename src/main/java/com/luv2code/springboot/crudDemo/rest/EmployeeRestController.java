package com.luv2code.springboot.crudDemo.rest;

import com.luv2code.springboot.crudDemo.dao.EmployeeDao;
import com.luv2code.springboot.crudDemo.dao.EmployeeDaoImp;
import com.luv2code.springboot.crudDemo.entity.Employee;
import com.luv2code.springboot.crudDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findall() {
        return employeeService.findall();
    }

    @GetMapping("/employees/{id}")
    public Employee GetEmployee(@PathVariable int id) {
        Employee employee = employeeService.findbyid(id);
        if (employee == null) throw new RuntimeException("Employee Id not found " + id);
        return employee;
    }


    @PostMapping("/employees")
    public Employee AddEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        Employee dpemployee = employeeService.save(employee);
        return dpemployee;
    }

    @PutMapping("/employees")
    public Employee UpdateEmployee(@RequestBody Employee employee) {
        Employee dpemployee = employeeService.save(employee);
        return dpemployee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee dpEmployee = employeeService.findbyid(id);
        if (dpEmployee == null) {
            throw new RuntimeException("The id not found to delete");
        }
        employeeService.delete(id);
        return "Employee with id " + id + " deleted";
    }
}
