import java.io.IOException;

public class HospitalManagementSystem{


	private QueueSystem patients;
	private View view;
	private Input input;


	public HospitalManagementSystem(){
		this.patients = new QueueSystem();
		new ReadFile();

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

	private void loadSampleData() throws IOException {
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

	/**
	 * Method responsable to exit the system
	 */
	private void exitSystem() {
		View.display("Thank you for using Hospital Management System!");
		System.exit(0);
	}

	/**
	 * Method responsable to take String as parameters and add the information to add a new Patient into the list
	 * after a user input.
	 */
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
	
	/**
	 * Thie method remove a patient from the list after a user input.
	 */
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
	

	/**
	 * Thie method removes a number of N element typed by the user from the end of the List.
	 */
	private void removeLastPatients() {
		View.display("How many patients should be removed from the end of the list?");
		int removed  = patients.deletePatients(input.getNextInt(patients.getListSize()));
		View.display("\nSuccessfully removed "+ removed + " patients.");

	}

	/**
	 * This method return a List of all patients into the List.
	 * @throws IOException
	 */
	private void listAll() throws IOException{
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

	/**
	 * This method a new Patient ID Position by typing the old position, then the new position after the urgency set. 
	 */
	private void updatePatient() {
		// TODO Auto-generated method stub
		View.display("Do you want to update patient? - 1 Yes -- 2 No\n-----------------\n");
		int answer = this.input.validate.checkForInt(this.input.scan, 1, 2);
		if(answer == 1){
			View.display("Select priority A or priority B: \n-----------------\n");
			input.validate.checkForPriority(this.input.scan);
			
			View.display("Type Patient current ID: \n--------------\n");
			int oldID = input.getPid();
			
			View.display("Type new patient disired position: \n-----------\n");
			int newID = input.getPid();
			
			if(patients.updatePatient(oldID, newID) != null ){
				View.display("Patient updated successfully!");
			}else{
				View.displayError("Could not upddate patient");
			}
			
		}
		else if(answer == 2){
		}



	}

	/**
	 * This method return a patient position, by typing ID Number.
	 */
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

	/**
	 * This method returns a choice of PPS Number from user input.
	 * @return
	 */
	private String typePpsNumber(){
		View.display("Please type PPS Number: "); 
		return input.getNextString();
	}
	
	/**
	 * This method returns a choice of Name from user input.
	 * @return
	 */
	private String typeName(){
		View.display("Please type name: ");  
		return input.getNextString();
	}
	
	/**
	 * This method returns a choice of Surname from user input.
	 * @return
	 */
	private String typeSurname(){
		View.display("Please type surname: "); 
		return input.getNextString();
	}
	
	/**
	 * This method returns a choice of Phone Number from user input.
	 * @return
	 */
	private String typeMobileNumber(){
		View.display("Please type phone: ");
		return input.getNextString();
	}
	
	/**
	 * This method returns a choice of Email from user input.
	 * @return
	 */
	private String typeEmail(){
		View.display("Please type email: "); 
		return input.getNextString();
	}
	
	/**
	 * This method returns a choice of city from user input.
	 * @return
	 */
	private String typeCity(){
		View.display("Please type city: "); 
		return input.getNextString();
	}




}
