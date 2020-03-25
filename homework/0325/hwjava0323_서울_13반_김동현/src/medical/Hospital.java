package medical;

import java.util.List;

import person.Patient;

public class Hospital extends Organization implements MedicalAction{

	private String hospitalId;
	int roomTotalCount;
	int roomEmptyCount;
	
	
	public Hospital() {
		super();
	}

	public Hospital(String name, int employeeCount,String hospitalId, int roomTotalCount, int roomEmptyCount) {
		super(name,employeeCount);
		this.hospitalId = hospitalId;
		this.roomTotalCount = roomTotalCount;
		this.roomEmptyCount = roomEmptyCount;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public int getRoomTotalCount() {
		return roomTotalCount;
	}

	public void setRoomTotalCount(int roomTotalCount) {
		this.roomTotalCount = roomTotalCount;
	}

	public int getRoomEmptyCount() {
		return roomEmptyCount;
	}

	public void setRoomEmptyCount(int roomEmptyCount) {
		this.roomEmptyCount = roomEmptyCount;
	}

	public void aobut(String more) {
		super.about();
		System.out.println("we are Hospital"+more);
	}

	@Override
	public String toString() {
		return "Hospital [hospitalId=" + hospitalId + ", roomTotalCount=" + roomTotalCount + ", roomEmptyCount="
				+ roomEmptyCount + "]";
	}

	@Override
	public void addPatient(CDC cdc, Patient p) throws NotCoronaException {
		// TODO Auto-generated method stub
		if(!p.isCorona())throw new NotCoronaException("NotCorona");
		cdc.addPatient(cdc,p);
		
	}

	@Override
	public void removePatient(CDC cdc, Patient p) {
		// TODO Auto-generated method stub
		cdc.removePatient(cdc,p);
	}

	@Override
	public void writePatient(List<Patient> pList) {

//		getPatientNum();
	}
	
	
}
