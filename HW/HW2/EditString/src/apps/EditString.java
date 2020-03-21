package apps;

import java.util.Scanner;

import stack.ArrayListStack;
import stack.StackOverflowException;
import stack.StackUnderflowException;

public class EditString {

	public static void main(String[] args) {
		/**
		 * EditString prompts the user for a string and then repeatedly prompts the
		 * user for changes to the string until the user enters an X, indicating the
		 * end of changes. Legal change operations are:
		 * U|make all letters uppercase
		 * L|make all letters lowercase
		 * R|reverse the string
		 * C ch1 ch2|change all occurrences of ch1 to ch2
		 * Z|undo the most recent change
		 * You may assume a friendly user, that is, the user will not enter anything
		 * illegal. When the user is finished, the resultant string is printed.
		 * For example, if the user enters:
		 * All dogs go to heaven
		 * U
		 * R
		 * Z
		 * C O A
		 * C A t
		 * Z
		 * the output from the program will be \ALL DAGS GA tA HEAVEN\
		 * Make sure this driver test is possible to be compiled and run from command
		 * line. Include all the packages/dependencies in your submission!
		 */
		// create scanner and get user input
		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter a string");
	    String str = sc.nextLine();
	    System.out.println("Your original string is: " + str);  // Output user input
	    
	    //create stack for keeping track of user's operations and initialize with initial input
	    ArrayListStack<String> history = new ArrayListStack<String>();
	    try {
	    	history.push(str);
	    } catch (StackOverflowException soe) {
	    	System.out.println("This should not be reachable since we are using an ArrayList.");	    	
	    }
	    // string for getting commands from user while in the loop
	    String userIn = null;
	    
		do {
			System.out.print("Enter an operation: ");
		    userIn = sc.nextLine();
		    
		    // handle various cases as defined in spec
		    switch (userIn.charAt(0)) {
		    	case 'Z':
		    		str = undoLastOperation(history, str);
		    		// if we undo, we don't want to push a duplicate state of the string
		    		// onto the stack, so we continue
			    	continue;
		    	case 'U':
			    	str = str.toUpperCase();
			    	break;
		    	case 'L':
			    	str = str.toLowerCase();
			    	break;
		    	case 'R':
			    	str = reverse(str);
			    	break;
		    	case 'C':
			    	//this assumes benevolent user input!!!
			    	str = str.replace(userIn.charAt(2), userIn.charAt(4));
			    	break;
		    	case 'X':
		    		// the condition in the while loop is set to terminate when we encounter 'X'
		    		// at this point, it doesn't matter what we do to the stack
			    	break;
			    default:
			    	System.out.println("Invalid entry...");
			    	// if we didn't perform an operation, we don't want to push onto the stack
			    	// since we didn't change the state of str, so we continue
			    	continue;
		    }
		    
		    try {
		    	history.push(str);
		    } catch (StackOverflowException soe) {
		    	System.out.println("This should not be reachable since we are using an ArrayList.");
		    }
		} while (userIn.charAt(0) != 'X');
		
		System.out.println("The string after all modifications is: " + str);
		sc.close();
	}
	
	public static String reverse(String str) {
		StringBuilder s = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			s.append(str.charAt(i));
		}
		return s.toString();
	}
	
	public static String undoLastOperation(ArrayListStack<String> history, String str) {
		String prevStr = null;
		if (history.size() > 1) {
    		try {
    			history.pop();
    			prevStr = history.top();
    		} catch (StackUnderflowException e) {
    			System.out.println("This should not be reachable since an exception will only be raised if "
    					+ "history is empty, which we check with isEmpty().");
    			return str;
    		}
    	} else {
    		System.out.println("There are no operations to undo...");
    		return str;
    	}
		return prevStr;
	}
}
