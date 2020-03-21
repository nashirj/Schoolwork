package ch02.stacks;
import ch02.linkedlist.*;
/**
 * Implementation of stack using a linked list
 * @author irma
 *This class implements the StackInterface with a generic type T
 * @param <T>
 */
public class LinkedListStack<T> implements StackInterface<T>
{
  protected LLNode<T> top;   // reference to the top of this stack

  public LinkedListStack()
  {
    top = null; //when newly created the top node is null
  }

  public void push(T element)
  // Places element at the top of this stack.
  { 
    LLNode<T> newNode = new LLNode<T>(element); //create a new node
    newNode.setLink(top); //set newNode to refer to the current top node
    top = newNode; //change the top mode to be the newly created node
  }     

  public void pop()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
  {                  
    if (isEmpty())
      throw new StackUnderflowException("Pop attempted on an empty stack.");
    else
      top = top.getLink(); //when an element is removed, we just move top to the next element
  }

  public T top()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns top element of this stack.
  {                 
    if (isEmpty())
      throw new StackUnderflowException("Top attempted on an empty stack.");
    else
      return top.getInfo();
  }

  public boolean isEmpty()
  // Returns true if this stack is empty, otherwise returns false.
  {              
    return (top == null); 
  }

  public boolean isFull()
  // Returns false - a linked stack is never full
  {              
      return false;
  }

}

