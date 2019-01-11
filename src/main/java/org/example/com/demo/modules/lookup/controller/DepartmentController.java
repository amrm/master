package org.example.com.demo.modules.lookup.controller;


import org.example.com.demo.modules.lookup.model.Department;
import org.example.com.demo.modules.lookup.service.DepartmentService;
import org.example.com.demo.core.utils.JsonUtil;
import org.example.com.demo.core.utils.HttpHeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author :Amr Abdeldayem
 */


@Controller
@RequestMapping("/department")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value ="/all" ,headers = "Accept=application/json",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getAllEmployees() {
        HttpHeaders headers = HttpHeaderUtil.getHeadersObject();
		List<Department> result = departmentService.findAll();
		return new ResponseEntity<String>(JsonUtil.toJsonArray(result), headers, HttpStatus.OK);
    }

}