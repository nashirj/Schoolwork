package apps;

import stack.StackInterface;
import stack.StackOverflowException;
import stack.StackUnderflowException;
import stack.StackImplementationArray;
import stack.StackImplementationArrayList;

public class StackDriver {

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		// can't instantiate an interface!!!
//		StackInterface<String> stack = new StackInterface();
		
		StackInterface<Character> stack = new StackImplementationArrayList<Character>();

		Character c = 'A';
		for (int i = 0; i < 10; i++) {
			stack.push(c++);
			System.out.println(stack.peek());
		}
		stack.pop();
		stack.push('A');
		System.out.println(stack.peek());
		for (int i = 0; i < 10; i++) {
			stack.pop();
		}
		stack.pop();
	}
}
