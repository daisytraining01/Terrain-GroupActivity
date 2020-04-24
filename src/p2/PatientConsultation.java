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
		Date date=new Date();
		System.out.println("Current date and time - "+date);
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
			break;			
		case "sathish":	
			available="No";			
			break;
			default:
				break;
			
		}
		return available;
	}

	@Override
	public String LabTestResult() {
		
		String LabResult="";
		if(this.DoctorAvailablity().equals("Yes")) {
			
		System.out.println();
		LabResult="positive";
		System.out.println("Here is your Test Result...");
		}else {
			LabResult="negative";
			System.out.println("Doctor is not available ...your appointment will be rescheduled");
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
		
		if(this.DoctorAvailablity().equals("No")) {	
			
		}else if(ls.contains(DoctorPrescription)) {
			System.out.println("Medicines are provided");
		}else {
			System.out.println("Medicines are not available");
		}
		return ls.contains(DoctorPrescription);
	}
	
	@Override
	public void payment() {
		System.out.print("Enter the patient type :");
		Scanner s4=new Scanner(System.in);
		String TypeOfPatient=s4.next();
				
		if(this.MedicinesPrescribed()==true&&TypeOfPatient.equals("Regular")&&
				this.DoctorAvailablity().equals("Yes")) {					
		
		int patientAccountBalance=3450;		
		int MedicineFee=70;
		int DoctorFee=350;
		int Amount=0;	
		 
	    Amount=patientAccountBalance-(MedicineFee+DoctorFee);
	    System.out.println("Patients Existing balance- "+patientAccountBalance);		
		System.out.println("Doctor fee- "+DoctorFee+ " MedicineFee- "+MedicineFee);
		System.out.println("Patient Account balance after debit- "+Amount);
		System.out.println("******Payment has been made sucessfully*****");
		
	}else if(TypeOfPatient.equals("New")&& this.DoctorAvailablity().equals("Yes")&&
			this.MedicinesPrescribed()==true){
		System.out.println("Amount paid in cash");
	}
	}

}
