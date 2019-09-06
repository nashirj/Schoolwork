package circuits;

abstract class UnaryGate extends LogicGate {
	public UnaryGate(int a) {
		if (a != 1 && a != 0)
			System.out.println("Invalid Argument - a must be either 1 or 0");
	}

}
