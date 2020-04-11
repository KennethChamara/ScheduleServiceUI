package controllers;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Payment;
import beans.CardPayment;
import beans.CommonResponse;
import beans.OnlinePayment;
import beans.PaypalPayment;
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
}
