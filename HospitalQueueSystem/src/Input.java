import java.util.Scanner;

public class Input {

	Scanner scan = new Scanner(System.in);
	Validation validate;
	
	public Input() {
		 scan = new Scanner(System.in);
		 validate = new Validation();
	}
	
	public int getNextInt(int limit) {
		return validate.checkForInt(scan, 1, limit);
	}
	
	public String getNextString() {
		String line = "";
		while(line.isEmpty())
			line = scan.nextLine();
		return line;
	}
	
	public boolean isYes() {
		return validate.checkForYes(scan);
	}
	
	
}
