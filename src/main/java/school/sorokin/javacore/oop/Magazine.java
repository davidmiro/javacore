package school.sorokin.javacore.oop;

public class Magazine extends Publication implements Printable {
    private int issueNumber;

    public Magazine(String title, String author, int year, int issueNumber) {
        super(title, author, year);
        this.issueNumber = issueNumber;
    }

    @Override
    public String getType() {
        return "Magazine";
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public void printDetails() {
        System.out.println("Title: " + getTitle() + " Author: " + getAuthor() + " Year: " + getYear()
                + " Issue number" + issueNumber);
    }
}
