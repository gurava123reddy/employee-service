package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.AddressClient;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee-service")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	AddressClient addressClient;
	
	@PostMapping
	public ResponseEntity<String> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
		
		Employee saveEmployee = employeeRepository.save(employeeDTO.getEmployee());
		if(saveEmployee!=null && saveEmployee.getEmpId()>0) {
			addressClient.saveAddress(employeeDTO.getAddresses(), saveEmployee.getEmpId());
		}
		return new ResponseEntity<>("Employee "+saveEmployee.getEmpName()+" saved successfully with ID "+saveEmployee.getEmpId(), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee(){
		
		List<Employee> saveEmployee = employeeRepository.findAll();
		return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
	}
}
