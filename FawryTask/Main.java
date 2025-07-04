import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new FreshProduct("Cheese", 100, 5, LocalDate.now().plusDays(3), 400);
        Product biscuits = new FreshProduct("Biscuits", 150, 3, LocalDate.now().plusDays(5), 700);
        Product tv = new PhysicalProduct("TV", 300, 5, 180);
        Product scratchCard = new DigitalProduct("Scratch Card", 50, 20);
        Customer customer = new Customer(1000);
        Cart cart = new Cart();
        cart.addItem(cheese, 2);
        cart.addItem(biscuits, 1);
        cart.addItem(scratchCard, 1);
        cart.addItem(tv, 1);
        CheckOut.checkout(customer, cart);
    }
}
