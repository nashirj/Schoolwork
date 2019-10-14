package questions;

import java.util.HashSet;

import utils.MessageUtils;

public class User {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	static HashSet<String> userSet = new HashSet<String>();

	public User(String firstName, String lastName, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		// this is a bad design, we should check the username and password before we
		// invoke the constructor, but I wanted to have something more than just
		// assignment
		boolean validUserName = true;
		if (User.userSet.contains(username)) {
			/**
			 * ask about a better way to do this
			 */
			int suffix = 0;
			for (String user : userSet) {
				if (user.startsWith(username)) {
					suffix++;
				}
			}
			
			/**
			 * is using extra space better than doing username.concat(Integer.toString(suffix))?
			 */
//			StringBuilder sbUsername = new StringBuilder(username);
//			sbUsername.append(suffix);
//			username = sbUsername.toString();
			
			username.concat(Integer.toString(suffix));
			validUserName = false;
		}
		
		userSet.add(username);
		this.username = username;
		
		boolean validPassword = true;
		if (password.length() < 6 || password.equals(username)) {
			this.password = User.generateStrongPassword();
			validPassword = false;
		}
		StringBuilder s = new StringBuilder("Hello " + this.firstName + " " + this.lastName + "! Thank you for registering as a user.");
		if (!validUserName || !validPassword) {
			s.append(" We are sending this message because you had an invalid ");
			if (!validUserName && !validPassword) {
				s.append("username and password. We have updated them accordingly: username = " + this.username
						+ ", password = " + this.password + ".");
			} else if (!validUserName) {
				s.append("username. We have updated it accordingly: username = " + this.username + ".");
			} else if (!validPassword) {
				s.append("password. We have updated it accordingly: password = " + this.password + ".");
			}
			s.append(" Please respond to this email if you have any questions or concerns.");
			MessageUtils.sendEmail(this.email, s.toString());
		}
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public static String generateStrongPassword() {
		return "";
	}
}
