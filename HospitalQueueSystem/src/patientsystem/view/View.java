package patientsystem.view;
import patientsystem.lib.interfaces.DoublyLinkedListInterface;
import patientsystem.model.Patient;

/**
 * Class responsible for displaying information to the CLI. Can
 * @author gustavolessa1
 *
 */
public class View {

	public View(){
		
	}

	/**
	 * Method to display the main menu
	 * @return number of choices. 
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
	
	/**
	 * Method to display the update menu.
	 * @return number of choices for the updates
	 */
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
	 * Method to display welcome logo message.
	 */
	public static void displayLogo(){
		display("\\    /\\    / |‾ ‾  |     /‾ ‾   /‾ ‾\\   /\\    /\\   |‾ ‾   \n" + 
				" \\  /  \\  /  |- -  |    |      |     | /  \\  /  \\  |- -    \n" + 
				"  \\/    \\/   |_ _  |_ _  \\_ _   \\_ _/ /    \\/    \\ |_ _   \n" + 
				"");
	}
	
	/**
	 * Method to display an String.
	 * @param str
	 */
	public static void display(String str) {
		System.out.println(str);
	}
	
	
	/**
	 * Method to display a Patient's information.
	 * @param Patient patient
	 */
	public static void displayPatient(Patient patient) {
		display(patient.toString());
	}
	
	/**
	 * Method to display an String and keep the same line.
	 * @param str
	 */
	public static void displaySameLine(String str) {
		System.out.print(str);
	}
	
	/**
	 * Method to display an error message.
	 * @param str
	 */
	public static void displayError(String str) {
		System.err.println(str);
	}

	/**
	 * Method to display a message asking for a Patient ID.
	 */
	public static void askForPid() {
		displaySameLine("Type Patient Number:");
	}

	/**
	 * Method to display an empty list message.
	 */
	public static void emptyListMessage() {
		display("The list is empty.");
	}

	/**
	 * Method to display a 'choose option' message.
	 */
	public void displayChooseOption() {
		display("Please choose an option: ");
	}
	
}
