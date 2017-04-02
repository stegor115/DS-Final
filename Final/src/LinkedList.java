
public class LinkedList implements LinkedListInterface<Object>{
	private class Node{
		private Object data;
		private Node next;
		
		public Node(Object data){
			this.data = data;
			next = null;
		} //end public Node
	} //end private class node

	private Node head;
	private Node tail;

	@Override
	public boolean isEmpty() {
		if(head == null && tail == null){
			return true;
		} else{
			return false;
		} //end if else
	}

	@Override
	public int size() {
		int counter = 0;
		if(isEmpty()){
			return 0;
		} //end if
		for(Node pointer = head; pointer != null; pointer = pointer.next){
			counter++;
		} //end for
		return counter-1;
	} //end method

	@Override
	public void addFirst(Object newItem) {
		Node n = new Node(newItem);
		if(head == null){
			head = n;
			tail = n;
			return;
		} //end if
		n.next = head;
		head = n;
		  } //end method

	@Override
	public void addLast(Object newItem) {
		  Node t = head;
	      Node n = new Node( newItem );
	      if( head == null )
	      {
	         head = n;
	         tail = n;
	         return;
	      }
	      while( t.next != null ){
	    	  t = t.next;
	      } //end while
	      	  t.next = n;
	      	  tail = n;
		  } //end method

	@Override
	public Object removeFirst() { //Likely used to pop off stuff
		Object nuke = head.data;
		if(head == tail){
			head = null;
			tail = null;
		} else{
			head = head.next;
			Node newTail = head;
			while(newTail.next != null){ //Sets the new tail up
				newTail = newTail.next;
			} //end while
			tail = newTail;	
		} //end if
		return nuke;
	}
	
	@Override
	public String toString(){
		  String r = "";
	      Node t = head;
	      while( t != null )
	      {
	         r += t.data + " ";
	         t = t.next;
	      }
	      return r;
	}
	
	public boolean contains(Object myItem){
		Node pointer = head;
		boolean flag = false;
		while(pointer != null){
			if(pointer.data == myItem){
				flag = true;
				break;
			} //end if
			pointer = pointer.next;
		} //end while
		return flag;
	}
} //end class
