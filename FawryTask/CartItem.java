/**
 *
 * @author Omar Goda
 */
public class CartItem {

    public Product product;
    public int quantity;

    public CartItem(Product product, int quantity){
        this.product=product;
        this.quantity=quantity;
    }

    public double getTotal(){
        return product.getPrice() * quantity;
    }
    
}

