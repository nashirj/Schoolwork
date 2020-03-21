package circuits;

public class AndGate extends BinaryGate {
	public AndGate(int a, int b) {
		super(a, b);
		if (a == 1 && b == 1) {
			this.value = 1;
		}
		else {
			this.value = 0;
		}
	}
}
