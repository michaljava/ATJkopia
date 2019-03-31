package atj.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import atj.rest.model.Database;
import atj.rest.model.UserProfile;

public class ProfileService {

	private Map<Long, UserProfile> userProfiles = Database.getUsers();
	
	public ProfileService() {
		UserProfile userProfile1 = new UserProfile(1L, "Jan", "Kowalski", "jan.kowalski@gmail.com");
		UserProfile userProfile2 = new UserProfile(2L, "Jan2", "Kowalski2", "jan.kowalski2@gmail.com");
		UserProfile userProfile3 = new UserProfile(3L, "Jan3", "Kowalski3", "jan.kowalski3@gmail.com");
		UserProfile userProfile4 = new UserProfile(4L, "Jan4", "Kowalski4", "jan.kowalski4@gmail.com");
		userProfiles.put(1L, userProfile1);
		userProfiles.put(2L, userProfile2);
		userProfiles.put(3L, userProfile3);
		userProfiles.put(4L, userProfile4);
	}

	public List<UserProfile> getAllProfile() {
		List<UserProfile> list = new ArrayList<UserProfile>(userProfiles.values());
		return list;
	}

	public UserProfile getProfile(long profileId) {
		return userProfiles.get(profileId);
	}

	public UserProfile addProfile(UserProfile userProfile) {
		userProfile.setProfileId(userProfiles.size() + 1);
		userProfiles.put(userProfile.getProfileId(), userProfile);
		return userProfile;
	}

	public UserProfile updateProfile(UserProfile userProfile) {
		if (userProfile.getProfileId() <= 0) {
			return null;
		}
		else {
			userProfiles.put(userProfile.getProfileId(), userProfile);
			return userProfile;
		}
	}

	public void removeProfile(long profileId) {
		userProfiles.remove(profileId);
	}

}