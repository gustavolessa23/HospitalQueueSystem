package patientsystem.model;

import java.util.InputMismatchException;
import java.util.Scanner;

import patientsystem.lib.Validation;
import patientsystem.view.View;

public class Input {

	private Scanner scan;
	private Validation validate;

	public Input() {
		scan = new Scanner(System.in);
		validate = new Validation();
	}

	/**
	 * Method responsible to check if the input is an String
	 * @return String input
	 */
	public String getNextString() {
		String line = "";
		while(line.isEmpty())
			line = scan.nextLine();
		
		return line;
	}

	/**
	 * Method responsible to check an Integer input
	 * @param limit
	 * @return int input.
	 */
	public int getNextInt(int limit) {
		int typedInt = 0;
		try{
			while(typedInt == 0){
				typedInt = scan.nextInt();
			}
			typedInt = validate.checkForInt(typedInt, 1, limit);
			if(typedInt == -1) {
				View.displayError("\n*** The option should be and integer between 1"
						+ " and "+limit+". ***\n");
				View.displayError("Please try again:");
				return getNextInt(limit);
			} else {
				return typedInt;
			}
			
		} catch(InputMismatchException e){
			View.displayError("\n*** Input is not an integer. ***\nPlease try again.\n");
			scan.nextLine();
			return getNextInt(limit);
		}
	}

	public String getPhoneNumber() {

		String phone = validate.checkPhoneNumber(getNextString());

		if(phone.isEmpty() || phone == null) {
			View.displayError("\n*** Incorrect phone number format. Please try again. ***\n");
			return getPhoneNumber();
		} else {
			return phone;
		}
	}
	
	public String getPpsNumber() {
		String pps = "";
		pps = validate.checkPpsNumber(getNextString());
		
		if(pps.isEmpty() || pps == null) {
			View.displayError("\n*** Incorrect PPS number format. Please type 7 digits followed by 1 or 2 letters. ***\n");
			return getPpsNumber();
		} else 
			return pps;
	}
	
	public String getEmail() {
		String email = validate.checkEmail(getNextString());
		
		if(email.isEmpty() || email == null) {
			View.displayError("\n*** Incorrect e-mail address format. Please try again. ***\n");
			return getEmail();
		} else 
			return email;
	}
	
	/**
	 * Method responsible to return a ID after an user input.
	 * @return Patient id.
	 */
	public int getPid() {
		return getNextInt(Patient.getLastPid());
	}

	public boolean isYes() {
		String answer = "";
		try{
			while(answer.isEmpty())
				answer = scan.nextLine();

			return validate.checkForYes(answer);

		} catch(Exception e){
			View.displayError("Error retrieving String from input.");
			return isYes();
		}
	}


}
