package queues;

import linkedlist.LLNode;

public class CircularLinkedQueue<T> implements QueueInterface<T> {

	protected LLNode<T> rear;
	protected int size;
	
	public CircularLinkedQueue() {
		rear = null;
		size = 0;
	}

	@Override
	public void enqueue(T entry) throws QueueOverflowException {
		LLNode<T> newNode = new LLNode<T>(entry);
//		if (rear == null) {
//			rear = newNode;
//		} else {
//			rear.setLink(newNode);
//		}
//		rear = newNode;
		if (rear == null) {
			rear = newNode;
		} else if (rear.getLink() == null) {
			newNode.setLink(rear);
			rear.setLink(newNode);
		} else {
			newNode.setLink(rear.getLink());
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
		
		T val = null;
		
		LLNode<T> kill = rear.getLink();
		if (kill == null) {
			val = rear.getInfo();
			rear = null;
		}
		else {
			val = kill.getInfo();
			if (kill.getLink() == rear) {
				kill = null;
				rear.setLink(null);
			} else {
				rear.setLink(kill.getLink());
				kill = null;
			}
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
		return rear == null;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		if (rear == null) {
			return "[]";
		}
		if (rear.getLink() == null) {
			return "[" + rear.getInfo().toString() + "]";
		}
		StringBuilder s = new StringBuilder("[");
		LLNode<T> ref = rear.getLink();
		while (ref != rear) {
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
			dequeue();
		}
		
		return;
	}
}
