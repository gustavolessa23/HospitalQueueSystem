package patientsystem.model;

public class Patient implements Comparable<Patient> {
	private static int lastPid = 0;
	private int pid;

	private String pps;
	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private String city;
	private Priority priority;

	/**
	 * Patient constructor.
	 * @param pps
	 * @param firstName
	 * @param lastName
	 * @param mobile
	 * @param email
	 * @param city
	 */
	public Patient(String pps, String firstName, String lastName, String mobile, String email, String city, Priority priority) {
		super();
		this.pid = ++lastPid;
		this.pps = pps;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.city = city;
		this.priority = priority;
	}	
	
	/**
	 * Patient constructor.
	 * @param pps
	 * @param firstName
	 * @param lastName
	 * @param mobile
	 * @param email
	 * @param city
	 */
	public Patient(String pps, String firstName, String lastName, String mobile, String email, String city) {
		this(pps, firstName, lastName, mobile, email, city, Priority.C);
	}
	
	/**
	 * Patient constructor.
	 * @param name
	 * @param lastname
	 */
	public Patient(String firstName, String lastName){
		this(null, firstName, lastName, null, null, null, Priority.C);
	}

	/**
	 * Patient constructor.
	 */
	public Patient() {
		this(null, null);
	}
	
	/**
	 * This method gets a Priority id
	 * @return
	 */
	public Priority getPriority() { 
		return this.priority;
	}

	/**
	 * This method set a priority id
	 * @param c
	 */
	public void setPriority(Priority p) {
		this.priority = p;
	}

	/**
	 * This method gets a patient first name
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * This method sets a patient first name.
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * This method gets a patients last name.
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * This method set a patient last name.
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * This method get a patient mobile number.
	 * @return
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * This method set a patient mobile number.
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * This method gets a patient emial address.
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method set a patient email address
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method gets a patient city
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * This method sets a patient city
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * This method gets a patient pid 
	 * @return
	 */
	public int getPid() {
		return pid;
	}
	
	/**
	 * This method sets a patient PPS number.
	 * @param pps
	 */
	public void setPps(String pps){
		this.pps = pps;
	}

	/**
	 * This method gets a patient PPS number.
	 * @return
	 */
	public String getPps() {
		return pps;
	}
	
	/**
	 * This method gets last patient id.
	 * @return
	 */
	public static int getLastPid() {
		return lastPid;
	}

	/**
	 * This method display a single patient on CLI.
	 */
	@Override
	public String toString(){


		return ("\n\nPatient\n------\n" +

	               "ID: " + this.getPid() + "\n" +
	               "PPS: " + this.getPps() + "\n" +
	               "Name: " + this.getFirstName() + "\n"+
	               "Last Name: "+ this.getLastName() + "\n"+
	               "Mobile Number: " + this.getMobile() + "\n" +
	               "E-mail: " + this.getEmail() + "\n" +
	               "City: " + this.getCity() +"\n" +
	               "Priority: " + this.getPriority().getDescription()
				);	                       	
	}


	@Override
	public int compareTo(Patient o) {
		
		if (this.priority.compareTo(o.getPriority()) > 0) {
			return 1;
		} else if (this.priority.compareTo(o.getPriority()) == 0) {
			return 0;
		} else if (this.priority.compareTo(o.getPriority()) < 0) {
			return -1;
		} else {
			return -2;
		}
	}

}
