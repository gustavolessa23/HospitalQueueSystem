
public class HospitalManagementSystem {
	
	private QueueSystem patients;
	private View view;
	private Input input;
	
	public HospitalManagementSystem(){
		this.patients = new QueueSystem();
		this.view = new View();
		this.input = new Input();
	}
	
	public void start() {
		int options = view.displayMainMenu();
		int chosenOption = input.getInt(options);
		
		mainMenuOption(chosenOption);
	}

	private void mainMenuOption(int chosenOption) {
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

	private void removePatient() {
		// TODO Auto-generated method stub
		
	}

	private void removeLastPatients() {
		// TODO Auto-generated method stub
		
	}

	private void listAll() {
		// TODO Auto-generated method stub
		
	}

	private void updatePatient() {
		// TODO Auto-generated method stub
		
	}

	private void checkPosition() {
		// TODO Auto-generated method stub
		
	}

	private void addPatient() {
		View.display("\nCREATE NEW PATIENT\n-----------------------\\n");
		
		
	}
	
	

}
