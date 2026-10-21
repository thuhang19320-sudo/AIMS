package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.util.Arrays;

/** Inventory uses an array that grows as needed; store capacity is not the cart limit. */
public class Store {
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[10];
    private int qtyInStore;
    public int getQtyInStore() { return qtyInStore; }
    public DigitalVideoDisc[] getItemsInStore() {
        return Arrays.copyOf(itemsInStore, qtyInStore);
    }
    public void addDVD(DigitalVideoDisc dvd) {
        if (dvd == null) { System.out.println("Cannot add a null DVD"); return; }
        for (int i = 0; i < qtyInStore; i++)
            if (itemsInStore[i] == dvd) {
                System.out.println("The DVD is already in the store"); return;
            }
        if (qtyInStore == itemsInStore.length)
            itemsInStore = Arrays.copyOf(itemsInStore, itemsInStore.length * 2);
        itemsInStore[qtyInStore++] = dvd;
        System.out.println("The DVD has been added to the store");
    }
    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyInStore; i++)
            if (itemsInStore[i] == dvd) {
                System.arraycopy(itemsInStore, i + 1, itemsInStore, i, qtyInStore - i - 1);
                itemsInStore[--qtyInStore] = null;
                System.out.println("The DVD has been removed from the store"); return;
            }
        System.out.println("The DVD was not found in the store");
    }
}
