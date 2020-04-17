package model;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import beans.AppointmentBean;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import util.DBConnection;

public class Appointment {
	
	public String output;
	private Connection con;
	private String query;
	private PreparedStatement preparedStmt;
	private int LastAppointmentID;
	
	
	
	public String readAppointment() {		
		output = "";
		AppointmentBean appBeanRead =  new AppointmentBean();
		try {
			 con = DBConnection.connect();
			 
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr>"+
					 "<th>AppointmentID</th>"+
					 "<th>CheckedStatus</th>"+
					 "<th>TokenNumber</th>"+
					 "<th>Another Patient Status</th>"+
					 "<th>Another Patient NIC</th>"+					 
					 "<th>Another Patient Name</th>"+
					 "<th>Another Patient Email</th>"+
					 "<th>Another Patient Contact Number</th>"+
					 "<th>d_ID</th>"+
					 "<th>SheduleID</th>"+
					 "<th>HospitalID</th>"+
					 "<th>Added Date</th>"+
					 "<th>Booked Date</th>"+
					 "</tr>";
			
			query = "SELECT * FROM appointment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// iterate through the rows in the result set
			while (rs.next()) {
				
				appBeanRead.setAppointmentID(rs.getInt("AppointmentID"));
				appBeanRead.setCheckedStatus(rs.getString("CheckedStatus"));
				appBeanRead.setTokenNumber(rs.getInt("TokenNumber"));
				appBeanRead.setAnotherPatientStatus(rs.getString("AnotherPatientStatus"));
				appBeanRead.setAnotherPatientNIC(rs.getString("AnotherPatientNIC"));
				appBeanRead.setAnotherPatientName(rs.getString("AnotherPatientName"));
				appBeanRead.setAnotherPatientEmail(rs.getString("AnotherPatientEmail"));
				appBeanRead.setAnotherPatientContactNumber(rs.getString("AnotherPatientContactNumber"));
				appBeanRead.setD_ID(rs.getInt("d_ID"));
				appBeanRead.setSheduleID(rs.getInt("SheduleID"));
				appBeanRead.setHospitalID(rs.getInt("HospitalID"));
				appBeanRead.setAddedDate(rs.getString("AddedDate"));
				appBeanRead.setBookedDate(rs.getString("BookedDate"));
				
				// Add into the HTML table
				output += "<tr><td>" + appBeanRead.getAppointmentID() + "</td>";
				output += "<td>" + appBeanRead.getCheckedStatus() + "</td>";
				output += "<td>" + appBeanRead.getTokenNumber()+ "</td>";
				output += "<td>" + appBeanRead.getAnotherPatientStatus() + "</td>";
				output += "<td>" + appBeanRead.getAnotherPatientNIC() + "</td>";
				output += "<td>" + appBeanRead.getAnotherPatientName() + "</td>";
				output += "<td>" + appBeanRead.getAnotherPatientEmail() + "</td>";
				output += "<td>" + appBeanRead.getAnotherPatientContactNumber()+ "</td>";
				output += "<td>" + appBeanRead.getD_ID() + "</td>";
				output += "<td>" + appBeanRead.getSheduleID() + "</td>";
				output += "<td>" + appBeanRead.getHospitalID() + "</td>";		
				output += "<td>" + appBeanRead.getAddedDate() + "</td>";
				output += "<td>" + appBeanRead.getBookedDate() + "</td></tr>";	
				
			}
			con.close();
			
			// Complete the html table
			output += "</table>";
			
		} catch (Exception e) {
			output = "Error while reading the Appointments.";
			System.err.println(e.getMessage());
		}
		return output;
	}
  
	public String insertAppointment(AppointmentBean appointment	){			
		
		output = "";
		
		try {
			
			con = DBConnection.connect();
			 
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			
			// create a prepared statement
			query = "INSERT INTO appointment ( CheckedStatus, TokenNumber, AnotherPatientStatus, AnotherPatientNIC, AnotherPatientName, AnotherPatientEmail, AnotherPatientContactNumber, d_ID, SheduleID, HospitalID,BookedDate,AddedDate) "+ 
					" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,CURDATE());";
			preparedStmt = con.prepareStatement(query);
			// binding values				
			preparedStmt.setString(1, appointment.getCheckedStatus());
			preparedStmt.setInt(2, appointment.getTokenNumber());
			preparedStmt.setString(3, appointment.getAnotherPatientStatus());
			preparedStmt.setString(4, appointment.getAnotherPatientNIC());
			preparedStmt.setString(5, appointment.getAnotherPatientName());
			preparedStmt.setString(6, appointment.getAnotherPatientEmail());
			preparedStmt.setString(7, appointment.getAnotherPatientContactNumber());
			preparedStmt.setInt(8, appointment.getD_ID());
			preparedStmt.setInt(9, appointment.getSheduleID());
			preparedStmt.setInt(10, appointment.getHospitalID());
			preparedStmt.setString(11, appointment.getBookedDate());

			// execute the statement
			preparedStmt.execute();
			
			//get the AppointmentID of the current inserted row & assign it to LastAppointmentID variable
			GetAppointmentIdOfRecentInsert(con);
			//insert into related Payment Tables 
			GetInsertServiceFromPayment(appointment);
			
			con.close();
			output = "Inserted successfully to Appointment";
		    
			
		} catch (Exception e) {
			output = "Error while inserting the Appointment.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	public void GetAppointmentIdOfRecentInsert(Connection con) {		
		
		try {			
			query = "SELECT AppointmentID FROM appointment ORDER BY AppointmentID DESC LIMIT 1;";
			preparedStmt = con.prepareStatement(query);
			ResultSet rs = preparedStmt.executeQuery(query);			
			// iterate through the rows in the result set			
			while (rs.next()) {
				LastAppointmentID = rs.getInt("AppointmentID");
			}
		}catch (Exception e) {
			System.out.println("Error In Fetching Last Row of Appointment Table ");
		}
		
	}
	
	//this method call payment API and insert appointment details to  payment table
	public String  GetInsertServiceFromPayment(AppointmentBean appointment)
	{
		try {
			MediaType JSONType = MediaType.get("application/json; charset=utf-8");
			OkHttpClient client = new OkHttpClient();			
			RequestBody body = RequestBody.create( "{ 'AppointmentID':'"+LastAppointmentID+"','PaymentType':'"+appointment.getPaymentType()+"','Amount':'"+appointment.getAmount()+"'}",JSONType);
			Request request = new Request.Builder()
				        .url("http://localhost:8080/PaymentService/api/payment/insertPaymentFromAppointment")
				        .post(body)
				        .build();
			
			 try (Response response = client.newCall(request).execute()) {
				 return response.body().string();
			 }
		}catch (Exception e) {
			System.out.println("Error in GetInsertSeviveFromPayment " + e);
		}
		return "Inserted Successfull to payment";
	}
	 
	
		
	public String updateAppointment(AppointmentBean appointment) {
	
	   output = "";
	   
		try {		
			con = DBConnection.connect();
			
			if (con == null) {
				return "Error while connecting to the database for Updating.";
			}
			
			// create a prepared statement
			query = " UPDATE appointment SET "+
						   " CheckedStatus=?, "+
						   " TokenNumber = ?,"+
							" AnotherPatientStatus=?, "+
							" AnotherPatientNIC = ?," +
							" AnotherPatientName= ?, "+
						    " AnotherPatientEmail = ?, "+
							" AnotherPatientContactNumber = ?, "+
							" d_ID = ?, "+
							" SheduleID = ?, "+
							" HospitalID =?, "+
							" BookedDate = ?, "+
							" AddedDate = ?	"+							
							" WHERE AppointmentID = ? ;";
			
			preparedStmt = con.prepareStatement(query);
			// binding values				
			preparedStmt.setString(1, appointment.getCheckedStatus());
			preparedStmt.setInt(2, appointment.getTokenNumber());
			preparedStmt.setString(3, appointment.getAnotherPatientStatus());
			preparedStmt.setString(4, appointment.getAnotherPatientNIC());
			preparedStmt.setString(5, appointment.getAnotherPatientName());
			preparedStmt.setString(6, appointment.getAnotherPatientEmail());
			preparedStmt.setString(7, appointment.getAnotherPatientContactNumber());
			preparedStmt.setInt(8, appointment.getD_ID());
			preparedStmt.setInt(9, appointment.getSheduleID());
			preparedStmt.setInt(10, appointment.getHospitalID());	
			preparedStmt.setString(11, appointment.getBookedDate());
			preparedStmt.setString(12, appointment.getAddedDate());
			preparedStmt.setInt(13, appointment.getAppointmentID());	

			// execute the statement
			preparedStmt.executeUpdate();	
			
			con.close();
			
			output = "Updated successfully ";
			GetUpdatetServiceFromPayment(appointment);
		} catch (Exception e) {
			output = "Error while Updating the Appointment.";
			System.err.println(e.getMessage());
		}
		
		return output;

	} 
	
	//this method call payment API and update appointment details to  payment table
	public String  GetUpdatetServiceFromPayment(AppointmentBean appointment)
	{
		
		try {
			MediaType JSONType = MediaType.get("application/json; charset=utf-8");
			OkHttpClient client = new OkHttpClient();		
			RequestBody body = RequestBody.create( "{ 'AppointmentID':'"+appointment.getAppointmentID()+"','PaymentType':'"+appointment.getPaymentType()+"','Amount':'"+appointment.getAmount()+"'}",JSONType);
			Request request = new Request.Builder()
				        .url("http://localhost:8080/PaymentService/api/payment/updatePaymentFromAppointment")
				        .put(body)
				        .build();
			
			 try (Response response = client.newCall(request).execute()) {
				 return response.body().string();
			 }
		}catch (Exception e) {
			System.out.println("Error in GetUpdateSeviveFromPayment " + e);
		}
		return "Update Successfull to payment";
	}


    public String deleteAppointement(AppointmentBean appointment) {
	   output = "";
		try {
			
			//first call delete method from paymnet and delete the payment method
			GetDeleteServiceFromPayment(appointment);
			
			con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for Deleting.";
			}
			// create a prepared statement
			query = " DELETE FROM appointment where AppointmentID = ?";
			preparedStmt = con.prepareStatement(query);
			// binding values					
			preparedStmt.setInt(1, appointment.getAppointmentID());	
			// execute the statement
			preparedStmt.executeUpdate();
			con.close();
			output = "Deleting successfully";
		} catch (Exception e) {
			output = "Error while Deleting the Appointment.";
			System.err.println(e.getMessage());
		}
		return output;
    }
	
    //this method call payment API and delete appointment details to  payment table
  	public String  GetDeleteServiceFromPayment(AppointmentBean appointment)
  	{
  		
  		try {
	  		MediaType JSONType = MediaType.get("application/json; charset=utf-8");
	  		OkHttpClient client = new OkHttpClient();		
	  		RequestBody body = RequestBody.create( "{ 'AppointmentID':'"+appointment.getAppointmentID()+"'}",JSONType);
	  		Request request = new Request.Builder()
	  			        .url("http://localhost:8080/PaymentService/api/payment/deletePaymentFromAppointment")
	  			        .delete(body)
	  			        .build();
	  		
	  		 try (Response response = client.newCall(request).execute()) {
	  			 return response.body().string();
	  		 }
  		}catch (Exception e) {
  			System.out.println("Error in GetDeleteSeviveFromPayment " + e);
  		}
  		return "Delete Successfull to Payment";
  	}
	 

}
