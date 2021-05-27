import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
public class PuzzleJavaTester{
    public static void main(String[] args){
        PuzzleJava puzzle = new PuzzleJava();
        int[] numbers = {3,5,1,2,7,9,8,13,25,32};
        puzzle.GreaterThanBound(numbers,10);

        ArrayList<String> names = new ArrayList<>(Arrays.asList("Nancy","Jinichi","Fujibayashi","Momochi","Ishikawa"));
        puzzle.ShuffleName(names);
        puzzle.Alphabet();
        
        puzzle.RandomNumbers();

        System.out.println(puzzle.randString());
    }
}