/**
 * @author Dario Melconian 
 * @author 251044493
 * Snake class represents information about the snake as its moving through the board.
 * It deals with movements of the snake as well as growth and shrinking depending on the
 * object it hits on the gameBoard.
 */


public class Snake {

	private int snakeLength;  // this is the snakes length as an integer
	private Position[] snakeBody; // represents where the snake is as an array	
	
	// constructor intakes coordinates for snakes head
	public Snake(int row, int col) {

		snakeLength = 1;
		// create an object of position type called snakeBody using snakeLength as the size of array
		//snakeBody[] = new Position[snakeLength];
		snakeBody = new Position[5];
		// create object 'pos' represents the snakes head, of type Position
		Position pos = new Position(row,col);
		
		// the snakes head is by default, the array of snakeBody at index 0
		snakeBody[0] = pos;
	
		
	}
	
	// @return length of the snake (integer value)
	public int getLength() {
		
		return this.snakeLength;
	}
	
	
	public Position getPosition(int index) {
		
		// @return has to return position of the array snakeBody at the index parameter 
		if (index < 0 || index >= snakeLength) {
			return null;
		} else {
			// @return the snakeBody at that given index input parameter
			return snakeBody[index];
		}
	}
	
	
	public void shrink() {
		
		// decreases snakeLength by one
		snakeLength = snakeLength - 1;
		
	}
	
	
	// @return this returns a boolean depending on if the position parameter is in the array length of 
	// the snakeBody array, and returns false otherwise
	public boolean snakePosition(Position pos) {
		
		// @return as it goes through each snakePart, as long as its less than the length of the snake,
		// if the snakeBody arrays position at that snakePart isn't null AND equals the position 
		// of the head, return true
		for (int snakePart = 0; snakePart < snakeBody.length; snakePart++) {
			if (snakeBody[snakePart] != null && snakeBody[snakePart].equals(pos)) {
				return true;
			}	
		}
		// @return false otherwise
		return false;
		
		
	}
	
	// returns position of head when snake moves in given direction
	public Position newHeadPosition(String direction) {
		
		// row or column change at the snakeBody[0] which is the head, and get the row or column
		// values of this change
		int row = this.snakeBody[0].getRow();
		int col = this.snakeBody[0].getCol();
		// create a new 'pos' of the snakeHead location with new row and column coordinates
		Position pos = new Position(row,col);
		
		// interpret the given string and change the new 'pos' snake head position accordingly
		
		if (direction == "right") {
			// increase the column by 1
			col = col + 1;
			// set the column to the new column using existing setCol() method
			pos.setCol(col);
			//return pos;
		}
		
		else if (direction == "left") {
			// decrease the column by 1
			col = col - 1;
			// set the column to the new column
			pos.setCol(col);
			//return pos;
		}
		
		else if (direction == "up") {
			// decrease the row by 1
			row = row - 1;
			// set the row to the new row adjusted, using the existing setRow() method
			pos.setRow(row);
			//return pos;
		}
		
		else if (direction == "down") {
			// increase row by 1
			row = row + 1;
			// set the row to the new adjusted row 
			pos.setRow(row);
			//return pos;
		}
		// @return this snake head 'pos'
		return pos;
	}

	// moves snake in specific direction parameter inputed 
	void moveSnake(String direction) {
		
		// CASE 1
		// if the snakeLength is 1, return the snake's head (snakeBody[0]) and make it the 
		// new position as nothing else moves because its length is 1 and therefore it's 
		// components are just the head. 
		if (snakeLength == 1) {
			snakeBody[0] = newHeadPosition(direction);
			return;
		}
		
		// CASE 2
		// iterates from the last position upward
		// create a counter that begins at the last element in the snakeBody (can use the 
		// integer snakeLength for this), and ascend up the snake (ctr--)
		for (int ctr = snakeLength - 1; ctr >= 1; ctr --) {
			// at each increment through the snakeBody, at that given value as you go through
			// the snake, decrease it by one (the index of Snakebody changes).
			snakeBody[ctr] = snakeBody[ctr - 1];
		}
		
		// the snake head is given a new head position using the method above with the parameter
		// direction specified.
		snakeBody[0] = newHeadPosition(direction);
	}
	

	// increases snakeLength by one and moves snake's head in direction parameter specified
	 void grow(String direction) {
		
		// if the snakeLength integer-value  = the snakeBody array's length, increase the array size
		if (snakeLength == snakeBody.length) {
			// capacity reached so double the array but keep the values of existing array 
			increaseArraySize();
			
		}

		// as it goes through each of the snakes body parts (digits), starting from the end, to
		// the front, move each by one, while increasing the snakeLength by 1 as its grown
		for (int snakeDigit = snakeBody.length -1; snakeDigit >= 1; snakeDigit --) {
			
			snakeBody[snakeDigit] = snakeBody[snakeDigit - 1];
		}
		// the snake head is given a new head position using the method created above
		// this is the same concept as in moveSnake
		snakeBody[0] = newHeadPosition(direction);
		// increase snakeLength by one 
		snakeLength = snakeLength + 1;
		
	}
	
	// increases array size by double the existing size while keeping the existing 
	// contents inside
	private void increaseArraySize() {
		
		// double array size while keeping components inside new array of same name
		// largerArr is a larger array double the size of snakeBody of type Position 
		Position[] largerArr = new Position[snakeBody.length * 2];
		// as going through the existing snakeBody array, transfer its contents into the new
		// array of double the size
		for (int i = 0; i < snakeBody.length; i++)
			// this ensures each index of snakeBody is correctly copied into largerArr
			largerArr[i] = snakeBody[i];
		// make snakeBody equal the largerArr so that snakeBody is still the array used
		snakeBody = largerArr;

	}

}
