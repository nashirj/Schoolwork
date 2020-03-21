package apps;

import stack.StackInterface;
import stack.StackOverflowException;
import stack.StackUnderflowException;
import stack.ArrayStack;
import stack.ArrayListStack;

public class StackDriver {

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		// can't instantiate an interface!!!
//		StackInterface<String> stack = new StackInterface();
		
		StackInterface<Character> stack = new ArrayListStack<Character>();

		Character c = 'A';
		for (int i = 0; i < 10; i++) {
			stack.push(c++);
			System.out.println(stack.top());
		}
		stack.pop();
		stack.push('A');
		System.out.println(stack.top());
		for (int i = 0; i < 10; i++) {
			stack.pop();
		}
		stack.pop();
	}
}
