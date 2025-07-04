/**
 *
 * @author Omar Goda
 */
public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;
    public abstract boolean isExpired();
    public abstract boolean needsShipping();
    
    public Product(String name, double price, int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
   
    public String getName(){return name;}
    public double getPrice(){return price;}
    public int getQuantity(){return quantity;}
    public boolean isAvailable(int requested){
        return requested <= quantity;
    }
    public void reduceQuantity(int amount){
        quantity -= amount;
    }
}
