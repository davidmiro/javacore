package school.sorokin.javacore.oop;

import java.util.Scanner;

import static school.sorokin.javacore.oop.Publication.getPublicationCount;

public class LibraryHomeWork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("Choose an option: ");
            System.out.println("1. Add new publication");
            System.out.println("2. Display a list of all publications.");
            System.out.println("3. Search for publication by author.");
            System.out.println("4. Display total number of publications");
            System.out.println("0. Exit");

            String userInput = sc.nextLine();
            if (userInput.matches("\\d+")) {
                int choice = Integer.parseInt(userInput);
                switch (choice) {
                    case 1:

                        System.out.println("Choose publication type: : 1 – Book, 2 – Magazine, 3 – Newspaper");
                        int publicationTypeChoice = sc.nextInt();
                        sc.nextLine();

                        if (publicationTypeChoice == 1) {
                            System.out.println("Enter book title: ");
                            String title = sc.nextLine();
                            System.out.println("Enter book author: ");
                            String author = sc.nextLine();
                            int year = readValidYear(sc);
                            String isbn = readValidateIsbn(sc);
                            Book book = new Book(title, author, year, isbn);
                            library.addPublication(book);
                        } else if (publicationTypeChoice == 2) {
                            System.out.println("Enter magazine title: ");
                            String title = sc.nextLine();
                            System.out.println("Enter magazine author: ");
                            String author = sc.nextLine();
                            int year = readValidYear(sc);
                            int issueNumber = readValidIssueNum(sc);
                            Magazine magazine = new Magazine(title, author, year, issueNumber);
                            library.addPublication(magazine);
                        } else if (publicationTypeChoice == 3) {
                            System.out.println("Enter newspaper title: ");
                            String title = sc.nextLine();
                            System.out.println("Enter newspaper author: ");
                            String author = sc.nextLine();
                            int year = readValidYear(sc);
                            System.out.println("Enter publication day ");
                            String publicationDay = sc.nextLine();
                            Newspaper newspaper = new Newspaper(title, author, year, publicationDay);
                            library.addPublication(newspaper);
                        } else {
                            System.out.println("Please enter correct choice");
                        }
                        break;
                    case 2:
                        library.listPublications();
                        break;
                    case 3:
                        System.out.println("Enter author full name to search:");
                        String authorToSearch = sc.nextLine();
                        library.searchByAuthor(authorToSearch);
                        break;
                    case 4:
                        System.out.println("Total publications:  " + getPublicationCount());
                        break;
                    case 0:
                        System.out.println("Program terminated.");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } else {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static int readValidYear(Scanner sc) {
        while (true) {
            System.out.println("Enter year: ");
            String userInput = sc.nextLine();
            try {
                int year = Integer.parseInt(userInput);
                if (year < 0) {
                    System.out.println("Year can't be negative.");
                } else if (year > 2025) {
                    System.out.println("Year cannot be greater than 2025");
                } else {
                    return year;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
    }

    private static int readValidIssueNum(Scanner sc) {
        while (true) {
            System.out.println("Enter Issue number: ");
            String userInput = sc.nextLine();
            try {
                int issueNumber = Integer.parseInt(userInput);
                if (issueNumber < 0) {
                    System.out.println("Issue number can't be negative.");
                } else {
                    return issueNumber;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
    }

    private static String readValidateIsbn(Scanner sc) {
        while (true) {
            System.out.println("Enter book ISBN: ");
            String userInput = sc.nextLine();
            if (userInput.matches("\\d{10}") || userInput.matches("\\d{13}")) {
                return userInput;
            } else {
                System.out.println("ISBN must be 10 or 13 digits");
            }
        }
    }
}
