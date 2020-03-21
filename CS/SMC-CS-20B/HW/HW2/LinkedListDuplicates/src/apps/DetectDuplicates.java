package apps;

import java.util.HashSet;

import linkedlist.LLNode;
import stack.LinkedListStack;
import stack.StackOverflowException;
import stack.StackUnderflowException;

public class DetectDuplicates {
	
	public static void main(String[] notArgsForAChange) throws StackUnderflowException, StackOverflowException {
		/**
		 * Detects if there are duplicates in a linked list stack or not.
		 * This is a test class that will test if the detection of the duplicates works.
		 * Test your code on the following stack of Strings:
		 * "A", "B", "B", "A", for which your method should return true. Also write a
		 * test for which the method returns false. Make sure to document your code!
		 * This function removes duplicates from a linked list stack. When fed with
		 * "A", "B", "B", "A", it should update the linked list stack to contain only "A", "B".
		 */
		LinkedListStack<LLNode> lls = new LinkedListStack<LLNode>();
		LLNode<String> lln1 = new LLNode<String>("A");
		LLNode<String> lln2 = new LLNode<String>("B");
		LLNode<String> lln3 = new LLNode<String>("C");
		LLNode<String> lln4 = new LLNode<String>("D");
		LLNode<String> lln5 = new LLNode<String>("C");
		LLNode<String> lln6 = new LLNode<String>("B");
		LLNode<String> lln7 = new LLNode<String>("A");
		
		try {
			lls.push(lln1);
			lls.push(lln2);
			lls.push(lln3);
			lls.push(lln4);
			lls.push(lln5);
			lls.push(lln6);
			lls.push(lln7);
			lls.push(lln2);
		} catch (StackOverflowException soe) {
			System.out.println("This shouldn't be reachable since we are using a linked list for stack");
		}
		
		System.out.println(lls);
		System.out.println(lls.detectDuplicates());
		lls.removeDuplicates();
		System.out.println("Stack after removing duplicates: " + lls);
	}
	
	// non-class methods that use buffer stack to detect and remove duplicates
//	public static boolean detectDuplicates(LinkedListStack<LLNode> lls) throws StackUnderflowException, StackOverflowException {
//		LinkedListStack<LLNode> buffer = new LinkedListStack<LLNode>();
//		HashSet<String> hs = new HashSet<String>();
//		LLNode<String> curr = null;
//		boolean hasDuplicate = false;
//		while (!lls.isEmpty()) {
//			curr = lls.top();
//			lls.pop();
//			buffer.push(curr);
//			if (hs.contains(curr.getData())) {
//				hasDuplicate = true;
//				break;
//			} else {
//				hs.add(curr.getData());
//			}
//		}
//		while (!buffer.isEmpty()) {
//			curr = buffer.top();
//			lls.push(curr);
//			buffer.pop();
//		}
//		return hasDuplicate;
//	}
//	public static void removeDuplicates(LinkedListStack<LLNode> lls) throws StackUnderflowException, StackOverflowException {
//		LinkedListStack<LLNode> buffer = new LinkedListStack<LLNode>();
//		HashSet<String> hs = new HashSet<String>();
//		LLNode<String> curr = null;
//		while (!lls.isEmpty()) {
//			curr = lls.top();
//			lls.pop();
//			if (!hs.contains(curr.getData())) {
//				hs.add(curr.getData());
//				buffer.push(curr);
//			}
//		}
//		while (!buffer.isEmpty()) {
//			curr = buffer.top();
//			lls.push(curr);
//			buffer.pop();
//		}
//	}

}
