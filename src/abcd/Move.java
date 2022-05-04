package abcd;
import static java.lang.Math.abs;

public class Move {
	
	Scope start;
	Scope end;

	public Move(Scope start, Scope end) {
		this.start = start;
		this.end = end;
	}

	public boolean isValid(Puzzle puzzleBoard) {

		if (!start.isScopeValid(puzzleBoard.anInt) || !end.isScopeValid(puzzleBoard.anInt))
			return false;
		if (!puzzleBoard.board[start.x][start.y] || puzzleBoard.board[end.x][end.y])
			return false;

		int row = abs(start.x - end.x);
		int col = abs(start.y - end.y);

		if (row == 0) {
			if (col != 2)
				return false;
		} else if (row == 2) {
			if (col != 0 && col != 2)
				return false;
		} else {
			return false;
		}

		return puzzleBoard.board[(start.x + end.x) / 2][(start.y + end.y) / 2];
	}
	
	public String toString() {
		return "from " + start + " to " + end;
	}

}
