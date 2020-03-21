package mypair;

public class ArrayPair<T> implements PairInterface<T> {

	protected T[] pair;
	
	public ArrayPair() {
		// create an array of size two because we have two elements
		this.pair = (T[]) new Object[2];
	}
	
	public ArrayPair(T first, T second) {
		this(); // initialize pair array
		this.pair[0] = first;
		this.pair[1] = second;
	}
	
	public void setFirst(T first) {
		this.pair[0] = first;
	}
	public T getFirst() {
		return this.pair[0];
	}
	public void setSecond(T second) {
		this.pair[1] = second;
	}
	public T getSecond() {
		return this.pair[1];
	}

}
