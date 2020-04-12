package com;

import java.util.*;

import javax.annotation.security.PermitAll;
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


import beans.DoctorBean;
import model.Doctor;


@Path("/Doctors")
@PermitAll
public class DoctorService {
	
	Doctor objDoctor = new Doctor();


	//View a Doctor
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DoctorBean> viewDoctor() {
		return objDoctor.viewDoctors();
	}
	
	
	
	
	//Insert a Doctor
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertDoctor(String doctorData) {
		
//		DoctorBean doc = new DoctorBean(doctorData);

		JsonObject doctorObject = new JsonParser().parse(doctorData).getAsJsonObject();

		
		String dFname = doctorObject.get("d_fname").getAsString();
		String dLname = doctorObject.get("d_lname").getAsString();
		String dNIC = doctorObject.get("d_NIC").getAsString();
		String dPhone = doctorObject.get("d_phone").getAsString();
		String dEmail = doctorObject.get("d_email").getAsString();
		String dAdline1 = doctorObject.get("d_adline1").getAsString();
		String dAdline2 = doctorObject.get("d_adline2").getAsString();
		String dAdline3 = doctorObject.get("d_adline3").getAsString();
		String dCity = doctorObject.get("d_city").getAsString();
		String dSpeciality = doctorObject.get("d_speciality").getAsString();
		String dWorkinghospital = doctorObject.get("d_working_hospital").getAsString();
		String dBank = doctorObject.get("d_bank").getAsString();
		String dCardtype = doctorObject.get("d_cardtype").getAsString();
		String dCardno = doctorObject.get("d_bankaccno").getAsString();
		String dCharge = doctorObject.get("d_charge").getAsString();

		
	
		
		String output =	objDoctor.insertDoctor(dFname,dLname,dNIC,dPhone,dEmail,dAdline1,dAdline2,dAdline3,dCity,dSpeciality,dWorkinghospital,dBank,dCardtype,dCardno,dCharge);
		return output;
	} 
	
	
	//Update a Doctor
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDoctor(String Doctor) {
		DoctorBean doc = new DoctorBean(Doctor);
		
		String output =	objDoctor.updateDoctor(doc);
		return output;				
	}
	
	
	
	//Remove a Doctor
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String removeDoctor(String doctor) {
		JsonObject DoctorObject = new JsonParser().parse(doctor).getAsJsonObject();
		
		String doctorID = DoctorObject.get("d_ID").getAsString();
		String output = objDoctor.removeDoctor(doctorID);
		
		return output;
		
		
	}

}
