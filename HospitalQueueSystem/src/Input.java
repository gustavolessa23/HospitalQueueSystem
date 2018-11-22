import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Input {

	Scanner scan = new Scanner(System.in);
	Validation validate;
	ReadFile sample;
	
	public Input() {
		 scan = new Scanner(System.in);
		 validate = new Validation();
		 sample = new ReadFile();
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
	
	public int getPid() {
		return validate.checkForInt(scan, 1, Patient.getLastPid());
	}
	
	public DoublyLinkedList<Patient> getSamplePatients(){
		try {
			return sample.getSamplePatients();
		} catch (IOException e) {
			View.displayError("Could not load sample patients from file.");
			return null;
		}
	}

	
}
