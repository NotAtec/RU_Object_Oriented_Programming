package slidingGame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * A template of a sliding game
 */
public class SlidingGame implements Configuration {

	public static final int N = 3, SIZE = N * N, HOLE = SIZE;
	/**
	 * The board is represented by a 2-dimensional array; the position of the hole
	 * is kept in 2 variables holeX and holeY
	 */
	private int[][] board;
	private int holeX, holeY;
	private int manhattanDist = 1337;
	private SlidingGame parent = null;

	/**
	 * A constructor that initializes the board with the specified array
	 *
	 * @param start: a one dimensional array containing the initial board. The
	 *               elements of start are stored row-wise.
	 */
	public SlidingGame(int[] start) {
		board = new int[N][N];

		assert start.length == N * N : "Length of specified board incorrect";

		for (int p = 0; p < start.length; p++) {
			board[p % N][p / N] = start[p];
			if (start[p] == HOLE) {
				holeX = p % N;
				holeY = p / N;
			}
		}
		manhattanDist = calculateManhattanDistance();
	}

	public SlidingGame(int[][] board, int manhattenDist) {
		
		assert board.length == N : "Length of specified board incorrect";
		
		this.board = board;
		this.manhattanDist = manhattenDist;
	}

	public int getManhattanDistance() {
		return manhattanDist;
	}

	/**
	 * Converts a board into a printable representation. The hole is displayed as a
	 * space
	 *
	 * @return the string representation
	 */
	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				int puzzel = board[col][row];
				buf.append(puzzel == HOLE ? "  " : puzzel + " ");
			}
			buf.append("\n");
		}
		return buf.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) {
			return false;
		} else {
			return toString() == o.toString();
		}
	}

	@Override
	public boolean isSolution() {
		int count = 0;
		//if the hole is not on the right botttom corner, the puzzle is not solved
		if (board[N-1][N-1] != SIZE) {
			return false;
		}
		for(int i = 0; i < (N - 1); i++) {
			for(int j = 0; j < (N-1); j++) {
				//board is solved iff the current value is 1 higher than the previous one
				if (board[i][j] != (count + 1)) {
					return false;
				}
				count ++;
			}
		}
		return true;
	}

	@Override
	public Collection<Configuration> successors() {
		ArrayList<Configuration> configurations = new ArrayList<Configuration>();	//Creating arraylist  

		for (Direction dir : Direction.values()) {
			if (validRowCol(holeX + dir.getDX(), holeY + dir.getDY())) {
				int holex = holeX;
				int holey = holeY;

				//swap the cells and add to the collection
				swapHole(holeX + dir.getDX(), holeY + dir.getDY());
				SlidingGame successor = new SlidingGame(board, manhattanDist);
				configurations.add(successor);
				
				//swap back
				swapHole(holex, holey);
			}	
		}
		return configurations;
	}

	@Override
	public int compareTo(Configuration g) {
		return manhattanDist - ((SlidingGame) g).manhattanDist;
	}

	@Override
	public Configuration getParent() {
		return parent;
	}


	/*
	 * PRIVATE HELPER FUNCTIONS
	 */


	/*
	 * Calculates the manhattendistance of one piece on the board. 
	 * That is, calculate the distance between the currenct place of the piece and the correct place of the piece in manhatten style
	 * 
	 * 
	 * @param row: the row of the pice on the board
	 * 		  col: the column of the piece on the board
	 * 
	 * @return the manhattendistance of this piece on the board
	 */
	private int manhattenDistance(int x, int y) {

		assert x >=0 && x < N && y >=0 && y < N : "Length of specified board incorrect";

		int val = board[x][y];

		//correct place
		int toX = val % N;
		int toY = val / N;

		//distance between correct place and the current place in manhatten style
		int manhattenDistance = Math.abs((toX - x) + (toY - y));
		return manhattenDistance;
	}

	/*
	 * Calculates the total manhattendistance of the board. That is, the manhattendistance of every piece on the board
	 * 
	 */
	private int calculateManhattanDistance() {

		int totalManhattanDistence = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				totalManhattanDistence += manhattenDistance(i, j);
			}
		}

		return totalManhattanDistence;
	}

	
	/*
	 * Checks if the row and column are in the array bounds
	 * @param row: row
	 * @param col: column
	 * 
	 * @return: the boolean associated with this
	 */
	private boolean validRowCol (int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N);
	}

	/*
	 * Swaps the number on the board at the given row and col with the hole
	 * The manhattendistance is updated accordingly
	 * 
	 * @param row: the row of number that needs to be swapped
	 * 		  col: the column of the number that needs to be swapped
	 * 
	 */
	private void swapHole(int x, int y) {

		parent = new SlidingGame(board, manhattanDist);

		//calculate manhattendistance without the two pieces to be swapped.
		//this is needed for updating the manhattendistance after swapping
		manhattanDist -= manhattenDistance(x, y) - manhattenDistance(holeX, holeY);

		board[holeX][holeY] = board[x][y];
		board[x][y] = HOLE;
		
		//update manhattendistance
		manhattanDist += manhattenDistance(x, y) + manhattenDistance(holeY, holeX);
		
		holeX = x;
		holeY = y;
	}

}
