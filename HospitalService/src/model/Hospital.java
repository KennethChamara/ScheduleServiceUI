package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.HospitalBean;
import util.DBConnection;

public class Hospital 
{
	public String insertHospital(HospitalBean hos) 
	{
		String output = "";
		
		try 
		{
			Connection con = DBConnection.connect();
			
			if (con == null) 
			{return "Error while connecting to the database for inserting."; }
			
			// create a prepared statement
			String query = " insert into hospital"
					+ "(h_ID,h_name,h_phone,h_addrLine1,h_addrLine2,h_addrLine3,h_city,h_email,h_desc,h_services,h_accountNo,h_bank,h_charge)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, 0);    
			preparedStmt.setString(2, hos.getHospitalName());    
			preparedStmt.setString(3, hos.getHospitalPhone()); 
			preparedStmt.setString(4, hos.getHospitalAddrLine1());    
			preparedStmt.setString(5, hos.getHospitalAddrLine2()); 
			preparedStmt.setString(6, hos.getHospitalAddrLine3());    
			preparedStmt.setString(7, hos.getHospitalCity()); 
			preparedStmt.setString(8, hos.getHospitalEmail());    
			preparedStmt.setString(9, hos.getHospitalDesc()); 
			preparedStmt.setString(10, hos.getHospitalServices());    
			preparedStmt.setString(11, hos.getHospitalAccNo()); 
			preparedStmt.setString(12, hos.getHospitalBank());    
			preparedStmt.setDouble(13, Double.parseDouble(hos.getHospitalCharge()));

			//execute the statement
			preparedStmt.execute();
			con.close();
			
			output = "Hospital details have been successfully inserted";
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

			while (resultsSet.next()) 
			{
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
	
	
	public String updateHospital(HospitalBean hos) 
	{
		String output = "";
		
		try {
			Connection con = DBConnection.connect();
			
			if (con == null) 
			{return "Error while connecting to the database for updating."; }
			
			// create a prepared statement
			String query = "UPDATE hospital SET" + " h_name=?," + "h_phone=?," + "h_addrLine1=?," + "h_addrLine2=?," + " h_addrLine3=?," + "h_city=?," + "h_email=?," + "h_desc=?,"
					+ "h_services=?, " + "h_accountNo=?, " + "h_bank=?, " + "h_charge=?" + "WHERE h_ID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, hos.getHospitalName());    
			preparedStmt.setString(2, hos.getHospitalPhone()); 
			preparedStmt.setString(3, hos.getHospitalAddrLine1());    
			preparedStmt.setString(4, hos.getHospitalAddrLine2()); 
			preparedStmt.setString(5, hos.getHospitalAddrLine3());    
			preparedStmt.setString(6, hos.getHospitalCity()); 
			preparedStmt.setString(7, hos.getHospitalEmail());    
			preparedStmt.setString(8, hos.getHospitalDesc()); 
			preparedStmt.setString(9, hos.getHospitalServices());    
			preparedStmt.setString(10, hos.getHospitalAccNo()); 
			preparedStmt.setString(11, hos.getHospitalBank());    
			preparedStmt.setDouble(12, Double.parseDouble(hos.getHospitalCharge()));
			preparedStmt.setInt(13, hos.getId());
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			output = "Hospital details have been successfully updated.";
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
			{return "Error while connecting to the database for deleting."; }
			
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
