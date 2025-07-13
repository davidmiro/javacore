package school.sorokin.javacore;


import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> catalog;

    public Library() {
        catalog = new ArrayList<>();
    }
    public void addBook(int availableCopies, String title, String author) {
        catalog.add(new Book(availableCopies, title, author));
    }

    public void takeBook(String title) throws BookNotFoundException, NoAvailableCopiesException {
        Book book = findBookByTitle(title);
        if (book == null) {
            throw new BookNotFoundException("Book not found: " + title);
        }
        if (book.getAvailableCopies() == 0) {
            throw new NoAvailableCopiesException("No copies available for: " + title);
        }
        book.setAvailableCopies(book.getAvailableCopies() - 1);
    }

    public void returnBook(String title) throws BookNotFoundException{
        Book book = findBookByTitle(title);
        if (book == null) {
            throw new BookNotFoundException("Book not found: " + title);
        }
        book.setAvailableCopies(book.getAvailableCopies() + 1);
    }

    public List<Book> getAllBooks() {
        return catalog;
    }

    private Book findBookByTitle(String title) {
        for (Book book : catalog) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}

