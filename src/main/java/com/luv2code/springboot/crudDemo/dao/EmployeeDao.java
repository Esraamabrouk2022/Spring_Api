package com.luv2code.springboot.crudDemo.dao;

import com.luv2code.springboot.crudDemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findall();
    public Employee findbyid(int id);
    public Employee save(Employee employee);
    public void delete(int id);
}
