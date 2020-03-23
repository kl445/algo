package medical;

import java.util.List;
import person.Patient;

public interface MedicalAction {

	void addPatient(CDC cdc, Patient p) throws NotCoronaException  ;
	void removePatient(CDC cdc, Patient p);
	void writePatient(List<Patient> pList);
	
	default int getPatientNum() {
		return 1;
	}
}
