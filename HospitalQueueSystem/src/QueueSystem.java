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

	public void updatePatient(int index){
		
		if(list.get(index) == null){
			View.display("\nDo you want to Update Patient "+ getPatient(index) + " Information? (Y/N)");
			int answer = this.input.validate.checkForInt(this.input.scan, 1, 2);
			if(answer == 1){
				list.addInPosition(patient, index);
			}else if(answer == 2){
				
			}
			
		}
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
