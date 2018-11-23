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
	QueueSystem queue;
	DoublyLinkedList<Patient> array;
	Patient patient;
	public ReadFile(){
		queue = new QueueSystem();
		array = new DoublyLinkedList<>();
		patient = new Patient();
	}
	//static Patient patient = new Patient();
	//	public DoublyLinkedList<Patient> generateAllPatients(int numPatients){
	//
	//		DoublyLinkedList<Patient> queueList = new DoublyLinkedList<>();
	//		try {
	//			for(int i = 0; i<numPatients; i++){
	//				queueList.addLast(this.createPatients(patient));
	//			}
	//		} catch (IOException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		return queueList;
	//
	//	}
	/**
	 * Method responsable to get patients information from text file, and print into the patient list.
	 * @return
	 * @throws IOException
	 */
	public Patient createPatients() throws IOException{
		File file = new File("src/Patients","names.txt"); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String st = null;	
		if((st =  br.readLine()) != null) {
			String[] row = new String[6];
			row =  st.split("\\s+");

			patient.setPps(row[0]);
			patient.setFirstName(row[1]);
			patient.setLastName(row[2]);
			patient.setMobile(row[3]);
			patient.setEmail(row[4]);
			patient.setCity(row[5]);

			for(int i = 1; i < array.size(); i++){
				array.addFirst(patient);
				View.displayPatient(array);
			}


		}
		return patient;
	}


}
