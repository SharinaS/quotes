package quotes;

public class Quotes {
    // instance variables
    String author;
    String text;

    // constructor function
    public Quotes(String author, String text) {
        this.author = author;
        this.text = text;
    }

    // === instance methods
    public void getQuote() {
        System.out.println(this.author + "is real");
    }

    // return in a string
    @Override
    public String toString() {
        return String.format(
                "%s wrote this amazing quote: %s",
                this.author,
                this.text);
    }
}