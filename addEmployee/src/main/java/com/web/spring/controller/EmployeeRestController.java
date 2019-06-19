package com.web.spring.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.client.http.HttpRequest;
import com.web.spring.model.EmployeeDto;
import com.web.spring.service.AddEmployeeService;

import io.swagger.annotations.ApiOperation;


@RestController
@CrossOrigin
public class EmployeeRestController {
	
	@Autowired
	AddEmployeeService empService;
	/*
	 * @ApiOperation(value = "View a list of available products",response =
	 * Iterable.class)
	 * 
	 * @ApiResponse(value = {
	 * 
	 * @ApiResponse(code = 200, message = "Successfully retrieved list"),
	 * 
	 * @ApiResponse(code = 401, message =
	 * "You are not authorized to view the resource"),
	 * 
	 * @ApiResponse(code = 403, message =
	 * "Accessing the resource you were trying to reach is forbidden"),
	 * 
	 * @ApiResponse(code = 404, message =
	 * "The resource you were trying to reach is not found") }
	 */
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String greet(){
		return "Welcome to Add Employee!!!!!!";
	}
	
	
	  @RequestMapping(value="/addEmployee",method=RequestMethod.POST)
	  public EmployeeDto saveEmployee(@RequestBody EmployeeDto dto){
	  
	  System.out.println("Add employee Request");
	 // dto.setEmpAddress("Noida");
	//  dto.setEmpAge(12);
	//  dto.setEmpName("Anand");
	//  dto.setSalary(123l);
	  return empService.saveEmployee(dto); }
	/*
	 * @RequestMapping(value="/getAll",method=RequestMethod.GET) public
	 * List<EmployeeDto> getEmployee(@RequestBody EmployeeDto dto) {
	 * 
	 * return (List<EmployeeDto>) empService.getEmployee();
	 * 
	 * }
	 */
	
	  @RequestMapping(value="/getAll",method=RequestMethod.GET)
	  public ResponseEntity<List<EmployeeDto>> listAllUsers(HttpServletRequest req) {
	        
		  System.out.println("ip Address======="+req.getRemoteHost());
		  List<EmployeeDto> users = (List<EmployeeDto>) empService.getEmployee();
	        if (users.isEmpty()) {
	            return new ResponseEntity(HttpStatus.NO_CONTENT);
	            // You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<EmployeeDto>>(users, HttpStatus.OK);
	    }
	  
	  @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	  public void deleteById(@RequestBody @PathVariable int id) {
		  empService.deleteById(id);
	  }
	/*
	 * @RequestMapping(value="/editById/{id}",method=RequestMethod.GET) public
	 * ResponseEntity<EmployeeDto> editById(@RequestBody @PathVariable int id) {
	 * 
	 * EmployeeDto users= empService.editById(id); return new
	 * ResponseEntity<EmployeeDto>(users,HttpStatus.OK); }
	 */
	  
}
