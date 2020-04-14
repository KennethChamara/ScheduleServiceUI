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

import beans.AppointmentBean;
import model.Appointment;

@Path("/Appointment")
public class AppointmentService {

	Appointment appointmentObj = new Appointment();
	AppointmentBean appbean ;
	JsonObject AppointmentObject ;
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readAppointment()
	{	
		String output = appointmentObj.readAppointment();
		return output;
	}
	

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertAppointment(String appointmentData)
	{	
		//Convert the input string to a JSON object 
		AppointmentObject = new JsonParser().parse(appointmentData).getAsJsonObject(); 	
		
		appbean =  new AppointmentBean();
		
		//get values into variables in AppointmentBean to appbean object
		appbean.setCheckedStatus(AppointmentObject.get("CheckedStatus").getAsString());
		appbean.setTokenNumber(AppointmentObject.get("TokenNumber").getAsInt());
		appbean.setAnotherPatientStatus(AppointmentObject.get("AnotherPatientStatus").getAsString());
		appbean.setAnotherPatientNIC(AppointmentObject.get("AnotherPatientNIC").getAsString());
		appbean.setAnotherPatientName(AppointmentObject.get("AnotherPatientName").getAsString());
		appbean.setAnotherPatientEmail(AppointmentObject.get("AnotherPatientEmail").getAsString());
		appbean.setAnotherPatientContactNumber(AppointmentObject.get("AnotherPatientContactNumber").getAsString());
		appbean.setD_ID(AppointmentObject.get("d_ID").getAsInt());
		appbean.setSheduleID(AppointmentObject.get("SheduleID").getAsInt());
		appbean.setHospitalID(AppointmentObject.get("HospitalID").getAsInt());
		appbean.setBookedDate(AppointmentObject.get("BookedDate").getAsString());
		appbean.setPaymentType(AppointmentObject.get("PaymentType").getAsString());
		String output = appointmentObj.insertAppointment(appbean);
		return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAppointment(String appointmentData)
	{
		//Convert the input string to a JSON object 
		AppointmentObject = new JsonParser().parse(appointmentData).getAsJsonObject(); 
		
		appbean =   new AppointmentBean();
		
		appbean.setAppointmentID(AppointmentObject.get("AppointmentID").getAsInt());
		appbean.setCheckedStatus(AppointmentObject.get("CheckedStatus").getAsString());
		appbean.setTokenNumber(AppointmentObject.get("TokenNumber").getAsInt());
		appbean.setAnotherPatientStatus(AppointmentObject.get("AnotherPatientStatus").getAsString());
		appbean.setAnotherPatientNIC(AppointmentObject.get("AnotherPatientNIC").getAsString());
		appbean.setAnotherPatientName(AppointmentObject.get("AnotherPatientName").getAsString());
		appbean.setAnotherPatientEmail(AppointmentObject.get("AnotherPatientEmail").getAsString());
		appbean.setAnotherPatientContactNumber(AppointmentObject.get("AnotherPatientContactNumber").getAsString());
		appbean.setD_ID(AppointmentObject.get("d_ID").getAsInt());
		appbean.setSheduleID(AppointmentObject.get("SheduleID").getAsInt());
		appbean.setHospitalID(AppointmentObject.get("HospitalID").getAsInt());
		appbean.setBookedDate(AppointmentObject.get("BookedDate").getAsString());
		appbean.setBookedDate(AppointmentObject.get("AddedDate").getAsString());
		String output = appointmentObj.updateAppointment(appbean);
		return output;
		
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String appointmentData)
	{
		//Convert the input string to a JSON object 
		AppointmentObject = new JsonParser().parse(appointmentData).getAsJsonObject(); 
		
		appbean =   new AppointmentBean();
		
		appbean.setAppointmentID(AppointmentObject.get("AppointmentID").getAsInt());
		
		String output = appointmentObj.deleteAppointement(appbean);
		return output;
	}
	
	
}
