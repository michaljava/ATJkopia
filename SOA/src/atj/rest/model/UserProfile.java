package atj.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserProfile {
	private long profileId;
	private String firstName;
	private String lastName;
	private String email;
	
	public UserProfile(){
		
	}
	public UserProfile(long profileId, String firstName, String lastName, String email) {
		this.profileId = profileId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public long getProfileId() {
		return profileId;
	}

	public void setProfileId(long profileId) {
		this.profileId = profileId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
