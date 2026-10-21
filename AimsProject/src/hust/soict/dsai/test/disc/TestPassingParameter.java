package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    /** Intentionally ineffective: only swaps local copies of reference values. */
    public static void swap(Object o1, Object o2) {
        Object tmp = o1; o1 = o2; o2 = tmp;
    }
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle); // Does not reassign the caller's variable.
    }
    /** A mutable holder lets the method change references observed by the caller. */
    public static void swap(DigitalVideoDisc[] pair) {
        if (pair == null || pair.length != 2)
            throw new IllegalArgumentException("Exactly two DVDs are required");
        DigitalVideoDisc tmp = pair[0]; pair[0] = pair[1]; pair[1] = tmp;
    }
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
        if (!jungleDVD.getTitle().equals("Jungle") || !cinderellaDVD.getTitle().equals("Cinderella"))
            throw new AssertionError("Local swap changed caller references");
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        if (!jungleDVD.getTitle().equals("Cinderella"))
            throw new AssertionError("Shared object mutation was not visible");
        DigitalVideoDisc[] pair = {jungleDVD, cinderellaDVD};
        swap(pair);
        if (pair[0] != cinderellaDVD || pair[1] != jungleDVD)
            throw new AssertionError("Holder swap failed");
        System.out.println("PASS: pass-by-value and working holder swap");
    }
}
