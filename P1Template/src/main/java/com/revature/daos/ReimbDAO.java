package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

public class ReimbDAO {
//all reimb table except approve/deny table
	
	//int amount, Timestamp submitted, int type_id_fk
	
	public boolean submitReimb (Reimbursement reimbursement) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into ers_reimbursement (reimb_amount, reimb_submitted, reimb_type_id) values (?, now(), ?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//input the appropriate values into our PreparedStatement
			ps.setInt(1, reimbursement.getAmount());
			ps.setInt(2, reimbursement.getType_id_fk());
			
			//execute the update!
			ps.executeUpdate();
			
			//tell the console the update was successfully
			System.out.println("Request Successfully Submitted!");
			
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