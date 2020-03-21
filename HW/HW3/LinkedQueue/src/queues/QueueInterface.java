package queues;

public interface QueueInterface<T> {
	void enqueue(T entry) throws QueueOverflowException;
	T dequeue() throws QueueUnderflowException;
	boolean isFull();
	boolean isEmpty();
	int size();
}
