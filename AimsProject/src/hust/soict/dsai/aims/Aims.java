package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Store store = new Store();
        DigitalVideoDisc lion = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc star = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc aladdin = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);
        store.addDVD(lion); store.addDVD(star); store.addDVD(aladdin);
        cart.addDigitalVideoDisc(lion, star, aladdin);
        cart.print();
        cart.searchById(star.getId());
        cart.searchByTitle("KING missing");
        cart.removeDigitalVideoDisc(star);
        cart.print();
    }
}
