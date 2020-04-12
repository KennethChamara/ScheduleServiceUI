package com;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
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

import beans.PatientBean;
import model.Patient;

@Path("/Patients")

public class PatientService {
	
	Patient PatientObj = new Patient();

	//@RolesAllowed("admin")
	@PermitAll
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PatientBean> readPatient() {
		return PatientObj.readPatient();
	}

	
	
	@PermitAll
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPatient(String PatientData) {
		
		PatientBean patient = new PatientBean(PatientData);	
		
		String output = PatientObj.insertPatient(patient);
				return output;
		
		
	} 
	
	@PermitAll
	@PUT 
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePatient(String PatientData) {
		PatientBean patient = new PatientBean(PatientData);
		String output =	PatientObj.updatePatient(patient);
		return output;
	}
	

	@PermitAll
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePatient(String PatientData) {
		JsonObject PatientObject = new JsonParser().parse(PatientData).getAsJsonObject();
		
		String PatientID = PatientObject.get("PatientID").getAsString();
		
		String output = PatientObj.deletePatient(PatientID);
		return output;
		
		
	}
	
	

}
