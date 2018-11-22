import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class ReadFile<E> {
	private DoublyLinkedList<E> queueList;
	ArrayListClass<E> list;
	Queue<?> queue;
	Patient patient;
	FileReader file;



	public static void main(String [] agrs) throws IOException{
		ReadFile read = new ReadFile();
		// System.out.println(read.test());
		System.out.println("Name: " + read.generateAllPatients(1));
	}
	public ReadFile(){

	}

	public DoublyLinkedList<Patient> generateAllPatients(int numPatients){
		DoublyLinkedList<Patient> queueList = new DoublyLinkedList<Patient>();
		try {
			for(int i = 0; i<numPatients; i++){
				queueList.addLast(this.test());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queueList;

	}
	public Patient test() throws IOException{
		DoublyLinkedList<Patient> array = new DoublyLinkedList<>();
		ArrayListClass<E> list = new ArrayListClass<>();
		File file = new File("src/Patients","names.txt"); 

		BufferedReader br = new BufferedReader(new FileReader(file)); 

		String st;
		//		  if((st = br.readLine() != null){
		//			  
		//		  }
		while ((st =  br.readLine()) != null) {
			String[] row = new String[6];
			row =  st.split("\\s+");
			Patient patient =  new Patient();
			((Patient) patient).setPps(row[0]);
			((Patient) patient).setFirstName(row[1]);
			((Patient) patient).setLastName(row[2]);
			((Patient) patient).setMobile(row[3]);
			((Patient) patient).setEmail(row[4]);
			((Patient) patient).setCity(row[5]);
			array.addLast(patient);

			for(int i = 0; i< array.size(); i++){
				System.out.println(array);
			}

		}
		return patient;	
	}


}
