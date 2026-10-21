public class CartTest {
    private static void check(boolean value, String name) {
        if (!value) throw new AssertionError(name);
        System.out.println("PASS: " + name);
    }
    public static void main(String[] args) {
        Cart cart = new Cart();
        DigitalVideoDisc a = new DigitalVideoDisc("A", "Animation", "Dir", 50, 10f);
        DigitalVideoDisc b = new DigitalVideoDisc("B", "Drama", "Dir", 70, 15f);
        cart.addDigitalVideoDisc(a);
        cart.addDigitalVideoDisc(b);
        check(cart.getQtyOrdered() == 2, "add two DVDs");
        check(Math.abs(cart.totalCost() - 25f) < .001f, "totalCost");
        cart.removeDigitalVideoDisc(a);
        check(cart.getQtyOrdered() == 1 && cart.totalCost() == 15f, "remove DVD");
        cart.removeDigitalVideoDisc(a);
        check(cart.getQtyOrdered() == 1, "removing missing DVD");
        for (int i = 0; i < 19; i++) cart.addDigitalVideoDisc(new DigitalVideoDisc("Disc " + i));
        check(cart.getQtyOrdered() == 20, "cart capacity 20");
        cart.addDigitalVideoDisc(new DigitalVideoDisc("Extra"));
        check(cart.getQtyOrdered() == 20, "reject overflow");
        System.out.println("All tests passed.");
    }
}