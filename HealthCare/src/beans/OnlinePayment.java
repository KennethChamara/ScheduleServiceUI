package beans;

import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

public class OnlinePayment extends  Payment  implements Serializable{

    public String onlinePaymentReferenceNumber;
    
    

	public OnlinePayment(double amount, Date paymentDate, boolean refunded, Date refundedDate, int appointmentId,
			String onlinePaymentReferenceNumber) {
		super(amount, paymentDate, refunded, refundedDate, appointmentId);
		this.onlinePaymentReferenceNumber = onlinePaymentReferenceNumber;
	}

	public OnlinePayment() {
		super();
	}

	public String getOnlinePaymentReferenceNumber() {
		return onlinePaymentReferenceNumber;
	}

	public void setOnlinePaymentReferenceNumber(String onlinePaymentReferenceNumber) {
		this.onlinePaymentReferenceNumber = onlinePaymentReferenceNumber;
	}

    
}
