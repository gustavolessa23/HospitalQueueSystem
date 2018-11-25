

public class QueueSystem {

	private DoublyLinkedList<Patient> list;
	public QueueSystem(){
		
		list = new DoublyLinkedList<>();
		new Input();
		new Patient();
	}

	/**
	 * Method responsible to delete a patient by the given id number.
	 * @param pid
	 * @returns the deleted patient.
	 */
	public Patient deletePatient(int pid){
		int patientPosition = searchPatient(pid);

		if(patientPosition <= 0)
			return null;

		else
			return list.remove(patientPosition);

	}

	/**
	 * Method responsible to remove a N number of patients from the end of the list.
	 * @param number
	 * @return number of patients removed.
	 */
	public int deletePatients(int number) {
		return list.removeLastNodes(number);
	}

	/**
	 * Method responsible to search a patient in the list
	 * @param pid
	 * @return return the patient position.
	 */
	public int searchPatient(int pid){
		int foundPosition = -1;
		for(int x = 1; x < list.size(); x++) 
			if(list.get(x).getPid() == pid)
				foundPosition = x;

		return foundPosition;
	}

	/**
	 * Method responsible to add patient in the end of the list.
	 * @param toAdd
	 */
	public void addPatient(Patient toAdd) {
		// list.addDNode(toAdd);
		// list.addFirstEnhanced(toAdd);
		list.addLast(toAdd);
	}

	/**
	 * Method responsible to get the last element.
	 * @returns Last patient in the list
	 */
	public Patient getLast() {
		return list.last();
	}

	/**
	 * Method to get the last ID in the list
	 * @returns last patient id from the list. 
	 */
	public int getLastPid() {
		return Patient.getLastPid();
	}

	/**
	 * This method gets a patient ID and add it to a new Position in the list.
	 * @param index
	 */
	public Patient updatePatient(int index, int newPosition){

		for(int i = 1; i < list.size(); i++){
			if(list.set(index, newPosition).getPid() == newPosition){;	
				newPosition = i;
			}
		}
		return list.get(newPosition);

	}
	
	/**
	 * Method to check the size of the list
	 * @return list size.
	 */
	public int getListSize() {
		return list.size();
	}

	/**
	 * Method to check a patient position.
	 * @param position
	 * @return patient position.
	 */
	public Patient getPatient(int position) {
		if(position>list.size())
			return null;
		return list.get(position);	
	}

	/**
	 * Method to return a True if the list empty, false if it is not
	 * @return
	 */
	public boolean isEmpty() {
		return (list.size() == 0);
	}

	public void addPatients(DoublyLinkedList<Patient> samplePatients) {
		Patient temp = null;
		//		while((temp = samplePatients.removeLast()) != null) {
		//			int pidToBeAdded = temp.getPid();
		//			int lastPid = 0;
		//			System.out.println("Added: "+ temp.getPid());
		//			while(pidToBeAdded != lastPid) {
		//				list.addFirstEnhanced(temp);
		//				lastPid = list.first().getPid();
		//				System.out.println(list.last().getPid());
		//				System.out.println(list.last());
		//			}
		//				
		//		}
		while((temp = samplePatients.removeFirst()) != null) {
			int pidToBeAdded = temp.getPid();
			int lastPid = 0;
			System.out.println("Added: "+ temp.getPid());
			while(pidToBeAdded != lastPid) {
				list.addLastEnhanced(temp);
				lastPid = list.last().getPid();
				System.out.println(list.last().getPid());
				System.out.println(list.last());
			}
		}
	}



}
