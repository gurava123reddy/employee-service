package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;

public class EmployeeDTO {
	
	private Employee employee;
	private List<Address> addresses;
	
	public EmployeeDTO() {}

	public EmployeeDTO(Employee employee, List<Address> addresses) {
		super();
		this.employee = employee;
		this.addresses = addresses;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
}
