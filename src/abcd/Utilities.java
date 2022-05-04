
package abcd;
public class Utilities {
	
	public static void printLocation(Puzzle puzzle) {
		for (int i = 0; i < puzzle.anInt; i++) {
			System.out.print("  ");
			for (int k = 0; k < (puzzle.anInt - i - 1); k++)
				System.out.print(" ");
			for (int j = 0; j <= i; j++)
				System.out.print((puzzle.board[i][j] ? 'x' : '.') + " ");

			System.out.println();
		}
	}

}
