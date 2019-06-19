package com.web.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.web.spring.model.EmployeeDto;

public interface AddEmployeeService {

	EmployeeDto saveEmployee(EmployeeDto dto);

	List<EmployeeDto> getEmployee();

	void deleteById(int id);

	//EmployeeDto editById(int id);

}
