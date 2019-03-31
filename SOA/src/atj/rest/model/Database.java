package atj.rest.model;

import java.util.HashMap;
import java.util.Map;

public class Database {
	private static Map<Long, UserProfile> users = new HashMap<Long, UserProfile>();

	public static Map<Long, UserProfile> getUsers() {
		return users; 
	}
}
