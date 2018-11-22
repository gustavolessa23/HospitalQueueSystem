import java.io.IOException;
import java.util.Scanner;

public class HospitalManagementSystem{
	
	private ReadFile listOfPatients;
	private QueueSystem patients;
	private View view;
	private Input input;
	private Scanner in = new Scanner(System.in);
	
	public HospitalManagementSystem(){
		this.patients = new QueueSystem();
		this.listOfPatients = new ReadFile();
		this.view = new View();
		this.input = new Input();
	}
	
	public void start() throws IOException {
		int options = view.displayMainMenu();
		int chosenOption = input.getInt(options);
		
		mainMenuOption(chosenOption);
	}

	private void mainMenuOption(int chosenOption) throws IOException {
		switch(chosenOption) {

		case 1:
			addPatient();
			break;
		
		case 2:
			checkPosition();
			break;
		
		case 3:
			updatePatient();
			break;
		
		case 4:
			listAll();
			break;		
		
		case 5:
			removePatient();
			break;
		
		case 6:
			removeLastPatients();
			break;	
		
		case 7:
			exitSystem();
			break;
		
		default:
			View.displayError("Option not found!");;
			break;
		
		}
	}

	private void exitSystem() {
		View.display("Thank you for using Hospital Management System!");
		System.exit(0);
	}
	
	private void addPatient() {
		View.display("\nCREATE NEW PATIENT\n-----------------------\\n");
		String ppsNumber = typePpsNumber();
		String name = typeName();
		String surname = typeSurName();
		String phone = typeMobileNumber();
		String email = typeEmail();
		String city = typeCity();
		Patient patient = new Patient(ppsNumber, name, surname, phone, email, city);
		View.displayPatient(patient);
		View.display("Do you want to add more Patiend?\n----------------------\n");
		
	}

	private void removePatient() {
		// TODO Auto-generated method stub
		View.display("Type Patient Number:\n---------------------\n");
		
	}

	private void removeLastPatients() {
		// TODO Auto-generated method stub
		
	}

	private void listAll() throws IOException {
		// TODO Auto-generated method stub
		listOfPatients.createPatients();
		
	}

	private void updatePatient() {
		// TODO Auto-generated method stub
		
	}

	private void checkPosition() {
		// TODO Auto-generated method stub
		
	}

	private String typePpsNumber(){
		View.display("Please type PPS Number: "); 
		return in.next();
	}
	private String typeName(){
		View.display("Please type name: ");  
        return in.next();
    }
	private String typeSurName(){
		View.display("Please type surname: "); 
		return in.next();
	}
	private String typeMobileNumber(){
		View.display("Please type phone: ");
		return in.next();
	}
	private String typeEmail(){
		View.display("Please type email: "); 
		return in.next();
	}
	private String typeCity(){
		View.display("Please type City: "); 
		return in.next();
	}
	
	
	

}
