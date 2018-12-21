package patientsystem.model;
import java.io.IOException;

import patientsystem.controller.SystemController;
import patientsystem.view.TableList;
import patientsystem.view.View;

public class PatientManagementSystem{

	private SystemController patients;
	private View view;
	private Input input;


	public PatientManagementSystem(){
		this.patients = new SystemController();
		this.view = new View();
		this.input = new Input();
	}

	public void start(){
		if(patients.isEmpty())
			loadSampleData();

		int options = view.displayMainMenu();
		int chosenOption = input.getNextInt(options);

		mainMenuHandler(chosenOption);

	}

	/**
	 * Method responsible to load the Patient sample data. 
	 */
	private void loadSampleData(){
		View.displayLogo();
		View.display("Would you like to load sample patient data? (Y/N)");

		if(input.isYes()) 
			patients.generateSamplePatients();
	}

	private void mainMenuHandler(int chosenOption){
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
			//listAll();
			listAllTable();
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
	 * Method responsible to take String as parameters and add the information to create a new Patient into the list
	 * after a user input.
	 */
	private void addPatient() {
		View.display("\nADD NEW PATIENT\n-----------------------\n");
		String ppsNumber = typePpsNumber();
		String name = typeFirstName();
		String lastname = typeLastName();
		String phone = typeMobileNumber();
		String email = typeEmail();
		String city = typeCity();
		char priority = choosePriority();
		Patient newPatient = new Patient(ppsNumber, name, lastname, phone, email, city, priority);

		Patient returnedAfterInsertion = null;
		
		if(addByPriority()) 
			returnedAfterInsertion = patients.addPatientByPriority(newPatient); // uses the SystemController method to add to the list
		
		else	
			returnedAfterInsertion = patients.addPatientByPosition(newPatient, choosePosition());			

		View.displayPatient(returnedAfterInsertion); // prints the last patient to confirm that it is the same 

		View.display("Position in the queue: "+ patients.searchPatient(returnedAfterInsertion.getPid()));
	}



	/**
	 * This method is responsible to choose the position that the patient is going to be added
	 * @return return the last position added in the sytem.
	 */
	private int choosePosition() {
		View.display("\nPlease choose the position:");
		return input.getNextInt(patients.getListSize());
	}

	/**
	 * This method checks which type of priority the patient is being added as
	 * @return the input number chosen by the user 
	 */
	private boolean addByPriority() {
		View.display("Where in the list the new patient should be added?\n"+
					"1 - According to the specified priority;\n"+
					"2 - Choose specific position");
		
		return (input.getNextInt(2) == 1) ? true : false;
	}

	/**
	 * This method return a patient position, by typing ID Number.
	 */
	private void checkPosition() {
		View.askForPid();
		int pid = input.getPid();
		int position = patients.searchPatient(pid);
		if(position > 0) {
			View.displayPatient(patients.getPatient(position));
			View.display("The patient is in position "+position+".");
		}
	}

	//	/**
	//	 * This method a new Patient ID Position by typing the old position, then the new position after the urgency set. 
	//	 */
	//	private void updatePatient() {
	//		// TODO Auto-generated method stub
	//		View.display("Do you want to update patient? - 1 Yes -- 2 No\n-----------------\n");
	//		int answer = this.input.validate.checkForInt(this.input.scan, 1, 2);
	//		if(answer == 1){
	//			View.display("Select priority A or priority B: \n-----------------\n");
	//			input.validate.checkForPriority(this.input.scan);
	//			
	//			View.askForPid();;
	//			int oldID = input.getPid();
	//			
	//			View.display("Type new patient disired position: \n-----------\n");
	//			int newID = input.getPid();
	//			
	//			if(patients.updatePatient(oldID, newID) != null ){
	//				View.display("Patient updated successfully!");
	//			}else{
	//				View.displayError("Could not upddate patient");
	//			}
	//			
	//		}
	//		else if(answer == 2){
	//		}
	//	}

	/**
	 * This method is responsible to update patient information by a given ID. 
	 */
	private void updatePatient() {
		View.display("Do you want to update a patient's information? (Y/N)");

		if(input.isYes()){

			View.askForPid();
			int idUptd = input.getPid();
			int positionID = patients.searchPatient(idUptd);

			if(positionID <= 0)
				View.display("Patient not found! ");

			else {

				boolean n_done = false;
				Patient updtPatient = patients.getPatient(positionID);
				View.displayPatient(updtPatient);
				int options = view.displayUpdateMenu();

				while(!n_done){
					view.displayChooseOption();
					int chosen = input.getNextInt(options);

					switch (chosen) {
					case 1:
						updtPatient.setPps(typePpsNumber());
						break;

					case 2:
						updtPatient.setFirstName(typeFirstName());					
						break;

					case 3:
						updtPatient.setLastName(typeLastName());
						break;

					case 4:
						updtPatient.setMobile(typeMobileNumber());
						break;

					case 5:
						updtPatient.setEmail(typeEmail());
						break;

					case 6:
						updtPatient.setCity(typeCity());
						break;

					case 7:
						n_done = true;
						View.displayPatient(updtPatient);
						View.display("Information Updated Successfully!");
						break;
					}
				}
			}	
		}
	}

	/**
	 * This method return a List of all patients into the List.
	 * @throws IOException
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
	 * Method responsible to list the table into the system, by getting patient information.
	 */
	private void listAllTable() {
		if(!patients.isEmpty()) {
			TableList tl = new TableList(4, "POSITION", "PID", "PRIORITY", "NAME").withUnicode(true)
																				.align(0, TableList.EnumAlignment.CENTER)
																				.align(1, TableList.EnumAlignment.CENTER)
																				.align(2, TableList.EnumAlignment.CENTER);
			for(int x = 0; x<patients.getListSize(); x++) {
				Patient p = patients.getPatient(x+1);
				int position = x+1;
				tl.addRow(String.valueOf(position),
						String.valueOf(p.getPid()),
						String.valueOf(p.getPriority()),
						p.getFirstName().concat(" ").concat(p.getLastName()));
			}

			tl.print();
		} else 
			View.emptyListMessage();
	}

	/**
	 * This method remove a patient from the list after a user input.
	 */
	private void removePatient() {

		View.askForPid();

		if(patients.deletePatient(input.getPid()) != null) 
			View.display("Patient removed successfully!");

		else
			View.displayError("Could not remove patient");
	}

	/**
	 * This method removes a number of N element typed by the user from the end of the List.
	 */
	private void removeLastPatients() {

		View.display("How many patients should be removed from the end of the list?");

		int removed = patients.deletePatients(input.getNextInt(patients.getListSize()));

		View.display("\nSuccessfully removed "+ removed + " patients.");
	}

	/**
	 * Method responsible to exit the system
	 */
	private void exitSystem() {
		View.display("Thank you for using Hospital Management System!");
		System.exit(0);
	}





	//	/**
	//	 * This method a new Patient ID Position by typing the old position, then the new position after the urgency set. 
	//	 */
	//	private void updatePatient() {
	//		// TODO Auto-generated method stub
	//		View.display("Do you want to update patient? - 1 Yes -- 2 No\n-----------------\n");
	//		int answer = this.input.validate.checkForInt(this.input.scan, 1, 2);
	//		if(answer == 1){
	//			View.display("Select priority A or priority B: \n-----------------\n");
	//			input.validate.checkForPriority(this.input.scan);
	//			
	//			View.askForPid();;
	//			int oldID = input.getPid();
	//			
	//			View.display("Type new patient disired position: \n-----------\n");
	//			int newID = input.getPid();
	//			
	//			if(patients.updatePatient(oldID, newID) != null ){
	//				View.display("Patient updated successfully!");
	//			}else{
	//				View.displayError("Could not upddate patient");
	//			}
	//			
	//		}
	//		else if(answer == 2){
	//		}
	//	}

	/**
	 * This method returns a choice of PPS Number from user input.
	 * @return
	 */
	private String typePpsNumber(){
		View.display("Please type PPS Number: "); 
		return input.getPpsNumber();
	}

	/**
	 * This method returns a choice of Name from user input.
	 * @return
	 */
	private String typeFirstName(){
		View.display("Please type first name: ");  
		return input.getNextString();
	}

	/**
	 * This method returns a choice of Surname from user input.
	 * @return
	 */
	private String typeLastName(){
		View.display("Please type last name: "); 
		return input.getNextString();
	}

	/**
	 * This method returns a choice of Phone Number from user input.
	 * @return
	 */
	private String typeMobileNumber(){
		View.display("Please type phone: ");
		return input.getPhoneNumber();
	}

	/**
	 * This method returns a choice of Email from user input.
	 * @return
	 */
	private String typeEmail(){
		View.display("Please type email: "); 
		return input.getEmail();
	}

	/**
	 * This method returns a choice of city from user input.
	 * @return
	 */
	private String typeCity(){
		View.display("Please type city: "); 
		return input.getNextString();
	}
	
	/**
	 * Method responsible to check the priority type
	 * @return 
	 */
	private char choosePriority() {
		View.display("Please choose a priority: \n"+
				"1 - Risk of death / Emergency;\n"+
				"2 - Elderly / Pregnant / Disabled;\n"+
				"3 - Normal priority;");
		view.displayChooseOption();
		int reponse = input.getNextInt(3);
		return (char)(96+reponse);
	}


}
