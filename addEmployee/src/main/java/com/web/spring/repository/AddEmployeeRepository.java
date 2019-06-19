package com.web.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.spring.model.EmployeeDto;

@Repository
public interface AddEmployeeRepository extends CrudRepository<EmployeeDto, Integer>{

}
