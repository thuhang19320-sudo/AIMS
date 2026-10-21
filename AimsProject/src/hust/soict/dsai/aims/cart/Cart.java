package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.util.Locale;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;

    public int getQtyOrdered() { return qtyOrdered; }
    public DigitalVideoDisc[] getItemsOrdered() {
        return java.util.Arrays.copyOf(itemsOrdered, qtyOrdered);
    }
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (disc == null) { System.out.println("Cannot add a null disc"); return; }
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full"); return;
        }
        itemsOrdered[qtyOrdered++] = disc;
        System.out.println("The disc has been added");
        if (qtyOrdered == MAX_NUMBERS_ORDERED - 1)
            System.out.println("The cart is almost full");
    }
    // Varargs also accepts DigitalVideoDisc[]; declaring both would duplicate a signature.
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        if (dvdList == null) { System.out.println("Cannot add a null DVD list"); return; }
        for (DigitalVideoDisc disc : dvdList) addDigitalVideoDisc(disc);
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                System.arraycopy(itemsOrdered, i + 1, itemsOrdered, i, qtyOrdered - i - 1);
                itemsOrdered[--qtyOrdered] = null;
                System.out.println("The disc has been removed"); return;
            }
        }
        System.out.println("The disc was not found in the cart");
    }
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) total += itemsOrdered[i].getCost();
        return total;
    }
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++)
            System.out.println((i + 1) + ". " + itemsOrdered[i]);
        System.out.printf(Locale.ROOT, "Total cost: %.2f $%n", totalCost());
        System.out.println("***************************************************");
    }
    public void displayCart() { print(); }
    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++)
            if (itemsOrdered[i].getId() == id) {
                System.out.println(itemsOrdered[i]); found = true;
            }
        if (!found) System.out.println("No matching DVD found in the cart.");
    }
    public void searchByTitle(String keywords) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++)
            if (itemsOrdered[i].isMatch(keywords)) {
                System.out.println(itemsOrdered[i]); found = true;
            }
        if (!found) System.out.println("No matching DVD found in the cart.");
    }
}
