package abcd;
import java.util.ArrayList;

public class Puzzle {
	boolean[][] board;
	int pegsRemaining;
	int anInt;

	public boolean move(Move m) {
		if (!m.isValid(this)) {
			System.out.println("Invalid move.");
			return false;
		}

		board[m.start.x][m.start.y] = false;

		board[m.end.x][m.end.y] = true;

		board[(m.start.x + m.end.x) / 2][(m.start.y + m.end.y) / 2] = false;

		pegsRemaining--;

		return true;
	}

	private void undoMove(Move m) {

		board[m.start.x][m.start.y] = true;

		board[m.end.x][m.end.y] = false;

		board[(m.start.x + m.end.x) / 2][(m.start.y + m.end.y) / 2] = true;

		pegsRemaining++;
	}

	private ArrayList<Move> movesFromLoc(Scope start) {
		ArrayList<Move> temp = new ArrayList<Move>();

		if (!start.isScopeValid(anInt) || !board[start.x][start.y])
			return temp;

		Move possibility = new Move(start, new Scope(start.x - 2, start.y));

		if (possibility.isValid(this))
			temp.add(possibility);

		possibility = new Move(start, new Scope(start.x - 2, start.y - 2));

		if (possibility.isValid(this))
			temp.add(possibility);

		possibility = new Move(start, new Scope(start.x, start.y - 2));

		if (possibility.isValid(this))
			temp.add(possibility);

		possibility = new Move(start, new Scope(start.x, start.y + 2));

		if (possibility.isValid(this))
			temp.add(possibility);

		possibility = new Move(start, new Scope(start.x + 2, start.y));

		if (possibility.isValid(this))
			temp.add(possibility);

		possibility = new Move(start, new Scope(start.x + 2, start.y + 2));

		if (possibility.isValid(this))
			temp.add(possibility);

		return temp;
	}

	public ArrayList<Move> validMoves() {
		Scope tmpScope;
		ArrayList<Move> scopeMoves;
		ArrayList<Move> tmpMoves = new ArrayList<Move>();

		for (int i = 0; i < anInt; i++) {
			for (int j = 0; j <= i; j++) {
				tmpScope = new Scope(i, j);
				scopeMoves = movesFromLoc(tmpScope);
				tmpMoves.addAll(scopeMoves);
			}
		}

		return tmpMoves;
	}

	public ArrayList<Move> solutionPath() {
		ArrayList<Move> p = new ArrayList<Move>();
		ArrayList<Move> manoeuvres = this.validMoves();

		if (manoeuvres.isEmpty())
			return p;

		for (int i = 0; i < manoeuvres.size(); i++) {
			this.move(manoeuvres.get(i));

			// Win condition
			if (pegsRemaining == 1) {
				p.add(manoeuvres.get(i));
				undoMove(manoeuvres.get(i));

				return p;
			}

			// Recurse
			ArrayList<Move> movePath = this.solutionPath();

			if (movePath.size() + 1 > p.size()) {
				p.clear();
				p.add(manoeuvres.get(i));
				p.addAll(movePath);
			}

			undoMove(manoeuvres.get(i));
		}

		return p;
	}

}