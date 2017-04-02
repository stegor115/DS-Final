
public class Stack<T> implements StackQueueInterface<Position>{
	LinkedList unexplored = new LinkedList();
	
	@Override
	public boolean isEmpty() {
		if(unexplored.isEmpty()){
			return true;
		} else{
			return false;
		}
	}

	@Override
	public void put(Position newItem) {
		unexplored.addFirst(newItem);
	}

	@Override
	public Position get() throws StackQueueException {
		Position curPos = (Position) unexplored.removeFirst();
		return curPos;
	}

	@Override
	public int size() {
		int count = unexplored.size()-1;
		return count;
	}

}
