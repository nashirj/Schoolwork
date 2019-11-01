package houses;

import java.util.Iterator;

public class ArrayCollection<T> implements CollectionInterface<T>, Iterable<T>
{
	protected final int DEFCAP = 100; // default capacity
	protected T[] elements;           // array to hold collections elements
	protected int numElements = 0;    // number of elements in this collection

	// set by find method
	protected boolean found;  // true if target found, otherwise false
	protected int location;   // indicates location of target if found

	public ArrayCollection() 
	{
		elements = (T[]) new Object[DEFCAP];
	}

	public ArrayCollection(int capacity) 
	{
		elements = (T[]) new Object[capacity];
	}

	protected void find(T target)
	// Searches elements for an occurrence of an element e such that
	// e.equals(target). If successful, sets instance variables
	// found to true and location to the array index of e. If
	// not successful, sets found to false.
	{
		location = 0;
		found = false;

		while (location < numElements) 
		{
			if (elements[location].equals(target))
			{  
				found = true;
				return;
			}
			else
				location++;
		}
	}

	public boolean add(T element)
	// Attempts to add element to this collection.
	// Returns true if successful, false otherwise.
	{
		if (isFull())
			return false;
		else
		{
			elements[numElements] = element;
			numElements++;
			return true;
		}
	}

	public boolean remove (T target)
	// Removes an element e from this collection such that e.equals(target)
	// and returns true; if no such element exists, returns false.
	{
		find(target);    
		if (found)
		{
			elements[location] = elements[numElements - 1];
			elements[numElements - 1] = null;
			numElements--;  
		}
		return found;
	}

	public boolean contains (T target)
	// Returns true if this collection contains an element e such that 
	// e.equals(target); otherwise, returns false.
	{
		find(target);
		return found;
	}

	public T get(T target)
	// Returns an element e from this collection such that e.equals(target);
	// if no such element exists, returns null.
	{
		find(target);    
		if (found)
			return elements[location];
		else
			return null;
	}

	public boolean isFull()
	// Returns true if this collection is full; otherwise, returns false.
	{
		return (numElements == elements.length);
	}

	public boolean isEmpty()
	// Returns true if this collection is empty; otherwise, returns false.
	{
		return (numElements == 0);  
	}

	public int size()
	// Returns the number of elements in this collection. 
	{
		return numElements;
	}

	//Naive selection sort provided for you
	public void sort() 
	{ 
		int n = this.numElements; 

		// One by one move boundary of unsorted subarray 
		for (int i = 0; i < n-1; i++) 
		{ 
			// Find the minimum element in unsorted array 
			int min_idx = i; 
			for (int j = i+1; j < n; j++) 
				if (((Comparable)this.elements[j]).compareTo(this.elements[min_idx]) < 0) 
					min_idx = j; 

			// Swap the found minimum element with the first 
			// element 
			T temp = this.elements[min_idx]; 
			this.elements[min_idx] = this.elements[i]; 
			this.elements[i] = temp; 
		} 
	} 



	public String toString() {
		String res = "";
		for(int i = 0; i < numElements; i++)
			res += this.elements[i] + " ";
		return res;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			
			private int previousPos = -1;

			@Override
			public boolean hasNext() {
				return (previousPos < size() - 1);
			}

			@Override
			public T next() {
				if (!hasNext())
					throw new IndexOutOfBoundsException("Illegal invocation of next " + 
														" in ABList iterator.\n");
				return elements[++previousPos];
			}
		};
	}






}
