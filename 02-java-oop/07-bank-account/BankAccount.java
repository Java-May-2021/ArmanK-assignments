import java.util.Random;

public class BankAccount{
    private String account_number;
    private double checking_balance;
    private double saving_balance;
    private static double number_of_accounts;
    private static double total_amount_money;

    public BankAccount(){
        account_number = String.valueOf(rand_number());
        number_of_accounts++;
        total_amount_money++;

    }

    private double rand_number(){
      return (double)Math.random()*10+1;
    }

    public double getCheckingBalance(){
        return this.checking_balance; 
    }

    public double getSavingBalance(){
        return this.saving_balance; 
    }

    public void DepositMoney(int amount,String account_type){
        if(account_type == "checking"){
            this.checking_balance += amount;
        }
        else{
            this.saving_balance += amount;
        }
        total_amount_money+= amount;
    }

    public void WithdrawalMoney(int amount, String account_type){
        if(account_type == "checking"){
                if(checking_balance <=0 || amount>checking_balance){
                    System.out.println("No Funds or you are asking more than you have");
                }
                else{
                    this.checking_balance -= amount;
                    total_amount_money -= amount;
                }
            
            }
            else if(account_type == "saving"){
                if(saving_balance <=0 || amount>saving_balance){
                    System.out.println("No Funds or you are asking more than you have");
                }
                else{
                    this.saving_balance -= amount;
                     total_amount_money -= amount;
                }
            }
        }
    


    public void totalBalance(){
        System.out.println("Checking Balance: "+this.checking_balance+ "Saving Balance: "+ this.saving_balance);
    }
}