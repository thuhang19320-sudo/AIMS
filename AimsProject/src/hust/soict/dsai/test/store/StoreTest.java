package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import static hust.soict.dsai.test.TestSupport.*;
public class StoreTest {
    public static void main(String[] args) {
        Store store=new Store();
        DigitalVideoDisc first=new DigitalVideoDisc("First");
        store.removeDVD(first); store.addDVD(null);
        check(store.getQtyInStore()==0,"Empty/null");
        store.addDVD(first); store.addDVD(first); check(store.getQtyInStore()==1,"Duplicate");
        DigitalVideoDisc middle=null,last=null;
        for(int i=1;i<25;i++){last=new DigitalVideoDisc("Disc "+i);if(i==12)middle=last;store.addDVD(last);}
        check(store.getQtyInStore()==25,"Array growth");
        store.removeDVD(middle);store.removeDVD(first);store.removeDVD(last);
        check(store.getQtyInStore()==22,"Middle/first/last removal");
        for(DigitalVideoDisc dvd:store.getItemsInStore())
            check(dvd!=null && dvd!=middle && dvd!=first && dvd!=last,"Compaction");
        DigitalVideoDisc[] copy=store.getItemsInStore();copy[0]=null;
        check(store.getItemsInStore()[0]!=null,"Defensive copy");
        store.removeDVD(null);check(store.getQtyInStore()==22,"Missing removal");
        System.out.println("PASS: StoreTest");
    }
}
