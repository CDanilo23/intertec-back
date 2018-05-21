package com.intertec.app;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

	
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserRestController {
		
	@Autowired
	
	UserBusinessService userBusinessService;
	
	@RequestMapping(produces="application/json",value="/user/{user}",method=RequestMethod.GET)
	public Result <Boolean, List<String>,String> getSuggestedWords(@PathVariable("user") String user) {
		Result <Boolean, List<String>,String> response = userBusinessService.validateUserName(user);
		return response;
	}
}
