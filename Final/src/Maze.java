import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

 
public class Maze implements MazeInterface 
{
 
    protected char [][] maze;
    protected int nRows;
    protected int nCols;
    
    public void readFromFile(String filename) throws MazeException 
	{
	BufferedReader input;
	String line;
	StringTokenizer tokenizer;
 
	nRows = 0;
	try 
	{
	    int currentRow = 0;
	    input = new BufferedReader(new FileReader(filename));
	    
		while ((line = input.readLine()) != null) //Reads until no more lines
		{
			if (nRows == 0) 
			{  // true if reading first line in file, containing   nRows nColums
				tokenizer = new StringTokenizer(line);
				nRows = Integer.parseInt(tokenizer.nextToken()); //Finds the number of rows -
				nCols = Integer.parseInt(tokenizer.nextToken()); //Finds the number of columns |
				maze = new char[nRows][nCols]; //Sets up the grid
			} 
			else if (line.length() == 1) 
				break; // in case there is a linefeed at end of file
			else 
			{
				for (int c = 0; c < nCols; c++) 
				{
					maze[currentRow][c] = line.charAt(c); //Adds characters across the row
				}
		    currentRow ++; //moves to next row
			}
	    }
	}
	catch (IOException e) 
	{
	    throw new MazeException("Problem reading maze file " + filename);
	}
}
    public static String toString(Maze myMaze){ //IT WORKS
    	String r = "";
    	int col = 0;
    	int row = 0;
    	for(row = 0; row < myMaze.nRows; row++){ //Traverses the rows after all columns are added
    		for(col = 0; col < myMaze.nCols; col++){ //Traverses the columns in row above
    			r += myMaze.maze[row][col];
    		} //end col 
    		r += "\n";
    	} //end row
    	
    	return r;
    } //end toString
    
	@Override
	public String solveMaze(String stackOrQueue) {
		StackQueueInterface<Position> unexplored = null;
		String r = "";
		boolean complete = false;
		stackOrQueue = stackOrQueue.toLowerCase(); //Just in case
		if("queue".equals(stackOrQueue)){
			unexplored = new Queue<Position>();
		} //end if
		else if("stack".equals(stackOrQueue)){
			unexplored = new Stack<Position>();
		} //end else if
		
		//Find Start
		int col = 0;
		int row = 0;
		while(this.maze[row][col] != 'S'){ //Correctly found starting positon
			for(col = 0; col < this.nCols-1; col++){
				if(this.maze[row][col] == 'S'){
					break;
				} //end if
			} //end for
			if(this.maze[row][col] == 'S'){ //There's probably a better way to do this
				break;
			} else{
				row++;
			} //end if else
		} //end while
		
		Position startPos = new Position(row,col);
		LinkedList explored = new LinkedList();
		unexplored.put(startPos);
		try {
			while(!complete){
				Position cur, up, down, left, right;
				cur = unexplored.get();
				explored.addFirst(cur);
				if(this.maze[cur.row][cur.column] == 'T'){
					//Stop everything
					complete = true; //Might be useless
					break;
				} else if(this.maze[cur.row][cur.column] != 'S'){
					this.maze[cur.row][cur.column] = '.'; //Should change all spaces to periods if they have been explored
				} //end else if
				
				up = cur.up();
				if(this.maze[up.row][up.column] != '#' && this.maze[up.row][up.column] != '.'){
					if(this.maze[up.row][up.column] != 'T')
						unexplored.put(up);
					else{
						break;
					}
				}
				
				right = cur.right();
				if(this.maze[right.row][right.column] != '#' && this.maze[right.row][right.column] != '.'){
					if(this.maze[right.row][right.column] != 'T')
						unexplored.put(right);
					else
						break;
				} 
				
				down = cur.down();
				if(this.maze[down.row][down.column] != '#' && this.maze[down.row][down.column] != '.'){
					if(this.maze[down.row][down.column] != 'T')
						unexplored.put(down);
					else
						break;
				}
				
				left = cur.left();
				if(this.maze[left.row][left.column] != '#' && this.maze[left.row][left.column] != '.'){
					if(this.maze[left.row][left.column] != 'T')
						unexplored.put(left);
					else
						break;
				}
				
				//end all ifs
			} //end while
		} catch (StackQueueException e) {
			e.printStackTrace();
		}
		r = "With " + stackOrQueue + ": Treasure found!  " + explored.size() + " explored positions. The unexplored list contains " + unexplored.size() + " positions.";
		return r; //Replace later with a string
	}
}