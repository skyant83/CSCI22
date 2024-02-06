public class Acct {
    private double balance;

    public Acct(){
        balance = 0.0;
    }

    public double getBal(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount){
        balance -= amount;
    }

}
