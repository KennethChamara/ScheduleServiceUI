package controllers;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import beans.APaymentBean;
import beans.CommonResponseBean;
import services.PaymentService;
import util.DBConnection;

@Path("payment")
public class PaymentController {
	private PaymentService paymentService;

	public PaymentController() throws ClassNotFoundException, SQLException {
		this.paymentService = new PaymentService(DBConnection.connect());
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("make")
	public CommonResponseBean makePayment(APaymentBean payment) {
		try {
			this.paymentService.makePayment(payment);
			return CommonResponseBean.OK("Success");
		} catch (Exception e) {
			return CommonResponseBean.Error(e);
		}
	}
}
