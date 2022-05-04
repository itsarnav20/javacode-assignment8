package abcd;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) 
	{
        
        Puzzle b = new Puzzle();

        ArrayList<Scope> initial = new ArrayList<Scope>();

        initial.add(new Scope(0,0));
        initial.add(new Scope(1,0));
        initial.add(new Scope(1,1));
        initial.add(new Scope(2,0));
        initial.add(new Scope(2,1));

        initial.forEach(begin -> {
            System.out.println("\n--- " + begin + " ---");
            Bootstrap.initialize(5, begin, b);
            ArrayList<Move> bs = b.solutionPath();
            System.out.println();
            Utilities.printLocation(b);
            bs.forEach(move -> {
                System.out.println("\n" + move + "\n");
                b.move(move);
                Utilities.printLocation(b);
            });
        });
    }
}