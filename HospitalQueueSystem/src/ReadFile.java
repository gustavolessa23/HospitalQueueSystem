import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ReadFile {

	DoublyLinkedList<Patient> array;
	Patient patient;
	public ReadFile(){
		
		array = new DoublyLinkedList<>();
		patient = new Patient();
	}
	/**
	 * Method responsable to get patients information from text file, and print into the patient list.
	 * @return
	 * @throws IOException
	 */
	public DoublyLinkedList<Patient> getSamplePatients() throws IOException{
		DoublyLinkedList<Patient> samplePatients = new DoublyLinkedList<Patient>();


		File file = new File("src/Patients","names.txt"); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String st = null;	
		
		String[] test = {"1224327FB	Oliver		Barney		014370969		Oliver.32@gmail.com		Dublin", 
		"1224327FB	Jake		Hadley		+35314370969 	Jake@cct.com			Dublin",
		"1224327FB	Noah		Barton		0035314370969	Noah@hotmail.com		Galway",
		"1224327FB	James		Hadleigh	019898984		James@cct.com			Galway",
		"1243567FF	Jack		Bentham		0892528484		Jack@yahoo.com			Newcastle",
		"1235667FT	Connor		Hailey		0894735768		Connor@cct.com			Drogheda",
		"1767767FY	Liam		Beckwith	0885747636		Liam@hotmail.com		Waterford",
		"1234656FG	John		Hale		0837558967		John@ss.com				Sheffield",
		"1234567FU	Harry		Badger		0865747526		Harry@yahoo.com			Limerick",
		"6445567FA	Callum		Hadlee		014933847		Callum@gmail.com		Galway",
		"1567567FI	Mason		Benson		0862356837		Mason@hotmail.com		Bristol",
		"1654337FH	Robert		Bentley		0899567472		Robert.321@cct.com		Wolverhampton"};

		for(String str : test){
			String[] row = str.split("\\s+");

			String pps = (row[0]);
			String firstName = (row[1]);
			String lastName = (row[2]);
			String mobile = (row[3]);
			String email = (row[4]);
			String city = (row[5]);
			
			samplePatients.addLast(new Patient(pps, firstName, lastName, mobile, email, city));
			System.out.println(samplePatients.size());
			st = null;

		}
		System.out.println("Tamanho: "+samplePatients.size());
		br.close();
		return samplePatients;

	}
}
