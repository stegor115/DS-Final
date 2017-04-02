public class SolveMaze extends Maze {
	public static void main(String[] args){
		String theFile = "maze1.txt";
		Maze myMazeQ = new Maze(); //Reading the file works
		Maze myMazeS = new Maze();
		try {
			myMazeQ.readFromFile(theFile);
			myMazeS.readFromFile(theFile);
		} catch (MazeException e) {
			System.out.println("Unable to read file.");
			e.printStackTrace();
		} //end try catch
		
		LinkedList test = new LinkedList();
		test.addFirst(4);
		
		//Wasted hours trying to fix this only to realize it was because I was trying to use a stack when I only have worked on the queue :(
		System.out.println(myMazeQ.solveMaze("queue"));
		System.out.println(toString(myMazeQ));
		System.out.println(myMazeS.solveMaze("stack"));
		System.out.println(toString(myMazeS));
		} //end main
} //end class
