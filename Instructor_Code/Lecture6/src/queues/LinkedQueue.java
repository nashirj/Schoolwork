package queues;

import ch02.linkedlist.LLNode;

public class LinkedQueue<T> implements QueueInterface<T> {

	LLNode<T> front;
	LLNode<T> rear;
	public int size;
	
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
		return front == null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size;
	}

}
