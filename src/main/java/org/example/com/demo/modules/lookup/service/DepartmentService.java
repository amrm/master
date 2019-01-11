package org.example.com.demo.modules.lookup.service;

import org.example.com.demo.core.exception.CustomNotFoundException;
import org.example.com.demo.modules.lookup.model.Department;

import java.util.List;


/**
 * @author :Amr Abdeldayem
 */

public interface DepartmentService {
	Department findByName(String name) throws CustomNotFoundException;
	List<Department> findAll();
}
