/**
 * @author Dario Melconian
 * @author 251044493
 * This class is the constructor for the file and represents where the snake moves as the game
 *  is being played, including when it receives apples.
 */

public class BoardGame {

	private int board_length;
	private int board_width;
	private Snake theSnake;
	private String[][] matrix;
	
	// constructor designed to take in a file with dimensions of the board length (which vary),
	// the snakes initial position, and the objects' positions
	public BoardGame(String boardFile) {
		
		// create object info of type MyFileReader
		MyFileReader info = new MyFileReader(boardFile);
		
		// integer array for storing the board width and length and any incoming read integer
		// as it reads through the file
		int[] numArr = new int[100];

		// loop for reading and storing the values into the numArr
		for(int j=0; j < 6; j++ ) {
		 	int k = info.readInt();
			numArr[j] = k;
			//System.out.println(numArr[j]);
			}	
		
		// create initialization for board length and width using values read put into numArr
		board_length = numArr[2];
		board_width = numArr[3]; 
		
		// create initialization for the row and col using indexes 4 and 5
		int initialRow;
		int initialColumn;
		initialRow = numArr[4];
		initialColumn = numArr[5];
		
		// create object snake using initial row and column given in file that was read
		theSnake = new Snake(initialRow, initialColumn);
		
		// string array with dimensions of the board set to "empty"
		matrix = new String[board_width][board_length];
		for (int a = 0; a < matrix.length; a++) {  // < board_width
			for (int b = 0; b < matrix[a].length; b++) {
				matrix[a][b] = "empty";
				//System.out.println(strArr[a][b]);
			}
		}
		
		// read 2 int, 1 string, repeatedly
		int counter = 0;
		int firstNum = 0;
		int secondNum = 0;
		String stringName;
		
		// while not done reading through the end of the file..
		while (info.endOfFile() != true) {
			
			if (counter == 0) {
				// first thing = integer
				firstNum = info.readInt();
				
			}
			
			if (counter == 1) {
				// second thing = intger
				secondNum = info.readInt();
			}
			
			if (counter == 2) {
				// third thing = string
				stringName = info.readString();
				matrix[firstNum][secondNum] = stringName;
				counter = -1;
			}
			// iterate 
			counter ++;	
			
		}
		
		
	}
	// @return the string stored in the matrix[row][col]
	public String getObject(int row, int col) {
		
		return matrix[row][col];
	}
	 
	// stores new object with coordinates and an object name 
	public void setObject(int row, int col, String newObject) {
		
		matrix[row][col] = newObject;
	}

	// @return the snake
	public Snake getSnake() {
		
		return theSnake;
	}
	
	// stores the new snake value in theSnake instance variable 
	public void setSnake(Snake newSnake) {
		
		newSnake = theSnake;
	}
	
	// @return the length of the board
	public int getLength() {
		
		return board_length;
	}
	
	// @return the width of the board
	public int getWidth() {
		
		return board_width;
	}
	
	// @return the string with coordinates of its location
	public String getType(int row, int col) {
		
		return matrix[row][col];
	}
	
}


