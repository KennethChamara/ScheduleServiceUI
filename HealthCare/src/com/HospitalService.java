package com;

import java.util.List;

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

import beans.HospitalBean;
import model.Hospital;

@Path("/hospitals")
@PermitAll
public class HospitalService 
{
	Hospital hospitalObj = new Hospital();
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HospitalBean> readHospital() 
	{
		return hospitalObj.readHospital();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertHospital(String HopitalData) 
	{
		
		JsonObject hospitalbject = new JsonParser().parse(HopitalData).getAsJsonObject();

		String h_name = hospitalbject.get("h_name").getAsString();  
		String h_phone = hospitalbject.get("h_phone").getAsString();  
		String h_addrLine1 = hospitalbject.get("h_addrLine1").getAsString();  
		String h_addrLine2 = hospitalbject.get("h_addrLine2").getAsString(); 
		String h_addrLine3 = hospitalbject.get("h_addrLine3").getAsString();  
		String h_city = hospitalbject.get("h_city").getAsString();  
		String h_email = hospitalbject.get("h_email").getAsString();  
		String h_desc = hospitalbject.get("h_desc").getAsString();  
		String h_services = hospitalbject.get("h_services").getAsString(); 
		String h_accountNo = hospitalbject.get("h_accountNo").getAsString();  
		String h_bank = hospitalbject.get("h_bank").getAsString();  
		String h_charge = hospitalbject.get("h_charge").getAsString(); 

		String output =	hospitalObj.insertHospital(h_name, h_phone, h_addrLine1, h_addrLine2,h_addrLine3,h_city,h_email,h_desc,h_services,h_accountNo,h_bank,h_charge);
		return output;
	} 
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateHospital(String hospitalData) 
	{  
		//Convert the input string to a JSON object  
		JsonObject hospitalbject = new JsonParser().parse(hospitalData).getAsJsonObject(); 
		 
		//Read the values from the JSON object  
		String h_ID = hospitalbject.get("h_ID").getAsString();  
		String h_name = hospitalbject.get("h_name").getAsString();  
		String h_phone = hospitalbject.get("h_phone").getAsString();  
		String h_addrLine1 = hospitalbject.get("h_addrLine1").getAsString();  
		String h_addrLine2 = hospitalbject.get("h_addrLine2").getAsString(); 
		String h_addrLine3 = hospitalbject.get("h_addrLine3").getAsString();  
		String h_city = hospitalbject.get("h_city").getAsString();  
		String h_email = hospitalbject.get("h_email").getAsString();  
		String h_desc = hospitalbject.get("h_desc").getAsString();  
		String h_services = hospitalbject.get("h_services").getAsString(); 
		String h_accountNo = hospitalbject.get("h_accountNo").getAsString();  
		String h_bank = hospitalbject.get("h_bank").getAsString();  
		String h_charge = hospitalbject.get("h_charge").getAsString();  
		
		 
		String output = hospitalObj.updateHospital(h_ID, h_name, h_phone, h_addrLine1, h_addrLine2,h_addrLine3,h_city,h_email,h_desc,h_services,h_accountNo,h_bank,h_charge); 
		 
		return output; 
	} 
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteHospital(String hospitalData) {
		
		JsonObject hospitalObject = new JsonParser().parse(hospitalData).getAsJsonObject();
		
		String h_ID = hospitalObject.get("h_ID").getAsString();
		
		String output = hospitalObj.deleteHospital(h_ID);
		
		return output;
		
		
	}
	

	
}
