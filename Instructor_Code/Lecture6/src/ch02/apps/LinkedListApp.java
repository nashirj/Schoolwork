package ch02.apps;
import ch02.linkedlist.*;

public class LinkedListApp {

	public static void main(String[] args) {
		LLNode<String> letters = new LLNode<String>("B");
		LLNode<String> newNode1 = new LLNode<String>("C");
		LLNode<String> newNode2 = new LLNode<String>("D");
		letters.setLink(newNode1);
		newNode1.setLink(newNode2);
		
		LLNode<String> curNode = letters;
		while(curNode!=null) {
			System.out.println(curNode.getInfo());
			curNode = curNode.getLink();
		}
		LLNode<String> newNode3 = new LLNode<String>("A");
		newNode3.setLink(letters);
		letters = newNode3;
		
		System.out.println("----- ADDING A ----");
		
		curNode = letters;
		while(curNode!=null) {
			System.out.println(curNode.getInfo());
			curNode = curNode.getLink();
		}
	}
}
