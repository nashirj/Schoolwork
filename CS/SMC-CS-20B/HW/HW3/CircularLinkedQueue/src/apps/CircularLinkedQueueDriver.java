package apps;

import linkedlist.LLNode;
import queues.CircularLinkedQueue;
import queues.QueueOverflowException;
import queues.QueueUnderflowException;

public class CircularLinkedQueueDriver {

	public static void main(String[] args) {
		LLNode<String> temp1, temp2, temp3, temp4, temp5;
		temp1 = new LLNode<String>("alpha");
		temp2 = new LLNode<String>("beta");
		temp3 = new LLNode<String>("comma");
		temp4 = new LLNode<String>("delta");
		temp5 = new LLNode<String>("emma");

		CircularLinkedQueue<LLNode<String>> q = new CircularLinkedQueue<LLNode<String>>();
		
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
		
		// test dequeueing with one elem
		System.out.println("test dequeueing with one elem");
		try {
			q.enqueue(temp1);
			System.out.println(q);
			q.dequeue();
			System.out.println(q);
		} catch (QueueOverflowException e) {
			System.out.println("shouldn't throw exception");
		} catch (QueueUnderflowException e) {
			System.out.println("shouldn't throw exception");
			e.printStackTrace();
		}
		
		
		// test dequeueing with two elems
		System.out.println("test dequeueing with two elems");
		try {
			q.enqueue(temp1);
			q.enqueue(temp2);
			System.out.println(q);
			q.dequeue();
			q.dequeue();
			System.out.println(q);
		} catch (QueueOverflowException e) {
			System.out.println("shouldn't throw exception");
		} catch (QueueUnderflowException e) {
			// System.out.println("shouldn't throw exception");
			e.printStackTrace();
		}
		
		// test dequeueing with n elems
		System.out.println("test dequeueing with n elems");
		try {
			q.enqueue(temp1);
			q.enqueue(temp2);
			q.enqueue(temp3);
			q.enqueue(temp4);
			q.enqueue(temp5);
			System.out.println(q);
			q.dequeue();
			q.dequeue();
			q.dequeue();
			q.dequeue();
			q.dequeue();
			System.out.println(q);
		} catch (QueueOverflowException e) {
			System.out.println("shouldn't throw exception");
		} catch (QueueUnderflowException e) {
			System.out.println("shouldn't throw exception");
		}
		System.out.println(q);
		
		// test proper exception thrown when calling remove with no elements
		System.out.println("test proper exception throwing when calling remove with no elements");
		try {
			q.dequeue();
		} catch (QueueUnderflowException e) {
			System.out.println("exception properly thrown");
		}
	}

}
