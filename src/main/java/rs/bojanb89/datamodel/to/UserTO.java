package rs.bojanb89.datamodel.to;

public class UserTO {
	
	public String username;
	
	public Boolean enabled;

	public String password;
	
	public String email;
	
	public UserTO() {
	}

	public UserTO(String username, Boolean enabled, String email) {
		super();
		this.username = username;
		this.enabled = enabled;
		this.email = email;
	}
	
}
