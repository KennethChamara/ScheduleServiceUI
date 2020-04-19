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
			String query = "INSERT INTO tbl_payments (appointment_id,type,amount) "+ 
						   "VALUES (?,?,?);";
			// create a prepared statement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values				
			preparedStmt.setInt(1, payappbean.getAppointmentID());	
			preparedStmt.setString(2, payappbean.getPaymethod());
			preparedStmt.setDouble(3, payappbean.getAmount());	
			// execute the statement
			preparedStmt.execute();
			
			con.close();
			
			output = "Payment inserted successfully";
			
		} catch (Exception e) {
			output = "Error while inserting the paydetails.";
			System.err.println(e.getMessage());
		}
		return output;	
		
	}
	
	
	public String UpdatePayment(PaymentAppointmentBean payappbean) {
		
		String output = "";
		try {
			Connection con  =  DBConnection.connect();
			
			if (con == null) {
				return "Error while connecting to the database for payment inserting.";
			}			
			//create the insert query
			String query = "UPDATE tbl_payments SET amount = ? , type = ? WHERE appointment_id = ?;";
			// create a prepared statement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values				
			preparedStmt.setDouble(1, payappbean.getAmount());	
			preparedStmt.setString(2, payappbean.getPaymethod());
			preparedStmt.setInt(3, payappbean.getAppointmentID());	
			// execute the statement
			preparedStmt.executeUpdate();
			
			con.close();
			
			output = "Payment updated successfully";
			
		} catch (Exception e) {
			output = "Error while Updating the paydetails.";
			System.err.println(e.getMessage());
		}
		return output;	
		
	}
	
	public String DeletePayment(PaymentAppointmentBean payappbean) {
		
		String output = "";
		try {
			Connection con  =  DBConnection.connect();
			
			if (con == null) {
				return "Error while connecting to the database for payment inserting.";
			}			
			//create the insert query
			String query = "DELETE FROM tbl_payments WHERE  appointment_id = ?;";
			// create a prepared statement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values				
			preparedStmt.setInt(1, payappbean.getAppointmentID());	
			// execute the statement
			preparedStmt.execute();
			
			con.close();
			
			output = "Payment deleted successfully";
			
		} catch (Exception e) {
			output = "Error while DELETING the paydetails.";
			System.err.println(e.getMessage());
		}
		return output;	
		
	}
	
	
}
