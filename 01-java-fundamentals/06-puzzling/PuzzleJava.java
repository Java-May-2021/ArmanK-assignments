import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Random;
public class PuzzleJava{
    
    public ArrayList<Integer> GreaterThanBound(int[] numbers, int bound){
        ArrayList<Integer> newNum = new ArrayList<Integer>();
        int sum = 0;
        for(Integer number : numbers){
            sum = sum+number;
            if(number>bound){
                newNum.add(number);
            }
        }
        System.out.println("Sum: "+sum);
        System.out.println("New Array "+newNum);
        return newNum;
    }

    public ArrayList<String> ShuffleName(ArrayList<String> names){
        ArrayList<String> newNames = new ArrayList<String>();
        
        Collections.shuffle(names);
        System.out.println("Shuffled Names"+ names);
        for(String name: names){
            if(name.length() <=5){
                newNames.add(name);
            }
        }
        System.out.println("Names less then or equal 5 characters are:");
        System.out.println(newNames);
        return newNames;
    }

    public void Alphabet(){
        ArrayList<Character> letters = new ArrayList<Character>();
       
        for(char ch='a';ch<='z';ch++){
            letters.add(ch);
        }
        Collections.shuffle(letters);
        System.out.println(letters.get(0));
        System.out.println(letters.get(25));
        if(letters.get(0) == 'a') {
                System.out.println("You got vowel!");
        }
        if(letters.get(0) == 'e') {
                System.out.println("You got vowel!");
        }
        if(letters.get(0) == 'i') {
                System.out.println("You got vowel!");
        }
        if(letters.get(0) == 'o') {
                System.out.println("You got vowel!");
        }
        if(letters.get(0) == 'u') {
                System.out.println("You got vowel!");
        }

        
    }
    public int[]  RandomNumbers(){
        Random rand = new Random();
        int[] numbers = new int[10];
        for(int i=0;i<numbers.length;i++){
            numbers[i] = rand.nextInt(45)+55;
            System.out.println(numbers[i]);
        }
        Arrays.sort(numbers);

         
        System.out.println("Min: "+numbers[0]);
        System.out.println("Max: "+ numbers[9]);
      
        return numbers;
    }

    public String randString(){
       String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
   
}