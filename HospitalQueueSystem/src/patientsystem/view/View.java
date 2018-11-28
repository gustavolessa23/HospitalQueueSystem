package patientsystem.view;
import patientsystem.lib.DoublyLinkedList;
import patientsystem.model.Patient;

public class View {

	public View(){
		
	}

	/**
	 * Method to display the main menu
	 * @return number of choice. 
	 */
	public int displayMainMenu() {
		int numberOfOptions = 7;
        display(
      "\n+----------------------------------+\n" +
        "|     Hospital Management System   |\n" +
        "|----------------------------------|\n" +  
        "| 1 - Add new patient              |\n" +
        "| 2 - Check patient's status       |\n" +
        "| 3 - Update patient's info        |\n" + 
        "| 4 - List all patients            |\n" + 
        "| 5 - Remove patient               |\n" + 
        "| 6 - Remove patients from the end |\n" + 
        "| 7 - Exit Program                 |\n" +        
        "+----------------------------------+\n");
        displayChooseOption();
		return numberOfOptions;
	}
	
	public int displayUpdateMenu() {
		int numberOfOptions = 7;
		
        display(
      "\n+----------------------------------+\n" +
        "|  Updating Patient's Information  |\n" +
        "|----------------------------------|\n" +  
        "| 1 - PPS number                   |\n" +
        "| 2 - First name                   |\n" +
        "| 3 - Last name                    |\n" + 
        "| 4 - Mobile number                |\n" + 
        "| 5 - E-mail address               |\n" + 
        "| 6 - City                         |\n" + 
        "| 7 - Go back to Main Menu         |\n" +        
        "+----------------------------------+\n");

		return numberOfOptions;
	}
	
	/**
	 * Method to display an String message.
	 * @param str
	 */
	public static void display(String str) {
		System.out.println(str);
	}
	
	/**
	 * Method to display an element into the DoublyLinkedList.
	 * @param array
	 */
	public static <E> void displayPatient(DoublyLinkedList<E> array) {
		display(array.toString());
	}
	
	/**
	 * Method to display Patients.
	 * @param patient
	 */
	public static void displayPatient(Patient patient) {
		display(patient.toString());
	}
	
	/**
	 * 
	 * @param str
	 */
	public static void displaySameLine(String str) {
		System.out.print(str);
	}
	
	/**
	 * Method to display a error message.
	 * @param str
	 */
	public static void displayError(String str) {
		System.err.println(str);
	}

	/**
	 * Method to print a message for the ID input.
	 */
	public static void askForPid() {
		display("Type Patient Number:");
	}

	/**
	 * Method to print a empty list message .
	 */
	public static void emptyListMessage() {
		display("The list is empty.");
		
	}

	public void displayChooseOption() {
		display("Please choose an option: ");
	}
	
}
