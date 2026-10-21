public class DigitalVideoDisc {
    private final String title;
    private final String category;
    private final String director;
    private final int length;
    private final float cost;
    public DigitalVideoDisc(String title) { this(title, null, null, 0, 0); }
    public DigitalVideoDisc(String category, String title, float cost) { this(title, category, null, 0, cost); }
    public DigitalVideoDisc(String director, String category, String title, float cost) { this(title, category, director, 0, cost); }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title is required");
        if (cost < 0) throw new IllegalArgumentException("Cost cannot be negative");
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }
    @Override public String toString() {
        return "DVD[title=" + title + ", category=" + category + ", director=" + director
                + ", length=" + length + ", cost=" + cost + "]";
    }
}