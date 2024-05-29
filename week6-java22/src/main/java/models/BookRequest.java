package models;

public class BookRequest {
    private final String title;
    private final String author;
    private final int yearOfProduction;
    private int numberOfCopies;

    public BookRequest(String title, String author, int yearOfProduction, int numberOfCopies) {
        this.title = title;
        this.author = author;
        this.yearOfProduction = yearOfProduction;
        this.numberOfCopies = numberOfCopies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    @Override
    public String toString() {
        return "BookRequest{" +
                "title='" + title + "\n" +
                ", author='" + author + "\n" +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
}