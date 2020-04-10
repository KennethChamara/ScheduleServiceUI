package model;

import java.sql.*;

public class Patient {

	// A common method to connect to the DB
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public String insertPatient(String nic, String fname, String lname, String gender,String phone, String blood, String mstatus, String aLine1,String aLine2, String aLine3, String aCity,String dob, String email, String username, String password) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into patient"
					+ "(PatientID,PatientNIC,PatientFName,PatientLName,PatientGender,PatientPhone,PatientBloodGroup,PatientMaritalStatus,Patient_Add_Line1,Patient_Add_Line2,Patient_Add_Line3,Patient_Add_City,PatientDOB,PatientEmail,PatientUsername,PatientPassword)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, nic);
			preparedStmt.setString(3, fname);
			preparedStmt.setString(4, lname);
			preparedStmt.setString(5, gender);
			preparedStmt.setString(6, phone);
			preparedStmt.setString(7, blood);
			preparedStmt.setString(8, mstatus);
			preparedStmt.setString(9, aLine1);
			preparedStmt.setString(10, aLine2);
			preparedStmt.setString(11, aLine3);
			preparedStmt.setString(12, aCity);
			preparedStmt.setString(13, dob);
			preparedStmt.setString(14, email);
			preparedStmt.setString(15, username);
			preparedStmt.setString(16, password);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the patient.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	
	public String readPatient() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>NIC</th><th>First Name</th><th>Last Name</th><th>Gender</th><th>Phone Number</th><th>Blood Group</th><th>Marital Status</th><th>Address Line 1</th><th>Address Line 2</th><th>Address Line 3</th><th>Address City</th><th>DOB</th><th>Email</th><th>Username</th><th>Password</th><th>Update</th><th>Remove</th></tr>";
			String query = "select * from patient";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String PatientID = Integer.toString(rs.getInt("PatientID"));
				String PatientNIC = rs.getString("PatientNIC");
				String PatientFName = rs.getString("PatientFName");
				String PatientLName = rs.getString("PatientLName");
				String PatientGender = rs.getString("PatientGender");
				String PatientPhone = rs.getString("PatientPhone");
				String PatientBloodGroup = rs.getString("PatientBloodGroup");
				String PatientMaritalStatus = rs.getString("PatientMaritalStatus");
				String Patient_Add_Line1 = rs.getString("Patient_Add_Line1");
				String Patient_Add_Line2 = rs.getString("Patient_Add_Line2");
				String Patient_Add_Line3 = rs.getString("Patient_Add_Line3");
				String Patient_Add_City = rs.getString("Patient_Add_City");
				String PatientDOB = rs.getString("PatientDOB");
				String PatientEmail = rs.getString("PatientEmail");
				String PatientUsername = rs.getString("PatientUsername");
				String PatientPassword = rs.getString("PatientPassword");

				
				// Add into the html table
				output += "<tr><td>" + PatientNIC + "</td>";
				output += "<td>" + PatientFName + "</td>";
				output += "<td>" + PatientLName + "</td>";
				output += "<td>" + PatientGender + "</td>";
				output += "<td>" + PatientPhone + "</td>";
				output += "<td>" + PatientBloodGroup + "</td>";
				output += "<td>" + PatientMaritalStatus + "</td>";
				output += "<td>" + Patient_Add_Line1 + "</td>";
				output += "<td>" + Patient_Add_Line2 + "</td>";
				output += "<td>" + Patient_Add_Line3 + "</td>";
				output += "<td>" + Patient_Add_City + "</td>";
				output += "<td>" + PatientDOB + "</td>";
				output += "<td>" + PatientEmail + "</td>";
				output += "<td>" + PatientUsername + "</td>";
				output += "<td>" + PatientPassword + "</td>";
				
				// buttons
				output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"
						+ "<td><form method=\"post\" action=\"items.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\" class=\"btn btn-danger\">"
						+ "<input name=\"itemID\" type=\"hidden\" value=\"" + PatientID + "\">" + "</form></td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the patients.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	
	public String updatePatient(String id, String nic, String fname, String lname, String gender,String phone, String blood,String mstatus, String aLine1,String aLine2, String aLine3, String aCity,String dob,String email, String username, String password) {
 {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE patient SET PatientNIC=?,PatientFName=?,PatientLName=?,PatientGender=?,PatientPhone=?,PatientBloodGroup=?,PatientMaritalStatus=?,Patient_Add_Line1=?,Patient_Add_Line2=?,Patient_Add_Line3=?,Patient_Add_City=?,PatientDOB=?,PatientEmail=?,PatientUsername=?,PatientPassword=? WHERE PatientID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, nic);
			preparedStmt.setString(2, fname);
			preparedStmt.setString(3, lname);
			preparedStmt.setString(4, gender);
			preparedStmt.setString(5, phone);
			preparedStmt.setString(6, blood);
			preparedStmt.setString(7, mstatus);
			preparedStmt.setString(8, aLine1);
			preparedStmt.setString(9, aLine2);
			preparedStmt.setString(10, aLine3);
			preparedStmt.setString(11, aCity);
			preparedStmt.setString(12, dob);
			preparedStmt.setString(13, email);
			preparedStmt.setString(14, username);
			preparedStmt.setString(15, password);
			preparedStmt.setInt(16, Integer.parseInt(id));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the patient.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	}
	
	


	public String deletePatient(String PatientID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from patient where PatientID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(PatientID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the patient.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
