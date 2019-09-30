package apps;

import linkedlist.LLNode; 

public class LLDriver {
	public static void main(String[] args) {
		LLNode<String> n1 = new LLNode<String>("A");
		LLNode<String> n2 = new LLNode<String>("B");
		LLNode<String> n3 = new LLNode<String>("C");
		LLNode<String> n4 = new LLNode<String>("D");
		
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		
		LLNode<String> root = n1;
		while (root != null) {
			System.out.println(root);
			root = root.getNext();
		}
	}
}
