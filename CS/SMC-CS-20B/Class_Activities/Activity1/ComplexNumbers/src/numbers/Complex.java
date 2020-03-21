package numbers;

public class Complex {
	/**
	 * Class for representing complex numbers.
	 * This class has two members representing the real and imaginary portions of complex numbers
	 * 	in addition to the common operations performed by and on on complex numbers.
	 */
	private double real;
	private double imag;
	
	/**
	 * Constructor
	 * @param real: the real portion of the complex number.
	 * @param imaginary: the imaginary portion of the complex number.
	 */
	public Complex(double real, double imaginary) {
		this.real = real;
		this.imag = imaginary;
	}
	
	/**
	 * Default constructor
	 */
	public Complex() {
		this.real = 0;
		this.imag = 0;
	}
	
	@Override
	public String toString() {
		char operand;
		if (imag >= 0) {
			operand = '+';
		} else {
			operand = '-';
		}
		return this.real + " " + operand + " " + Math.abs(this.imag) + "i";
	}
	
	/**
	 * Complex addition.
	 * @param c
	 * @return an object of the Complex class that is the sum of this and c.
	 */
	public Complex add(Complex c) {
		return new Complex(this.real + c.real, this.imag + c.imag);
	}
	
	/**
	 * Complex subtraction.
	 * @param c
	 * @return an object of the Complex class that is the difference between this and c.
	 */
	public Complex subtract(Complex c) {
		return new Complex(this.real - c.real, this.imag - c.imag);
	}
	
	//TODO: implement the other operations and functionality of Complex numbers
}
