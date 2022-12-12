package com.example.AuthenticatorProject;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AuthService {
	@Autowired
	private UsersRepo usersrepo;	
	
	
	
	
	public String Signin(String email,String password)
	{
		Optional<User> u= usersrepo.findById(email);
		
		String res=u.get().signin(password);
		if(res=="null")
		{
			return "0";

		}
		else{
			usersrepo.save(u.get());
			return u.get().getSignintoken();

		}
		
		
		
	}
	public String Signup(User user)
	{
		Optional<User> u= usersrepo.findById(user.getEmail());
		if(u!=null)
		{
			return "0";
		}
		else{
			usersrepo.save(user);
			return "1";

		}
		
		
		
		
	}
	
	public boolean checktoken(String email,String token)
	{
		Optional<User> u= usersrepo.findById(email);
		if(u.get().getSignintoken().equals(token))
				return true;
		else
			return false;
		
		
		
	}

}
