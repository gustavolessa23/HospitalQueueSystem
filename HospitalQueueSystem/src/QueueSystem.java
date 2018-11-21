
public class QueueSystem {

	
	Queue<Patient> queue;
	
	public QueueSystem() {
		queue = new Queue<>();
		queue.enqueue(new Patient("333","Fernando", "Tenorio", "08997-76848", "fsantos.@hotmail.com", "dublin", 'c'));
		queue.enqueue(new Patient("333","Fernando", "Tenorio", "08997-76848", "fsantos.@hotmail.com", "dublin", 'b'));
		queue.enqueue(new Patient("333","Fernando", "Tenorio", "08997-76848", "fsantos.@hotmail.com", "dublin", 'a'));

		
		System.out.println(queue);
	}

	

}
