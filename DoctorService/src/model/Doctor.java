package model;

import java.sql.*;
import java.util.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import com.google.gson.JsonObject;

import beans.DoctorBean;
import util.DBConnection;

public class Doctor {
		
	
	
	
public String insertDoctor(DoctorBean doctor) {
	String output = "";
	try {
		Connection con = DBConnection.connect();
		if (con == null) {
			return "Error while connecting to the database for inserting.";
		}
// create a prepared statement

		String query = "INSERT INTO `doctors`"
						+"(`d_ID`, `d_fname`, `d_lname`, `d_NIC`, `d_phone`, `d_email`, `d_adline1`, `d_adline2`, `d_adline3`, `d_city`, `d_speciality`, `d_working_hospital`, `d_bank`, `d_cardtype`, `d_bankaccno`, `d_charge`)" 
						+"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		
		PreparedStatement preparedStmt = con.prepareStatement(query);

// binding values
		preparedStmt.setInt(1, 0);
		preparedStmt.setString(2, doctor.getFname());
		preparedStmt.setString(3, doctor.getLname());
		preparedStmt.setString(4, doctor.getNic());
		preparedStmt.setString(5, doctor.getPhone());
		preparedStmt.setString(6, doctor.getEmail());
		preparedStmt.setString(7, doctor.getAdline1());
		preparedStmt.setString(8, doctor.getAdline2());
		preparedStmt.setString(9, doctor.getAdline3());
		preparedStmt.setString(10, doctor.getCity());
		preparedStmt.setString(11, doctor.getSpeciality());
		preparedStmt.setString(12, doctor.getWorkinghospital());
		preparedStmt.setString(13, doctor.getBank());
		preparedStmt.setString(14, doctor.getCardtype());
		preparedStmt.setString(15, doctor.getCardno());
		preparedStmt.setString(16, doctor.getCharge());

			
// execute the statement
		preparedStmt.execute();
		
		JsonObject msg = new JsonObject();
		msg.addProperty("id", keyGen());
		msg.addProperty("username", doctor.getUsername());
		msg.addProperty("password", doctor.getPassword());
		msg.addProperty("role", "doctor");
		
		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "admin");
	    Client client = ClientBuilder.newBuilder().register(feature).build();
		WebTarget webTarget = client.target("http://localhost:8081/AuthService/AuthService").path("users");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(msg.toString(), MediaType.APPLICATION_JSON));
		

		con.close();
		output = "Successfully Inserted a Doctor to the System";
		System.out.println(output);
	} catch (Exception e) {
		output = "Error while inserting a doctor.";
		System.err.println(e.getMessage());
	}
	return output;
}

	
	

	//view list of doctors	
	public List<DoctorBean> viewDoctors() {
		
		return	viewDoctors(0);

	}
	
	//View the Doctor by ID
	public DoctorBean viewDoctorById(int id) {
	List<DoctorBean> list =viewDoctors(id);
		if(!list.isEmpty()) {
			return	list.get(0);
		}
		return null;
	}
	
	
	
	
	//view method
	public List<DoctorBean> viewDoctors(int id) {
			List <DoctorBean> doctorList = new ArrayList<>();
			
		try 
		{
			Connection con = DBConnection.connect();
			if (con == null) {
				
				System.out.println("Error While reading from database");
				return doctorList;
			}

			String query;
			
			if(id==0) {
			query = "select * from doctors";
			}
			else {
				query = "select * from doctors where d_ID="+id;	
			}
			Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery(query);

			while (results.next()) {
				DoctorBean doc = new DoctorBean(
												results.getInt("d_ID"),
												results.getString("d_fname"),
												results.getString("d_lname"),
												results.getString("d_NIC"),
												results.getString("d_phone"),
												results.getString("d_email"),
												results.getString("d_adline1"),
												results.getString("d_adline2"),
												results.getString("d_adline3"),
												results.getString("d_city"),
												results.getString("d_speciality"),
												results.getString("d_working_hospital"),
												results.getString("d_bank"),
												results.getString("d_cardtype"),
												results.getString("d_bankaccno"),
												results.getString("d_charge")
												
											);
//				doc.setId(results.getInt("d_ID"));
//				doc.setFname(results.getString("d_fname"));
//				doc.setLname(results.getString("d_lname"));
//				doc.setN
//				
				doctorList.add(doc);

			}
			con.close();

		}
		catch (Exception e) {
			System.out.println("Error While Reading");
			System.err.println(e.getMessage());
		}
		
		return doctorList;
	}
	
	

	//Update Doctor Details
	public String updateDoctor(DoctorBean dct) {
		String output = "";
		
		try 
		{
			Connection con = DBConnection.connect();
			
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			
			
			//Prepared Statement
			
			String query = "UPDATE `doctors` SET"
							+"`d_fname`=?,`d_lname`=?,`d_NIC`=?,"
							+"`d_phone`=?,`d_email`=?,`d_adline1`=?,`d_adline2`=?,"
							+"`d_adline3`=?,`d_city`=?,`d_speciality`=?,`d_working_hospital`=?,"
							+"`d_bank`=?,`d_cardtype`=?,`d_bankaccno`=?,`d_charge`=?"
							+"WHERE `d_ID`=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			
			// binding values
			preparedStmt.setString(1, dct.getFname());
			preparedStmt.setString(2, dct.getLname());
			preparedStmt.setString(3, dct.getNic());			
			preparedStmt.setString(4, dct.getPhone());
			preparedStmt.setString(5, dct.getEmail());
			preparedStmt.setString(6, dct.getAdline1());
			preparedStmt.setString(7, dct.getAdline2());
			preparedStmt.setString(8, dct.getAdline3());
			preparedStmt.setString(9, dct.getCity());
			preparedStmt.setString(10, dct.getSpeciality());
			preparedStmt.setString(11, dct.getWorkinghospital());
			preparedStmt.setString(12, dct.getBank());
			preparedStmt.setString(13, dct.getCardtype());
			preparedStmt.setString(14, dct.getCardno());
			preparedStmt.setString(15, dct.getCharge());
			
			preparedStmt.setInt(16, dct.getId());
			
			

			// Prepared Statement Execution
			preparedStmt.execute();
			con.close();
			output = "Successfully Updated "+ dct.getFname()+ " " + dct.getLname();
			
		} 
		catch (Exception e) {
			output = "Error while updating the Doctor.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	

	public String removeDoctor(String doctorID) {
		String output = "";
		
		try 
		{
			Connection con = DBConnection.connect();
		
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			
			
			// Prepared Statement
			String query = "delete from doctors where d_ID=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);

			
			// Binding values
			preparedStmt.setInt(1, Integer.parseInt(doctorID));

			
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
			
		} 
		catch (Exception e) {
			output = "Error while deleting the Doctor.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	public int keyGen() {
		List<DoctorBean> list ;
		list = viewDoctors();
		int num = list.size()+10;
		return num;
		
	}


}
