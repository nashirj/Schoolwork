package apps;

import stack.StackInterface;
import stack.ArrayListStack;
import stack.StackOverflowException;
import stack.StackUnderflowException;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		String s = new String("Hello there!");
		
		System.out.println(s);
		
		ArrayListStack<Character> als = new ArrayListStack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			Character c = Character.valueOf(s.charAt(i));
			try {
				als.push(c);				
			} catch (StackOverflowException soe){
				System.out.println("pushed too many chars onto stack! error...");
				System.exit(-1);
			}
		}
		
		System.out.println("Successfully reversed the string!");
		
		while (!als.isEmpty()) {
			try {
				System.out.print(als.top());
				als.pop();
			} catch (StackUnderflowException soe){
				System.out.println("popped too many chars from stack! error...");
				return;
			}
		}
		System.out.println();
	}

}
