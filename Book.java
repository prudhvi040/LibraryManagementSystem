package library;

public class Book {
    private static int counter = 1;
    private int id;
    private String title;
    private String author;
    private boolean issued;

    public Book(String title, String author) {
        this.id = counter++;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    @Override
    public String toString() {
        return id + " | " + title + " by " + author + (issued ? " [Issued]" : " [Available]");
    }
}
