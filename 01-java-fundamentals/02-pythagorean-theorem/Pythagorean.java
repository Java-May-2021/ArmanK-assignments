import java.lang.Math;


public class Pythagorean{
    public static void main(String[] args){
        System.out.println(calculateHypotenuse(9,3));
    }

    public static double calculateHypotenuse(int lenA, int lenB)
    {
        double result = Math.sqrt(lenA*lenA+lenB*lenB);
        return result;
    }
}