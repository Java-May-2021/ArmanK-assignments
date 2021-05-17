import java.util.ArrayList;
import java.util.Arrays;
public class BasicJava{
    public void printNumbers(){
        for(int i=1;i<=255;i++){
            System.out.println(i);
        }
    }
    public void printOdd(){
        for(int i=1;i<=255;i++){
            if(i%2!=0){
                 System.out.println(i);
            }
        }
    }
    public void printSum(){
        int sum = 0;
        for(int i=0;i<=255;i++){
           sum = sum+i;
           System.out.println("New number: "+i+" Sum: "+sum);
        }
    }

    public void printArray(String[] name){
        for(int i=0;i<name.length;i++){
            System.out.println(name[i]);
        }
    }

    public void maxNum(int[] numbers){
        int maxNum = numbers[0];
        for(int i=0;i<numbers.length;i++){
            if(maxNum<numbers[i]){
                maxNum = numbers[i];
            }
        }
        System.out.println(maxNum);
    }

    public void getAverage(int[] numbers){
        int sum = 0;
            for(int i=0;i<numbers.length;i++){
            sum = sum+numbers[i];
        }
        int avg = sum/numbers.length;
        System.out.println(avg);
    }

    
    public void arrayWithOdd(){
        ArrayList<Integer> oddnumbers = new ArrayList<>();
         for(int i=1;i<=255;i++){
            if(i%2!=0){
                oddnumbers.add(i);
            }
        }
        System.out.println(oddnumbers);
    }
    public void greaterThanY(int[] numbers, int y){
        int counter = 0;
        for(int i=0;i<numbers.length;i++){
            if(y<numbers[i]){
               counter++;
            }
        }
        System.out.println(counter);
    }
     public void squareValues(int[] numbers){
        
        for(int i=0;i<numbers.length;i++){
           numbers[i] = numbers[i]*numbers[i];
        }
        System.out.println(Arrays.toString(numbers));
    }
    public  void noNegative(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public int[] maxMinAvg(int[] numbers){
        int maxNum = numbers[0];
        int minNum = numbers[0];
        int sum = 0;
        for(int i=0;i<numbers.length;i++){
            if(maxNum<numbers[i]){
                maxNum = numbers[i];
            }
            if(minNum>numbers[i]){
                minNum = numbers[i];
            }
            sum = sum+numbers[i];
        }
        int avg = sum/numbers.length;
        int[] maxMinAvg = {maxNum,minNum,avg};
        return maxMinAvg;
    
    }

    public  void shiftArraysValue(int[] arr){
        for(int i = 1; i < arr.length; i++){
                arr[i-1] = arr[i];
            }
        arr[arr.length-1] = 0;
        System.out.println(Arrays.toString(arr));
    }

}