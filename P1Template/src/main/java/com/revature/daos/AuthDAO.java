package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Users;
import com.revature.utils.ConnectionUtil;

public class AuthDAO {

	//I should've made an Interace but it's ok
	
	//This DAO would likely have other methods like "register user", or "update user info"
	//but we just need a login for P0 and P1.
	
	public Users login(String username, String password) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from users where username = ? and password = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,  username);  
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			//if anything gets return at all, we know a user exists with that username/password pair. so we can create a new User object to send to the front end
			if(rs.next()) {

				Users u = new Users(
						rs.getInt("user_id"),
						rs.getString("username"),
						rs.getString("password")
						);
				return u;
				
				//nmotice we're returning a password here...probably not best practice lol
				//in a REAL application, you'd probably not want to send that back
			}
			
		} catch (SQLException e) {
			System.out.println("LOGIN FAILED");
			e.printStackTrace();
		}
		
		return null; //if no user is returned, return null. We will do a null check in the service layer
	}
	
}
