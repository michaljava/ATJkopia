package atj.rest.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import atj.rest.model.UserProfile;
import atj.rest.service.ProfileService;

@Path("profile")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class ProfileResource {
	private ProfileService profileService = new ProfileService();

	@GET
	public List<UserProfile> getProfile(){
		return profileService.getAllProfile();
	}

	@GET
	@Path("/{profileId}")
	public UserProfile getProfile(@PathParam("profileId") long profileId) {
		return profileService.getProfile(profileId);
	}

	@POST
	public UserProfile addProfile(UserProfile userProfile) {
		return profileService.addProfile(userProfile);
	}

	@PUT
	@Path("/{profileId}")
	public UserProfile updateProfile(@PathParam("profileId") long profileId, UserProfile userProfile) {
		userProfile.setProfileId(profileId);
		return profileService.updateProfile(userProfile);
	}

	@DELETE
	@Path("/{profileId}")
	public void deleteProfile(@PathParam("profileId") long profileId) {
		profileService.removeProfile(profileId);
	}
}