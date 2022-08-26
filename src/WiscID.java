// --== CS400 File Header Information ==--
// Name: Arnav Mehta
// Email: anmehta4@wisc.edu
// Team: LC
// Role: Test Engineer 2
// TA: Divyanshu Saxena
// Lecturer: Gary Dahl
// Notes to Grader: None

public class WiscID {
	private String username; // Stores students username
	private int ID; // Stores students ID
	
	// Constructor that creates Student object with specific ID and username
	public WiscID (int ID, String username) {
		this.ID = ID;
		this.username = username;
	}
	
	// Returns students ID
	public int getID() {
		return ID;
	}
	
	// Returns students username
	public String getUsername() {
		return username;
	}

}
