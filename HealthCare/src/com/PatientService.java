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
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPatient(@FormParam("PatientNIC") String PatientNIC, @FormParam("PatientFName") String PatientFName,
			@FormParam("PatientLName") String PatientLName, @FormParam("PatientGender") String PatientGender,
			@FormParam("PatientPhone") String PatientPhone, @FormParam("PatientBloodGroup") String PatientBloodGroup,
			@FormParam("PatientMaritalStatus") String PatientMaritalStatus, @FormParam("Patient_Add_Line1") String Patient_Add_Line1,
			@FormParam("Patient_Add_Line2") String Patient_Add_Line2, @FormParam("Patient_Add_Line3") String Patient_Add_Line3,
			@FormParam("Patient_Add_City") String Patient_Add_City, @FormParam("PatientDOB") String PatientDOB, 
			@FormParam("PatientEmail") String PatientEmail, @FormParam("PatientUsername") String PatientUsername,
			@FormParam("PatientPassword") String PatientPassword) {
		String output = PatientObj.insertPatient(PatientNIC, PatientFName,PatientLName, PatientGender,PatientPhone, PatientBloodGroup,PatientMaritalStatus, Patient_Add_Line1,Patient_Add_Line2, Patient_Add_Line3, Patient_Add_City, PatientDOB, PatientEmail, PatientUsername,PatientPassword);
		return output;
	}

	

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePatient(String PatientData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(PatientData, "", Parser.xmlParser());

		// Read the value from the element <itemID>
		String PatientID = doc.select("PatientID").text();
		String output = PatientObj.deletePatient(PatientID);
		return output;  
	}
	
	

}
