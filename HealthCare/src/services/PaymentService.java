package services;

import beans.APaymentBean;
import beans.CardPaymentBean;
import beans.OnlinePaymentBean;
import beans.PaypalPayment;
import enums.PaymentMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentService {

    private Connection sqlConnection;

    public PaymentService(Connection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public boolean makePayment(APaymentBean payment) throws SQLException {
        if (payment.getClass().getCanonicalName() == CardPaymentBean.class.getCanonicalName()) {
            return makeCardPayment((CardPaymentBean) payment);
        } else if (payment.getClass().getCanonicalName() == OnlinePaymentBean.class.getCanonicalName()) {
            return makeOnlinePayment((OnlinePaymentBean) payment);
        } else if (payment.getClass().getCanonicalName() == PaypalPayment.class.getCanonicalName()) {
            return makePaypalPayment((PaypalPayment) payment);
        }

    }

    private boolean makeCardPayment(CardPaymentBean payment) throws SQLException {
        String sql = "INSERT INTO " +
                "`tbl_payments`(`appointment_id`, `amount`, `payment_date`, `card_number`, `exp_year`, `exp_month`, `security_code`, `card_holders_name`, `type`)" +
                " VALUES (?,?,?,?,?,?,?,?,?);";
        PreparedStatement statement = this.sqlConnection.prepareStatement(sql);
        statement.setString(4,payment.getCardNumber());
        statement.setInt(5,payment.getExpYear());
        statement.setInt(6,payment.getExpMonth());
        statement.setInt(7,payment.getSecurityCode());
        statement.setString(8,payment.getCardHoldersName());
        statement.setString(9, PaymentMethod.CreditCard.name());
        return statement.execute();
    }

    private void assignCommonParams(PreparedStatement statement, APaymentBean payment) throws SQLException {
        statement.setInt(1, payment.getAppointmentId());
        statement.setDouble(2, payment.getAmount());
        statement.setDate(3, payment.getPaymentDate());
    }

    private boolean makeOnlinePayment(OnlinePaymentBean payment) {
        return true;
    }

    private boolean makePaypalPayment(PaypalPayment payment) {
        return true;
    }

}
