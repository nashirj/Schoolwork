package collections;

import collections.AdvancedSetInterface;

public class AdvancedSet<T> implements AdvancedSetInterface<T> {

	protected T[] set;
	protected static final int DEFCAP = 100;
	protected int numElements;
	protected int location;

	public AdvancedSet() {
		this(DEFCAP);
	}
	
	public AdvancedSet(int capacity) {
		set = (T[]) new Object[capacity];
		numElements = 0;
	}

	public boolean add(T element)
	// If element is not already contained in this collection adds element to 
	// this collection and returns true; otherwise returns false.
	{
		if (!isFull() && !this.contains(element))
		{
			set[numElements++] = element;
			return true;
		}
		else
			return false;
	}

	public int size() {
		return numElements;
	}
	
	private boolean find(T target) {
		for (int i = 0; i < numElements; i++) {
			if (set[i].equals(target)) {
				location = i;
				return true;
			}
		}
		return false;
	}
	
	public boolean contains (T target) {
		if (target == null) {
			return false;
		}
		for (int i = 0; i < numElements; i++) {
			if (set[i].equals(target)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean remove (T target) {
		if (isEmpty() || !find(target)) {
			return false;
		}
		set[location] = set[numElements - 1];
		set[numElements - 1] = null;
		numElements--;
		return true;
	}
	
	public T get(T target) {
		if (find(target)) {
			return set[location];
		}
		return null;
	}
	
	public boolean isEmpty() {
		return numElements == 0;
	}
	
	public boolean isFull() {
		return numElements == set.length;
	}

	@Override
	public AdvancedSetInterface<T> union(AdvancedSetInterface<T> other) {
		int newSize = other.size() + this.size() + DEFCAP;
		AdvancedSet<T> union = new AdvancedSet<T>(newSize);
		AdvancedSet<T> otherAdvancedSet = (AdvancedSet<T>) other; // is this bad? not sure how else to do it
		for (int i = 0; i < this.size(); i++) {
			union.add(this.set[i]);
		}
		for (int i = 0; i < other.size(); i++) {
			// add method performs check to see if union already contains set[i]
			union.add(otherAdvancedSet.set[i]);
		}
		return union;
	}

	@Override
	public AdvancedSetInterface<T> intersection(AdvancedSetInterface<T> other) {
		int newSize = other.size() + this.size() + DEFCAP;
		AdvancedSet<T> intersection = new AdvancedSet<T>(newSize);
		AdvancedSet<T> otherAdvancedSet = (AdvancedSet<T>) other;
		for (int i = 0; i < other.size(); i++) {
			if (this.contains(otherAdvancedSet.set[i])) {
				intersection.add(otherAdvancedSet.set[i]);
			}
		}
		return intersection;
	}

	@Override
	public AdvancedSetInterface<T> difference(AdvancedSetInterface<T> other) {
		int newSize = other.size() + this.size() + DEFCAP;
		AdvancedSet<T> difference = new AdvancedSet<T>(newSize);
		AdvancedSet<T> otherAdvancedSet = (AdvancedSet<T>) other;
		for (int i = 0; i < other.size(); i++) {
			if (!this.contains(otherAdvancedSet.set[i])) {
				difference.add(otherAdvancedSet.set[i]);
			}
		}
		for (int i = 0; i < this.size(); i++) {
			if (!otherAdvancedSet.contains(this.set[i])) {
				difference.add(this.set[i]);
			}
		}
		
//		// add all from other
//		for (int i = 0; i < other.size(); i++) {
//			difference.add(otherAdvancedSet.set[i]);
//		}
//		// if this elem is in other, remove from difference
//		// else, add this elem
//		for (int i = 0; i < this.size(); i++) {
//			if (difference.contains(this.set[i])) {
//				difference.remove(this.set[i]);
//			} else {
//				difference.add(this.set[i]);
//			}
//		}
		
		return difference;
	}
	
	@Override
	public String toString()
	{
		if (numElements == 0) {
			return "[]";
		}
		StringBuilder s = new StringBuilder("[");
		int i = 0;
		while (i < numElements - 1) {
			s.append(set[i++]);
			s.append(", ");
		}
		s.append(set[i]);
		s.append("]");

		return s.toString();
	}
}
