package patientsystem.controller;
import patientsystem.data.DataStorage;
import patientsystem.data.SampleData;
import patientsystem.lib.DoublyLinkedList;
import patientsystem.model.Patient;
import patientsystem.model.Priority;
import patientsystem.view.View;

public class SystemController {

	private DoublyLinkedList<Patient> list;
	
	public SystemController(){
		DataStorage ds = new DataStorage();
		this.list = ds.list;
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
			if(list.get(x).getPid() == pid) {
				foundPosition = x;
				return foundPosition;
			}	
		
		return foundPosition;
	}

	/**
	 * Method responsible to add patient in the end of the list.
	 * @param toAdd
	 */
	public Patient addPatient(Patient toAdd) {
		list.addLast(toAdd);
		return list.last();
	}
	
	/**
	 * Method responsible to add patient in the end of the list.
	 * @param toAdd
	 */
	public Patient addPatientByPosition(Patient toAdd, int position) {
		list.addInPosition(toAdd, position);
		return list.get(position);
	}
	
	/**
	 * Method responsible to add patient in the end of the list.
	 * @param toAdd
	 */
	public Patient addPatientByPriority(Patient toAdd) {
		Priority priority = toAdd.getPriority();
		if(priority == Priority.C) {
			list.addLast(toAdd);
			return list.last();
		}else {
			int foundPosition = getLastPriorityPosition(1, toAdd);
			list.addInPosition(toAdd, foundPosition);
			return list.get(foundPosition);
		}
	}
	
	/**
	 * Method responsible to get patients last position 
	 * @param position
	 * @param toAdd
	 * @return 
	 */
	public int getLastPriorityPosition(int position, Patient toAdd) {
		
		if (position <= list.size()) { //check if the position is valid
			
			if (comparePatients(list.get(position), toAdd) <= 0) { //if priority of patient from list is higher than or equals to
																   //the new patient's priority
				
				return getLastPriorityPosition(position+1, toAdd); //recursively call this method with the next position
			
			}else // in case the patient to be added has higher priority
				return position; // return the position
			
		}else {
			View.displayError("Position > List size.");
			return -1;
		}

	}

	
	public int comparePatients(Patient fromList, Patient toAdd) {
		return fromList.compareTo(toAdd);
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
	public Patient updatePatientPosition(int index, int newPosition){
		
		for(int i = 1; i < list.size(); i++)
			if(list.set(index, newPosition).getPid() == newPosition)	
				newPosition = i;
			
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
	 * Method to return a True if the list empty, false if it is not.
	 * @return
	 */
	public boolean isEmpty() {
		return (list.size() == 0);
	}


	/**
	 * Method responsible to generate a sample of patient list on system.
	 */
	public void addSamplePatients(){
		Patient[] sample = SampleData.getSamplePatients();
		for(int x = 0; x < sample.length; x++) {
			list.addLast(sample[x]);
		}
	}

}
