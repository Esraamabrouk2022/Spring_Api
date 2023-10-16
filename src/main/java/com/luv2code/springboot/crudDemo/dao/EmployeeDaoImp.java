package com.luv2code.springboot.crudDemo.dao;

import com.luv2code.springboot.crudDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImp implements EmployeeDao {
    public EntityManager entityManager;

    @Autowired
    public EmployeeDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findall() {
        TypedQuery<Employee> theQuary = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = theQuary.getResultList();
        return employees;
    }

    @Override
    public Employee findbyid(int id) {

        Employee dpemployee = entityManager.find(Employee.class, id);

        return dpemployee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dpemployee = entityManager.merge(employee);

        return dpemployee;
    }

    @Override
    public void delete(int id) {

        Employee dpemployee = entityManager.find(Employee.class, id);
        entityManager.remove(dpemployee);

    }
}
