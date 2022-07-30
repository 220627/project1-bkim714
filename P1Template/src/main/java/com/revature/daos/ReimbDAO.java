package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.Users;
import com.revature.utils.ConnectionUtil;

public class ReimbDAO {
//all reimb table except approve/deny table

	// int amount, Timestamp submitted, int type_id_fk

	public boolean submitReimb(Reimbursement reimbursement, Users b) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			System.out.println(b.getUser_id());

			String sql = "insert into ers_reimbursement (reimb_amount, reimb_submitted, reimb_type_id, reimb_author) values (?, now(), ?, ?);";

			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(reimbursement.getAmount());
			ps.setInt(1, reimbursement.getAmount());
			ps.setInt(2, reimbursement.getType_id_fk());
			ps.setInt(3, b.getUser_id());

			ps.executeUpdate();

			System.out.println("Request Successfully Submitted!");

			return true;
		} catch (SQLException e) {
			System.out.println("failed to update");
			e.printStackTrace();
		}
		return false;

	}

	public ArrayList<Reimbursement> viewReimb() {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "select * from ers_reimbursement;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			ArrayList<Reimbursement> reimbList = new ArrayList<>();
			while (rs.next()) {

				Reimbursement reimb = new Reimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_amount"), null,
						rs.getInt("reimb_author"), rs.getInt("reimb_resolver"), rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")

				);

				reimbList.add(reimb);
			} return reimbList;

		} catch (SQLException e) {
			System.out.println("Get Role failed");
			e.printStackTrace();
		}
		return null;
	}
	
	
public boolean updateStatus(Reimbursement reimb) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
		
			String sql = "update ers_reimbursement set reimb_status_id = ? where reimb_id =?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reimb.getStatus_id_fk());
			ps.setInt(2, reimb.getReimb_id());
			
			ps.executeUpdate();
			
			System.out.println("Approve/Deny worked");
			
			return true;
		} catch (SQLException e) {
			System.out.println("failed to update");
			e.printStackTrace();
		}
		
		return false; 
	}
	

}

//reimb_id serial PRIMARY KEY,
//reimb_amount int,
//reimb_submitted timestamp,
//reimb_author int,
//reimb_resolver int,
//reimb_status_id int,
//reimb_type_id int,
//CONSTRAINT ers_users_fk_auth FOREIGN KEY (reimb_author) REFERENCES ers_users(ers_users_id),
//CONSTRAINT ers_users_fk_reslvr FOREIGN KEY (reimb_resolver) REFERENCES ers_users(ers_users_id),
//CONSTRAINT ers_reimbursement_status_fk FOREIGN KEY (reimb_status_id) REFERENCES ers_reimbursement_status(reimb_status_id),
//CONSTRAINT ers_reimbursement_type_fk FOREIGN KEY (reimb_type_id) REFERENCES ers_reimbursement_type(reimb_type_id)