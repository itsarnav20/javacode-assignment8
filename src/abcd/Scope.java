package abcd;
public class Scope {

	int x, y;

	public Scope(int r, int c) {
		this.x = r;
		this.y = c;
	}

	public boolean isScopeValid(int board_size) {
		return (x >= 0) && (x < board_size) && (y >= 0) && (y <= x);
	}

	public String toString() {
		return "[" + x + "," + y + "]";
	}

}
