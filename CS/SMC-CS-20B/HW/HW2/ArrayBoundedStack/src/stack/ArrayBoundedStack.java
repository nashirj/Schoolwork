package stack;

public class ArrayBoundedStack<T> implements StackInterface<T> {
	protected T[] elements;
	protected int stackSize;
	protected int topIndex;
	protected static int minCapacity = 10;
	
	public ArrayBoundedStack() {
		// default size for stackSize if no stackSize is provided
		this(ArrayBoundedStack.minCapacity);
	}
	public ArrayBoundedStack(int stackSize) {
		if (stackSize > ArrayBoundedStack.minCapacity) {
			this.stackSize = stackSize;
		} else {
			this.stackSize = ArrayBoundedStack.minCapacity;
		}
		this.topIndex = -1;
		this.elements = (T[]) new Object[this.stackSize];
	}
	public void push(T t) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException("Could not push to stack, stack is full...");
		}
		this.elements[++this.topIndex] = t;
	}
	public void pop() {
		if (isEmpty()) {
			System.out.println("Could not pop stack, stack is already empty...");
		}
		this.elements[this.topIndex--] = null;
	}
	public boolean isEmpty() {
		return (this.topIndex == -1);
	}
	public boolean isFull() {
		return (this.topIndex == this.stackSize - 1);
	}
	public T top() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new StackUnderflowException("Error, called top when stack is empty...");
		}
		return this.elements[this.topIndex];
	}
	
	//New functions for Week 3 HW.
	/**
	 * In order to practice your array related coding skills, code each of these
	 * methods by accessing the internal variables of the ArrayBoundedStack, not
	 * by calling the previously defined public methods of the class.
	 */
	
	/**
	 * This function returns a string that correctly represents the current stack.
	 * This method could prove useful for testing and debugging the class and for
	 * testing and debugging applications that use the class. Assume each stacked
	 * element already provided its own reasonable toString method.
	 */
	public String toString() {
		//TODO: create a check here for edge cases
		int numElements = this.size();
		if (numElements == 0) {
			return "[]";
		}
		StringBuilder s = new StringBuilder();
		s.append("[");
		for (int i = 0; i < numElements - 1; i++) {
			s.append(this.elements[i].toString());
			s.append(", ");
		}
		s.append(this.elements[numElements-1].toString());
		s.append("]");
		return s.toString();
	}

	/**
	 * This function returns a count of how many items are currently on the stack.
	 * @return numItems on the stack
	 */
	public int size() {
		int numItems = 0;
		/** 
		 * The only way to say that we have reached the end of the stack is to return
		 * when we encounter a null value.
		 */
		for (T elem : this.elements) {
			if (elem == null) {
				break;
			}
			numItems++;
		}
		return numItems;
	}
	
	/**
	 * This function removes the top count elements	from the stack.
	 * A StackUnderflowException is thrown if there are less than
	 * count elements on the stack.
	 * @param count
	 */
	public void popSome(int count) throws StackUnderflowException{
		int numItems = this.size();
		if (count < 0) {
			System.out.println("Parameter 'count' must be an integer greater than zero.");
			return;
		}
		if (numItems - count < 0) {
			String s = null;
			if (numItems == 0) {
				s = "Can not pop elements when the stack is empty.";
			} else if (numItems == 1) {
				s = "Can not pop " + count + " element(s) when there is only 1 element on the stack.";
			} else {
				s = "Can not pop " + count + " element(s) when there are only " + numItems + " on the stack.";
			}
			throw new StackUnderflowException(s);
		}
		while (numItems - count > 0) {
			// could just call this.pop(), but spec sheet says not to use public functions
			this.elements[this.topIndex--] = null;
			numItems--;
		}
	}
	/**
	 * This function returns false if there are fewer than two elements
	 * on the stack, otherwise it reverses the order of the top two elements
	 * on the stack and returns true.
	 * @return
	 */
	public boolean swapStart() {
		/**
		 * This function should not throw StackOverflowException or StackUnderflowException,
		 * we check the conditions that would lead to them and return false before
		 * executing code which raises these exceptions.
		 */
		if (this.size() < 2) {
			return false;
		}
		// temporary swap variable
		T top = this.elements[this.topIndex];
		this.elements[this.topIndex] = this.elements[this.topIndex - 1];
		this.elements[this.topIndex - 1] = top;
		
		return true;
	}
	
	public ArrayBoundedStack<T> clone() {
		ArrayBoundedStack<T> copy = new ArrayBoundedStack<T>(this.stackSize);
		for (T t : this.elements) {
			try {
				copy.push(t);
			} catch (StackOverflowException soe) {
				System.out.println("this shouldn't happen...");
				return null;
			}
		}
		return copy;
	}
}
