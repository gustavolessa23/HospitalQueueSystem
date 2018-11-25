import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


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
			
			Patient newPatient = new Patient(pps, firstName, lastName, mobile, email, city);
			samplePatients.addLast(newPatient);
			System.out.println(newPatient.getPid());
			
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
