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
	public String insertHospital(String hospitalData) 
	{
		HospitalBean hos = new HospitalBean(hospitalData);
		
		String output =	hospitalObj.insertHospital(hos);
		return output;
		
	} 
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateHospital(String hospitalData) 
	{
		HospitalBean hos = new HospitalBean(hospitalData);
		
		String output =	hospitalObj.updateHospital(hos);
		return output;
		
	}
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteHospital(String hospitalData) 
	{
		JsonObject hospitalObject = new JsonParser().parse(hospitalData).getAsJsonObject();
		
		String h_ID = hospitalObject.get("h_ID").getAsString();
		
		String output = hospitalObj.deleteHospital(h_ID);
		return output;
		
	}
	

}