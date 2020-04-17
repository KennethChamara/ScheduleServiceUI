package beans;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@XmlRootElement
public class HospitalBean {
	int id;
	private String hospitalName;
	private String hospitalPhone;
	private String hospitalAddrLine1;
	private String hospitalAddrLine2;
	private String hospitalAddrLine3;
	private String hospitalCity;
	private String hospitalEmail;
	private String hospitalDesc;
	private String hospitalServices;
	private String hospitalAccNo;
	private String hospitalBank;
	private String hospitalCharge;

	public HospitalBean() {
	}

	public HospitalBean(String hos) {

		JsonObject hospitalObject = new JsonParser().parse(hos).getAsJsonObject();

		if (hospitalObject.get("h_ID") != null) {
			this.id = hospitalObject.get("h_ID").getAsInt();
		}
		this.hospitalName = hospitalObject.get("h_name").getAsString();
		this.hospitalPhone = hospitalObject.get("h_phone").getAsString();
		this.hospitalAddrLine1 = hospitalObject.get("h_addrLine1").getAsString();
		this.hospitalAddrLine2 = hospitalObject.get("h_addrLine2").getAsString();
		this.hospitalAddrLine3 = hospitalObject.get("h_addrLine3").getAsString();
		this.hospitalCity = hospitalObject.get("h_city").getAsString();
		this.hospitalEmail = hospitalObject.get("h_email").getAsString();
		this.hospitalDesc = hospitalObject.get("h_desc").getAsString();
		this.hospitalServices = hospitalObject.get("h_services").getAsString();
		this.hospitalAccNo = hospitalObject.get("h_accountNo").getAsString();
		this.hospitalBank = hospitalObject.get("h_bank").getAsString();
		this.hospitalCharge = hospitalObject.get("h_charge").getAsString();

	}

	public HospitalBean(int id, String hospitalName, String hospitalPhone, String hospitalAddrLine1,
			String hospitalAddrLine2, String hospitalAddrLine3, String hospitalCity, String hospitalEmail,
			String hospitalDesc, String hospitalServices, String hospitalAccNo, String hospitalBank,
			String hospitalCharge) {
		this.id = id;
		this.hospitalName = hospitalName;
		this.hospitalPhone = hospitalPhone;
		this.hospitalAddrLine1 = hospitalAddrLine1;
		this.hospitalAddrLine2 = hospitalAddrLine2;
		this.hospitalAddrLine3 = hospitalAddrLine3;
		this.hospitalCity = hospitalCity;
		this.hospitalEmail = hospitalEmail;
		this.hospitalDesc = hospitalDesc;
		this.hospitalServices = hospitalServices;
		this.hospitalAccNo = hospitalAccNo;
		this.hospitalBank = hospitalBank;
		this.hospitalCharge = hospitalCharge;
	}

	public HospitalBean(String hospitalName, String hospitalPhone, String hospitalAddrLine1, String hospitalAddrLine2,
			String hospitalAddrLine3, String hospitalCity, String hospitalEmail, String hospitalDesc,
			String hospitalServices, String hospitalAccNo, String hospitalBank, String hospitalCharge) {
		this.hospitalName = hospitalName;
		this.hospitalPhone = hospitalPhone;
		this.hospitalAddrLine1 = hospitalAddrLine1;
		this.hospitalAddrLine2 = hospitalAddrLine2;
		this.hospitalAddrLine3 = hospitalAddrLine3;
		this.hospitalCity = hospitalCity;
		this.hospitalEmail = hospitalEmail;
		this.hospitalDesc = hospitalDesc;
		this.hospitalServices = hospitalServices;
		this.hospitalAccNo = hospitalAccNo;
		this.hospitalBank = hospitalBank;
		this.hospitalCharge = hospitalCharge;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalPhone() {
		return hospitalPhone;
	}

	public void setHospitalPhone(String hospitalPhone) {
		this.hospitalPhone = hospitalPhone;
	}

	public String getHospitalAddrLine1() {
		return hospitalAddrLine1;
	}

	public void setHospitalAddrLine1(String hospitalAddrLine1) {
		this.hospitalAddrLine1 = hospitalAddrLine1;
	}

	public String getHospitalAddrLine2() {
		return hospitalAddrLine2;
	}

	public void setHospitalAddrLine2(String hospitalAddrLine2) {
		this.hospitalAddrLine2 = hospitalAddrLine2;
	}

	public String getHospitalAddrLine3() {
		return hospitalAddrLine3;
	}

	public void setHospitalAddrLine3(String hospitalAddrLine3) {
		this.hospitalAddrLine3 = hospitalAddrLine3;
	}

	public String getHospitalCity() {
		return hospitalCity;
	}

	public void setHospitalCity(String hospitalCity) {
		this.hospitalCity = hospitalCity;
	}

	public String getHospitalEmail() {
		return hospitalEmail;
	}

	public void setHospitalEmail(String hospitalEmail) {
		this.hospitalEmail = hospitalEmail;
	}

	public String getHospitalDesc() {
		return hospitalDesc;
	}

	public void setHospitalDesc(String hospitalDesc) {
		this.hospitalDesc = hospitalDesc;
	}

	public String getHospitalServices() {
		return hospitalServices;
	}

	public void setHospitalServices(String hospitalServices) {
		this.hospitalServices = hospitalServices;
	}

	public String getHospitalAccNo() {
		return hospitalAccNo;
	}

	public void setHospitalAccNo(String hospitalAccNo) {
		this.hospitalAccNo = hospitalAccNo;
	}

	public String getHospitalBank() {
		return hospitalBank;
	}

	public void setHospitalBank(String hospitalBank) {
		this.hospitalBank = hospitalBank;
	}

	public String getHospitalCharge() {
		return hospitalCharge;
	}

	public void setHospitalCharge(String hospitalCharge) {
		this.hospitalCharge = hospitalCharge;
	}

}
