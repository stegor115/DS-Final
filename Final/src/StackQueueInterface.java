public interface StackQueueInterface<T>
{
//	public class StackQueueException extends Exception{
//		public StackQueueException(){
//			super();
//		} //end stackQueueException
//	}
 
    public boolean isEmpty();
 
    public void put(T newItem);
 
    public T get() throws StackQueueException;
 
    public int size();
 
    public String toString();
}