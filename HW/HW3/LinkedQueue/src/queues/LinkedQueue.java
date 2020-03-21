package queues;

import linkedlist.LLNode;

public class LinkedQueue<T> implements QueueInterface<T> {

	protected LLNode<T> front;
	protected LLNode<T> rear;
	protected int size;
	
	public LinkedQueue() {
		front = null;
		rear = null;
		size = 0;
	}

	@Override
	public void enqueue(T entry) throws QueueOverflowException {
		// don't need to call isFull since we can grow as much as we want
		LLNode<T> newNode = new LLNode<T>(entry);
		if (rear == null) {
			front = newNode;
		} else {
			rear.setLink(newNode);
		}
		rear = newNode;
		size++;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException("The queue is empty");
		}
		T val = front.getInfo();
		front = front.getLink();
		if (front == null) {
			rear = null;
		}
		size--;
		return val;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return front == null;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		if (front == null) {
			return "[]";
		}
		StringBuilder s = new StringBuilder("[");
		LLNode<T> ref = front;
		while (ref.getLink() != null) {
			s.append(ref.toString());
			s.append(", ");
			ref = ref.getLink();
		}
		s.append(ref.toString());
		s.append("]");
		
		return s.toString();
	}
	
	public void remove(int N) throws QueueUnderflowException {
		if (size() < N) {
			throw new QueueUnderflowException("Cannot remove " + N + " elements when there are"
					+ " only " + size() + " elements in the queue...");
		}
		
		for (int i = 0; i < N; i++) {
//			dequeue();
			front = front.getLink();
			if (front == null) {
				rear = null;
			}
			size--;
		}
		
		return;
	}
}
