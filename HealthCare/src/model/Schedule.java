package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonObject;

public class Schedule {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/HMS?useTimezone=true&serverTimezone=UTC",
					"root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertScedule(String doctorID, String hospitalID, String st_time, String end_time, String day_of_wk,
			String status) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into schedule"
					+ "(scheduleID,doctorID,hospitalID,st_time,end_time,day_of_wk,status)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";

		
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setInt(2, Integer.parseInt(doctorID));
			preparedStmt.setInt(3, Integer.parseInt(hospitalID));
			preparedStmt.setString(4, st_time);
			preparedStmt.setString(5, end_time);
			preparedStmt.setString(6, day_of_wk);
			preparedStmt.setString(7, status);

//execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the schedule.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readSchedule() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			String query = "select * from schedule";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String scheduleID = Integer.toString(rs.getInt("scheduleID"));
				String doctorID = Integer.toString(rs.getInt("doctorID"));
				String hospitalID = Integer.toString(rs.getInt("hospitalID"));
				String stTime = rs.getString("st_time");
				String endTime = rs.getString("end_time");
				String DOW = rs.getString("day_of_wk");
				String status = rs.getString("status");

				JsonObject sampleObject = new JsonObject();
				sampleObject.addProperty("scheduleID", scheduleID);
				sampleObject.addProperty("doctorID", doctorID);
				sampleObject.addProperty("hospitalID", hospitalID);
				sampleObject.addProperty("st_time", stTime);
				sampleObject.addProperty("end_time", endTime);
				sampleObject.addProperty("day_of_wk", DOW);
				sampleObject.addProperty("status", status);

				output = sampleObject.toString();

			}
			con.close();

		} catch (Exception e) {
			output = "Error while reading the schedule.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateSchedule(String ID, String doctorID, String hospitalID, String st_time, String end_time,
			String day_of_wk, String status) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
// create a prepared statement
			String query = "UPDATE schedule SET" + " doctorID=?," + "hospitalID=?," + "st_time=?," + "end_time=?,"
					+ "day_of_wk=?, " + "status=?" + "WHERE scheduleID=?";


			PreparedStatement preparedStmt = con.prepareStatement(query);
// binding values
			preparedStmt.setInt(1, Integer.parseInt(doctorID));
			preparedStmt.setInt(2, Integer.parseInt(hospitalID));
			preparedStmt.setString(3, st_time);
			preparedStmt.setString(4, end_time);
			preparedStmt.setString(5, day_of_wk);
			preparedStmt.setString(6, status);
			preparedStmt.setInt(7, Integer.parseInt(ID));
// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the schedule.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteSchedule(String ID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
// create a prepared statement
			String query = "delete from schedule where scheduleID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
// binding values
			preparedStmt.setInt(1, Integer.parseInt(ID));
// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the schedule.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
