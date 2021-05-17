import java.util.Arrays;
public class BasicJavaTester{
    public static void main(String[] args){
                BasicJava b1 = new BasicJava();
                // b1.printNumbers();
                // b1.printOdd();
                // b1.printSum();
                // String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
                // b1.printArray(cars);
                //  int[] numbers = {10,20,-3,-5,5,0};
                //  b1.maxNum(numbers);
                //  b1.getAverage(numbers);
                //  b1.arrayWithOdd();
                // b1.greaterThanY(numbers, 11);
                // b1.squareValues(numbers);
                // b1.noNegative(numbers);
                int[] newNumbers = {10,20,30,40,50,-2};
                System.out.println(Arrays.toString(b1.maxMinAvg(newNumbers)));
                b1.shiftArraysValue(newNumbers);
    }          
}