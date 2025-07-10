package school.sorokin.javacore;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        while (true) {
            System.out.println(
                    "Choose an option:\n" +
                            "1. View the list of all available books.\n" +
                            "2. Rent a book (if available).\n" +
                            "3. Return a book.\n" +
                            "4. Add a new book to the system.\n" +
                            "5. Exit the application."
            );
            String userInput = scanner.nextLine();
            if (userInput.matches("\\d+")) {
                int choice = Integer.parseInt(userInput);
                switch (choice) {
                    case 1:
                        if (library.getAllBooks().isEmpty()) {
                            System.out.println("No books found.");
                        } else {
                            for (Book book : library.getAllBooks()) {
                                System.out.println(book);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Enter the title of the book to rent: ");
                        String bookToTake = scanner.nextLine();
                        try {
                            library.takeBook(bookToTake);
                            System.out.println("Book rented successfully!");
                        } catch (BookNotFoundException | NoAvailableCopiesException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("Enter the title of the book to return: ");
                        String bookToReturn = scanner.nextLine();
                        try {
                            library.returnBook(bookToReturn);
                            System.out.println("Book returned successfully!");
                        } catch (BookNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println("Enter number of book copies: ");
                        int bookCopiesNumber = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter the title of the book to add: ");
                        String bookToAdd = scanner.nextLine();
                        System.out.println("Enter book author name: ");
                        String bookAuthorName = scanner.nextLine();
                        library.addBook(bookCopiesNumber, bookToAdd, bookAuthorName);
                        break;
                    case 5:
                        System.out.println("Program terminated.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }
}
