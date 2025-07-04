
/**
 *
 * @author Omar Goda
 */
public class Customer {
    private double balance;
    
    public Customer(double balance){
        this.balance=balance;
    }
    public boolean canPay(double moneyAmount){
        return balance >= moneyAmount;
    }
    public void pay(double moneyAmount){
        balance -= moneyAmount;
    }
    public double getAmount(){
        return balance;
    }
}
