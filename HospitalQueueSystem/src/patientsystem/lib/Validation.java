package patientsystem.lib;

import java.util.regex.Pattern;
import patientsystem.view.View;

/**
 * This class contains methods used to validate user input such as  
 * int, int with defined range and yes/no.
 * @author Gustavo Lessa
 */
public class Validation {

//	/**
//	 * This method checks if the input is a integer.
//	 * @param input (boolean)
//	 * @return -1 if the input is not a integer
//	 */
//	public int checkForInt(Scanner input){
//		try{
//			return input.nextInt();
//		} catch(InputMismatchException e){
//			input.next();
//			View.displayError(("\n*** Input is not a integer. Please try again. ***\n"));
//			return checkForInt(input);
//		}
//	}
	
	public String checkPhoneNumber(String phone) {

		Pattern pattern = Pattern.compile("^(?:(?:\\(?(?:00|\\+)([1-4]\\d\\d|[1-9]\\"
				+ "d?)\\)?)?[\\-\\.\\ \\\\\\/]?)?((?:\\(?\\d{1,}\\)?[\\-\\.\\ \\\\\\/]?){0,})"
				+ "(?:[\\-\\.\\ \\\\\\/]?(?:#|ext\\.?|extension|x)[\\-\\.\\ \\\\\\/]?(\\d+))?$");

		if(pattern.matcher(phone).matches()) {
			return phone;
		} else {
			return null;
		}
	}
	

	public String checkEmail(String email) {

		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		if(pattern.matcher(email).matches()) {
			return email;
		} else {
			return null;
		}
	}
	
	
	
	public String checkPpsNumber(String pps) {

		Pattern pattern = Pattern.compile("^(\\d{7})([A-Za-z]{1,2})$");

		if(pattern.matcher(pps).matches()) {
			return pps;
		} else {
			return "";
		}
	}
	
//	/**
//	 * This method checks for a Priority answer
//	 * @param input
//	 * @return true if option chosen is A || false is option chosen is B.
//	 */
//	public boolean checkForPriority(Scanner input){
//		String answer = "";
//		try{
//			while(answer.isEmpty())
//				answer = input.nextLine();
//			
//			if(answer.startsWith("A") || answer.startsWith("a")){
//				View.display("Patient risk of death!! \n--------------\n");
//				return true;
//			}else if(answer.startsWith("B") || answer.startsWith("b")){
//				View.display("Reason not compatible to move patient!! ");
//				return false;
//			}else {
//				return checkForPriority(input);
//			}
//		}catch(Exception e) {
//			View.display("Update could not be completed!! ");
//		}
//		
//		return checkForPriority(input);
//
//	}

	/**
	 * This method checks for a positive answer from user.
	 * @param input (Scanner)
	 * @return true if the input is 'Y' or 'y' and false otherwise
	 */
	public boolean checkForYes(String answer){

		if(answer.startsWith("y") || answer.startsWith("Y")){
			return true;
		} else if(answer.startsWith("n") || answer.startsWith("N")) {
			return false;
		} 
		return false;
	}

	/**
	 * This method checks for a integer input between a specific boundary.
	 * @param input (Scanner)
	 * @param lowerBoundary (int)
	 * @param upperBoundary (int)
	 * @return A validated integer between the specified boundary.
	 */
	public int checkForInt(int number, int lowerBoundary, int upperBoundary){
		if(number>=lowerBoundary && number<=upperBoundary){
			return number;
		}else{
			return -1;
		}

	}

}
