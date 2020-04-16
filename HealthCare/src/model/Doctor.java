package model;

import java.sql.*;
import java.util.*;

import beans.DoctorBean;
import util.DBConnection;

public class Doctor {
		

	
	//Insert a Doctor
//	public String insertDoctor(DoctorBean dct) {
	public String insertDoctor(String dFname,String dLname,String dNIC,String dPhone,String dEmail,String dAdline1,String dAdline2,String dAdline3,String dCity,String dSpeciality,String dWorkinghospital,String dBank,String dCardtype,String dCardno,String dCharge) {

		String output = "";
		
		try 
		{
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			
			
			// Prepared Statement
//			String query = " insert into doctors"
//							+ "(d_ID,d_fname,d_lname,d_NIC,d_phone,d_email,d_adline1,d_adline2,d_adline3,d_city,d_speciality,d_working_hospital,d_bank,d_cardtype,d_bankaccno,d_charge)"
//							+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//			
			
//			INSERT INTO `doctors`(`d_ID`, `d_fname`, `d_lname`, `d_NIC`, `d_phone`, `d_email`, `d_adline1`, `d_adline2`, `d_adline3`, `d_city`, `d_speciality`, `d_working_hospital`, `d_bank`, `d_cardtype`, `d_bankaccno`, `d_charge`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);

			
			String query =" INSERT INTO `doctors`"
						+ "(`d_ID`, `d_fname`, `d_lname`, `d_NIC`, `d_phone`, `d_email`, `d_adline1`, `d_adline2`, `d_adline3`, `d_city`, `d_speciality`, `d_working_hospital`, `d_bank`, `d_cardtype`, `d_bankaccno`, `d_charge`) "
						+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			
			// Binding Values
	/**		preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, dct.getFname());
			preparedStmt.setString(3, dct.getLname());
			preparedStmt.setString(4, dct.getNIC());
			preparedStmt.setString(5, dct.getPhone());
			preparedStmt.setString(6, dct.getEmail());
			preparedStmt.setString(7, dct.getAdline1());
			preparedStmt.setString(8, dct.getAdline2());
			preparedStmt.setString(9, dct.getAdline3());
			preparedStmt.setString(10, dct.getCity());
			preparedStmt.setString(11, dct.getSpeciality());
			preparedStmt.setString(12, dct.getWorkingHospital());
			preparedStmt.setString(13, dct.getBank());
			preparedStmt.setString(14, dct.getCardtype());
			preparedStmt.setString(15, dct.getCardno());
			preparedStmt.setString(16, dct.getCharge());	**/
			
			
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, dFname);
			preparedStmt.setString(3, dLname);
			preparedStmt.setString(4, dNIC);
			preparedStmt.setString(5, dPhone);
			preparedStmt.setString(6, dEmail);
			preparedStmt.setString(7, dAdline1);
			preparedStmt.setString(8, dAdline2);
			preparedStmt.setString(9, dAdline3);
			preparedStmt.setString(10, dCity);
			preparedStmt.setString(11, dSpeciality);
			preparedStmt.setString(12, dWorkinghospital);
			preparedStmt.setString(13, dBank);
			preparedStmt.setString(14, dCardtype);
			preparedStmt.setString(15, dCardno);
			preparedStmt.setString(16, dCharge);			
			
			
			
			//Prepared Statement Execution
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
			System.out.println(output);
			
		} catch (Exception e) {
			
			output = "Error while inserting the doctor.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	
	
	//View the Doctors
	public List<DoctorBean> viewDoctors() {
			List <DoctorBean> doctorList = new ArrayList<>();
			
		try 
		{
			Connection con = DBConnection.connect();
			if (con == null) {
				
				System.out.println("Error While reading from database");
				return doctorList;
			}

			String query = "select * from doctors";
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
//			String query = "UPDATE doctors SET" 
//							+ "d_fname=?," + "d_lname=?," + "d_NIC=?,"
//							+ "d_phone=?, " + "d_email=?" + "d_adline1=?" + "d_adline2=?" 
//							+ "d_adline3=?" + "d_city=?" + "d_speciality=?" + "d_working_hospital=?" 
//							+ "d_bank=?" + "d_cardtype=?" + "d_bankaccno=?" + "d_charge=?" 
//							+ "WHERE d_ID=?";
//			
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
			preparedStmt.setString(3, dct.getNIC());			
			preparedStmt.setString(4, dct.getPhone());
			preparedStmt.setString(5, dct.getEmail());
			preparedStmt.setString(6, dct.getAdline1());
			preparedStmt.setString(7, dct.getAdline2());
			preparedStmt.setString(8, dct.getAdline3());
			preparedStmt.setString(9, dct.getCity());
			preparedStmt.setString(10, dct.getSpeciality());
			preparedStmt.setString(11, dct.getWorkingHospital());
			preparedStmt.setString(12, dct.getBank());
			preparedStmt.setString(13, dct.getCardtype());
			preparedStmt.setString(14, dct.getCardno());
			preparedStmt.setString(15, dct.getCharge());
			
			preparedStmt.setInt(16, dct.getdID());
			
			

			// Prepared Statement Execution
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
			
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


}
