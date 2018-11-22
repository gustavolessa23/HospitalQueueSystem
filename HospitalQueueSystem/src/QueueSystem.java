import java.util.List;

public class QueueSystem {

	private DoublyLinkedList<Patient> list;
	private ArrayListClass<Patient> patient;
	
	

	public QueueSystem(){
		list = new DoublyLinkedList<>();
		patient = new ArrayListClass<>();
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
	private void updatePatient(int index){
		
//		 if(keepers.getKeeper(index).getQualifications().size()<
//	                ZooKeeper.getLimitOfQualifications()){
//	            
//	            // show current qualifications
//	            System.out.println("\nCurrent qualifications: "
//	                    +keepers.getKeeper(index).getQualifications());           
//	            
//	            // if user wants to add another qualification
//	            System.out.println("Would you like to add another "
//	                    + "Qualification? (Y/N)");
//	            if(validate.checkForYes(in)){
//	                
//	                // retrieve list of qualifications the keeper doesn' have
//	                List<Qualification> qualifications
//	                        = this.otherQualifications(keepers.getKeeper(index)
//	                                .getQualifications());
//	                
//	                // for the number of qualifications allowed to add
//	                for (int x = keepers.getKeeper(index).getQualifications()
//	                        .size(); x<ZooKeeper.getLimitOfQualifications(); x++){
//	                    
//	                    // ask user to choose one and get input
//	                    System.out.println("Select a qualification:");
//	                    keepers.getKeeper(index).addQualification(qualifications.remove(this.chooseOption(qualifications)));
//	                    
//	                    // if it isn't the last one, ask if the user wants to add
//	                    // another qualification
//	                    if (x < 2){
//	                        System.out.println("Would you like to add another one? (Y/N)");
//	                        if(!validate.checkForYes(in)){
//	                            break;
//	                        }               
//	                    }
//	                }               
//	            }
//	        } else { // if limit was reached
//	            System.out.println("This keeper has already the limit of "
//	                    + "qualifications");
//	        }
	}


}
