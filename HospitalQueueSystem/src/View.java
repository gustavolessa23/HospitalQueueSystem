
public class View {

	public View(){
		
	}

	/**
	 * Method to display the main menu
	 * @return number of choice. 
	 */
	public int displayMainMenu() {
        display(
      "\n+----------------------------------+\n" +
        "|     Hospital Management System   |\n" +
        "|----------------------------------|\n" +  
        "| 1 - Add new patient              |\n" +
        "| 2 - Check patient's position     |\n" +
        "| 3 - Update patient's info        |\n" + 
        "| 4 - List all patients            |\n" + 
        "| 5 - Remove patient               |\n" + 
        "| 6 - Remove patients from the end |\n" + 
        "| 7 - Exit Program                 |\n" +        
        "+----------------------------------+\n" +
        "Please select an option: ");
		return 7;
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
	
}
