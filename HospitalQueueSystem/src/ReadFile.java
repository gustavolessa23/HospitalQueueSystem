import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class ReadFile<E> {
	ArrayListClass<E> list;
	Queue queue;
	Patient patient;
	Random random;
	FileReader file;
	Path namePath;
	Path surnamePath;
	Path emailPath;
	Path cityPath;
	Path phonePath;
	
	
	public static void main(String [] agrs){
		ReadFile read = new ReadFile();
		System.out.println("Name: " + read.generateAllPatients(10));
	}
	public ReadFile(){
		random = new Random(100);
		namePath = Paths.get("src/Patients","names.txt");
		surnamePath = Paths.get("src/Patients","surnames.txt");
		emailPath = Paths.get("src/Patients","email.txt");
		cityPath = Paths.get("src/Patients","cities.txt");
		phonePath = Paths.get("src/Patients","phone.txt");
	}

	public String getName() throws IOException{
		ArrayListClass<E> list = new ArrayListClass<>();
		File file = new File("src/Patients","names.txt"); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		  String st; 
		  while ((st = br.readLine()) != null) {
		    System.out.println(st); 
		  }
	
		return st = (String) list.get(random.nextInt(list.size())); 
	}
	
	public String generateSurname() throws IOException{
		ArrayListClass<E> list = new ArrayListClass<>();
		File file = new File("src/Patients","names.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		  String st; 
		  while ((st = br.readLine()) != null) {
		    System.out.println(st); 
		  }
	
		return st = (String) list.get(random.nextInt(list.size())); 
			
	}
	public String generatePhoneNumber() throws IOException{
		ArrayListClass<E> list = new ArrayListClass<>();
		File file = new File("src/Patients","names.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		  String st; 
		  while ((st = br.readLine()) != null) {
		    System.out.println(st); 
		  }
	
		return st = (String) list.get(random.nextInt(list.size())); 
	}
	public String generateEmail() throws IOException{
		ArrayListClass<E> list = new ArrayListClass<>();
		File file = new File("src/Patients","email.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		  String st; 
		  while ((st =  br.readLine()) != null) {
		    System.out.println(st); 
		  }
	
		return st = (String) list.get(random.nextInt(list.size())); 
	}
	
	public String generateCity() throws IOException{
		ArrayListClass<E> list = new ArrayListClass<>();
		File file = new File("src/Patients","cities.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		  String st; 
		  while ((st =  br.readLine()) != null) {
		    System.out.println(st); 
		  }
	
		return st = (String) list.get(random.nextInt(list.size())); 
	}
	public Patient createPatient() throws IOException{
		String name = (String) getName();
		String surname = (String) generateSurname();
		String phoneNumber =(String) generatePhoneNumber();
		String email =(String) generateEmail();
		String city = (String) generateCity();
	
		return new Patient("",name, surname, phoneNumber, email, city) ;
	}
	
	public Queue<Patient> generateAllPatients(int numPatients){
		Queue<Patient> queue = new Queue<Patient>();
			try {
				for(int i = 0; i<numPatients; i++){
					queue.enqueue(this.createPatient());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		return queue;
		
	}

	
}
