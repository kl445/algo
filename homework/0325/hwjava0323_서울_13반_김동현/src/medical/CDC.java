package medical;


import java.util.List;
import java.util.Set;

import person.Patient;

public class CDC extends Organization implements MedicalAction{
	
	private List<Hospital> hospitalList ;
	private Set<Patient> patientList;
	
	public CDC() {
	}
	
	public CDC(String name, int employeeCount,List<Hospital> hospitalList, Set<Patient> patientList) {
		super(name,employeeCount);
		this.hospitalList = hospitalList;
		this.patientList = patientList;
	}

	public List<Hospital> getHospitalList() {
		return hospitalList;
	}

	public void setHospitalList(List<Hospital> hospitalList) {
		this.hospitalList = hospitalList;
	}

	public Set<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(Set<Patient> patientList) {
		this.patientList = patientList;
	}

	public void about(){
		System.out.println("Organization - CDC " + super.getName());
	}
	public void about(String more) {
		about();
		System.out.println("We Manage Hospital and Patients");
	}

	@Override
	public String toString() {
		return "CDC [hospitalList=" + hospitalList + ", patientList=" + patientList + "]";
	}
	
	public void addPatient(CDC cdc, Patient p) throws NotCoronaException{
		 if( ! p.isCorona() ) throw new NotCoronaException("NotCorona");
		 cdc.getPatientList().add(p);
		 }

	@Override
	public void removePatient(CDC cdc, Patient p) {
		 cdc.getPatientList().remove(p);
		 }
		

	@Override
	public void writePatient(List<Patient> pList) {
		// TODO Auto-generated method stub
		
	}
	
	

}
