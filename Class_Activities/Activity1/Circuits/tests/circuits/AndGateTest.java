package circuits;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AndGateTest {

	@Test
	void testAndGate() {
		AndGate a1 = new AndGate (0, 1);
		assert a1.getValue() == 0 : " awkwaaard ";
	}

}
