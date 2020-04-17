package com;

import java.util.*;

import javax.annotation.security.PermitAll;
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

import beans.DoctorBean;
import model.Doctor;

@Path("/Doctors")
@PermitAll
public class DoctorService {

	Doctor objDoctor = new Doctor();

	// View list of Doctors
	@RolesAllowed({ "doctor", "admin","patient" })
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DoctorBean> viewDoctor() {
		return objDoctor.viewDoctors();
	}

	// View a doctor identified by id
	@RolesAllowed({ "doctor", "admin","patient" })
	@GET
	@Path("/{d_ID}")
	// @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DoctorBean viewDoctorById(@PathParam("d_ID") int id) {
		return objDoctor.viewDoctorById(id);
	}

	// Insert a Doctor
	@RolesAllowed("admin")
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertDoctor(DoctorBean doc) {

		String output = objDoctor.insertDoctor(doc);
		return output;

	}

	// Update a Doctor
	@RolesAllowed({ "doctor", "admin"})
	@PUT
	@Path("/{did}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDoctor(DoctorBean doctor,@PathParam("did") int id) {
		doctor.setId(id);
		String output = objDoctor.updateDoctor(doctor);
		return output;
	}

	// Remove a Doctor
	@RolesAllowed({ "doctor", "admin"})
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
