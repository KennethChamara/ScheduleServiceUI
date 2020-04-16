package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import beans.PaymentAppointmentBean;
import util.DBConnection;

public class PaymentAppointment {
	
	
	public String InsertPayment(PaymentAppointmentBean payappbean) {
			
		String output = "";
		try {
			Connection con  =  DBConnection.connect();
			
			if (con == null) {
				return "Error while connecting to the database for payment inserting.";
			}			
			//create the insert query
			String query = "INSERT INTO tbl_payments (appointment_id,type) "+ 
						   "VALUES (?,?);";
			// create a prepared statement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values				
			preparedStmt.setInt(1, payappbean.getAppointmentID());	
			preparedStmt.setString(2, payappbean.getPaymethod());	
			// execute the statement
			preparedStmt.execute();
			
			con.close();
			
			output = "Inserted successfully";
			
		} catch (Exception e) {
			output = "Error while inserting the paydetails.";
			System.err.println(e.getMessage());
		}
		return output;	
		
	}
}
