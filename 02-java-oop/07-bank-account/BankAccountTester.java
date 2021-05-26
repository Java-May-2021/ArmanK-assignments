public class BankAccountTester{
    public static void main(String[] args){
        BankAccount b = new BankAccount();
        b.DepositMoney(1000, "checking");
        b.DepositMoney(3000,"saving");
        b.WithdrawalMoney(1000,"checking");
        b.WithdrawalMoney(1000,"saving");
        b.WithdrawalMoney(1000,"saving");
        b.DepositMoney(12000,"saving");
        b.totalBalance();
    }
}