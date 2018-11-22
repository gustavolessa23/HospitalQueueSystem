import java.util.Scanner;

public class Input {

	Scanner scan;
	Validation validate;
	
	public Input() {
		 scan = new Scanner(System.in);
		 validate = new Validation();
	}
	
	public int getInt(int limit) {
		return validate.checkForInt(scan, 1, limit);
	}
	
	
	
}
