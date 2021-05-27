public class Calculator{
    
        private double num1;
        private double num2;
        private double result;
        public void setOperandOne(double number1){
            this.num1 = number1;
        }
        public void setOperandTwo(double number2){
            this.num2 = number2;
        }

        public void performOperation(String operation){
            if(operation == "+"){
                    this.result = this.num1+this.num2;
            }
            else if(operation == "-"){
                this.result = this.num1-this.num2;
            }
        }
        public double getResults(){
            return this.result;
        }

}