package patientsystem.controller;
import patientsystem.data.DataStorage;
import patientsystem.data.SampleData;
import patientsystem.model.Patient;
import patientsystem.model.Priority;
import patientsystem.view.View;

/**
 * Class responsible for performing operations to the list that is stored according to the DataStorage class.
 * @author Gustavo Lessa
 * @author Fernando Tenorio
 */
public class ListController {

	private DataStorage ds; // instance to access the data
	
	/**
	 * Constructor initializing the DataStorage variable
	 */
	public ListController(){
		ds = new DataStorage();
	}

	/**
	 * Method responsible for deleting a patient by the PID number.
	 * @param pid
	 * @return the deleted patient.
	 */
	public Patient deletePatient(int pid){
		int patientPosition = searchPatient(pid); // retrieve patient's position

		if(patientPosition <= 0) // if position is invalid
			return null; 
		else // if position is valid
			return ds.getList().remove(patientPosition); // remove and return the patient object;
	}

	/**
	 * Method responsible for removing N patients from the end of the list.
	 * @param number
	 * @return number of patients removed.
	 */
	public int deletePatients(int number) {
		return ds.getList().removeLastNodes(number); // calls method from DoublyLinkedList class.
	}

	/**
	 * Method responsible for searching for a patient in the list, according to a PID number.
	 * @param pid
	 * @return return the patient position.
	 */
	public int searchPatient(int pid){
		int foundPosition = -1; // variable to store found position
		
		for(int x = 1; x < ds.getList().size(); x++) // iterate through list
			if(ds.getList().get(x).getPid() == pid) { // if pid is found
				foundPosition = x; // save position
				return foundPosition; // return variable
			}	
		
		return foundPosition; // return variable if not found (-1)
	}

	/**
	 * Method responsible for adding a patient in the end of the list.
	 * @param toAdd Patient to be added.
	 * @return Last patient of the list.
	 */
	public Patient addPatient(Patient toAdd) {
		ds.getList().addLast(toAdd); // add patient to the end of the list
		return ds.getList().last(); // return last patient (should be the same).
	}
	
	/**
	 * Method responsible for adding a patient at a specific position in the list.
	 * @param toAdd Patient to be added.
	 * @param position Desired position.
	 * @return Patient from specific position, after insertion.
	 */
	public Patient addPatientByPosition(Patient toAdd, int position) {
		ds.getList().addInPosition(toAdd, position); // calls method to add to the specific position
		return ds.getList().get(position); // return patient from that position (should be the same).
	}
	
	/**
	 * Method responsible for adding a patient according to the specified priority level.
	 * @param toAdd Patient to be added.
	 * @return
	 */
	public Patient addPatientByPriority(Patient toAdd) {
		Priority priority = toAdd.getPriority(); // get patient's priority
		
		if(priority == Priority.values()[(Priority.values().length)-1]) { // if priority is the last one
			ds.getList().addLast(toAdd); // add to the end of the list
			return ds.getList().last(); // return last patient (should be the same).
			
		}else { // if the priority is NOT the last one
			int foundPosition = getLastPriorityPosition(1, toAdd); // get the right position to add the patient 
			ds.getList().addInPosition(toAdd, foundPosition); // add patient in that position
			return ds.getList().get(foundPosition); // return patient from the same position.
		}
	}
	
	/**
	 * Method responsible for retrieving the right position to add a patient according to priority level 
	 * @param position to start the search
	 * @param toAdd patient to be added
	 * @return position to add the patient
	 */
	public int getLastPriorityPosition(int position, Patient toAdd) {
		
		if (position <= ds.getList().size()) { //check if the position is valid
			
			if (comparePatients(ds.getList().get(position), toAdd) <= 0) { //if priority of patient from list is higher than or equals to
																   //the new patient's priority
				
				return getLastPriorityPosition(position+1, toAdd); //recursively call this method with the next position
			
			}else // in case the patient to be added has higher priority
				return position; // return the position
			
		}else { // in case the position is greater than the list size.
			View.displayError("Position > List size.");
			return -1;
		}

	}

	/**
	 * Method responsible for comparing patients' priority levels.
	 * @param fromList Patient from the list
	 * @param toAdd Patient to be added
	 * @return 1 if toAdd's priority is lower, 0 if it's the same and -1 if it's higher.
	 */
	public int comparePatients(Patient fromList, Patient toAdd) {
		return fromList.compareTo(toAdd); // calls method overridden in Patient class from Comparable interface.
	} 

	/**
	 * Method responsible for retrieving the last patient of the list
	 * @return the last patient from the list.
	 */
	public Patient getLast() {
		return ds.getList().last();
	}

	/**
	 * Method responsible for retrieving the last PID number generated by Patient class.
	 * @return last PID generated. 
	 */
	public int getLastPid() {
		return Patient.getLastPid();
	}

//	/**
//	 * This method gets a patient ID and add it to a new Position in the list.
//	 * @param index
//	 */
//	public Patient updatePatientPosition(int index, int newPosition){
//		
//		for(int i = 1; i < ds.getList().size(); i++)
//			if(ds.getList().set(index, newPosition).getPid() == newPosition)	
//				newPosition = i;
//			
//		return ds.getList().get(newPosition);
//	}
	
	/**
	 * Method to check the size of the list
	 * @return list size.
	 */
	public int getListSize() {
		return ds.getList().size();
	}

	/**
	 * Method to get a patient from specified position.
	 * @param position
	 * @return patient from position.
	 */
	public Patient getPatient(int position) {
		if(position>getListSize()) // if position is bigger than list size
			return null;
		
		return ds.getList().get(position);	
	}

	/**
	 * Method to check if the list is empty.
	 * @return true for empty, false otherwise.
	 */
	public boolean isEmpty() {
		return (getListSize() == 0); // true if list is empty
	}


	/**
	 * Method responsible for adding sample patients to the system.
	 */
	public void addSamplePatients(){
		Patient[] sample = SampleData.getSamplePatients(); // retrieve sample data
		for(int x = 0; x < sample.length; x++) // iterate through array
			ds.getList().addLast(sample[x]); // add every patient
	}

}
