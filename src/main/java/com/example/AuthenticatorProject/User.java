package com.example.AuthenticatorProject;
import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Users")
public class User {
	@Id
	private String email;
	private String password;
	private String Signintoken;
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public boolean changePassword(String oldpassword,String password) {
		if(this.password==oldpassword)
		{
			this.password = password;
			return true;
		}
		else 
			return false;
			
	}
	public String getSignintoken() {
		return Signintoken;
	}
	public String signin(String pass) {
		if(pass.equals(this.password))
		{
			Random rand = new Random();
			int token = rand.nextInt(450000); 
			this.Signintoken=String.valueOf(token);;
			return String.valueOf(token);
		}
		else 
		{
			return "null";
		}
	}
	public String getEmail() {
		return email;
	}
	

}
