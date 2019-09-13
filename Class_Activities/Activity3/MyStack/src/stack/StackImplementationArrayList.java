package stack;

import java.util.ArrayList;
import java.util.List;

public class StackImplementationArrayList<T> implements StackInterface<T> {
	protected List<T> elements;
	protected int size;
	public StackImplementationArrayList() {
		elements = new ArrayList<T>();
	}
	public void push(T t) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException("Could not push to stack, stack is full...");
		}
		elements.add(t);
	}
	public void pop() throws StackUnderflowException{
		if (isEmpty()) {
			throw new StackUnderflowException("Could not pop stack, stack is already empty...");
		}
		elements.remove(elements.size()-1);
	}
	public boolean isEmpty() {
		return (elements.size() == 0);
	}
	public boolean isFull() {
		return false;
	}
	public T peek() {
		return elements.get(elements.size()-1);
	}
}
