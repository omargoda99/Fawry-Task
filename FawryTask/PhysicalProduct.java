/**
 *
 * @author Omar Goda
 */

public class PhysicalProduct  extends Product implements Shippable {
    private final double weight;
    public PhysicalProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public boolean needsShipping() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f kg)", getName(), weight);
    }
}
