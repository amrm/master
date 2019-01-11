package org.example.com.demo.modules.employee.service;


import org.example.com.demo.core.exception.CustomNotFoundException;
import org.example.com.demo.modules.employee.model.Employee;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * @author :Amr Abdeldayem
 */


public interface EmployeeService {
	long countAllEmployees();
	void deleteEmployee(Long id);
	Employee findEmployee(Long id) throws CustomNotFoundException;
	List<Employee> findAllEmployees();
	List<Employee> findByName(String name);
	void saveEmployee(Employee e);
	Employee updateEmployee(Employee e);
	List<Employee> findEmployees(Pageable pageable);
}
