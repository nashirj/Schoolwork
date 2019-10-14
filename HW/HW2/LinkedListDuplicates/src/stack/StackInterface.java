package stack;

public interface StackInterface<T> {
	public void pop() throws StackUnderflowException;
	public void push(T t) throws StackOverflowException;
	public T top() throws StackUnderflowException;
	public boolean isEmpty();
	public boolean isFull();
}
