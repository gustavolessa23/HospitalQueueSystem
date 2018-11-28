package patientsystem;

import patientsystem.controller.PatientSystemController;

public class Main {

	public static void main(String[] args){
		PatientSystemController system = new PatientSystemController();
		system.start();
	}
}
