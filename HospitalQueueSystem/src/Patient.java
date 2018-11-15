
public class Patient {
	private static int lastPid = 0;
	private final int pid;


	private final String pps;
	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private String city;
	
	public Patient(String pps, String firstName, String lastName, String mobile, String email, String city) {
		super();
		this.pid = ++lastPid;
		this.pps = pps;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.city = city;
	}
	
}
