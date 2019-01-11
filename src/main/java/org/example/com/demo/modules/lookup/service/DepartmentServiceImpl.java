package org.example.com.demo.modules.lookup.service;

import org.example.com.demo.core.exception.CustomNotFoundException;
import org.example.com.demo.modules.lookup.model.Department;
import org.example.com.demo.modules.lookup.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author :Amr Abdeldayem
 */


@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
    DepartmentRepository departmentRepository;

	public Department findByName(String name) throws CustomNotFoundException{
		return departmentRepository.findByName(name).orElseThrow(
				() -> new CustomNotFoundException("Department Not Found with ->  name: " + name));
	}

	public List<Department> findAll(){
		return departmentRepository.findAll();
	}
}
