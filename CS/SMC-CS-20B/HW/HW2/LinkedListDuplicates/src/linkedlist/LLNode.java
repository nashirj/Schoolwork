package linkedlist;

public class LLNode<T> {
	
	protected T data;
	protected LLNode<T> next;
	
	public LLNode(T data) {
		this.data = data;
		this.next = null;
	}
	
	public void setNext(LLNode<T> node) {
		this.next = node;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LLNode<T> getNext() {
		return next;
	}
	
	public String toString() {
		return this.data.toString();
	}

}
