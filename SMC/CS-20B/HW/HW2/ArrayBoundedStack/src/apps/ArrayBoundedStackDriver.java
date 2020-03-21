package apps;

import stack.ArrayBoundedStack;
import stack.StackOverflowException;
import stack.StackUnderflowException;

public class ArrayBoundedStackDriver {

	public static void main(String[] args) throws StackOverflowException {
		// if changing either of these lines, also need to change try
		// statement for popSome
		int stackSize = 20;
		int diff = 5;
		ArrayBoundedStack<String> abs = new ArrayBoundedStack<String>(20);
		for (int i = 0; i < stackSize - diff; i++) {
			abs.push("hi #" + (i + 1));
		}
		//test toString()
		System.out.println(abs);
		//test size()
		assert(abs.size() == stackSize - diff);
		//test popSome
		try {
			//test that this pops correctly
			abs.popSome(diff);
			assert(abs.size() == stackSize - (2 * diff));
			System.out.println(abs.size());
			//test that exception is thrown when popSome > numItems on stack
			abs.popSome(10 * diff);
		} catch (StackUnderflowException soe) {
			System.out.println(soe);
		}
		//test swapStart
		//test normal operation
		System.out.println(abs);
		if (abs.swapStart()) {
			System.out.println(abs);
		}
		if (abs.swapStart()) {
			System.out.println(abs);
		}
		for (int i = 0; i < abs.size() - 2; i++) {
			abs.pop();
		}
		if (abs.swapStart()) {
			System.out.println(abs);
		}
		abs.pop();
		if (abs.swapStart()) {
			System.out.println(abs);
		}
		abs.pop();
		if (abs.swapStart()) {
			System.out.println(abs);
		} else {
			System.out.println("can not call swapStart() when there are < 2 elements on stack");
		}
	}

}
