package library;

public class User {
    private static int counter = 1;
    private int id;
    private String name;

    public User(String name) {
        this.id = counter++;
        this.name = name;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + " | " + name;
    }
}
