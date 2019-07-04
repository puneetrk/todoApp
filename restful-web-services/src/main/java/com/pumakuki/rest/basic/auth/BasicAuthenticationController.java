package com.pumakuki.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BasicAuthenticationController {
	
	

	@GetMapping(path="/puneet")
	String getMessage(){
		return "Hello Puneet";
	}
	
	@GetMapping(path="/hello-world-bean")
	AuthenticationBean getHellowWorldBean(){
		return new AuthenticationBean("Hello Puneet");
	}
	
	@GetMapping(path ="/hello-world/user/{name}")
	AuthenticationBean getHellowWorldPathVariable(@PathVariable String name){
		 //throw new RuntimeException("Something something went wrong");
		return new AuthenticationBean(String.format("Hello %s",name));
	}
	
	
	
}
