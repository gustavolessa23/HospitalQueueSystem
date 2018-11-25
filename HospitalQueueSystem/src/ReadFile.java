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
	 * Method responsible to get patients information from text file, and print into the patient list.
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
		"1654337FH	Robert		Bentley		0899567472		Robert.321@cct.com		Wolverhampton",
		"1975587FM	Jacob		Barclay		0875736272		Jacob@hotmail.com		Cork", 
		"1754347FI	Jacob		Adley		0877465732		Jacob@gmail.com			Sheffield", 
		"1296437FO	Jacob		Hackney		0883474573		Jacob@google.com		Sheffield", 
		"1956637FQ	Michael		Ainsworth	0847573745		Michael@gmail.xom		Manchester", 
		"1234567FE	Charlie		Berkelen	0884585348		Charlie@hotmail.com		Sunderland", 
		"1245647FP	Kyle		Alby		0853458582		Kyle@cct.com			Bradford", 
		"1265327FW	William		Addington	4756558372		William@ccd.com			Newcastle", 
		"1554217FL	Thomas		Alston		018384475		Thomas@hotmail.com		Liverpool", 
		"12345674K	Joe			Ethan		019484557		David@gmail.co			Dublin", 
		"1444567FJ	George		Allerton	015733848		George@grindr.com		Swords", 
		"1654347FS	Reece		Ainsley		018475746		Reece@cct.com			Leeds", 
		"1265337FV	Michael		Abram		017564857		Michael@vanilla.com		Birmingham"};

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
