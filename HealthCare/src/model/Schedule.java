package model;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ParametersAreNullableByDefault;

import beans.ScheduleBean;
import util.DBConnection;

public class Schedule {

	public String insertScedule(ScheduleBean sch) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
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
			preparedStmt.setInt(2, Integer.parseInt(sch.getDoctorID()));
			preparedStmt.setInt(3, Integer.parseInt(sch.getHospitalID()));
			preparedStmt.setString(4, sch.getStTime());
			preparedStmt.setString(5, sch.getEndTime());
			preparedStmt.setString(6, sch.getDay_of_wk());
			preparedStmt.setString(7, sch.getStatus());

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

	public List<ScheduleBean> readSchedule() {
		
				return	readSchedule(0);
	
	}
	
	public ScheduleBean readScheduleById(int id) {
		List<ScheduleBean> list =readSchedule(id);
			if(!list.isEmpty()) {
				return	list.get(0);
			}
			return null;
	}
	public List<ScheduleBean> readSchedule(int id ) {
		List<ScheduleBean> schList = new ArrayList<>();
		try {
			Connection con = DBConnection.connect();
			if (con == null) {

				System.out.println("Error While reading from database");
				return schList;
			}
			String query;
			if ( id==0) {
			 query = "select * from schedule";
			}else {
			 query = "select * from schedule where scheduleID="+id;
			}
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ScheduleBean sch = new ScheduleBean(rs.getInt("scheduleID"), Integer.toString(rs.getInt("doctorID")),
						Integer.toString(rs.getInt("hospitalID")), rs.getString("st_time"), rs.getString("end_time"),
						rs.getString("day_of_wk"), rs.getString("status"));

				schList.add(sch);

			}
			con.close();

		} catch (Exception e) {
			System.out.println("error wihile reading");
			System.err.println(e.getMessage());
		}
		return schList;
	}

	public String updateSchedule(ScheduleBean sch) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
// create a prepared statement
			String query = "UPDATE schedule SET" + " doctorID=?," + "hospitalID=?," + "st_time=?," + "end_time=?,"
					+ "day_of_wk=?, " + "status=?" + "WHERE scheduleID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);
// binding values
			preparedStmt.setInt(1, Integer.parseInt(sch.getDoctorID()));
			preparedStmt.setInt(2, Integer.parseInt(sch.getHospitalID()));
			preparedStmt.setString(3, sch.getStTime());
			preparedStmt.setString(4, sch.getEndTime());
			preparedStmt.setString(5, sch.getDay_of_wk());
			preparedStmt.setString(6, sch.getStatus());
			preparedStmt.setInt(7, sch.getId());
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

	public String deleteSchedule(int ID) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
// create a prepared statement
			String query = "delete from schedule where scheduleID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
// binding values
			preparedStmt.setInt(1, ID);
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

	public List<ScheduleBean> getShedulesByDoc(int docId){
		List<ScheduleBean> list = new ArrayList<>();
	
		for(ScheduleBean sch : readSchedule()){
			if(Integer.parseInt(sch.getDoctorID())==docId) {
				list.add(sch);
			}		
		}
		
		return list;
	}
	
	public List<ScheduleBean> getShedulesByHos(int hosId){
		List<ScheduleBean> list = new ArrayList<>();
	
		for(ScheduleBean sch : readSchedule()){
			if(Integer.parseInt(sch.getHospitalID())==hosId) {
				list.add(sch);
			}		
		}
		
		return list;
	}
	
	public List<ScheduleBean> getShedulesByHos(String day){
		List<ScheduleBean> list = new ArrayList<>();
	
		for(ScheduleBean sch : readSchedule()){
			if(sch.getDay_of_wk()==day) {
				list.add(sch);
			}		
		}
		
		return list;
	}
	
}
