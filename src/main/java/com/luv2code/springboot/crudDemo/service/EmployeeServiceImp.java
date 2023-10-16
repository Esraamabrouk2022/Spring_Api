package com.luv2code.springboot.crudDemo.service;

import com.luv2code.springboot.crudDemo.dao.EmployeeDao;
import com.luv2code.springboot.crudDemo.dao.EmployeeDaoImp;
import com.luv2code.springboot.crudDemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImp(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findall() {
        return employeeDao.findall();
    }

    @Override
    public Employee findbyid(int id) {
        return employeeDao.findbyid(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Transactional
    @Override
    public void delete(int id) {
        employeeDao.delete(id);
    }
}
