
public class HospitalManagementSystem {
	
	public static Patient patient;

	public static void main(String[] args) {
		Queue<Patient> queue = new Queue<>();
		
		queue.enqueue(new Patient("333","Fernando", "Tenorio", "08997-76848", "fsantos.@hotmail.com", "dublin", 'c'));
		queue.enqueue(new Patient("333","Fernando", "Tenorio", "08997-76848", "fsantos.@hotmail.com", "dublin", 'b'));
		queue.enqueue(new Patient("333","Fernando", "Tenorio", "08997-76848", "fsantos.@hotmail.com", "dublin", 'a'));

		
	
		queue.displayQueue();
	}

}
