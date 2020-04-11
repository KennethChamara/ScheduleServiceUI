package beans;

import java.sql.Date;

public abstract class APaymentBean {

    private double amount;

    private Date paymentDate;

    private boolean refunded;
    private Date refundedDate;
    private int appointmentId;

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getRefundedDate() {
        return refundedDate;
    }

    public void setRefundedDate(Date refundedDate) {
        this.refundedDate = refundedDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean isRefunded() {
        return refunded;
    }

    public void setRefunded(boolean refunded) {
        this.refunded = refunded;
    }
}
