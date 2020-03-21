package apps;

import numbers.Complex;

public class ComplexDriver {
	public static void main(String[] args) {
		Complex c1 = new Complex(1, -1);
		Complex c2 = new Complex(4, 3);
		Complex c3 = c1.add(c2);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		Complex c4 = new Complex(-4, 3);
		System.out.println(c4);
	}
}
