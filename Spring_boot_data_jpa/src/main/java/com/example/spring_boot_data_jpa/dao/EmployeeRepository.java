package com.example.spring_boot_data_jpa.dao;

import com.example.spring_boot_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findAllByName(String name);

    /*public List<Employee> findAllBySalaryBetweenAndName(int min, int max, String name);*/

}
