package patientsystem.model;

import java.util.Scanner;

import patientsystem.lib.Validation;

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
		return validate.checkForString(scan);
	}

	/**
	 * Method responsible to check an Integer input
	 * @param limit
	 * @return int input.
	 */
	public int getNextInt(int limit) {
		return validate.checkForInt(scan, 1, limit);
	}

	/**
	 * Method responsible to get patient validated phone number
	 * @return validated phone number input
	 */
	public String getPhoneNumber() {
		return validate.checkPhoneNumber(scan);
	}
	
	/**
	 * Method responsible to get patient validated PPS Number
	 * @return validated PPS Number input
	 */
	public String getPpsNumber() {
		return validate.checkPpsNumber(scan);
	}
	
	/**
	 * Method responsible to get patient validated email
	 * @return validated email input
	 */
	public String getEmail() {
		return validate.checkEmail(scan);
	}
	
	/**
	 * Method responsible to return a ID after an user input.
	 * @return Patient id.
	 */
	public int getPid() {
		return validate.checkForInt(scan, 1, Patient.getLastPid());
	}

	/**
	 * Method responsible to check if a input is Yes
	 * @return validated yes input
	 */
	public boolean isYes() {
		return validate.checkForYes(scan);
	}


}
