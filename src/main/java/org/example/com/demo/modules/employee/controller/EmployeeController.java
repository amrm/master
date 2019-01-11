package org.example.com.demo.modules.employee.controller;

import org.example.com.demo.core.exception.CustomNotFoundException;
import org.example.com.demo.core.utils.JsonUtil;
import org.example.com.demo.core.utils.HttpHeaderUtil;
import org.example.com.demo.modules.employee.model.Employee;
import org.example.com.demo.modules.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

/**
 * @author :Amr Abdeldayem
 */

@Controller
@RequestMapping("/employee")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> showEmployee(@PathVariable("id") Long id) throws CustomNotFoundException {
        HttpHeaders headers = HttpHeaderUtil.getHeadersObject();
		Employee employee = employeeService.findEmployee(id);
		if (employee == null) {
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(JsonUtil.toJson(employee), headers, HttpStatus.OK);
    }

	@RequestMapping(value ="/pagination" ,headers = "Accept=application/json",method = RequestMethod.GET)
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> getListEmployees(@RequestParam("page") int page ,@RequestParam("size")int size) {
		HttpHeaders headers = HttpHeaderUtil.getHeadersObject();
		Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "name"));
		Pageable pageable =PageRequest.of(page, size,sort);
		List<Employee> result = employeeService.findAllEmployees();
		return new ResponseEntity<String>(JsonUtil.toJsonArray(result), headers, HttpStatus.OK);
	}

	@RequestMapping(value ="/all" ,headers = "Accept=application/json",method = RequestMethod.GET)
    @ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> getAllEmployees() {
        HttpHeaders headers = HttpHeaderUtil.getHeadersObject();
		List<Employee> result = employeeService.findAllEmployees();
		return new ResponseEntity<String>(JsonUtil.toJsonArray(result), headers, HttpStatus.OK);
    }

	@RequestMapping(value ="/search" ,headers = "Accept=application/json",method = RequestMethod.GET)
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> search(@RequestParam("name") String name) {
		HttpHeaders headers = HttpHeaderUtil.getHeadersObject();
		List<Employee> result = employeeService.findByName(name);
		return new ResponseEntity<String>(JsonUtil.toJsonArray(result), headers, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
	@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee, UriComponentsBuilder uriBuilder) {
		HttpHeaders headers = HttpHeaderUtil.getHeadersObject();
		employeeService.saveEmployee(employee);
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id) {
		HttpHeaders headers = HttpHeaderUtil.getHeadersObject();
		employee.setId(id);
		if (employeeService.updateEmployee(employee) == null) {
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) throws CustomNotFoundException {
		HttpHeaders headers = HttpHeaderUtil.getHeadersObject();
		Employee employee=employeeService.findEmployee(id);
		if (employee == null) {
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		}
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>(headers, HttpStatus.OK);
    }
}