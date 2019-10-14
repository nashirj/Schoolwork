package stack;

import java.util.HashSet;

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
		newNode.setNext(top);
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
	
	public String toString() {
		LLNode<T> curr = this.top;
		if (this.top == null) {
			return "[]";
		}
		StringBuilder s = new StringBuilder();
		s.append("[");
		while (curr.getNext() != null) {
			s.append(curr.getData());
			s.append(", ");
			curr = curr.getNext();
		}
		s.append(curr.getData());
		s.append("]");
		return s.toString();
	}
	
	// class method that uses constant space to iterate through list with two pointers and detect duplicates
	// only works with comparing string values
	public boolean detectDuplicates() {
		LLNode<T> curr = top;
		while (curr.getNext() != null) {
			LLNode<T> next = curr.getNext();
			while (next != null) {
				if (curr.getData().toString().equals(next.getData().toString())) {
					return true;
				}
				next = next.getNext();
			}
			curr = curr.getNext();
		}
		return false;
	}
	
	// class method that uses a hash set to keep track of seen data and removes duplicates
	public void removeDuplicates() {
		LLNode<T> curr = top;
		LLNode<T> prev = curr;
		curr = curr.getNext();
		HashSet<String> hs = new HashSet<String>();
		hs.add(prev.getData().toString());
		while (curr != null) {
			if (hs.contains(curr.getData().toString())) {
				prev.setNext(curr.getNext());
			} else {
				hs.add(curr.getData().toString());
				prev = curr;
			}
			curr = curr.getNext();
		}
	}

}
