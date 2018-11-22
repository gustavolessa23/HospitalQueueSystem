import java.io.IOException;

public class HospitalManagementSystem{
	
	private ReadFile listOfPatients;
	private QueueSystem patients;
	private View view;
	private Input input;

	
	public HospitalManagementSystem(){
		this.patients = new QueueSystem();
		this.listOfPatients = new ReadFile();
		this.view = new View();
		this.input = new Input();
	}
	
	public void start() throws IOException {
		int options = view.displayMainMenu();
		int chosenOption = input.getNextInt(options);
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
		start();
	}

	private void exitSystem() {
		View.display("Thank you for using Hospital Management System!");
		System.exit(0);
	}
	
	private void addPatient() {
		View.display("\nADD NEW PATIENT\n-----------------------\n");
		String ppsNumber = typePpsNumber();
		String name = typeName();
		String surname = typeSurname();
		String phone = typeMobileNumber();
		String email = typeEmail();
		String city = typeCity();
		Patient newPatient = new Patient(ppsNumber, name, surname, phone, email, city);
		
		patients.addPatient(newPatient); // uses the QueueSystem method to add to the list
		View.displayPatient(patients.getLast()); // prints the last patient to confirm that it is the same 
		
		View.display("Do you want to add another patient? (Y/N)\n------------------------------\n");
		if(input.isYes())
			addPatient();
	
	}

	private void removePatient() {
		// TODO Auto-generated method stub
		View.display("Type Patient Number:\n---------------------\n");
		
	}

	private void removeLastPatients() {
		// TODO Auto-generated method stub
		
	}

	private void listAll(){
		StringBuilder sb = new StringBuilder("");
		sb.append("POSITION\tPID\t\tNAME\n");
		for(int x = 0; x<patients.getListSize()-1; x++) {
			Patient p = patients.getPatient(x+1);
			int position = x+1;
			sb.append(position);
			sb.append("\t\t");
			sb.append(p.getPid());
			sb.append("\t\t");
			sb.append(p.getFirstName());
			sb.append(" ");
			sb.append(p.getLastName());
			sb.append("\n");
		}
		
		View.display(sb.toString());
		
	}

	private void updatePatient() {
		// TODO Auto-generated method stub
		
	}

	private void checkPosition() {
		// TODO Auto-generated method stub
		
	}

	private String typePpsNumber(){
		View.display("Please type PPS Number: "); 
		return input.getNextString();
	}
	private String typeName(){
		View.display("Please type name: ");  
        return input.getNextString();
    }
	private String typeSurname(){
		View.display("Please type surname: "); 
		return input.getNextString();
	}
	private String typeMobileNumber(){
		View.display("Please type phone: ");
		return input.getNextString();
	}
	private String typeEmail(){
		View.display("Please type email: "); 
		return input.getNextString();
	}
	private String typeCity(){
		View.display("Please type City: "); 
		return input.getNextString();
	}
	
	
	

}
