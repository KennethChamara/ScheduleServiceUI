package com;

import java.util.List;  

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

import beans.ScheduleBean;
import model.Schedule;

@Path("/schedules")
public class ScheduleService {
	
	Schedule scheduleObj = new Schedule();
	
	

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ScheduleBean> readSchedule() {
		return scheduleObj.readSchedule();
	}
	

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String inserSchedule(String sheduleData) {
		
		ScheduleBean sch = new ScheduleBean(sheduleData);
		
		String output =	scheduleObj.insertScedule(sch);
		return output;
		
		
	} 
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateSchedule(String sheduleData) {
		ScheduleBean sch = new ScheduleBean(sheduleData);
		String output =	scheduleObj.updateSchedule(sch);
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
