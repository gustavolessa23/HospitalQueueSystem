
public class View {

	public View(){
		
	}

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
	
	public static void display(String str) {
		System.out.println(str);
	}
	
	public static void displaySameLine(String str) {
		System.out.print(str);
	}
	
	public static void displayError(String str) {
		System.err.println(str);
	}
	
}
