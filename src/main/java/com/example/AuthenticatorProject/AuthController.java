package com.example.AuthenticatorProject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class AuthController {
	
	
	@Autowired
	private AuthService service;
	
	
	@RequestMapping("/signin/{email}/{password}")
	public String Signin(@PathVariable String email,@PathVariable String password)
	{
		
		return service.Signin(email,password);
		
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/signup")
	public String Signup(@RequestBody User user)
	{
		return service.Signup(user);
		
	}
	@RequestMapping("/tokencheck/{email}/{token}")
	public boolean checktoken(@PathVariable String email,@PathVariable String token)
	{
		
		return service.checktoken(email,token);
		
		
	}
	

}
