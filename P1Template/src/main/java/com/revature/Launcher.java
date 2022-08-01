package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbController;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("CONNECTION SUCCESSFUL :)");
		} catch (SQLException e) {
			System.out.println("connection failed...");
			e.printStackTrace();
		}
		
		
		//Test/Create Front End connection
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins();
				}
				).start(3000);
		
		ReimbController rc = new ReimbController();
		AuthController ac = new AuthController();
		
		app.post("/login", ac.loginHandler);
		app.post("/submit", rc.submitReimbHandler);
		app.get("/view", rc.viewReimbHandler);
		app.put("/status", rc.updateStatusController);
		
		
	}
	//public static Logger log = LogManager.getLogger();
	
}
