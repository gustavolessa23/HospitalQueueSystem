package patientsystem.controller;
import patientsystem.lib.DoublyLinkedList;
import patientsystem.model.Patient;
import patientsystem.model.Priority;
import patientsystem.view.View;

public class SystemController {

	private DoublyLinkedList<Patient> list;
	
	public SystemController(){
		list = new DoublyLinkedList<>();
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
	public void generateSamplePatients(){
		
		String[] test = {"1224327FB	Oliver		Barney		014370969		Oliver.32@gmail.com		Dublin", 
		"1224327FB	Jake		Hadley		+35314370969 	Jake@cct.com			Dublin",
		"1224327FB	Noah		Barton		0035314370969	Noah@hotmail.com		Galway",
		"1224327FB	James		Hadleigh	019898984		James@cct.com			Galway",
		"1243567FF	Jack		Bentham		0892528484		Jack@yahoo.com			Newcastle",
		"1235667FT	Connor		Hailey		0894735768		Connor@cct.com			Drogheda",
		"1767767FY	Liam		Beckwith	0885747636		Liam@hotmail.com		Waterford",
		"1234656FG	John		Hale		0837558967		John@ss.com				Sheffield",
		"1234567FU	Harry		Badger		0865747526		Harry@yahoo.com			Limerick",
		"6445567FA	Callum		Hadlee		014933847		Callum@gmail.com		Galway",
		"1567567FI	Mason		Benson		0862356837		Mason@hotmail.com		Bristol",
		"1654337FH	Robert		Bentley		0899567472		Robert.321@cct.com		Wolverhampton",
		"1975587FM	Jacob		Barclay		0875736272		Jacob@hotmail.com		Cork", 
		"1754347FI	Jacob		Adley		0877465732		Jacob@gmail.com			Sheffield", 
		"1296437FO	Jacob		Hackney		0883474573		Jacob@google.com		Sheffield", 
		"1956637FQ	Michael		Ainsworth	0847573745		Michael@gmail.xom		Manchester", 
		"1234567FE	Charlie		Berkelen	0884585348		Charlie@hotmail.com		Sunderland", 
		"1245647FP	Kyle		Alby		0853458582		Kyle@cct.com			Bradford", 
		"1265327FW	William		Addington	4756558372		William@ccd.com			Newcastle", 
		"1554217FL	Thomas		Alston		018384475		Thomas@hotmail.com		Liverpool", 
		"12345674K	Joe			Ethan		019484557		David@gmail.co			Dublin", 
		"1444567FJ	George		Allerton	015733848		George@grindr.com		Swords", 
		"1654347FS	Reece		Ainsley		018475746		Reece@cct.com			Leeds", 
		"1265337FV	Michael		Abram		017564857		Michael@vanilla.com		Birmingham"};

		for(String str : test){
			String[] row = str.split("\\s+");

			String pps = (row[0]);
			String firstName = (row[1]);
			String lastName = (row[2]);
			String mobile = (row[3]);
			String email = (row[4]);
			String city = (row[5]);
			Patient temp = new Patient(pps, firstName, lastName, mobile, email, city);
			list.addLast(temp);
		}

	}

}
