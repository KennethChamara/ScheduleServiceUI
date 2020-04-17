package com;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import beans.AppointmentBean;
import model.Appointment;

@Path("/Appointment")
public class AppointmentService {

	Appointment appointmentObj = new Appointment();
	AppointmentBean appbean ;
	
	@RolesAllowed({ "admin","patient" })
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readAppointment()
	{	
		String output = appointmentObj.readAppointment();
		return output;
	}
	
	@RolesAllowed({ "admin","patient" })
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertAppointment(String appointmentData)
	{	
		//create object of AppointmentBean class to save the values for the variables			
		appbean =  new AppointmentBean();
		//convert string to JSON object and assign to variables in the class
		appbean.convertStringToJSONInsert(appointmentData);
		String output = appointmentObj.insertAppointment(appbean);
		return output;
	}
	
	@RolesAllowed({ "admin","patient" })
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAppointment(String appointmentData)
	{
		//create object of AppointmentBean class to save the values for the variables			
		appbean =  new AppointmentBean();
		//convert string to JSON object and assign to variables in the class
		appbean.convertStringToJSONUpdate(appointmentData);		
		String output = appointmentObj.updateAppointment(appbean);
		return output;
		
	}

	@RolesAllowed({ "admin","patient" })
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String appointmentData)
	{		
		//create object of AppointmentBean class to save the values for the variables			
		appbean =  new AppointmentBean();
		//convert string to JSON object and assign to variables in the class
		appbean.convertStringToJSONDelete(appointmentData);			
		String output = appointmentObj.deleteAppointement(appbean);
		return output;
	}
	
	
}
