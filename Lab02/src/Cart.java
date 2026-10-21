public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;
    public int getQtyOrdered() { return qtyOrdered; }
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (disc == null) { System.out.println("Cannot add a null disc"); return; }
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full");
            return;
        }
        itemsOrdered[qtyOrdered++] = disc;
        System.out.println("The disc has been added");
        if (qtyOrdered == MAX_NUMBERS_ORDERED - 1) System.out.println("The cart is almost full");
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) itemsOrdered[j] = itemsOrdered[j + 1];
                itemsOrdered[--qtyOrdered] = null;
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("The disc was not found in the cart");
    }
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) total += itemsOrdered[i].getCost();
        return total;
    }
    public void displayCart() {
        for (int i = 0; i < qtyOrdered; i++) System.out.println((i + 1) + ". " + itemsOrdered[i]);
        System.out.println("Total cost: " + totalCost());
    }
}