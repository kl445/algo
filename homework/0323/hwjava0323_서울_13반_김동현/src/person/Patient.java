package person;

public class Patient extends Person {

	private String diseaseName;
	private String hospitalled;
	private boolean isCorona;
	
	
	
	public Patient() {
	}
	public Patient(String name, int age, String phone, String diseaseName, String hospitalled, boolean isCorona) {
		super(name, age, phone);
		this.diseaseName = diseaseName;
		this.hospitalled = hospitalled;
		this.isCorona = isCorona;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public String getHospitalled() {
		return hospitalled;
	}
	public void setHospitalled(String hospitalled) {
		this.hospitalled = hospitalled;
	}
	public boolean isCorona() {
		return isCorona;
	}
	public void setCorona(boolean isCorona) {
		this.isCorona = isCorona;
	}
	@Override
	public String toString() {
		return super.toString()+",diseaseName=" + diseaseName + ", hospitalled=" + hospitalled + ", isCorona=" + isCorona + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		Patient p= (Patient) o;
		if(this.getName().equals(p.getName())&& this.getPhone().equals(p.getPhone())) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash=7;
		hash=31*hash+this.getName().hashCode();
		hash=31*hash+this.getPhone().hashCode();
		return hash;
	}
	
	
	
	
}
