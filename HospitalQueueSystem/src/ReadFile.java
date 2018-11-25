import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.RowId;
import java.util.Random;

public class ReadFile {

	DoublyLinkedList<Patient> array;
	Patient patient;
	public ReadFile(){
		// queue = new QueueSystem();
		array = new DoublyLinkedList<>();
		patient = new Patient();
	}
	
	public DoublyLinkedList<Patient> getSamplePatients() throws IOException{
		DoublyLinkedList<Patient> samplePatients = new DoublyLinkedList<Patient>();


		File file = new File("src/Patients","names.txt"); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String st = null;	

		if((st =  br.readLine()) != null) {
			String[] row = new String[6];

//		while ((st =  br.readLine()) != null) {
//			String[] row = st.split("\\s+");
//
//			patient.setPps(row[0]);
//			patient.setFirstName(row[1]);
//			patient.setLastName(row[2]);
//			patient.setMobile(row[3]);
//			patient.setEmail(row[4]);
//			patient.setCity(row[5]);
//
//			for(int i = 1; i < array.size(); i++){
//				array.addFirst(patient);
//				View.displayPatient(array);
//			}

			String pps = (row[0]);
			String firstName = (row[1]);
			String lastName = (row[2]);
			String mobile = (row[3]);
			String email = (row[4]);
			String city = (row[5]);
			
			samplePatients.addLast(new Patient(pps, firstName, lastName, mobile, email, city));
			
			System.out.println(samplePatients.size());
			
		}
		System.out.println("Tamanho: "+samplePatients.size());
		br.close();
		return samplePatients;
	}
	

}

