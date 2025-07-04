/**
 *
 * @author Omar Goda
 */
import java.util.ArrayList;

public class Cart {
    private final ArrayList<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity){
        if(!product.isAvailable(quantity)){
            throw new IllegalArgumentException("No enough stock for "+product.getName());
        }
        else{
            items.add(new CartItem(product, quantity));
        }
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }
}
