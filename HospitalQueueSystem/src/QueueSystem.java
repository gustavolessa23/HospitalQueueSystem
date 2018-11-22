
public class QueueSystem {

	private DoublyLinkedList<Patient> list;

	public QueueSystem() {
		list = new DoublyLinkedList<>();
	}
	
	public Patient deletePatient(int pid){
		int patientPosition = searchPatient(pid);
		
		if(patientPosition <= 0)
			return null;
		
		else
			return list.remove(patientPosition);

	}
	
	public int searchPatient(int pid){
		int foundPosition = -1;
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
	
	public int getLastPid() {
		return Patient.getLastPid();
	}
	
	public int getListSize() {
		return list.size();
	}
	
	public Patient getPatient(int position) {
		if(position>list.size())
			return null;
		
		return list.get(position);	
	}

	public boolean isEmpty() {
		return (list.size() == 0);
	}

	public void addPatients(DoublyLinkedList<Patient> samplePatients) {
		int counter = 0;
		for(int x = 0; x < samplePatients.size()-1; x++) {
			System.out.println("Added: "+ ++counter);
			list.addLast(samplePatients.get(x+1));
		}
		
	}



}
