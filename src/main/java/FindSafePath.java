import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Use backtracking to find a safe path
 * @author kchung
 */
public class FindSafePath {

	static boolean[][] USED; //keeps track of the cells that we have been in
	static List<Index> PATH; //keeps track of the path
	static int pathCount = 0;

	public static void main(String[] args) {
		int N = 4;
		int[][] board = {
			{0, 0, 1, 0},
			{0, 1, 1, 0},
			{0, 0, 0, 1},
			{1, 1, 0, 0}
		};

		USED = new boolean[N][N];
		PATH = new ArrayList<Index>();

		findSafePath(board, 4);
	}

	public static void findSafePath(int[][] board, int N) {
		findPath(board, N, 0, 0);
		if(pathCount == 0){
			System.out.println("No Safe Path!");
		}
	}

	public static void findPath(int[][] board, int N, int currRow, int currCol) {
		//makes the move
		PATH.add(new Index(currRow, currCol));
		USED[currRow][currCol] = true;

		//solution found! process it
		if (currRow == N - 1 && currCol == N - 1){
			pathCount++;
			printPath();
			return;
		}

		//for each possible candidate move, recurse.
		for (Index ind : getMoves(board, N, currRow, currCol)){
			findPath(board, N, ind.i, ind.j);
		}

		//unmakes the move
		PATH.remove(PATH.size() - 1);
		USED[currRow][currCol] = false;
	}

	public static void printPath() {
		System.out.println("Path #" + pathCount);
		for (Index ind : PATH){
			System.out.println(ind);
		}
	}

	/**
	 * Returns the allowed moves
	 */
	public static Collection<Index> getMoves(int[][] board, int N, int i, int j) {
		//possible moves:
		// left (i, j-1)
		// right (i, j+1)
		// up (i-1, j)
		// down (i+1, j)
		Collection<Index> moves = new ArrayList<Index>(4);

		if ((j - 1) >= 0 && !USED[i][j - 1] && isSafe(board, i, j - 1)){
			moves.add(new Index(i, j - 1));
		}

		if ((j + 1) < N && !USED[i][j + 1] && isSafe(board, i, j + 1)) {
			moves.add(new Index(i, j + 1));
		}

		if ((i - 1) >= 0 && !USED[i - 1][j] && isSafe(board, i - 1, j)){
			moves.add(new Index(i - 1, j));
		}

		if ((i + 1) < N && !USED[i + 1][j] && isSafe(board, i + 1, j)){
			moves.add(new Index(i + 1, j));
		}

		return moves;
	}

	/**
	 * Determines whether going to the position (i,j) is safe
	 */
	public static boolean isSafe(int[][] board, int i, int j) {
		return board[i][j] == 0;
	}

	/**
	 * Holds index
	 */
	public static class Index {
		int i; //row
		int j; //column

		Index(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "(" + i + ", " + j + ")";
		}
	}
}
