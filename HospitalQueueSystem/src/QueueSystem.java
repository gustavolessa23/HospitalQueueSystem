import java.util.List;

public class QueueSystem {

	private DoublyLinkedList<Patient> list;
	private Input input;
	private Patient patient;

	public QueueSystem(){
		list = new DoublyLinkedList<>();
		input = new Input();
		patient = new Patient();
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

	/**
	 * This method gets a patient ID and add it to a new Position in the list.
	 * @param index
	 */
	public int updatePatient(int index){
		int newPosition = 0;
		for(int i = 1; i < list.size(); i++){
			if(list.set(index, newPosition).getPid() == index){
				newPosition = i;
			}
		}
		return newPosition;
		
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
