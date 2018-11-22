import java.util.Scanner;

public class Input {

	Scanner scan = new Scanner(System.in);
	Validation validate;
	
	public Input() {
		 scan = new Scanner(System.in);
		 validate = new Validation();
	}
	
	public String getNextString() {
 
 		String line = "";
 		while(line.isEmpty())
 			line = scan.next();
 		return line;
 	}
	
	public int getNextInt(int limit) {
		return validate.checkForInt(scan, 1, limit);
	}

	
	
	
}
