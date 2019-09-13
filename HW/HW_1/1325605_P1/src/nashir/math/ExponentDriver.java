package nashir.math;

public class ExponentDriver {
	public static void main(String[] args) {
		System.out.println("There is no difference in the time efficiency of these "
				+ "two methods");
	}
	/**
	 * Time complexity O(n) -> number of iterations of the for loop based on input
	 *   of size n.
	 * Space complexity O(1) -> only constant extra space is used, amount of space used
	 *   does not depend on input.
	 * This method is able to handle negative numbers. 
	 * @param base, number to be exponentiated
	 * @param power, number of times to multiply the base by itself
	 * @return
	 */
	public static double calculateExponentIteratively(double base, double power) {
		if (power == 0) {
			return 1;
		}
		double res = base;
		double unsignedPower = (power < 0) ? -power : power;
		// calculate both positive and negative exponents the same way initially
		for (int i = 1; i < unsignedPower; i++) {
			res *= base;
		}
		
		// if power is less than zero, return the reciprocal of the result
		return (power < 0) ? 1/res : res;
	}
	
	/**
	 * Time complexity O(n) -> the number of calls that are executed based on input of
	 *   size n.
	 * Space complexity O(n) -> the number of calls that are placed on the stack based
	 *   on input of size n.
	 * This method is not able to handle negative numbers. 
	 * @param base, number to be exponentiated
	 * @param power, number of times to multiply the base by itself
	 * @return
	 */
	public static double calculateExponentRecursively(double base, double power) throws IllegalArgumentException {
		// this function does not handle negative exponents
		if (power < 0) {
			throw new IllegalArgumentException("Cannot recursively calculate negative exponents.");
		}
		// base case
		if (power == 0) {
			return 1;
		}
		// passes smaller subproblem to next function call
		return base * calculateExponentRecursively(base, power-1);
	}
}