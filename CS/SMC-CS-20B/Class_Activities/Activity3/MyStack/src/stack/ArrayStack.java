package stack;

public class ArrayStack<T> implements StackInterface<T> {
	protected T[] elements;
	protected int size = 16;
	protected int topIndex;
	public ArrayStack(int size) {
		topIndex = -1;
		elements = (T[]) new Object[size];
	}
	public void push(T t) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException("Could not push to stack, stack is full...");
		}
		topIndex++;
		elements[topIndex] = t;
	}
	public void pop() {
		if (isEmpty()) {
			System.out.println("Could not pop stack, stack is already empty...");
		}
		elements[topIndex] = null;
		topIndex--;
	}
	public boolean isEmpty() {
		return (topIndex == -1);
	}
	public boolean isFull() {
		return (topIndex == size - 1);
	}
	public T top() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new StackUnderflowException("Error, called top when stack is empty");
		}
		return elements[topIndex];
	}
}
