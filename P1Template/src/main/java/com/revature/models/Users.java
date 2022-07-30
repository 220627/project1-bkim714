package com.revature.models;

public class Users {

	private int user_id;                //REFACTOR TO INCLUDE EVERYTHING ELSE, BASELINE TO TEST CONNECTION
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String email;
	private int role_id_fk;
	private UserRoles role;
	
//	public UserRoles getRole() {
//		return role;
//	}
//	public void setRole(UserRoles role) {
//		this.role = role;
//	}

	public Users(int user_id, String username, String password) {  //might not need this later
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
	}


	public Users(int user_id, String username, String password, String first_name, String last_name, String email,
			int role_id_fk, UserRoles role) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.role_id_fk = role_id_fk;
		this.role = role;
	}



	public Users(String username, String password, String first_name, String last_name, String email, int role_id_fk) {
		super();
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.role_id_fk = role_id_fk;
	}




	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", username=" + username + ", password=" + password + ", first_name="
				+ first_name + ", last_name=" + last_name + ", email=" + email + ", role_id_fk=" + role_id_fk
				+ ", role=" + role + "]";
	}



	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getRole_id_fk() {
		return role_id_fk;
	}



	public void setRole_id_fk(int role_id_fk) {
		this.role_id_fk = role_id_fk;
	}



	public UserRoles getRole() {
		return role;
	}



	public void setRole(UserRoles role) {
		this.role = role;
	}



	
	
	
	
}
