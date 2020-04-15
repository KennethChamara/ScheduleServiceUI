package beans;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@XmlRootElement
public class DoctorBean {

	int dID;
	private String dNIC;
	private String dFname;
	private String dLname;
	private String dPhone;
	private String dEmail;
	private String dAdline1;
	private String dAdline2;
	private String dAdline3;
	private String dCity;
	private String dSpeciality;
	private String dWorkinghospital;
	private String dBank;
	private String dCardtype;
	private String dCardno;
	private String dCharge;
	
	public DoctorBean() {}

	public DoctorBean(String doc) {

		JsonObject doctorObject = new JsonParser().parse(doc).getAsJsonObject();

		if (doctorObject.get("d_ID") != null) {
			this.dID = doctorObject.get("d_ID").getAsInt();
		}

		this.dFname = doctorObject.get("d_fname").getAsString();
		this.dLname = doctorObject.get("d_lname").getAsString();
		this.dNIC = doctorObject.get("d_NIC").getAsString();
		this.dPhone = doctorObject.get("d_phone").getAsString();
		this.dEmail = doctorObject.get("d_email").getAsString();
		this.dAdline1 = doctorObject.get("d_adline1").getAsString();
		this.dAdline2 = doctorObject.get("d_adline2").getAsString();
		this.dAdline3 = doctorObject.get("d_adline3").getAsString();
		this.dCity = doctorObject.get("d_city").getAsString();
		this.dSpeciality = doctorObject.get("d_speciality").getAsString();
		this.dWorkinghospital = doctorObject.get("d_working_hospital").getAsString();
		this.dBank = doctorObject.get("d_bank").getAsString();
		this.dCardtype = doctorObject.get("d_cardtype").getAsString();
		this.dCardno = doctorObject.get("d_bankaccno").getAsString();
		this.dCharge = doctorObject.get("d_charge").getAsString();

	}

	public DoctorBean(int dID, String dFname, String dLname, String dNIC,  String dPhone, String dEmail, String dAdline1, String dAdline2, String dAdline3, String dCity, String dSpeciality, String dWorkinghospital, String dBank, String dCardtype, String dCardno, String dCharge) {

				
		this.dID = dID;
		this.dFname = dFname;
		this.dLname = dLname;
		this.dNIC = dNIC;
		this.dPhone = dPhone;
		this.dEmail = dEmail;
		this.dAdline1 = dAdline1;
		this.dAdline2 = dAdline2;
		this.dAdline3 = dAdline3;
		this.dCity = dCity;
		this.dSpeciality = dSpeciality;
		this.dWorkinghospital = dWorkinghospital;
		this.dBank = dBank;
		this.dCardtype = dCardtype;
		this.dCardno = dCardno;
		this.dCharge = dCharge;		
		
	}

	
	
	public DoctorBean (String dFname, String dLname, String dNIC, String dPhone, String dEmail, String dAdline1, String dAdline2, String dAdline3, String dCity, String dSpeciality, String dWorkinghospital, String dBank, String dCardtype, String dCardno, String dCharge) {

		this.dFname = dFname;
		this.dLname = dLname;
		this.dNIC = dNIC;
		this.dPhone = dPhone;
		this.dEmail = dEmail;
		this.dAdline1 = dAdline1;
		this.dAdline2 = dAdline2;
		this.dAdline3 = dAdline3;
		this.dCity = dCity;
		this.dSpeciality = dSpeciality;
		this.dWorkinghospital = dWorkinghospital;
		this.dBank = dBank;
		this.dCardtype = dCardtype;
		this.dCardno = dCardno;
		this.dCharge = dCharge;
	}

	
	

	//getters & setters
	public int getdID() {
		return dID;
	}

	public void setId(int dID) {
		this.dID = dID;
	}

	public String getNIC() {
		return dNIC;
	}

	public void setNIC(String dNIC) {
		this.dNIC = dNIC;
	}

	public String getFname() {
		return dFname;
	}

	public void setFname(String dFname) {
		this.dFname = dFname;
	}

	public String getLname() {
		return dLname;
	}

	public void setLname(String dLname) {
		this.dLname = dLname;
	}

	public String getPhone() {
		return dPhone;
	}

	public void setPhone(String dPhone) {
		this.dPhone = dPhone;
	}

	public String getEmail() {
		return dEmail;
	}

	public void setEmail(String dEmail) {
		this.dEmail = dEmail;
	}

	public String getAdline1() {
		return dAdline1;
	}

	public void setAdline1(String dAdline1) {
		this.dAdline1 = dAdline1;
	}

	public String getAdline2() {
		return dAdline2;
	}

	public void setAdline2(String dAdline2) {
		this.dAdline2 = dAdline2;
	}
	
	public String getAdline3() {
		return dAdline3;
	}

	public void setAdline3(String dAdline3) {
		this.dAdline3 = dAdline3;
	}
	
	public String getCity() {
		return dCity;
	}

	public void setCity(String dCity) {
		this.dCity = dCity;
	}
	
	public String getSpeciality() {
		return dSpeciality;
	}

	public void setSpeciality(String dSpeciality) {
		this.dSpeciality = dSpeciality;
	}
	
	public String getWorkingHospital() {
		return dWorkinghospital;
	}

	public void setWorkingHospital(String dWorkinghospital) {
		this.dWorkinghospital = dWorkinghospital;
	}
	
	public String getBank() {
		return dBank;
	}

	public void setBank(String dBank) {
		this.dBank = dBank;
	}
	
	public String getCardtype() {
		return dCardtype;
	}

	public void setCardtype(String dCardtype) {
		this.dCardtype = dCardtype;
	}
	
	public String getCardno() {
		return dCardno;
	}

	public void setCardno(String dCardno) {
		this.dCardno = dCardno;
	}
	
	public String getCharge() {
		return dCharge;
	}

	public void setCharge(String dCharge) {
		this.dCharge = dCharge;
	}

	
}
