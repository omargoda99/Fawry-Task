
/**
 *
 * @author Omar Goda
 */
public class Customer {
    private final String name;
    private double balance;
    
    public Customer(String name, double balance){
        this.balance=balance;
        this.name=name;
    }
    public boolean canPay(double moneyAmount){
        return balance >= moneyAmount;
    }
    public void pay(double moneyAmount){
        balance -= moneyAmount;
    }
    public String getName(){
        return name;
    }
    public double getAmount(){
        return balance;
    }
}
