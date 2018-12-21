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
	 * Getter for priority.
	 * @return priority
	 */
	public Priority getPriority() { 
		return this.priority;
	}

	/**
	 * Setter for priority.
	 * @param p New Priority level
	 */
	public void setPriority(Priority p) {
		this.priority = p;
	}

	/**
	 * Getter for first name
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter for first name.
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter for last name.
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter for last name.
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter for mobile number.
	 * @return mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Setter for mobile number.
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * Getter for e-mail address.
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter for e-mail address
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter for city
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Setter for city
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Getter for pid (patient id)
	 * @return pid
	 */
	public int getPid() {
		return pid;
	}
	
	/**
	 * Setter for PPS number.
	 * @param pps
	 */
	public void setPps(String pps){
		this.pps = pps;
	}

	/**
	 * Getter for PPS number.
	 * @return pps
	 */
	public String getPps() {
		return pps;
	}
	
	/**
	 * This method gets last patient id created by this class.
	 * @return
	 */
	public static int getLastPid() {
		return lastPid;
	}

	/**
	 * This method displays a single patient's information on CLI.
	 */
	@Override
	public String toString(){


		return ("\n\n"
				+ "+-----------+\n" + 
				  "|  Patient  |\n" + 
				  "+-----------+\n" +

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

	/**
	 * This method compares two Patient objects, according to their Priority level.
	 * @return 1 , 0 or -1.
	 */
	@Override
	public int compareTo(Patient o) {
		
		if (this.priority.compareTo(o.getPriority()) > 0) { // this patient has higher priority than patient o.
			return 1;
		} else if (this.priority.compareTo(o.getPriority()) == 0) { // this patient has the same priority as patient o.
			return 0;
		} else if (this.priority.compareTo(o.getPriority()) < 0) { // this patient has lower priority than patient o.
			return -1;
		} else { // this should be unreachable
			return -2; 
		}
	}

}
