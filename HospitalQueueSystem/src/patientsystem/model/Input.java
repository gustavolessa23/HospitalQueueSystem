package patientsystem.model;

import java.util.Scanner;

import patientsystem.lib.Validation;

public class Input {

	Scanner scan;
	Validation validate;

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
		return validate.checkForInt(scan, 1, limit);
	}

	/**
	 * Method responsible to return a ID after an user input.
	 * @return Patient id.
	 */
	public int getPid() {
		return validate.checkForInt(scan, 1, Patient.getLastPid());
	}

	public boolean isYes() {
		return validate.checkForYes(scan);
	}


}
