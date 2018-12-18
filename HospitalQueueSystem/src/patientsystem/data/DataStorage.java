package patientsystem.data;

import patientsystem.lib.DoublyLinkedList;
import patientsystem.model.Patient;

public class DataStorage {

	public DoublyLinkedList<Patient> list;
	
	public DataStorage() {
		list = new DoublyLinkedList<>();
	}
}
