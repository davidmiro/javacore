package school.sorokin.javacore.oop;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Publication> publications;
    private int publicationCount = 0;

    public Library() {
        publications = new ArrayList<>();
    }

    public void addPublication(Publication pub) {
        publications.add(pub);
        publicationCount++;
    }
    public int getPublicationCount() {
        return publicationCount;
    }


    public void listPublications() {
        if (publications.isEmpty()) {
            System.out.println("No publications found.");
        } else {
            for (Publication pub : publications) {
                if (pub instanceof Printable) {
                    ((Printable) pub).printDetails();
                } else {
                    System.out.println(pub);
                }
            }
        }
    }

    public void searchByAuthor(String author) {
        if (publications.isEmpty()) {
            System.out.println("No publications found.");
        } else {
            boolean found = false;
            for (Publication pub : publications) {
                if (pub.getAuthor().equalsIgnoreCase(author)) {
                    System.out.println(pub);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No publications found for this author.");
            }
        }
    }
}
