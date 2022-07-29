package com.revature.services;

import com.revature.daos.AuthDAO;
import com.revature.models.Users;

//The service layer is where we put any other business logic that doesn't deal with:
//parsing HTTP Requests and sending REsponses (which is the job of the Controllers)
//talking to the database(which is th ejob of the DAOs)
//So in this case, we want to take in a LoginDTO, and determine if its values get a "true" returned from the DAO
//In a more fleshed out application, this class would create a new User object from the DAO and send it to the controller
public class AuthService {

	AuthDAO aDAO = new AuthDAO();
	
	public Users login(String username, String password) {
		
		if(aDAO.login(username, password) != null) {
			return aDAO.login(username, password);  //if the username and password get a "true" from the DAO, send the username back
		}
		return null; //if login fails, return null
	}
	
	
	
}
