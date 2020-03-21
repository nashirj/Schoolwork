package stack;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStack<T> implements StackInterface<T> {
	protected List<T> elements;
	protected int size;
	public ArrayListStack() {
		this.elements = new ArrayList<T>();
	}
	public void push(T t) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException("Could not push to stack, stack is full...");
		}
		this.elements.add(t);
	}
	public void pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException("Could not pop stack, stack is already empty...");
		}
		this.elements.remove(this.elements.size()-1);
	}
	public boolean isEmpty() {
		return (this.elements.size() == 0);
	}
	public boolean isFull() {
		return false;
	}
	public T top() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new StackUnderflowException("Error, called top when stack is empty");
		}
		return this.elements.get(this.elements.size()-1);
	}
}