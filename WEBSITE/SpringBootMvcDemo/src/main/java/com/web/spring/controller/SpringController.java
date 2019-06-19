package com.web.spring.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.web.spring.dto.EmployeeDto;
import com.web.spring.dto.EmployeePojo;
import com.web.spring.dto.UserDetailDto;

@Controller
public class SpringController {
	RestTemplate getemployee = new RestTemplate();
	RestTemplate addemployeeRest = new RestTemplate();

	@RequestMapping("/")
	public ModelAndView greet() {
		return new ModelAndView("index");
	}

	/*
	 * @RequestMapping(value="/signIn",method=RequestMethod.POST) public String
	 * signIn(@ModelAttribute("signIn") UserDetailDto emp,BindingResult b,Model m) {
	 * 
	 * 
	 * HttpHeaders headers = new HttpHeaders(); headers.set("X-COM-LOCATION",
	 * "USA");
	 * 
	 * HttpEntity<EmployeeDto> request = new HttpEntity<>(emp, headers);
	 * 
	 * String
	 * emp1=addemployeeRest.postForObject("http://localhost:1235/addEmployee",
	 * request, String.class); //EmployeePojo[]
	 * 
	 * EmployeeDto[]
	 * employeeList=getemployee.getForObject("http://localhost:1235/getAll",
	 * EmployeeDto[].class);
	 * m.addAttribute("employeeList",Arrays.asList(employeeList));
	 * 
	 * return "redirect:/getAll";
	 * 
	 * }
	 */

	/*
	 * @RequestMapping(value = "/signUp", method = RequestMethod.POST) public String
	 * signUP(@ModelAttribute("signUp") UserDetailDto signUp, BindingResult b) {
	 * 
	 * HttpHeaders headers = new HttpHeaders(); headers.set("X-COM-LOCATION",
	 * "USA");
	 * 
	 * HttpEntity<UserDetailDto> request = new HttpEntity<>(signUp, headers); String
	 * emp1 = addemployeeRest.postForObject("http://localhost:1234/signUp", request,
	 * String.class); // EmployeePojo[]
	 * 
	 * 
	 * EmployeeDto[]
	 * employeeList=getemployee.getForObject("http://localhost:1235/getAll",
	 * EmployeeDto[].class);
	 * m.addAttribute("employeeList",Arrays.asList(employeeList));
	 * 
	 * 
	 * return "redirect:/getAll";
	 * 
	 * }
	 */
	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
	public ModelAndView getEmployee(@ModelAttribute("emp") EmployeePojo emp, BindingResult b) {

		// EmployeePojo[]
		return new ModelAndView("employeeList");

	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute("emp") EmployeeDto emp, BindingResult b, Model m) {

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-LOCATION", "USA");

		HttpEntity<EmployeeDto> request = new HttpEntity<>(emp, headers);

		String emp1 = addemployeeRest.postForObject("http://localhost:1235/addEmployee", request, String.class); // EmployeePojo[]

		EmployeeDto[] employeeList = getemployee.getForObject("http://localhost:1235/getAll", EmployeeDto[].class);
		m.addAttribute("employeeList", Arrays.asList(employeeList));
		return new ModelAndView("employeeList");

	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ModelAndView getAll(Model m, @ModelAttribute("emp") EmployeeDto emp, BindingResult b) {
		EmployeeDto[] employeeList = getemployee.getForObject("http://localhost:1235/getAll", EmployeeDto[].class);

		m.addAttribute("employeeList", Arrays.asList(employeeList));

		return new ModelAndView("employeeList");

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delteById(@PathVariable int id, @ModelAttribute("emp") EmployeeDto emp, BindingResult b, Model m) {

		Map<String, String> params = new HashMap<String, String>();
		String id1 = String.valueOf(id);
		params.put("id", id1);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:1235/delete/{id}", params);

		System.out.println("SuccessFul delete Id===" + id);

		// EmployeeDto[]
		// employeeList=getemployee.getForObject("http://localhost:1235/getAll",
		// EmployeeDto[].class);

		// m.addAttribute("employeeList",Arrays.asList(employeeList));
		return "redirect:/getAll";

	}

}
