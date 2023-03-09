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
		throw new UnsupportedOperationException("successors : not supported yet.");
	}

	@Override
	public int compareTo(Configuration g) {
		throw new UnsupportedOperationException("compareTo : not supported yet.");
	}

	@Override
	public Configuration getParent() {
		throw new UnsupportedOperationException("parent: Not supported yet.");
	}

}
