package controllers;


import java.sql.SQLException; 
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import beans.Payment;
import beans.PaymentAppointmentBean;
import beans.CardPayment;
import beans.CommonResponse;
import beans.OnlinePayment;
import beans.PaypalPayment;
import model.PaymentAppointment;
import services.PaymentService;
import util.DBConnection;

@Path("payment")
public class PaymentController {
	private PaymentService paymentService;

	public PaymentController() throws ClassNotFoundException, SQLException {
		this.paymentService = new PaymentService(DBConnection.connect());
	}
		
	
	@GET
	@Path("view")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> view() throws SQLException {
		return this.paymentService.getAllPayments();
	}
	
	@POST
	@Path("refund")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommonResponse makeRefund(Payment payment) {
		try {
			this.paymentService.makeRefund(payment);
			return CommonResponse.OK("Success");
		} catch (Exception e) {
			return CommonResponse.Error(e);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("online")
	public CommonResponse makePayment(OnlinePayment payment) {
		try {
			this.paymentService.makePayment(payment);
			return CommonResponse.OK("Success");
		} catch (Exception e) {
			return CommonResponse.Error(e);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("card")
	public CommonResponse makePayment(CardPayment payment) {
		try {
			this.paymentService.makePayment(payment);
			return CommonResponse.OK("Success");
		} catch (Exception e) {
			return CommonResponse.Error(e);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("paypal")
	public CommonResponse makePayment(PaypalPayment payment) {
		try {
			this.paymentService.makePayment(payment);
			return CommonResponse.OK("Success");
		} catch (Exception e) {
			return CommonResponse.Error(e);
		}
	}

	
	@POST
	@Path("insertPaymentFromAppointment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPayAppointment(String appointPaydetails) {
		//payappbean get the appointPaydetails and get the values into the payment table related variables in it		
		PaymentAppointmentBean  payAppbean =  new PaymentAppointmentBean(appointPaydetails);
		payAppbean.ConvertStringToJSON();
		//this class insert the details to the database
		PaymentAppointment payapp =  new PaymentAppointment();		
		return payapp.InsertPayment(payAppbean);			
	}
	@PUT
	@Path("updatePaymentFromAppointment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePayAppointment(String appointPaydetails) {
		//payappbean get the appointPaydetails and get the values into the payment table related variables in it		
		PaymentAppointmentBean  payAppbean =  new PaymentAppointmentBean(appointPaydetails);
		payAppbean.ConvertStringToJSON();
		//this class update the details to the database
		PaymentAppointment payapp =  new PaymentAppointment();		
		return payapp.UpdatePayment(payAppbean);			
	}
	
	@DELETE
	@Path("deletePaymentFromAppointment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePayAppointment(String appointPaydetails) {
		//payappbean get the appointPaydetails and get the values into the payment table related variables in it		
		PaymentAppointmentBean  payAppbean =  new PaymentAppointmentBean(appointPaydetails);
		payAppbean.ConvertStringToJSONdelete();
		//this class delete the details to the database
		PaymentAppointment payapp =  new PaymentAppointment();		
		return payapp.DeletePayment(payAppbean);			
	}
	
	

	
}
