package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import static hust.soict.dsai.test.TestSupport.*;
public class CartTest {
    public static void main(String[] args) {
        Cart cart=new Cart();
        DigitalVideoDisc lion=new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
        DigitalVideoDisc star=new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
        DigitalVideoDisc aladdin=new DigitalVideoDisc("Aladdin","Animation","John Musker",90,18.99f);
        check(cart.getQtyOrdered()==0 && cart.totalCost()==0,"Empty cart");
        cart.addDigitalVideoDisc(lion); cart.addDigitalVideoDisc(star,aladdin);
        check(cart.getQtyOrdered()==3 && Math.abs(cart.totalCost()-63.89f)<.001f,"Single/pair and total");
        String printed=capture(cart::print);
        check(printed.contains("Ordered Items:") && printed.contains("1. DVD - The Lion King")
            && printed.contains("19.95 $") && printed.contains("Total cost: 63.89 $"),"Print format");
        check(capture(()->cart.searchById(star.getId())).contains("Star Wars"),"ID hit");
        check(capture(()->cart.searchById(-1)).contains("No matching DVD"),"ID miss");
        String matches=capture(()->cart.searchByTitle("KING AlAdDiN absent"));
        check(matches.contains("The Lion King") && matches.contains("Aladdin") && !matches.contains("Star Wars"),"Any-word search");
        for(String q:new String[]{"missing","   ",null})
            check(capture(()->cart.searchByTitle(q)).contains("No matching DVD"),"Title miss/blank/null");
        check(lion.isMatch("lion") && lion.isMatch("missing KING") && !lion.isMatch("missing"),"isMatch");
        DigitalVideoDisc[] snapshot=cart.getItemsOrdered(); snapshot[0]=null;
        check(cart.getItemsOrdered()[0]==lion,"Defensive copy");
        cart.removeDigitalVideoDisc(star);
        check(cart.getQtyOrdered()==2 && cart.getItemsOrdered()[1]==aladdin,"Middle removal");
        cart.removeDigitalVideoDisc(star); check(cart.getQtyOrdered()==2,"Missing removal");
        cart.removeDigitalVideoDisc(lion); cart.removeDigitalVideoDisc(aladdin);
        check(cart.getQtyOrdered()==0 && cart.totalCost()==0,"First/last removal");
        cart.addDigitalVideoDisc(new DigitalVideoDisc[]{lion,star});
        cart.addDigitalVideoDisc(lion,star,aladdin);
        check(cart.getQtyOrdered()==5,"Array/varargs");
        cart.addDigitalVideoDisc(); cart.addDigitalVideoDisc((DigitalVideoDisc)null);
        cart.addDigitalVideoDisc((DigitalVideoDisc[])null);
        check(cart.getQtyOrdered()==5,"Empty/null");
        while(cart.getQtyOrdered()<19) cart.addDigitalVideoDisc(lion);
        cart.addDigitalVideoDisc(star,aladdin); check(cart.getQtyOrdered()==20,"Pair capacity");
        cart.addDigitalVideoDisc(new DigitalVideoDisc[]{lion,star});
        check(cart.getQtyOrdered()==20,"Batch overflow");
        cart.removeDigitalVideoDisc(lion); cart.addDigitalVideoDisc(aladdin);
        check(cart.getQtyOrdered()==20,"Reuse capacity");
        check(capture(new Cart()::print).contains("Total cost: 0.00 $"),"Empty print");
        System.out.println("PASS: CartTest");
    }
}
