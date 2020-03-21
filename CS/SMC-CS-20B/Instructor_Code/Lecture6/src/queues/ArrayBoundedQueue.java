package queues;

public class ArrayBoundedQueue<T> implements QueueInterface<T> {

	protected final int CAP = 100;
	protected T[] elements;
	protected int size = 0;
	protected int front = 0;
	protected int rear;
	
	public ArrayBoundedQueue() {
		elements = (T[]) new Object[CAP];
		rear = CAP - 1;
	}

	@Override
	public void enqueue(T entry) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException("The queue is full");
		}
		rear = (rear + 1) % elements.length;
//		if (rear == elements.length - 1) {
//			rear = 0;
//		} else {
//			rear++;
//		}
		// shouldn't the above be elements.length instead of elements.length - 1?
		elements[rear] = entry;
		size++;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException("The queue is empty");
		}
		T returnElem = elements[front];
		elements[front] = null;
		front = (front + 1) % elements.length;
		size--;
		return returnElem;
	}

	@Override
	public boolean isFull() {
		return size == CAP;
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
