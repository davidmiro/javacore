package school.sorokin.javacore.oop;

public class Newspaper extends Publication implements Printable {
    String publicationDay;

    public Newspaper(String title, String author, int year, String publicationDay) {
        super(title, author, year);
        this.publicationDay = publicationDay;
    }

    @Override
    public String getType() {
        return "Newspaper";
    }

    public String getPublicationDay() {
        return publicationDay;
    }

    public void setPublicationDay(String publicationDay) {
        this.publicationDay = publicationDay;
    }

    public void printDetails() {
        System.out.println("Title: " + getTitle() + " Author: " + getAuthor() + " Year: " + getYear()
                + " Publication day " + publicationDay);
    }
}