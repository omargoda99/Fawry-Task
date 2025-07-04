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
        // output :
        /*
        ** Shipment notice **
2x Cheese       400g
1x Biscuits     700g
1x TV           180g

Total package weight  1.3kg

** Checkout receipt **
2x Cheese       200
1x Biscuits     150
1x Scratch Card 50
1x TV           300
----------------------
Subtotal         700
Shipping         30
Amount           730
        */
    }
}

 /*
        output of :
        public static void main(String[] args) {
        Product cheese = new FreshProduct("Cheese", 100, 5, LocalDate.now().plusDays(3), 200);
        Product biscuits = new FreshProduct("Biscuits", 150, 3, LocalDate.now().plusDays(5), 700);
        Customer customer = new Customer(1000);
        Cart cart = new Cart();
        cart.addItem(cheese, 2);
        cart.addItem(biscuits, 1);
        CheckOut.checkout(customer, cart);
    }
    ** Shipment notice **
2x Cheese       400g
1x Biscuits     700g

Total package weight  1.1kg

** Checkout receipt **
2x Cheese       200
1x Biscuits     150
----------------------
Subtotal         350
Shipping         30
Amount           380

        */
