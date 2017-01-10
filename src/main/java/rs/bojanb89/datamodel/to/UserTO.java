package rs.bojanb89.datamodel.to;

public class UserTO {
	
	public String id;
	
	public String username;
	
	public boolean enabled;

	public String password;
	
	public UserTO() {
	}

	public UserTO(String id, String username, boolean enabled) {
		this.id = id;
		this.username = username;
		this.enabled = enabled;
	}
	
	
}
