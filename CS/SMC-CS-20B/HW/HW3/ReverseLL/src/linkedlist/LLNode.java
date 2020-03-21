package linkedlist;

public class LLNode<T> {
	
	protected T data;
	protected LLNode<T> next;
	
	public LLNode(T data) {
		this.data = data;
		this.next = null;
	}
	
	public void setLink(LLNode<T> node) {
		this.next = node;
	}

	public T getInfo() {
		return data;
	}

	public void setInfo(T data) {
		this.data = data;
	}

	public LLNode<T> getLink() {
		return next;
	}
	
	public String toString() {
		return this.data.toString();
	}

}
