package person;

public class Doctor extends Person {

	private String hospitalId;
	private String licenseID;
	
	public Doctor() {
	}

	public Doctor(String name, int age, String phone, String hospitalId, String licenseID) {
		super(name, age, phone);
		this.hospitalId = hospitalId;
		this.licenseID = licenseID;
	}

	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getLicenseID() {
		return licenseID;
	}
	public void setLicenseID(String licenseID) {
		this.licenseID = licenseID;
	}

	@Override
	public String toString() {
		return "Doctor [hospitalId=" + hospitalId + ", licenseID=" + licenseID + "]";
	}

	
}
