package apps;

import linkedlist.LLNode;
import queues.LinkedQueue;
import queues.QueueOverflowException;
import queues.QueueUnderflowException;

public class LinkedQueueDriver {

	public static void main(String[] args) {
		LLNode<String> temp1, temp2, temp3, temp4, temp5;
		temp1 = new LLNode<String>("alpha");
		temp2 = new LLNode<String>("beta");
		temp3 = new LLNode<String>("comma");
		temp4 = new LLNode<String>("delta");
		temp5 = new LLNode<String>("emma");

		LinkedQueue<LLNode<String>> q = new LinkedQueue<LLNode<String>>();
		
		try {
			q.enqueue(temp1);
			q.enqueue(temp2);
			q.enqueue(temp3);
			q.enqueue(temp4);
			q.enqueue(temp5);
		} catch (QueueOverflowException qoe) {
			System.out.println("shouldn't throw exception");
		}
		System.out.println(q);
		try {
			q.remove(3);
		} catch (QueueUnderflowException que) {
			System.out.println("shouldn't throw exception");
		}
		System.out.println(q);
		try {
			q.remove(3);
		} catch (QueueUnderflowException que) {
			System.out.println("exception properly thrown");
		}
		System.out.println(q);
		try {
			q.remove(2);
		} catch (QueueUnderflowException que) {
			System.out.println("shouldn't throw exception");
		}
		System.out.println(q);
	}

}
