package circuits;

abstract class BinaryGate extends LogicGate {
	public BinaryGate(int a, int b) {
		if ((a != 1 && a != 0) || (b != 1 && b != 0))
			System.out.println("Invalid Argument - a and b must be either 1 or 0");
	}
}
