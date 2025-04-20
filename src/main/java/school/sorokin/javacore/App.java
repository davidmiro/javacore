package school.sorokin.javacore;


import java.util.Scanner;

public class App {
    private static String[] names = new String[100];
    private static String[] phoneNumbers = new String[100];
    private static int contactCount = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nContact Management System");
            System.out.println("1. Add new contact");
            System.out.println("2. View all contacts");
            System.out.println("3. Find contact");
            System.out.println("4. Delete contact");
            System.out.println("5. Exit");
            System.out.print("Choose an action: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    findContact(scanner);
                    break;
                case 4:
                    removeContact(scanner);
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

    private static void addContact(Scanner scanner) {
        if (contactCount >= names.length) {
            System.out.println("Contact limit reached!");
            return;
        }
        System.out.println("Enter name ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        if (name.trim().isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }
        if (phoneNumber.trim().isEmpty()) {
            System.out.println("Phone number cannot be empty!");
            return;
        }
        names[contactCount] = name;
        phoneNumbers[contactCount] = phoneNumber;
        contactCount++;

        System.out.println("Contact successfully added!");
    }

    private static void viewContacts() {
        for (int i = 0; i < contactCount; i++) {
            System.out.println(names[i] + " - " + phoneNumbers[i]);
        }
    }

    private static void findContact(Scanner scanner) {
        System.out.println("Enter the name");
        String findName = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < contactCount; i++) {
            if (findName.equalsIgnoreCase(names[i])) {
                System.out.print("The phone number is: " + phoneNumbers[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    private static void removeContact(Scanner scanner) {
        System.out.println("Enter name to delete");
        String nameToRemove = scanner.nextLine();
        for (int i = 0; i < contactCount; i++) {
            if (nameToRemove.equals(names[i])) {
                for (int j = i; j <= contactCount - 1; j++) {
                    names[j] = names[j + 1];
                    phoneNumbers[j] = phoneNumbers[j + 1];
                }
                names[contactCount - 1] = null;
                phoneNumbers[contactCount - 1] = null;
                contactCount--;
                break;
            }
        }
    }
}
