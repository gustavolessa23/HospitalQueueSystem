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
		if(patients.isEmpty())
			loadSampleData();

		int options = view.displayMainMenu();
		int chosenOption = input.getNextInt(options);

		mainMenuOption(chosenOption);

	}

	private void loadSampleData() {

		View.display("Would you like to load sample patient data? (Y/N)");
		if(input.validate.checkForYes(input.scan));
		patients.addPatients(input.getSamplePatients());
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

		View.display("Do you want to add more Patiend?\n----------------------\n"+ "1 - Yes\n" + "2 - No");

		int answer = this.input.validate.checkForInt(this.input.scan, 1, 2);
		if(answer == 1){
			addPatient();	
			patients.addPatient(newPatient); // uses the QueueSystem method to add to the list
			View.displayPatient(patients.getLast()); // prints the last patient to confirm that it is the same 
			View.display("Do you want to add another patient? (Y/N)\n------------------------------\n");
		}
		else if(answer == 2){
			View.displayPatient(newPatient);// display all patients added into the List, once the user select option 2.
		}
	}
	private void removePatient() {

		// TODO Auto-generated method stub
		int delete = 0;
		View.display("Type Patient Number:\n---------------------\n");
		patients.deletePatient(delete);

		View.askForPid();
		if(patients.deletePatient(input.getPid()) != null) {
			View.display("Patient removed successfully!");
		} else {
			View.displayError("Could not remove patient");
		}	
	}

	private void removeLastPatients() {
		// TODO Auto-generated method stu	
	}

	private void listAll(){

		if(!patients.isEmpty()) {
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
		} else {
			View.emptyListMessage();	
		}

	}

	private void updatePatient() {
		// TODO Auto-generated method stub
		view.display("Do you want to Update Patient? - 1 Yes -- 2 No\n-----------------\n");
		int answer = this.input.validate.checkForInt(this.input.scan, 1, 2);
		if(answer == 1){
			view.display("Type Patient actual ID: \n--------------\n");
			
			int oldID = input.getPid();
			int newID = input.getPid();

			patients.updatePatient(oldID, newID);

			if(patients.updatePatient(oldID, newID) == 1) {
				View.display("Patient updated successfully!");
			} else {
				View.displayError("Could not upddate patient");
			}
		}



	}

	private void checkPosition() {
		// TODO Auto-generated method stub

		patients.searchPatient(input.scan.nextInt());

		View.askForPid();
		int pid = input.getPid();
		int position = patients.searchPatient(pid);
		if(position > 0) {
			View.display("Patient PID "+pid+" is in position "+position+".");
		}

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
		View.display("Please type city: "); 
		return input.getNextString();
	}




}
