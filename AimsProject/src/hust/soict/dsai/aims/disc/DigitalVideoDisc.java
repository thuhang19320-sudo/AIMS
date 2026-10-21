package hust.soict.dsai.aims.disc;

import java.util.Locale;

/** DVD identity is assigned once per successfully constructed object. */
public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs;
    private final int id;
    private String title;
    private final String category;
    private final String director;
    private final int length;
    private final float cost;

    public DigitalVideoDisc(String title) { this(title, null, null, 0, 0); }
    // Preserve the argument order of the previous Lab02 constructors.
    public DigitalVideoDisc(String category, String title, float cost) {
        this(title, category, null, 0, cost);
    }
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this(title, category, director, 0, cost);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        requireTitle(title);
        if (length < 0 || !Float.isFinite(cost) || cost < 0)
            throw new IllegalArgumentException("Length and cost must be finite and non-negative");
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }
    private static void requireTitle(String title) {
        if (title == null || title.trim().isEmpty())
            throw new IllegalArgumentException("Title is required");
    }
    public int getId() { return id; }
    public static int getNbDigitalVideoDiscs() { return nbDigitalVideoDiscs; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }

    /** Lab03 parameter-passing experiment; other attributes remain read-only. */
    public void setTitle(String title) { requireTitle(title); this.title = title; }

    /** Lab02 rule: any query word contained in the title, ignoring case. */
    public boolean isMatch(String keywords) {
        if (keywords == null || keywords.trim().isEmpty()) return false;
        String folded = title.toLowerCase(Locale.ROOT);
        for (String word : keywords.trim().toLowerCase(Locale.ROOT).split("\\s+"))
            if (folded.contains(word)) return true;
        return false;
    }
    @Override public String toString() {
        return String.format(Locale.ROOT, "DVD - %s - %s - %s - %d: %.2f $",
                title, category == null ? "" : category,
                director == null ? "" : director, length, cost);
    }
}
