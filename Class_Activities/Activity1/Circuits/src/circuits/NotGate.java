package circuits;

public class NotGate extends UnaryGate {
	public NotGate(int a) {
		super(a);
		this.value = (a == 1) ? 0 : 1;
	}
}
