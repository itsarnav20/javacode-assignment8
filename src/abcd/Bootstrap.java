package abcd;
public class Bootstrap {
	
	public static void initialize(int n, Scope h, Puzzle puzzle) {
		puzzle.anInt = n;
		puzzle.board = new boolean[n][n];
		puzzle.pegsRemaining = -1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				puzzle.board[i][j] = true;
				puzzle.pegsRemaining++;
			}
		}

		puzzle.board[h.x][h.y] = false;
	}

}
