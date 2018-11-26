import java.util.Scanner;

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
 			line = scan.next();
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
	
	/**
	 * This method returns Sample of Patient List in the system
	 * @return Sample of Patient List
	 */
//	public DoublyLinkedList<Patient> getSamplePatients(){
//		try {
//			return sample.getSamplePatients();
//		} catch (IOException e) {
//			View.displayError("Could not load sample patients from file.");
//			return null;
//		}
//	}
	
	public boolean isYes() {
		return validate.checkForYes(scan);
	}

	
}
