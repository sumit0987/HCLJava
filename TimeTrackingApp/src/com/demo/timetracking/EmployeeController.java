package com.demo.timetracking;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void saveEmployee(@RequestBody Employee emp) {
		
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Employee getEmployee(@RequestParam(value = "key") String key, @RequestBody Employee emp) {
		return new Employee();
	}
	
}
