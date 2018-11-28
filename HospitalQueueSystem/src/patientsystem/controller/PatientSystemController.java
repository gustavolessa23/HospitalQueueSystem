package patientsystem.controller;
import java.io.IOException;

import patientsystem.model.Input;
import patientsystem.model.Patient;
import patientsystem.model.QueueSystem;
import patientsystem.view.View;

public class PatientSystemController{

	private QueueSystem patients;
	private View view;
	private Input input;


	public PatientSystemController(){
		this.patients = new QueueSystem();
		this.view = new View();
		this.input = new Input();
	}

	public void start(){
		if(patients.isEmpty())
			loadSampleData();

		int options = view.displayMainMenu();
		int chosenOption = input.getNextInt(options);

		mainMenuOption(chosenOption);

	}

	private void loadSampleData(){
		View.display("Would you like to load sample patient data? (Y/N)");
		
		if(input.isYes()) 
			patients.generateSamplePatients();
	}

	private void mainMenuOption(int chosenOption){
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
	 * Method responsible to exit the system
	 */
	private void exitSystem() {
		View.display("Thank you for using Hospital Management System!");
		System.exit(0);
	}

	/**
	 * Method responsible to take String as parameters and add the information to create a new Patient into the list
	 * after a user input.
	 */
	private void addPatient() {
		View.display("\nADD NEW PATIENT\n-----------------------\n");
		String ppsNumber = typePpsNumber();
		String name = typeFirstName();
		String surname = typeLastName();
		String phone = typeMobileNumber();
		String email = typeEmail();
		String city = typeCity();
		Patient newPatient = new Patient(ppsNumber, name, surname, phone, email, city);

		patients.addPatient(newPatient); // uses the QueueSystem method to add to the list
		View.displayPatient(patients.getLast()); // prints the last patient to confirm that it is the same 
			
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
	 * This method return a List of all patients into the List.
	 * @throws IOException
	 */
	private void listAll(){
		if(!patients.isEmpty()) {
			StringBuilder sb = new StringBuilder("");
			sb.append("POSITION\tPID\t\tNAME\n");
			for(int x = 0; x<patients.getListSize(); x++) {
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
		} else 
			View.emptyListMessage();
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
