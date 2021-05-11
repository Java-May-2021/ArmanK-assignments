public class FizzBuzz{

    public static void main(String[] args){
        System.out.println(fizzBuzz(3));
        System.out.println(fizzBuzz(5));
        System.out.println(fizzBuzz(15));
        System.out.println(fizzBuzz(2));
    }

    public static String fizzBuzz(int number){
        
        if(number %3 == 0 && number % 5 == 0){
            return "FizzBuzz";
        }
        if(number % 3 ==0 ){
           return "Fizz";
        }
        if(number % 5 == 0){
            return "Buzz";
        }
        String s = String.valueOf(number);
        return s;
    }
}