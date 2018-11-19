
public class QueueSystem {

	
	Queue<Patient> queue;
	
	public QueueSystem() {
		queue = new Queue<>();
		queue.enqueue(new Patient("333","Fernando", "Tenorio", "08997-76848", "fsantos.@hotmail.com", "dublin"));
		queue.enqueue(new Patient("333","Fernando", "Tenorio", "08997-76848", "fsantos.@hotmail.com", "dublin"));
		queue.enqueue(new Patient("333","Fernando", "Tenorio", "08997-76848", "fsantos.@hotmail.com", "dublin"));

		System.out.println(queue);
	}

	

}
