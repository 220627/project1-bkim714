package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.daos.ReimbDAO;
import com.revature.models.Reimbursement;
import com.revature.models.Users;

import io.javalin.http.Handler;

public class ReimbController {

	ReimbDAO rDAO = new ReimbDAO();

	public Handler submitReimbHandler = (ctx) -> {
		String body = ctx.body();
		Gson gson = new Gson();
		Reimbursement newReimb = gson.fromJson(body, Reimbursement.class);
		AuthController.ses = ctx.req.getSession();

		Users b = (Users) AuthController.ses.getAttribute("current_user"); // test string
		if (rDAO.submitReimb(newReimb)) {
			ctx.status(202);
		} else {
			ctx.status(406);
		}
	};

	public Handler viewReimbHandler = (ctx) -> {

		if (AuthController.ses != null) {

			ArrayList<Reimbursement> reimbList = rDAO.viewReimb(); // refactor (use "User object" to create more
																	// accurate funcitonality)

			Gson gson = new Gson();

			String JSONemployees = gson.toJson(reimbList);

			ctx.result(JSONemployees);
			ctx.status(200);
		} else {
			ctx.result("you are not logged in!!");
			ctx.status(401);
		}
	};

	public Handler updateStatusController = (ctx) -> {

		Gson gson = new Gson();
		Reimbursement reimb = gson.fromJson(ctx.body(), Reimbursement.class); 
		
		if (rDAO.updateStatus(reimb)) {
			ctx.status(202); 
		} else {
			ctx.status(406); 
		}
	};

}
