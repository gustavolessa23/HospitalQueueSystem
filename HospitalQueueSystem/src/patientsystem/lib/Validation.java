package patientsystem.lib;

import java.util.regex.Pattern;

/**
 * This class contains methods used to validate user input such as  
 * int with defined range, yes/no, PPS number, e-mail address and phone number.
 * @author Gustavo Lessa
 */
public class Validation {
	
	/**
	 * This method checks if a String is a phone number.
	 * @param phone
	 * @return
	 */
	public String checkPhoneNumber(String phone) {

		Pattern pattern = Pattern.compile("^(?:(?:\\(?(?:00|\\+)([1-4]\\d\\d|[1-9]\\"
				+ "d?)\\)?)?[\\-\\.\\ \\\\\\/]?)?((?:\\(?\\d{1,}\\)?[\\-\\.\\ \\\\\\/]?){0,})"
				+ "(?:[\\-\\.\\ \\\\\\/]?(?:#|ext\\.?|extension|x)[\\-\\.\\ \\\\\\/]?(\\d+))?$"); // pattern for phone number, accepting extension number.

		if(pattern.matcher(phone).matches()) // if given String matches the pattern
			return phone; // return it
		else // if it doesn't match
			return null; // return null
	}
	
	/**
	 * This method checks if a String is an e-mail address
	 * @param email (String)
	 * @return validated e-mail address or null.
	 */
	public String checkEmail(String email) {

		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"); // pattern for e-mail address format

		if(pattern.matcher(email).matches()) // if given String matches the pattern
			return email; // return it
		
		else // if it doesn't match
			return null; // return null

	}
	
	/**
	 * This method checks if a String is a PPS number (7 digits followed by 2 letters).
	 * @param pps (String)
	 * @return validated String or empty
	 */
	public String checkPpsNumber(String pps) {

		Pattern pattern = Pattern.compile("^(\\d{7})([A-Za-z]{1,2})$"); // pattern for PPS number.

		if(pattern.matcher(pps).matches())  // if given String matches the pattern
			return pps; // return it
		
		else // if it doesn't match
			return ""; // return empty
	}
	

	/**
	 * This method checks if a String is 'Yes' or 'No', accepting 'n' and 'y', case insensitive.
	 * @param answer (String)
	 * @return true if the input is 'Y' or 'yes', case insensitive, false otherwise.
	 */
	public boolean checkForYes(String answer){

		if(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) // if String is y or yes
			return true; // return true
		else if(answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) // if String is n or no
			return false; // return false
		else // if String isn't any of above options
			throw new IllegalArgumentException(); // throw exception.
	}

	/**
	 * This method checks for a integer input between a specific boundary.
	 * @param number (int)
	 * @param lowerBoundary (int)
	 * @param upperBoundary (int)
	 * @return true if integer is between the specified boundary.
	 */
	public boolean checkForInt(int number, int lowerBoundary, int upperBoundary){
		if(number>=lowerBoundary && number<=upperBoundary)
			return true;
		else
			return false;
	}

}
