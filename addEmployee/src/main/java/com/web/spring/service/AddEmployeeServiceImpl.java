package com.web.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web.spring.model.EmployeeDto;
import com.web.spring.repository.AddEmployeeRepository;

@Service
public class AddEmployeeServiceImpl implements AddEmployeeService {

	
	@Autowired
	AddEmployeeRepository emprepo;


	@Override
	public EmployeeDto saveEmployee(EmployeeDto dto) {
		// TODO Auto-generated method stub
		return emprepo.save(dto);
	}


	@Override
	public List<EmployeeDto> getEmployee() {
		// TODO Auto-generated method stub
		return (List<EmployeeDto>) emprepo.findAll();
	}


	@Override
	public void deleteById(int id) {
		emprepo.deleteById(id);
		
	}

	/*
	 * @Override public Optional<EmployeeDto> editById(int id) { // TODO
	 * Auto-generated method stub return emprepo.findById(id); }
	 */


	/*
	 * @Override public EmployeeDto editById(int id) {
	 * 
	 * return emprepo.findById(id);;
	 * 
	 * }
	 */
}
