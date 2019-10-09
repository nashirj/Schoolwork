package apps;

import java.util.Stack;

import linkedlist.LLNode;

public class LinkedListReverse
{
	static void recRevPrintList(LLNode<String> listRef)
	// Prints the contents of the listRef linked list to standard output
	// in reverse order recursively
	{
		if (listRef != null)
		{
			recRevPrintList(listRef.getLink());
			System.out.println(listRef.getInfo());
		}
	}

	/**
	 * Prints the contents of the listRef linked list to standard output
	 * in reverse order iteratively
	 * This approach uses O(n) space and O(1) time.
	 */
	static void iterRevPrintList(LLNode<String> listRef) {
		// basically the same algorithm as recRevPrintList, but done explicitly with a stack
		LLNode<String> ref = listRef;
		Stack<LLNode> s = new Stack<LLNode>();
		while (ref != null) {
			s.push(ref);
			ref = ref.getLink();
		}
		while (!s.empty()) {
			ref = s.pop();
			System.out.println(ref);
		}
	}
	
//	/**
//	 * Prints the contents of the listRef linked list to standard output
//	 * in reverse order iteratively
//	 * This approach uses O(1) space and O(n^2) time.
//	 */
//	static void iterRevPrintList(LLNode<String> listRef) {
//		LLNode<String> ref = listRef;
//		int numNodes = 0;
//		
//		// count the number of nodes in the list
//		while (ref != null) {
//			numNodes++;
//			ref = ref.getLink();
//		}
//		
//		int curr = 0;
//		
//		// 1) point ref to the beginning of the list each iteration
//		// 2) increment ref until it is curr steps away from the end
//		// 3) print ref then increment curr
//		while (curr < numNodes) {
//			int iter = curr;
//			ref = listRef;
//			while (numNodes - iter - 1 > 0) {
//				iter++;
//				ref = ref.getLink();
//			}
//			System.out.println(ref);
//			curr++;
//		}
//	}

	public static void main(String[] args) {
		System.out.println("\n\nTesting empty list:");
		LLNode<String> emptyList = null;

		System.out.println("\n  recursive print: "); recRevPrintList(emptyList);
		System.out.println("\n  iterative print: "); iterRevPrintList(emptyList);

		System.out.println("\n\nTesting list with: alpha:");
		LLNode<String> temp1;
		temp1 = new LLNode<String>("alpha");

		LLNode<String> singletonList = temp1;

		System.out.println("\n  recursive print: "); recRevPrintList(singletonList);
		System.out.println("\n  iterative print: "); iterRevPrintList(singletonList);

		System.out.println("\n\nTesting list with: alpha, beta, comma, delta, emma:");
		LLNode<String> temp2, temp3, temp4, temp5;
		temp1 = new LLNode<String>("alpha");
		temp2 = new LLNode<String>("beta");
		temp3 = new LLNode<String>("comma");
		temp4 = new LLNode<String>("delta");
		temp5 = new LLNode<String>("emma");

		LLNode<String> multiList = temp1;
		temp1.setLink(temp2);
		temp2.setLink(temp3);
		temp3.setLink(temp4);
		temp4.setLink(temp5);

		System.out.println("\n  recursive print: "); recRevPrintList(multiList);
		System.out.println("\n  iterative print: "); iterRevPrintList(multiList);
	}
}
