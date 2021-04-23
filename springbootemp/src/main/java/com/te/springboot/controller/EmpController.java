package com.te.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot.beans.EmployeeBean;
import com.te.springboot.beans.EmployeeResponse;
import com.te.springboot.service.EmployeeService;

@RestController
public class EmpController {

	@Autowired
	EmployeeService service;

	@GetMapping(path = "/getEmp", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse getEmployee(int id) {
		EmployeeBean employeeBean = service.getEmployee(id);
		EmployeeResponse employeeResponse = new EmployeeResponse();
		if (employeeBean != null) {
			employeeResponse.setStatusCode(200);
			employeeResponse.setMsg("success");
			employeeResponse.setDescription(" Data found for id : " + id);
			employeeResponse.setBean(employeeBean);
		} else {
			employeeResponse.setStatusCode(404);
			employeeResponse.setMsg("failure");
			employeeResponse.setDescription("Error Data Not found");
		}
		return employeeResponse;

	}// end of getEmp

	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse getAll() {
		EmployeeResponse response = new EmployeeResponse();
		List<EmployeeBean> employeeBeans = service.getAllEmp();
		if (employeeBeans != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Employee details found");
			response.setEmployeeBeans(employeeBeans);
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Details Not found");
		}
		return response;
	}// end get all

	@DeleteMapping(path = "/delete", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse delete(int id) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.deleteEmpData(id)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Employee details found");

		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Details Not found");

		}
		return response;
	}

	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse add(@RequestBody EmployeeBean bean) {

		EmployeeResponse response = new EmployeeResponse();
		if (service.addEmployee(bean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Employee data added");

		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something went wrong");

		}
		return response;

	}
	
	@PutMapping(path="/update",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse update(@RequestBody EmployeeBean bean) {

		EmployeeResponse response=new EmployeeResponse();
		if (service.updateEmployee(bean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Employee details found and updated");

		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Details Not found");

		}
		return response;
	}
		
		
}
