package school.sorokin.javacore.oop;

public class Book extends Publication implements Printable {
    String isbn;

    public Book() {
    }

    public Book(String title, String author, int year, String isbn) {
        super(title, author, year);
        this.isbn = isbn;
    }

    @Override
    public String getType() {
        return "Book";
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public void printDetails() {
        System.out.println("Title: " + getTitle() + " Author: " + getAuthor() + " Year: " + getYear()
                + " ISBN: " + isbn);
    }
}
