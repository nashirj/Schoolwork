package apps;

import facebook.FacebookUser;

public class FacebookUserDriver {

	public static void main(String[] args) {
		FacebookUser u1 = new FacebookUser(20, "nashir");
		FacebookUser u2 = new FacebookUser(20, "bob");
		FacebookUser u3 = new FacebookUser(24, "nashir");
		String s = new String("blah");
		
		// same username should be equal (even with different number of friends)
		assert(u1.equals(u3));
		// different username should not be equal
		assert(!u1.equals(u2));
		// different object types should not be equal
		assert(!u1.equals(s));

	}

}
