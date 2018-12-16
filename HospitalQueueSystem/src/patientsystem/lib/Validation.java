package patientsystem.lib;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

import patientsystem.view.View;

/**
 * This class contains methods used to validate user input such as  
 * int, int with defined range and yes/no.
 * @author Gustavo Lessa
 */
public class Validation {

	/**
	 * This method checks if the input is a integer.
	 * @param input (boolean)
	 * @return -1 if the input is not a integer
	 */
	public int checkForInt(Scanner input){
		try{
			return input.nextInt();
		} catch(InputMismatchException e){
			input.next();
			View.displayError(("\n*** Input is not a integer. Please try again. ***\n"));
			return checkForInt(input);
		}
	}
	
	/**
	 * This method checks the right input for a phone number.
	 * @param input
	 * @return the phone number if the input is correct
	 */
	public String checkPhoneNumber(Scanner input) {

		String phone = checkForString(input);

		Pattern pattern = Pattern.compile("^(?:(?:\\(?(?:00|\\+)([1-4]\\d\\d|[1-9]\\"
				+ "d?)\\)?)?[\\-\\.\\ \\\\\\/]?)?((?:\\(?\\d{1,}\\)?[\\-\\.\\ \\\\\\/]?){0,})"
				+ "(?:[\\-\\.\\ \\\\\\/]?(?:#|ext\\.?|extension|x)[\\-\\.\\ \\\\\\/]?(\\d+))?$");

		if(pattern.matcher(phone).matches()) {
			return phone;
		} else {
			View.displayError("\n*** Incorrect phone number format. Please try again. ***\n");
			return checkPhoneNumber(input);
		}
	}
	
	/**
	 * This method checks the right input for a email
	 * @param input
	 * @return the email if the input is correct.
	 */
	public String checkEmail(Scanner input) {

		String email = checkForString(input);

		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		if(pattern.matcher(email).matches()) {
			return email;
		} else {
			View.displayError("\n*** Incorrect e-mail address format. Please try again. ***\n");
			return checkEmail(input);
		}
	}
	
	
	/**
	 * This method checks the right input for the PPS Number
	 * @param input
	 * @return the PPS Number if the input is correct.
	 */
	public String checkPpsNumber(Scanner input) {

		String pps = checkForString(input);

		Pattern pattern = Pattern.compile("^(\\d{7})([A-Za-z]{1,2})$");

		if(pattern.matcher(pps).matches()) {
			return pps;
		} else {
			View.displayError("\n*** Incorrect PPS number format. Please type 7 digits followed by 1 or 2 letters. ***\n");
			return checkPpsNumber(input);
		}
	}
	
	/**
	 * This method checks for a Priority answer
	 * @param input
	 * @return true if option chosen is A || false is option chosen is B.
	 */
	public boolean checkForPriority(Scanner input){
		String answer = "";
		try{
			while(answer.isEmpty())
				answer = input.nextLine();
			
			if(answer.startsWith("A") || answer.startsWith("a")){
				View.display("Patient risk of death!! \n--------------\n");
				return true;
			}else if(answer.startsWith("B") || answer.startsWith("b")){
				View.display("Reason not compatible to move patient!! ");
				return false;
			}else {
				return checkForPriority(input);
			}
		}catch(Exception e) {
			View.display("Update could not be completed!! ");
		}
		
		return checkForPriority(input);

	}

	/**
	 * This method checks for a positive answer from user.
	 * @param input (Scanner)
	 * @return true if the input is 'Y' or 'y' and false otherwise
	 */
	public boolean checkForYes(Scanner input){
		String answer = "";
		try{
			while(answer.isEmpty())
				answer = input.nextLine();
			
			if(answer.startsWith("y") || answer.startsWith("Y")){
				return true;
			} else if(answer.startsWith("n") || answer.startsWith("N")) {
				return false;
			} else {
				return checkForYes(input);
			}
		} catch(Exception e){
			View.displayError("Error retrieving String from input.");
			return checkForYes(input);
		}
	}

	/**
	 * This method checks for a integer input between a specific boundary.
	 * @param input (Scanner)
	 * @param lowerBoundary (int)
	 * @param upperBoundary (int)
	 * @return A validated integer between the specified boundary.
	 */
	public int checkForInt(Scanner input, int lowerBoundary, int upperBoundary){
		int typedInt = 0;
		try{
			while(typedInt == 0){
				typedInt = input.nextInt();
			}
			if(typedInt>=lowerBoundary && typedInt<=upperBoundary){
				return typedInt;
			}else{
				System.out.println("\n*** The option should be and integer between "+
						lowerBoundary+" and "+upperBoundary+". ***\n");
				System.out.println("Please try again:");
				return checkForInt(input, lowerBoundary,upperBoundary);
			}
		} catch(InputMismatchException e){
			System.out.println("\n*** Input is not an integer. ***\nPlease try again.\n");
			input.nextLine();
			return checkForInt(input, lowerBoundary,upperBoundary);
		}
	}

	/**
	 * This method check for a String input
	 * @param scan
	 * @return a validated String.
	 */
	public String checkForString(Scanner scan) {
		String line = "";
		while(line.isEmpty())
			line = scan.nextLine();
		
		return line;
	}


}
