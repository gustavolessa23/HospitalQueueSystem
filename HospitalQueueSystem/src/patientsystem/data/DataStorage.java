package patientsystem.data;

import patientsystem.lib.DoublyLinkedList;
import patientsystem.model.Patient;

/**
 * Class representing the data storage, using a DoublyLinkedList
 * @author Gustavo Lessa
 *
 */
public class DataStorage {

	private DoublyLinkedList<Patient> list; // patients list
	
	public DataStorage() {
		list = new DoublyLinkedList<>();
	}
	
	public DoublyLinkedList<Patient> getList(){
		return list;
	}
}
