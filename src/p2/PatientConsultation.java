package p2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PatientConsultation extends PatientDetails implements PatientManagement{	
	 
	
	public static void main(String[] args) {
		System.out.println("*********Patient Management System-ERP********");		
		System.out.println("Enter the patient details:");
		 Scanner s=new Scanner(System.in);
		 System.out.print("Enter the patient name:");			
		 String patientName=s.nextLine();
		 System.out.print("Enter the patient contact number:");			
		 int contactNumber=s.nextInt();
		 System.out.print("Enter the patient gender:");			
		 String gender=s.next();
		 System.out.print("Enter the patient age:");
		 int age=s.nextInt();
		 System.out.print("Enter the patient Blood group:");			
		 String BG=s.next();	
		 System.out.print("Enter the patient ID proof:");			
		 String IDProof=s.next();
		 System.out.print("Enter the Doctor Name:");
		
		PatientConsultation pc=new PatientConsultation();
		pc.setPatientName(patientName);
		pc.setGender(gender);
		pc.setAge(age);
		pc.setContactNumber(contactNumber);
		pc.setBloodGroup(BG);
		pc.setIDProof(IDProof);
		
		pc.getPatientName();
		pc.getGender();
		pc.getAge();
		pc.getBloodGroup();
		pc.getContactNumber();
		pc.getIDProof();
		
		pc.AppoitmentDetails();
		pc.payment();
		
	}
	
	
	@Override
	public void AppoitmentDetails() {
		Date date;
	}

	Scanner s1=new Scanner(System.in);	
	String doctorName=s1.next();
	
	@Override
	public String DoctorAvailablity() {
		
		String available="No";
		
		switch(doctorName) {
		
		case "saravanan":
			available="Yes";
			System.out.println("The doctor is available");
			break;
		case "rajesh":	
			available="Yes";			
			System.out.println("The doctor is available");
			break;
		case "varun":	
			available="No";			
			System.out.println("The doctor is not  available");
			break;
			
		case "sathish":	
			available="No";			
			System.out.println("The doctor is not available");
			break;
			default:
				break;
			
		}
		return available;
	}

	@Override
	public String LabTestResult() {
		
		String LabResult="positive";
		if(this.DoctorAvailablity().equals("Yes")) {
		
		System.out.println("Get the test results");
		}else {
			System.out.println("Doctor not available ...your appointed will be rescheduled");
		}
		return LabResult;
		
	}

	@Override
	public String DoctorConsultation() {
		
		String prescription="";
		if(this.LabTestResult().equals("positive")) {			
			prescription = "DOLO650";
			System.out.println("Doctor has prescribed "+prescription);
		}
		return prescription;
		
	}

	
	@Override
	public boolean MedicinesPrescribed() {
		ArrayList<String> ls=new ArrayList<String>();
		ls.add("DOLO650");
		ls.add("Crosin");
		ls.add("Citrosin");
		ls.add("Aspernt");
		ls.add("Paracitamol");
		ls.add("Piriton");
		
		String DoctorPrescription=this.DoctorConsultation();
		ls.contains(DoctorPrescription);
		
		if(ls.contains(DoctorPrescription)) {
			System.out.println("Medicines are provided");
		}else {
			System.out.println("Medicines are not available");
		}
		return ls.contains(DoctorPrescription);
	}

	@Override
	public void payment() {
		
		String TypeOfPatient="Regular";
				
		if(this.MedicinesPrescribed()==true&&TypeOfPatient.equals("Regular")) {		
		
		int patientAccountBalance=3450;		
		int MedicineFee=70;
		int DoctorFee=350;
		int Amount=0;	
		 
	    Amount=patientAccountBalance-(MedicineFee+DoctorFee);
	    System.out.println("Patients Existing balance- "+patientAccountBalance);		
		System.out.println("Doctor fee- "+DoctorFee+ "MedicineFee- "+MedicineFee);
		System.out.println("Patient Account balance after debit- "+Amount);
		System.out.println("******Payment has been made sucessfully*****");
		
	}else {
		System.out.println("Amount paid in cash");
	}
	}
}
