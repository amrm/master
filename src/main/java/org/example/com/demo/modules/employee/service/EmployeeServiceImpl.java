package org.example.com.demo.modules.employee.service;

import org.example.com.demo.core.exception.CustomNotFoundException;
import org.example.com.demo.modules.employee.model.Employee;
import org.example.com.demo.modules.employee.repo.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author :Amr Abdeldayem
 */

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public long countAllEmployees() {
		return employeeRepository.count();
	}

	@Override
	public void deleteEmployee(Long id) {
		logger.info("Delete Employee -> id:{}",id);
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee findEmployee(Long id) throws CustomNotFoundException{
		logger.info("Find Employee -> id:{}",id);
		//employeeRepository.getOne(id);
		Employee employee=employeeRepository.findById(id).orElseThrow(
				() -> new CustomNotFoundException("Employee Not Found with ->  id: " +
						id));
		return employee;
	}

	@Override
	public List<Employee> findAllEmployees() {
		logger.info("Find All Employees");
		return employeeRepository.findAll()
				.stream().collect(Collectors.toList());
	}

	@Override
	public List<Employee> findByName(String name){
		logger.info("Search on employees with name like: {}",name);
		return employeeRepository.findByNameIgnoreCaseContaining(name)
				.stream().collect(Collectors.toList());
	}

	@Override
	public List<Employee> findEmployees(Pageable pageable) {
		logger.info("Find Employees with pagination");
		return employeeRepository.findAll(pageable).stream().collect(Collectors.toList());
	}

	@Override
	public void saveEmployee(Employee e)
	{
		logger.info("Save Employees");
		employeeRepository.save(e);
	}

	@Override
	public Employee updateEmployee(Employee e) {
		logger.info("Update Employees ->  id:{}",e.getId());
		return employeeRepository.save(e);
	}
}
