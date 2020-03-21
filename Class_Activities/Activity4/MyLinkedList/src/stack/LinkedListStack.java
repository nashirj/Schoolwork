package stack;

import linkedlist.LLNode;
import stack.StackOverflowException;
import stack.StackUnderflowException;
import stack.StackInterface;

public class LinkedListStack<T> implements StackInterface<T> {
	
	protected LLNode<T> top;
	
	public LinkedListStack() {
		this.top = null;
	}

	public LinkedListStack(LLNode<T> node) {
		this.top = node;
	}
	
	@Override
	public void push(T t) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException("Could not push to stack, stack is full...");
		}
		LLNode<T> newNode = new LLNode<T>(t);
		top.setNext(newNode);
		top = newNode;
	}
	
	@Override
	public void pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException("Could not pop stack, stack is already empty...");
		}
		top = top.getNext();
	}
	
	@Override
	public T top() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new StackUnderflowException("Error, called top when stack is empty");
		}
		return top.getData();
	}
	
	@Override
	public boolean isEmpty() {
		return (this.top == null);
	}
	
	@Override
	public boolean isFull() {
		return false;
	}

}
