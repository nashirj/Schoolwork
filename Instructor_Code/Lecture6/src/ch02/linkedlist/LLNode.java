package ch02.linkedlist;
/**
 * Linked List Node implementation
 * Each node contains some data of generic type T, and a link
 * to the next node (self referential class).
 *
 * @author irma
 *
 * @param <T>
 */
public class LLNode<T>
{
  protected LLNode<T> link;
  protected T info;
  
  public LLNode(T info)
  {
    this.info = info;
    link = null;
  }
  //getters and setters
  public void setInfo(T info){ this.info = info;}
  public T getInfo(){ return info; }
  public void setLink(LLNode<T> link){this.link = link;}
  public LLNode<T> getLink(){ return link;}
}
 
 