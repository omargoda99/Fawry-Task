/**
 *
 * @author Omar Goda
 */

import java.util.ArrayList;
import java.util.List;

public class CheckOut {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }

        double subtotal = 0;
        List<Shippable> toShip = new ArrayList<>();

        for (CartItem i : cart.getItems()) {
            Product product = i.product;

            if (!product.isAvailable(i.quantity)) {
                throw new IllegalStateException("The Product is out of stock");
            }

            if (product instanceof Expirable && ((Expirable) product).isExpired()) {
                throw new IllegalStateException("The Product is expired");
            }

            subtotal += i.getTotal();

            if (product.needsShipping() && product instanceof Shippable) {
                for (int j = 0; j < i.quantity; j++) {
                    toShip.add((Shippable) product);
                }
            }
        }

        double shipping = toShip.isEmpty() ? 0 : 30;
        double total = subtotal + shipping;

        if (!customer.canPay(total)) {
            throw new IllegalStateException("Insufficient balance.");
        }

        for (CartItem item : cart.getItems()) {
            item.product.reduceQuantity(item.quantity);
        }

        customer.pay(total);

        if (!toShip.isEmpty()) {
            System.out.println("** Shipment notice **");

            double totalWeightGrams = 0;

            for (CartItem item : cart.getItems()) {
                Product product = item.product;

                if (product.needsShipping() && product instanceof Shippable) {
                    double weightPerUnit = ((Shippable) product).getWeight();
                    double totalWeight = weightPerUnit * item.quantity;
                    totalWeightGrams += totalWeight;

                    System.out.printf("%dx %-12s %.0fg%n", item.quantity, product.getName(), totalWeight);
                }
            }

            System.out.printf("%nTotal package weight  %.1fkg%n", totalWeightGrams / 1000.0);
        }

        System.out.println("\n** Checkout receipt **");

        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %-12s %.0f%n", item.quantity, item.product.getName(), item.getTotal());
        }

        System.out.println("----------------------");
        System.out.printf("Subtotal         %.0f%n", subtotal);
        System.out.printf("Shipping         %.0f%n", shipping);
        System.out.printf("Amount           %.0f%n", total);
        //System.out.printf("Remaining Balance: %.1f%n", customer.getAmount());
    }
}
