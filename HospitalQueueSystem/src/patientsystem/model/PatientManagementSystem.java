package patientsystem.model;
import patientsystem.controller.ListController;
import patientsystem.view.TableList;
import patientsystem.view.View;

/**
 * This class is responsible for the system, including methods to start it, add patient, load sample data, among others.
 * @author Gustavo Lessa
 * @author Fernando Tenorio
 *
 */
public class PatientManagementSystem{

	private ListController patients; //controller with access to the data
	private View view; //view class to print to the console.
	private Input input; //input class to retrieve validated input from user.


	/**
	 * Constructor that initializes variables;
	 */
	public PatientManagementSystem(){
		this.patients = new ListController(); // for list operations
		this.view = new View(); // for displaying 
		this.input = new Input(); // to capture input
		View.displayLogo(); // to display the welcome logo
	}

	/**
	 * Method to start the system.
	 */
	public void start(){
		if(patients.isEmpty()) // if there is no patients in the list
			loadSampleData(); // ask if sample data should be loaded;

		int options = view.displayMainMenu(); // display menu options while saving the number of options.
		int chosenOption = input.getNextInt(options); // retrieve input using number of options as max.

		mainMenuHandler(chosenOption);  // call the handler with chosen option

	}

	/**
	 * 
	 * Method to load sample data if user wants to.
	 */
	private void loadSampleData(){
		View.display("Would you like to load sample patient data? (Y/N)"); // display message

		if(input.isYes()) // if user answered 'yes'
			patients.addSamplePatients(); // generate sample data
	}

	/**
	 * Method to execute a method depending on chosen option from main menu.
	 * @param chosenOption int representing the option.
	 */
	private void mainMenuHandler(int chosenOption){
		switch(chosenOption) {

		case 1:
			addPatient(); // calls method to start add patient wizard
			break;

		case 2:
			checkPosition(); // calls method to check patient status.
			break;

		case 3:
			updatePatient(); // calls method to update user's information
			break;

		case 4:
			//listAll(); // calls method to display list of patients using simple formatting.
			listAllTable(); // calls method to display list as a formatted table;
			break;		

		case 5:
			removePatient(); // calls method to remove patient
			break;

		case 6:
			removeLastPatients(); // calls method to remove last N patients.
			break;	

		case 7:
			exitSystem(); // calls method to exit system.
			break;

		default:
			// This is supposed to be unreachable, considering there are only 7 options in the main menu and the input is validated.
			View.displayError("Option not found!"); // error in case other option is chosen. 
			break;
		}
		start();
	}

	/**
	 * Method responsible to add a new user to the system.
	 */
	private void addPatient() {
		View.display("\n"
				+ "+-------------------+\n" + 
				  "|  Add New Patient  |\n" + 
				  "+-------------------+\n" ); // display message
		String ppsNumber = typePpsNumber(); // calls method to retrieve validated pps number;
		String name = typeFirstName(); // calls method to retrieve first name;
		String lastname = typeLastName(); // calls method to retrieve last name;
		String phone = typeMobileNumber(); // calls method to retrieve validated mobile number;
		String email = typeEmail(); // calls method to retrieve validated e-mail;
		String city = typeCity(); // calls method to retrieve city;
		Priority priority = choosePriority(); // calls method to retrieve priority
		Patient newPatient = new Patient(ppsNumber, name, lastname, phone, email, city, priority); // creates a new patient;

		Patient returnedAfterInsertion = null; // variable to check if patient was inserted correctly;

		if(patients.isEmpty()) {
			returnedAfterInsertion = patients.addPatient(newPatient);
		}else if(addByPriority()) // if patient should be added according to their priority
			returnedAfterInsertion = patients.addPatientByPriority(newPatient); // uses the ListController method to add to the list

		else // if the patient should be inserted in a specific position
			returnedAfterInsertion = patients.addPatientByPosition(newPatient, choosePosition());// uses the ListController method to add to that position.		

		printPatientAndPosition(returnedAfterInsertion.getPid()); // prints the last patient's information and position to confirm that it is the same 

	}

	/**
	 * This method is responsible to retrieve the desired new patient's position from the user.
	 * @return chosen position.
	 */
	private int choosePosition() {
		View.display("\nPlease choose the position:");
		return input.getNextInt(patients.getListSize()); // return validated int, maximum being the list size.
	}

	/**
	 * This method checks if the new patient should be inserted according to their priority. 
	 * @return true if they should be added by their priority
	 */
	private boolean addByPriority() {
		View.display("Where in the list the new patient should be added?\n"+
				"1 - According to the specified priority;\n"+
				"2 - Choose specific position");

		return (input.getNextInt(2) == 1) ? true : false; // if user input '1', return true. False otherwise.
	}

	/**
	 * Method to retrieve PID from user and to call another method to display information and position in the queue.
	 */
	private void checkPosition() {
		View.askForPid(); // ask for PID
		int pid = input.getPid(); // retrieve input
		printPatientAndPosition(pid); // call method to print information and position;
	}
	
	/**
	 * Method to print patient's information and position in the queue according to a PID number.
	 * @param pid
	 */
	private void printPatientAndPosition(int pid) {
		int position = patients.searchPatient(pid); // retrieve patient's position according to a PID.
		if(position > 0) { // if position exists
			View.displayPatient(patients.getPatient(position)); // display patient's information
			View.display("The patient is at position "+position+" in the queue."); // display patient's position in the queue.
		}
	}

	/**
	 * This method is responsible for updating a patient's information. 
	 */
	private void updatePatient() {

		View.askForPid(); // ask for PID;
		int idUptd = input.getPid(); // save PID 
		int positionID = patients.searchPatient(idUptd); // save patient's position

		if(positionID <= 0) // if position is not greater than 0
			View.display("Patient not found!"); // patient wasn't found

		else {

			boolean n_done = false; // determine if user wants finish updating information
			Patient updtPatient = patients.getPatient(positionID); // patient to be updated.
			printPatientAndPosition(positionID); // call method to print information and position;
			int options = view.displayUpdateMenu(); // display update menu and retrieve number of options

			while(!n_done){ // while user wants to update info
				view.displayChooseOption(); // display message asking to choose an option
				int chosen = input.getNextInt(options); // save option

				switch (chosen) {
				case 1:
					updtPatient.setPps(typePpsNumber()); // change PPS number
					break;

				case 2:
					updtPatient.setFirstName(typeFirstName()); // change first name			
					break;

				case 3:
					updtPatient.setLastName(typeLastName()); // change last name
					break;

				case 4:
					updtPatient.setMobile(typeMobileNumber()); // change mobile number
					break;

				case 5:
					updtPatient.setEmail(typeEmail()); // change e-mail address
					break;

				case 6:
					updtPatient.setCity(typeCity()); // change city
					break;

				case 7:
					n_done = true; // stop updating info
					printPatientAndPosition(positionID); // call method to print information and position;
					View.display("\n+-----------------------------------+\n"
							+      "| Information Updated Successfully! |\n"
							+      "+-----------------------------------+"); // display message
					break;
				}
			}
		}	
	}


	/**
	 * This method return a List of all patients into the List.
	 * 
	 */
	private void listAll(){
		if(!patients.isEmpty()) {
			StringBuilder sb = new StringBuilder("");
			sb.append("POSITION\tPID\t\tPRIORITY\t\tNAME\n");
			for(int x = 0; x<patients.getListSize(); x++) {
				Patient p = patients.getPatient(x+1);
				int position = x+1;
				sb.append(position);
				sb.append("\t\t");
				sb.append(p.getPid());
				sb.append("\t\t");
				sb.append(p.getPriority());
				sb.append("\t\t");
				sb.append(p.getFirstName());
				sb.append(" ");
				sb.append(p.getLastName());
				sb.append("\n");
			}

			View.display(sb.toString());
		} else 
			View.emptyListMessage();
	}

	/**
	 * Method to display a list of patients formatted as a table, ordered by position in the queue.
	 */
	private void listAllTable() {
		if(!patients.isEmpty()) { // if list is not empty
			TableList tl = new TableList(4, "POSITION", "PID", "PRIORITY", "NAME").withUnicode(true) // create new table, defining the headers
					.align(0, TableList.EnumAlignment.CENTER) // align first column to the center;
					.align(1, TableList.EnumAlignment.CENTER) // align second column to the center;
					.align(2, TableList.EnumAlignment.CENTER); // align third column to the center;
			for(int x = 0; x<patients.getListSize(); x++) { // for each patient in the queue
				Patient p = patients.getPatient(x+1); // retrieve patient
				int position = x+1; // get position
				
				// add new row
				tl.addRow(String.valueOf(position), 
						String.valueOf(p.getPid()),
						String.valueOf(p.getPriority().getDescription()),
						p.getFirstName().concat(" ").concat(p.getLastName())); // retrieve name as "First Last"
			}

			tl.print(); // print table
			
		} else  // if list is empty
			View.emptyListMessage(); // display message
	}

	/**
	 * Method to remove a patient, according to a PID.
	 */
	private void removePatient() {

		View.askForPid(); // ask for pid

		/*
		 * Try to delete a patient using user's input.
		 * The deletion method should return the deleted PID.
		 * If it returns something, a patient was removed.
		 */
		if(patients.deletePatient(input.getPid()) != null) 
			View.display("Patient removed successfully!"); // display message

		else // no patient was deleted
			View.displayError("Could not remove patient"); // display error message
	}

	/**
	 * Method to remove N patients (input by user) from the end of the list.
	 */
	private void removeLastPatients() {

		View.display("How many patients should be removed from the end of the list?"); // display message

		// retrieve input from user and delete patients, validated to just accept existing number of patients
		int removed = patients.deletePatients(input.getNextInt(patients.getListSize()));

		View.display("\nSuccessfully removed "+ removed + " patients."); // display amount of users removed.
	}

	/**
	 * Method responsible for exiting the system.
	 */
	private void exitSystem() {
		View.display("Thank you for using Hospital Management System!"); // display message
		System.exit(0);
	}

	/**
	 * Method to return validated PPS number input from user.
	 * @return PPS number
	 */
	private String typePpsNumber(){
		View.display("Please type PPS Number: "); // display message
		return input.getPpsNumber(); // return validated input
	}

	/**
	 * Method to return first name input from user.
	 * @return first name
	 */
	private String typeFirstName(){
		View.display("Please type first name: ");   // display message
		return input.getNextString(); // return input
	}

	/**
	 * Method to return last name input from user.
	 * @return last name
	 */
	private String typeLastName(){
		View.display("Please type last name: ");  // display message
		return input.getNextString(); // return input
	}

	/**
	 * Method to return validated phone number input from user.
	 * @return validated phone number
	 */
	private String typeMobileNumber(){
		View.display("Please type phone: "); // display message
		return input.getPhoneNumber(); // return validated input
	}

	/**
	 * Method to return validated e-mail address input from user.
	 * @return validated e-mail address
	 */
	private String typeEmail(){
		View.display("Please type email: ");  // display message
		return input.getEmail(); // return validated input
	}

	/**
	 * Method to return city input from user.
	 * @return city
	 */
	private String typeCity(){
		View.display("Please type city: ");  // display message
		return input.getNextString(); // return input
	}

	/**
	 * Method to return desired priority level from user.
	 * @return Priority level
	 */
	private Priority choosePriority() {

		View.display("Please choose a priority:"); // display message
		StringBuilder sb = new StringBuilder();

		for(int x = 0; x < Priority.getAllDescriptions().length; x++) {
			sb.append(x+1); // from 1 to the number of priority levels.
			sb.append(" - ");
			sb.append(Priority.getAllDescriptions()[x]);
			sb.append(";\n");
		}
		View.display(sb.toString()); // display created String, a list of all priority levels and descriptions.

		view.displayChooseOption(); // display choose option message.
		int response = input.getNextInt(Priority.getAllDescriptions().length); // get validated input, maximum being the number of priority levels.
		return Priority.getAllOptions()[response-1]; // return the correct priority level.
	}


}
