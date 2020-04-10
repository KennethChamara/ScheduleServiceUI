package com;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;


import model.Patient;

@Path("/Patients")

public class PatientService {
	
	Patient PatientObj = new Patient();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPatient() {
		return PatientObj.readPatient();
	}

	
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPatient(String PatientData) {
		
		JsonObject PatientObject = new JsonParser().parse(PatientData).getAsJsonObject();
		
		
		String PatientNIC = PatientObject.get("PatientNIC").getAsString();
		String PatientFName = PatientObject.get("PatientFName").getAsString();
		String PatientLName = PatientObject.get("PatientLName").getAsString();
		String PatientGender = PatientObject.get("PatientGender").getAsString();
		String PatientPhone = PatientObject.get("PatientPhone").getAsString();
		String PatientBloodGroup = PatientObject.get("PatientBloodGroup").getAsString();
		String PatientMaritalStatus = PatientObject.get("PatientMaritalStatus").getAsString();
		String Patient_Add_Line1 = PatientObject.get("Patient_Add_Line1").getAsString();
		String Patient_Add_Line2 = PatientObject.get("Patient_Add_Line2").getAsString();
		String Patient_Add_Line3 = PatientObject.get("Patient_Add_Line3").getAsString();
		String Patient_Add_City = PatientObject.get("Patient_Add_City").getAsString();
		String PatientDOB = PatientObject.get("PatientDOB").getAsString();
		String PatientEmail = PatientObject.get("PatientEmail").getAsString();
		String PatientUsername = PatientObject.get("PatientUsername").getAsString();
		String PatientPassword = PatientObject.get("PatientPassword").getAsString();
		
		
		String output = PatientObj.insertPatient(PatientNIC, PatientFName,PatientLName, PatientGender,PatientPhone, PatientBloodGroup,PatientMaritalStatus, Patient_Add_Line1,Patient_Add_Line2, Patient_Add_Line3, Patient_Add_City, PatientDOB,PatientEmail, PatientUsername,PatientPassword);
		return output;
		
		
	} 
	
	@PUT 
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePatient(String PatientData) {
		// Convert the input string to a JSON object
		JsonObject PatientObject = new JsonParser().parse(PatientData).getAsJsonObject();
		// Read the values from the JSON object
		String PatientID = PatientObject.get("PatientID").getAsString();
		String PatientNIC = PatientObject.get("PatientNIC").getAsString();
		String PatientFName = PatientObject.get("PatientFName").getAsString();
		String PatientLName = PatientObject.get("PatientLName").getAsString();
		String PatientGender = PatientObject.get("PatientGender").getAsString();
		String PatientPhone = PatientObject.get("PatientPhone").getAsString();
		String PatientBloodGroup = PatientObject.get("PatientBloodGroup").getAsString();
		String PatientMaritalStatus = PatientObject.get("PatientMaritalStatus").getAsString();
		String Patient_Add_Line1 = PatientObject.get("Patient_Add_Line1").getAsString();
		String Patient_Add_Line2 = PatientObject.get("Patient_Add_Line2").getAsString();
		String Patient_Add_Line3 = PatientObject.get("Patient_Add_Line3").getAsString();
		String Patient_Add_City = PatientObject.get("Patient_Add_City").getAsString();
		String PatientDOB = PatientObject.get("PatientDOB").getAsString();
		String PatientEmail = PatientObject.get("PatientEmail").getAsString();
		String PatientUsername = PatientObject.get("PatientUsername").getAsString();
		String PatientPassword = PatientObject.get("PatientPassword").getAsString();
		String output = PatientObj.updatePatient(PatientID,PatientNIC, PatientFName,PatientLName, PatientGender,PatientPhone, PatientBloodGroup,PatientMaritalStatus, Patient_Add_Line1,Patient_Add_Line2, Patient_Add_Line3, Patient_Add_City, PatientDOB,PatientEmail, PatientUsername,PatientPassword);
		return output;
	}
	

	
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
