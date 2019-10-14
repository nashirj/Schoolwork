package mypair;

import mypair.PairInterface;

public class BasicPair<T> implements PairInterface<T> {

	protected T first;
	protected T second;
	
	public BasicPair() {
		this.first = null;
		this.second = null;
	}
	
	public BasicPair(T first, T second) {
		this.first = first;
		this.second = second;
	}
	
	@Override
	public void setFirst(T first) {
		this.first = first;
	}
	
	@Override
	public T getFirst() {
		return this.first;
	}
	
	@Override
	public void setSecond(T second) {
		this.second = second;
	}
	
	@Override
	public T getSecond() {
		return this.second;
	}
}
