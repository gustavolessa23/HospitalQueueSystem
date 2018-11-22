
public class QueueSystem {

	private DoublyLinkedList<Patient> list;

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
	
	public void addPatient(Patient toAdd) {
		list.addLast(toAdd);
	}
	
	public Patient getLast() {
		return list.last();
	}
	
	public int getListSize() {
		return list.size();
	}
	
	public Patient getPatient(int position) {
		if(position>list.size())
			return null;
		
		return list.get(position);	
	}



}
