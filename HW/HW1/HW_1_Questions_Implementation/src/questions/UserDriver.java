package questions;

import questions.User;

public class UserDriver {
	public static void main(String[] args) {
		User u = new User("Nashir", "Janmohamed", "nashish", "jazzers");
		User u1 = new User("Nashir", "Janmohamed", "nashish", "jazzers");
		User u2 = new User("Nashir", "Janmohamed", "nashish", "jazzers");
		User u3 = new User("Nashir", "Janmohamed", "nashish", "jazzers");
		System.out.println(u.getUsername());
		System.out.println(u1.getUsername());
		System.out.println(u2.getUsername());
		System.out.println(u3.getUsername());
	}

}
