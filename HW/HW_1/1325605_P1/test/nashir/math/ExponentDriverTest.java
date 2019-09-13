package nashir.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExponentDriverTest {

	/**
	 * This test passes positive rational and irrational bases to the iterative exponentiation
	 * function and tests the precision of the result to 10 significant figures.  
	 */
	@Test
	void testIterativeVersionWithPositiveExponents() {
		System.out.println("TEST ITERATIVE FUNCTION WITH POSITIVE EXPONENTS");
		double base = 3, power = 3;
		double res = ExponentDriver.calculateExponentIteratively(base, power);
		assertTrue(res == 27);
		System.out.println(base + "^" + power + " = " + res);
		base = 2;
		power = 4;
		res = ExponentDriver.calculateExponentIteratively(base, power);
		assertTrue(res == 16);
		System.out.println(base + "^" + power + " = " + res);
		base = Math.PI;
		power = 2;
		res = ExponentDriver.calculateExponentIteratively(base, power);
		double lo = 9.8696044010, hi = 9.8696044011;
		// assert that res is within a certain allowable range (10 sig figs)
		assertTrue(lo <= res && res <= hi);
		System.out.println("result = " + res + " is in range (" + lo + ", " + hi + ")");
		System.out.println();
	}
	
	/**
	 * This test passes negative rational and irrational bases to the iterative exponentiation
	 * function and tests the precision of the result to 10 significant figures.  
	 */
	@Test
	void testIterativeVersionWithNegativeExponents() {
		System.out.println("TEST ITERATIVE FUNCTION WITH NEGATIVE EXPONENTS");
		double base = 3, power = -3;
		double res = ExponentDriver.calculateExponentIteratively(base, power);
		double lo = 0.0370370370, hi = 0.0370370371; 
		// assert that res is within a certain allowable range (10 sig figs)
		assertTrue(lo <= res && res <= hi);
		System.out.println("result = " + res + " is in range (" + lo + ", " + hi + ")");
		base = 10;
		power = -2;
		res = ExponentDriver.calculateExponentIteratively(10, -2);
		assertTrue(res == 0.01);
		System.out.println(base + "^" + power + " = " + res);
		System.out.println();
	}
	
	/**
	 * This test passes positive rational and irrational bases to the recursive exponentiation
	 * function and tests the precision of the result to 10 significant figures.  
	 */
	@Test
	void testRecursiveVersionWithPositiveExponents() {
		System.out.println("TEST RECURSIVE FUNCTION WITH POSITIVE EXPONENTS");
		double base = 3, power = 3;
		double res = ExponentDriver.calculateExponentRecursively(base, power);
		assertTrue(res == 27);
		System.out.println(base + "^" + power + " = " + res);
		base = 2;
		power = 4;
		res = ExponentDriver.calculateExponentRecursively(base, power);
		assertTrue(res == 16);
		System.out.println(base + "^" + power + " = " + res);
		base = Math.PI;
		power = 2;
		res = ExponentDriver.calculateExponentRecursively(base, power);
		double lo = 9.8696044010, hi = 9.8696044011;
		// assert that res is within a certain allowable range (10 sig figs)
		assertTrue(lo <= res && res <= hi);
		System.out.println("result = " + res + " is in range (" + lo + ", " + hi + ")");
		System.out.println();
	}
	
	/**
	 * This test passes a negative power to the recursive exponentiation function and 
	 * ensures that an exception is thrown.  
	 */
	@Test
	void testRecursiveVersionThrowsException() {
		System.out.println("TEST THAT RECURSIVE FUNCTION THROWS EXCEPTION WITH NEGATIVE EXPONENTS");
		try {
			ExponentDriver.calculateExponentRecursively(2, -4);
			fail("Should throw exception");
		} catch (IllegalArgumentException iae) {
			System.out.println("Exception thrown properly");
		}
		System.out.println();
	}
}
