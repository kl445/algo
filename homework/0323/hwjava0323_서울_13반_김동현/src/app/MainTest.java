package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import medical.CDC;
import medical.Hospital;
import medical.NotCoronaException;
import person.Patient;

public class MainTest {

	public static void main(String[] args) throws NotCoronaException {
		// TODO Auto-generated method stub

		Hospital univHospital=new Hospital("대학병원",15,"001",50,10);
		Hospital localHospital=new Hospital("동네병원",3,"901",10,2);
		
		Patient p1= new Patient("tommy brown", 42, "010-1111-111", "호흡곤란", "001", true);
		Patient p2= new Patient("mally julie", 30, "010-222-2222", "과음", "901",false);
		
		
		List<Hospital> hospitalList=new ArrayList<Hospital>();
		hospitalList.add(univHospital);
		hospitalList.add(localHospital);
		
		Set<Patient> patientList=new HashSet<Patient>();
		
		patientList.add(p1);
		patientList.add(p2);
		
		
		CDC cdc= new CDC("질병관리본부",200,hospitalList,patientList);

		Patient p3= new Patient("brown", 22, "010-1111-111", "발열", "001", true);
		Patient p4= new Patient("brown", 22, "010-1111-111", "발열", "001", true);
		Patient p5= new Patient("wr", 22, "010-1111-111", "발열", "001", false);
		Patient p6= new Patient("김이박", 22, "20200323", "발열", "001", true);
		
		univHospital.addPatient(cdc, p6);
		try {
			univHospital.addPatient(cdc, p5);
		}catch (NotCoronaException e) {

			System.out.println("not 코로나");
			
		}
		
		 univHospital.addPatient(cdc, p3);
		System.out.println(cdc.getPatientList());
		
		univHospital.removePatient(cdc, p3);
		System.out.println(cdc.getPatientList());

		univHospital.addPatient(cdc, p3);
		System.out.println(cdc.getPatientList());
		
		univHospital.removePatient(cdc, p4);
		System.out.println(cdc.getPatientList());
		
		
		
		
		String filePatch ="d:\\SSAFY\\JAVA\\KillCorona\\file";
		String fileName="CoronaPatientList.csv";
		
		try {
//			BufferedWriter writer=new BufferedWriter(new FileWriter(filePatch+File.separator+fileName));
			BufferedWriter writer=
				new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream(filePatch+File.separator+fileName),"MS949"));
		
			for (Patient p : patientList) {
				writer.write(p.getName()+ "," +p.getAge()+ "," +p.getPhone());
				writer.newLine();
			}
			writer.flush();
		}
		
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
