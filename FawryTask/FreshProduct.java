/**
 *
 * @author Omar Goda
 */

import java.time.LocalDate;

public class FreshProduct extends Product implements Expirable, Shippable{
    private final LocalDate expireDate;
    private final double weight;

    public FreshProduct(String name, double price, int quantity, LocalDate expireDate, double weight) {
        super(name, price, quantity);
        this.weight=weight;
        this.expireDate=expireDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expireDate);
    }

    @Override
    public boolean needsShipping() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
