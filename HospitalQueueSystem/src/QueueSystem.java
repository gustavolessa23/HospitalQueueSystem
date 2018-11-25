

public class QueueSystem {

	private DoublyLinkedList<Patient> list;
	public QueueSystem(){
		
		list = new DoublyLinkedList<>();
		new Input();
		new Patient();
	}

	public Patient deletePatient(int pid){
		int patientPosition = searchPatient(pid);

		if(patientPosition <= 0)
			return null;

		else
			return list.remove(patientPosition);

	}

	public int deletePatients(int number) {
		return list.removeLastNodes(number);
	}

	public int searchPatient(int pid){
		int foundPosition = -1;
		for(int x = 1; x < list.size(); x++) 
			if(list.get(x).getPid() == pid)
				foundPosition = x;

		return foundPosition;
	}

	public void addPatient(Patient toAdd) {
		// list.addDNode(toAdd);
		// list.addFirstEnhanced(toAdd);
		list.addLast(toAdd);
	}


	public Patient getLast() {
		return list.last();
	}

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
		//		System.out.println(list.toString());
		//		int counter = 0;
		//		for(int x = 0; x < samplePatients.size()-1; x++) {
		//			System.out.println("Added: "+ samplePatients.get(x+1).getPid());
		//			list.addLast(samplePatients.get(x+1));
		//		}

	}



}
