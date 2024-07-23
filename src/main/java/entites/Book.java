package entites;

public class Book {
    private int bookId;
    private String name;
    private int year;
    private String author;
    private double price;
    private int quantity;

    public Book(int bookId, String name, int year, String author, double price, int quantity) {
        this.bookId = bookId;
        this.name = name;
        this.year = year;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public Book(String name, int year, String author, double price, int quantity) {
        this.name = name;
        this.year = year;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
