package com;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes; 
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import beans.ScheduleBean;
import model.Schedule;

@Path("/schedules")
public class ScheduleService {
	
	Schedule scheduleObj = new Schedule();
	
	@RolesAllowed({"admin","docters"})
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ScheduleBean> readSchedule() {
		return scheduleObj.readSchedule();
	}
	
	@RolesAllowed({"admin","docters"})
	@GET
	@Path("/{scheduleID}")
	@Produces(MediaType.APPLICATION_JSON)
	public ScheduleBean readScheduleById(@PathParam("scheduleID") int id) {
		return scheduleObj.readScheduleById(id);
	}
	
	
	@RolesAllowed({"admin","docters"})
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String inserSchedule(ScheduleBean sch) {
		String output =	scheduleObj.insertScedule(sch);
		return output;
		
	} 
	
	@RolesAllowed({"admin","docters"})
	@PUT
	@Path("/{scheduleID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateSchedule(@PathParam("scheduleID") int scheduleID,ScheduleBean sch) {
		sch.setId(scheduleID);
		String output =	scheduleObj.updateSchedule(sch);
		return output;				
	}
	
	@RolesAllowed({"admin","docters"})
	@DELETE
	@Path("/{scheduleID}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteSchedule(@PathParam("scheduleID") int scheduleID) {
		String output = scheduleObj.deleteSchedule(scheduleID);		
		return output;
				
	}

}
