public class CalculatorTester{
    public static void main(String[] args){
        Calculator cal = new Calculator();
        cal.setOperandOne(40.2);
        cal.setOperandTwo(10.2);

        cal.performOperation("+");
        System.out.println("Result: "+cal.getResults());
    }
}