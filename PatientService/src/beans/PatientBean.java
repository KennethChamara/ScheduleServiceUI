package beans;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@XmlRootElement
public class PatientBean {

	int id;
	private String PatientNIC;
	private String PatientFName;
	private String PatientLName;
	private String PatientGender;
	private String PatientPhone;
	private String PatientBloodGroup;
	private String PatientMaritalStatus;
	private String Patient_Add_Line1;
	private String Patient_Add_Line2;
	private String Patient_Add_Line3;
	private String Patient_Add_City;
	private String PatientDOB_year;
	private String PatientDOB_month;
	private String PatientDOB_day;
	private String PatientEmail;
	private String PatientUsername;
	private String PatientPassword;

	String PatientRole = "patient";

	public PatientBean() {
	}

	public PatientBean(String patient) {

		JsonObject PatientObject = new JsonParser().parse(patient).getAsJsonObject();

		if (PatientObject.get("PatientID") != null) {
			this.id = PatientObject.get("PatientID").getAsInt();
		}
		this.PatientNIC = PatientObject.get("PatientNIC").getAsString();
		this.PatientFName = PatientObject.get("PatientFName").getAsString();
		this.PatientLName = PatientObject.get("PatientLName").getAsString();
		this.PatientGender = PatientObject.get("PatientGender").getAsString();
		this.PatientPhone = PatientObject.get("PatientPhone").getAsString();
		this.PatientBloodGroup = PatientObject.get("PatientBloodGroup").getAsString();
		this.PatientMaritalStatus = PatientObject.get("PatientMaritalStatus").getAsString();
		this.Patient_Add_Line1 = PatientObject.get("Patient_Add_Line1").getAsString();
		this.Patient_Add_Line2 = PatientObject.get("Patient_Add_Line2").getAsString();
		this.Patient_Add_Line3 = PatientObject.get("Patient_Add_Line3").getAsString();
		this.Patient_Add_City = PatientObject.get("Patient_Add_City").getAsString();
		this.PatientDOB_year = PatientObject.get("PatientDOB_year").getAsString();
		this.PatientDOB_month = PatientObject.get("PatientDOB_month").getAsString();
		this.PatientDOB_day = PatientObject.get("PatientDOB_day").getAsString();
		this.PatientEmail = PatientObject.get("PatientEmail").getAsString();
		this.PatientUsername = PatientObject.get("PatientUsername").getAsString();
		this.PatientPassword = PatientObject.get("PatientPassword").getAsString();

	}

	public PatientBean(int id, String PatientNIC, String PatientFName, String PatientLName, String PatientGender,
			String PatientPhone, String PatientBloodGroup, String PatientMaritalStatus, String Patient_Add_Line1,
			String Patient_Add_Line2, String Patient_Add_Line3, String Patient_Add_City, String PatientDOB_year,
			String PatientDOB_month, String PatientDOB_day, String PatientEmail, String PatientUsername,
			String PatientPassword, String status) {

		this.id = id;
		this.PatientNIC = PatientNIC;
		this.PatientFName = PatientFName;
		this.PatientLName = PatientLName;
		this.PatientGender = PatientGender;
		this.PatientPhone = PatientPhone;
		this.PatientBloodGroup = PatientBloodGroup;
		this.PatientMaritalStatus = PatientMaritalStatus;
		this.Patient_Add_Line1 = Patient_Add_Line1;
		this.Patient_Add_Line2 = Patient_Add_Line2;
		this.Patient_Add_Line3 = Patient_Add_Line3;
		this.Patient_Add_City = Patient_Add_City;
		this.PatientDOB_year = PatientDOB_year;
		this.PatientDOB_month = PatientDOB_month;
		this.PatientDOB_day = PatientDOB_day;
		this.PatientEmail = PatientEmail;
		this.PatientUsername = PatientUsername;
		this.PatientPassword = PatientPassword;

	}

	public PatientBean(String PatientNIC, String PatientFName, String PatientLName, String PatientGender,
			String PatientPhone, String PatientBloodGroup, String PatientMaritalStatus, String Patient_Add_Line1,
			String Patient_Add_Line2, String Patient_Add_Line3, String Patient_Add_City, String PatientDOB_year,
			String PatientDOB_month, String PatientDOB_day, String PatientEmail, String PatientUsername,
			String PatientPassword, String status) {

		this.PatientNIC = PatientNIC;
		this.PatientFName = PatientFName;
		this.PatientLName = PatientLName;
		this.PatientGender = PatientGender;
		this.PatientPhone = PatientPhone;
		this.PatientBloodGroup = PatientBloodGroup;
		this.PatientMaritalStatus = PatientMaritalStatus;
		this.Patient_Add_Line1 = Patient_Add_Line1;
		this.Patient_Add_Line2 = Patient_Add_Line2;
		this.Patient_Add_Line3 = Patient_Add_Line3;
		this.Patient_Add_City = Patient_Add_City;
		this.PatientDOB_year = PatientDOB_year;
		this.PatientDOB_month = PatientDOB_month;
		this.PatientDOB_day = PatientDOB_day;
		this.PatientEmail = PatientEmail;
		this.PatientUsername = PatientUsername;
		this.PatientPassword = PatientPassword;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatientNIC() {
		return PatientNIC;
	}

	public void setPatientNIC(String PatientNIC) {
		this.PatientNIC = PatientNIC;
	}

	public String getPatientFName() {
		return PatientFName;
	}

	public void setPatientFName(String PatientFName) {
		this.PatientFName = PatientFName;
	}

	public String getPatientLName() {
		return PatientLName;
	}

	public void setPatientLName(String PatientLName) {
		this.PatientLName = PatientLName;
	}

	public String getPatientGender() {
		return PatientGender;
	}

	public void setPatientGender(String PatientGender) {
		this.PatientGender = PatientGender;
	}

	public String getPatientPhone() {
		return PatientPhone;
	}

	public void setPatientPhone(String PatientPhone) {
		this.PatientPhone = PatientPhone;
	}

	public String getPatientBloodGroup() {
		return PatientBloodGroup;
	}

	public void setPatientBloodGroup(String PatientBloodGroup) {
		this.PatientBloodGroup = PatientBloodGroup;
	}

	public String getPatientMaritalStatus() {
		return PatientMaritalStatus;
	}

	public void setPatientMaritalStatus(String PatientMaritalStatus) {
		this.PatientMaritalStatus = PatientMaritalStatus;
	}

	public String getPatient_Add_Line1() {
		return Patient_Add_Line1;
	}

	public void sePatient_Add_Line1(String Patient_Add_Line1) {
		this.Patient_Add_Line1 = Patient_Add_Line1;
	}

	public String getPatient_Add_Line2() {
		return Patient_Add_Line2;
	}

	public void setPatient_Add_Line2(String Patient_Add_Line2) {
		this.Patient_Add_Line2 = Patient_Add_Line2;
	}

	public String getPatient_Add_Line3() {
		return Patient_Add_Line3;
	}

	public void setPatient_Add_Line3(String Patient_Add_Line3) {
		this.Patient_Add_Line3 = Patient_Add_Line3;
	}

	public String getPatient_Add_City() {
		return Patient_Add_City;
	}

	public void setPatient_Add_City(String Patient_Add_City) {
		this.Patient_Add_City = Patient_Add_City;
	}

	public String getPatientDOB_year() {
		return PatientDOB_year;
	}

	public void setPatientDOB_year(String PatientDOB_year) {
		this.PatientDOB_year = PatientDOB_year;
	}

	public String getPatientDOB_month() {
		return PatientDOB_month;
	}

	public void setPatientDOB_month(String PatientDOB_month) {
		this.PatientDOB_month = PatientDOB_month;
	}

	public String getPatientDOB_day() {
		return PatientDOB_day;
	}

	public void setPatientDOB_day(String PatientDOB_day) {
		this.PatientDOB_day = PatientDOB_day;
	}

	public String getPatientEmail() {
		return PatientEmail;
	}

	public void setPatientEmail(String PatientEmail) {
		this.PatientEmail = PatientEmail;
	}

	public String getPatientUsername() {
		return PatientUsername;
	}

	public void setPatientUsername(String PatientUsername) {
		this.PatientUsername = PatientUsername;
	}

	public String getPatientPassword() {
		return PatientPassword;
	}

	public void setPatientPassword(String PatientPassword) {
		this.PatientPassword = PatientPassword;
	}

}
