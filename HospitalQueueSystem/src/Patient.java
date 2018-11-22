
public class Patient implements Comparable<Patient> {
	private static int lastPid;
	private final int pid;

	private String pps;
	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private String city;
	private char priority;

	public Patient(String pps, String firstName, String lastName, String mobile, String email, String city, char priority) {
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

	public Patient(String name, String lastname){
		super();
		this.pid = ++lastPid;
		this.pps = null;
		this.firstName = name;
		this.lastName = lastname;
		this.priority = 'c';
	}

	public Patient() {
		super();
		this.pid = ++lastPid;
		this.pps = null;
		this.firstName = null;
		this.lastName = null;
		this.mobile = null;
		this.email = null;
		this.city = null;
		this.priority = 'c';

	}
	public char getPriority() { 
		return this.priority;
	}

	public void setPriority(char c) {
		this.priority = c;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPid() {
		return pid;
	}
	public void setPps(String pps){
		this.pps = pps;
	}

	public String getPps() {
		return pps;
	}

	@Override
	public String toString(){


		return ("\n\nPatient\n------\n" +

	               "ID: " + this.getPid() + "\n" +
	               "PPS: " + this.getPps() + "\n" +
	               "Name: " + this.getFirstName() + "\n"+
	               "Last Name: "+ this.getLastName() + "\n"+
	               "Mobile Number: " + this.getMobile() + "\n" +
	               "E-mail: " + this.getEmail() + "\n" +
	               "City: " + this.getCity() +"\n"
				);	                       	
	}



	@Override
	public int compareTo(Patient o) {
		if(this.priority < o.getPriority()) {
			return -1;
		} else if (this.priority > o.getPriority()) {
			return 1;
		} else {
			return 0;
		}
	}

}
