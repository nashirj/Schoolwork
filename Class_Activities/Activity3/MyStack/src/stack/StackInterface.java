package stack;

public interface StackInterface<T> {
	void pop() throws StackUnderflowException;
	void push(T t) throws StackOverflowException;
	T peek();
	boolean isEmpty();
	boolean isFull();
}
