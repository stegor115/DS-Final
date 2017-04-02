public interface LinkedListInterface<T> 
{
	public class LinkedListException extends Exception{
		public LinkedListException(){
			super();
		} //end linkedlisteception
	} // end class
 
    public boolean isEmpty();
 
    public int size();
 
    public void addFirst(T newItem);
 
    public void addLast(T newItem);
 
    public T removeFirst() throws LinkedListException;
 
    public String toString();
}
