package patientsystem;

import patientsystem.model.PatientManagementSystem;

/**
 * Main class, used to run the application.
 * @author Gustavo Lessa
 * @author Fernando Tenorio
 *
 */
public class Main {

	public static void main(String[] args){

		PatientManagementSystem system = new PatientManagementSystem(); // create new system.
		system.start(); // start it.
	}
}
