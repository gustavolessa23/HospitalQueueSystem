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
	
	public DoublyLinkedList<Patient> getSamplePatients() throws IOException{
		DoublyLinkedList<Patient> samplePatients = new DoublyLinkedList<>();

		File file = new File("src/Patients","names.txt"); 

		BufferedReader br = new BufferedReader(new FileReader(file)); 

		String st = null;	
		while ((st =  br.readLine()) != null) {
			String[] row = st.split("\\s+");

			String pps = (row[0]);
			String firstName = (row[1]);
			String lastName = (row[2]);
			String mobile = (row[3]);
			String email = (row[4]);
			String city = (row[5]);
			
			samplePatients.addLast(new Patient(pps, firstName, lastName, mobile, email, city));
			System.out.println(samplePatients.size());
			
//			System.out.println(patient);

			st = null;
//			if(patient !=null){
//				View.displayPatient(patient);
//			}
		}
		System.out.println("Tamanho: "+samplePatients.size());
		br.close();
		return samplePatients;
	}


}
