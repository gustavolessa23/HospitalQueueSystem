// CCT College Dublin
// Dr. Muhammad Iqbal

import java.util.ArrayList;

/**
 *
 * @author munaw
 */
public class Queue <E>{
    
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
 
	public int size() {
 		return queueList.size();
 	}
 
	public void displayQueue() {
		//for (int i = 0; i < queueList.size(); i++)
		//	System.out.println("QueueList[" + i + "] = " + queueList.get(i));   

 	}  
}
