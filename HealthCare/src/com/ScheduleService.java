package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Schedule;

@Path("/schedules")
public class ScheduleService {
	
	Schedule scheduleObj = new Schedule();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String readSchedule() {
		return scheduleObj.readSchedule();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String inserSchedule(String sheduleData) {
		
		JsonObject scheduleObject = new JsonParser().parse(sheduleData).getAsJsonObject();
		
		
		String doctorID = scheduleObject.get("doctorID").getAsString();
		String hospitalID = scheduleObject.get("hospitalID").getAsString();
		String stTime = scheduleObject.get("st_time").getAsString();
		String endTime = scheduleObject.get("end_time").getAsString();
		String day_of_wk = scheduleObject.get("day_of_wk").getAsString();
		String status = scheduleObject.get("status").getAsString();
		
		String output =	scheduleObj.insertScedule(doctorID, hospitalID, stTime, endTime, day_of_wk, status);
		return output;
		
		
	} 
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateSchedule(String sheduleData) {
JsonObject scheduleObject = new JsonParser().parse(sheduleData).getAsJsonObject();
		
		String scheduleID = scheduleObject.get("scheduleID").getAsString();
		String doctorID = scheduleObject.get("doctorID").getAsString();
		String hospitalID = scheduleObject.get("hospitalID").getAsString();
		String stTime = scheduleObject.get("st_time").getAsString();
		String endTime = scheduleObject.get("end_time").getAsString();
		String day_of_wk = scheduleObject.get("day_of_wk").getAsString();
		String status = scheduleObject.get("status").getAsString();
		
		String output =	scheduleObj.updateSchedule(scheduleID, doctorID, hospitalID, stTime, endTime, day_of_wk, status);
		return output;
		
		
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteSchedule(String sheduleData) {
		JsonObject scheduleObject = new JsonParser().parse(sheduleData).getAsJsonObject();
		
		String scheduleID = scheduleObject.get("scheduleID").getAsString();
		
		String output = scheduleObj.deleteSchedule(scheduleID);
		
		return output;
		
		
	}

}
