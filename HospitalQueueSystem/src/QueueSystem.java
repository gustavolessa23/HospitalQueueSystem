
public class QueueSystem {
	private Node<Patient> header;
	private Node<Patient> trailer;
	private int size = 0;
	DoublyLinkedList<Patient> list;

	public QueueSystem() {
		list = new DoublyLinkedList<>();
	}


	public Patient deletePatient(Node <Patient> patient){
		Patient current = list.remove(patient);
		return patient.getElement();

	}
	
	public Node<Patient> searchPatient(int position){
		Node<Patient> findPatient = list.getNode(position);
		return findPatient;
	}
	
	
	
	
	
	
	
	
	

	public Node findPatient(Node p, Node<Patient> patient) {
		Node current = p; // current is the cursor
		while (current != null && current.getElement() != patient) // while is not what I'm
			// looking for
			current = current.getNext();
		return current;
	}



}
