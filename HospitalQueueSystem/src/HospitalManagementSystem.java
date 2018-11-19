
public class HospitalManagementSystem {

	public static void main(String[] args) {
		DoublyLinkedList<Patient> queue = new DoublyLinkedList<>();
		
		queue.addFirst(new Patient("333","Fernando", "Tenorio", "08997-76848", "fsantos.@hotmail.com", "dublin"));
		queue.addFirst(new Patient("333","Fernando", "Tenorio", "08997-76848", "fsantos.@hotmail.com", "dublin"));
		queue.addFirst(new Patient("333","Fernando", "Tenorio", "08997-76848", "fsantos.@hotmail.com", "dublin"));

		for(int i = 0; i< queue.size(); i++){
			System.out.println(new Patient("333","Fernando", "Tenorio", "08997-76848", "fsantos.@hotmail.com", "dublin").toString());
		}
	
		queue.size();
	}

}
