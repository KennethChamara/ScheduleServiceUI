package beans;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@XmlRootElement
public class DoctorBean {

	private int id;
	private String fname;
	private String lname;
	private String nic;
	private String phone;
	private String email;
	private String adline1;
	private String adline2;
	private String adline3;
	private String city;
	private String speciality;
	private String workinghospital;
	private String bank;
	private String cardtype;
	private String cardno;
	private String charge;
	private String username;
	private String password;
	
	public DoctorBean() {}
	
	

	public DoctorBean(int id, String fname, String lname, String nic, String phone, String email, String adline1,
			String adline2, String adline3, String city, String speciality, String workinghospital, String bank,
			String cardtype, String cardno, String charge) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.nic = nic;
		this.phone = phone;
		this.email = email;
		this.adline1 = adline1;
		this.adline2 = adline2;
		this.adline3 = adline3;
		this.city = city;
		this.speciality = speciality;
		this.workinghospital = workinghospital;
		this.bank = bank;
		this.cardtype = cardtype;
		this.cardno = cardno;
		this.charge = charge;
	
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdline1() {
		return adline1;
	}

	public void setAdline1(String adline1) {
		this.adline1 = adline1;
	}

	public String getAdline2() {
		return adline2;
	}

	public void setAdline2(String adline2) {
		this.adline2 = adline2;
	}

	public String getAdline3() {
		return adline3;
	}

	public void setAdline3(String adline3) {
		this.adline3 = adline3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getWorkinghospital() {
		return workinghospital;
	}

	public void setWorkinghospital(String workinghospital) {
		this.workinghospital = workinghospital;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	

//	public DoctorBean(String doc) {
//
//		JsonObject doctorObject = new JsonParser().parse(doc).getAsJsonObject();
//
//		if (doctorObject.get("d_ID") != null) {
//			this.dID = doctorObject.get("d_ID").getAsInt();
//		}
//
//		this.dFname = doctorObject.get("d_fname").getAsString();
//		this.dLname = doctorObject.get("d_lname").getAsString();
//		this.dNIC = doctorObject.get("d_NIC").getAsString();
//		this.dPhone = doctorObject.get("d_phone").getAsString();
//		this.dEmail = doctorObject.get("d_email").getAsString();
//		this.dAdline1 = doctorObject.get("d_adline1").getAsString();
//		this.dAdline2 = doctorObject.get("d_adline2").getAsString();
//		this.dAdline3 = doctorObject.get("d_adline3").getAsString();
//		this.dCity = doctorObject.get("d_city").getAsString();
//		this.dSpeciality = doctorObject.get("d_speciality").getAsString();
//		this.dWorkinghospital = doctorObject.get("d_working_hospital").getAsString();
//		this.dBank = doctorObject.get("d_bank").getAsString();
//		this.dCardtype = doctorObject.get("d_cardtype").getAsString();
//		this.dCardno = doctorObject.get("d_bankaccno").getAsString();
//		this.dCharge = doctorObject.get("d_charge").getAsString();
//
//	}
	
	


	
	
	

	
}
