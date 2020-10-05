package bookstore.model;

import java.util.List;

/**
 * Represents a book.
 */
public class Book extends AbstractEntity {
    String title;
    List<String> authors;
    String description;
    float price;

    public Book(String title, List<String> authors, String description, float price) {
        this.title = title;
        this.authors = authors;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String toString() {
        return "Book #" + getId() +
                ", titled '" + getTitle() + "'" +
                ", by authors " + getAuthors().toString() +
                ", costing " + getPrice();
    }
}
