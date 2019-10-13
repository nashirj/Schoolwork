package facebook;

public class FacebookUser {
	int numFriends;
	String userName;
	
	public FacebookUser(int numFriends, String userName) {
		this.numFriends = numFriends;
		this.userName = userName;
	}
	
	// my implementation
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		FacebookUser user = (FacebookUser) obj;
		return user.userName.equals(this.userName);
	}
	
	// eclipse generated hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + numFriends;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	
	// modified version of eclipse auto generated implementation
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		FacebookUser other = (FacebookUser) obj;
////		if (numFriends != other.numFriends)
////			return false;
//		if (userName == null) {
//			if (other.userName != null)
//				return false;
//		} else if (!userName.equals(other.userName))
//			return false;
//		return true;
//	}
	
}
