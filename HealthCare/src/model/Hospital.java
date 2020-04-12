package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.HospitalBean;
import util.DBConnection;

public class Hospital {
	

	
	public String insertHospital(String name, String phone, String addr1, String addr2, String addr3, String city, String email, String desc, String service, String accNo, String bank, String charge) 
	{
		String output = "";
		try 
		{
			Connection con = DBConnection.connect();
			
			if (con == null) 
			{
				return "Error while connecting to the database for inserting.";
			}
			
			// create a prepared statement
			String query = " insert into hospital"
					+ "(h_ID,h_name,h_phone,h_addrLine1,h_addrLine2,h_addrLine3,h_city,h_email,h_desc,h_services,h_accountNo,h_bank,h_charge)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, 0);    
			preparedStmt.setString(2, name);    
			preparedStmt.setString(3, phone); 
			preparedStmt.setString(4, addr1);    
			preparedStmt.setString(5, addr2); 
			preparedStmt.setString(6, addr3);    
			preparedStmt.setString(7, city); 
			preparedStmt.setString(8, email);    
			preparedStmt.setString(9, desc); 
			preparedStmt.setString(10, service);    
			preparedStmt.setString(11, accNo); 
			preparedStmt.setString(12, bank);    
			preparedStmt.setDouble(13, Double.parseDouble(charge));    
			

			//execute the statement
			preparedStmt.execute();
			con.close();
			
			output = "Inserted successfully";
		} 
		catch (Exception e) 
		{
			output = "Error while inserting the hospital.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	public List<HospitalBean> readHospital() 
	{
		List <HospitalBean> hospitalList = new ArrayList<>();
	
		try 
		{
			Connection con = DBConnection.connect();
		
			if (con == null) 
			{
				System.out.println("Error While reading from database");
				return hospitalList;
			}

		String query = "select * from hospital";
		
		Statement statement = con.createStatement();
		ResultSet resultsSet = statement.executeQuery(query);

		while (resultsSet.next()) {
			HospitalBean hos = new HospitalBean(
					resultsSet.getInt("h_ID"),
					resultsSet.getString("h_name"),
					resultsSet.getString("h_phone"),
					resultsSet.getString("h_addrLine1"),
					resultsSet.getString("h_addrLine2"),
					resultsSet.getString("h_addrLine3"),
					resultsSet.getString("h_city"),
					resultsSet.getString("h_email"),
					resultsSet.getString("h_desc"),
					resultsSet.getString("h_services"),
					resultsSet.getString("h_accountNo"),
					resultsSet.getString("h_bank"),
					resultsSet.getString("h_charge"));
					
					hospitalList.add(hos);

		}
		con.close();

		} 
		catch (Exception e) 
		{
			System.out.println("error wihile reading");
			System.err.println(e.getMessage());
		}
		
		return hospitalList;
	}
	
	public String updateHospital(String ID,String name, String phone, String addr1, String addr2, String addr3, String city, String email, String desc, String service, String accNo, String bank, String charge) {
		String output = "";
		try 
		{
			Connection con = DBConnection.connect();
			if (con == null) 
			{
				return "Error while connecting to the database for updating.";
			}
				
			// create a prepared statement
			String query = "UPDATE hospital SET" + " h_name=?," + "h_phone=?," + "h_addrLine1=?," + "h_addrLine2=?," + " h_addrLine3=?," + "h_city=?," + "h_email=?," + "h_desc=?,"
					+ "h_services=?, " + "h_accountNo=?, " + "h_bank=?, " + "h_charge=?" + "WHERE h_ID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setString(1, name);    
			preparedStmt.setString(2, phone); 
			preparedStmt.setString(3, addr1);    
			preparedStmt.setString(4, addr2); 
			preparedStmt.setString(5, addr3);    
			preparedStmt.setString(6, city); 
			preparedStmt.setString(7, email);    
			preparedStmt.setString(8, desc); 
			preparedStmt.setString(9, service);    
			preparedStmt.setString(10, accNo); 
			preparedStmt.setString(11, bank);    
			preparedStmt.setDouble(12, Double.parseDouble(charge));
			preparedStmt.setInt(13, Integer.parseInt(ID)); 
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			output = "Updated successfully";
		} 
		catch (Exception e) 
		{
			output = "Error while updating the hospital.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	public String deleteHospital(String h_ID) 
	{
		String output = "";
		try 
		{
			Connection con = DBConnection.connect();
			if (con == null) 
			{
				return "Error while connecting to the database for deleting.";
			}
			
			// create a prepared statement
			String query = "delete from hospital where h_ID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(h_ID));
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			output = "Deleted successfully";
		} 
		catch (Exception e) 
		{
			output = "Error while deleting the hospital.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
