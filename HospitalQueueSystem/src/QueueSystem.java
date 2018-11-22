
public class QueueSystem {
//	private Node<Patient> header;
//	private Node<Patient> trailer;
//	private int size = 0;
	DoublyLinkedList<Patient> list;

	public QueueSystem() {
		list = new DoublyLinkedList<>();
	}
	
	public Patient deletePatient(int pid){
		int patientPosition = searchPatient(pid);
		
		return list.remove(patientPosition);
	}
	
	public int searchPatient(int pid){
		int foundPosition = 0;
		for(int x = 1; x < list.size(); x++) 
			if(list.get(x).getPid() == pid)
				foundPosition = x;
		
		return foundPosition;
	}
	
//	public Node findPatient(Node p, Node<Patient> patient) {
//		Node current = p; // current is the cursor
//		while (current != null && current.getElement() != patient) // while is not what I'm
//			// looking for
//			current = current.getNext();
//		return current;
//	}

}
