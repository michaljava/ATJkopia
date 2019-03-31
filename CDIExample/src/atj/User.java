package atj;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class User {
	
	
	
	private String email, access[], rights, password;

	public String generatePassword(IPasswordGenerator iPasswordGenerator) {
		password = iPasswordGenerator.generate();
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String[] getAccess() {
		return access;
	}

	public void setAccess(String[] access) {
		this.access = access;
	}

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

	public String getPassword() {
		return password;
	}

}
