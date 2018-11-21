// CCT College Dublin
// Dr. Muhammad Iqbal

/**
 *
 * @author munaw
 */
public class Queue<E>{
    
  private DoublyLinkedList<E> queueList;
 
	public Queue() {
 		queueList = new DoublyLinkedList<E>();
 	}
 
	public void enqueue(E item) {
 		queueList.addLast(item);
 	}
 
	public E dequeue() {
 		if (!isEmpty())
 		    return queueList.removeFirst();
		else return null;
// 		    throw new EmptyQueueException();
 	}
 
	public boolean isEmpty() {
 		return (queueList.isEmpty());
 	}
	
	public E firstElement() {
 		if (!isEmpty())
 			
 		    return queueList.first();
 		else
// 		    throw new EmptyQueueException();
		return null;
 	}
	
	public E lastElement() {
 		if (!isEmpty())
 			
 		    return queueList.last();
 		else
// 		    throw new EmptyQueueException();
		return null;
 	}
	
	public E getNext(Node<E> node) {
 		if (!isEmpty())
 		    return queueList.);
 		else
// 		    throw new EmptyQueueException();
		return null;
 	}
 
	public int size() {
 		return queueList.size();
 	}
 
	public void displayQueue() {
		System.out.println("HOSPITAL QUEUE");
		System.out.println("-------------------------"); 

		for (int i = 0; i < size(); i++) {
			System.out.println((i+1)+" - Patient: "+ );
		}
	
	}
}
