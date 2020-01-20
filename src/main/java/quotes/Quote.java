package quotes;

public class Quote {
    // instance variables
    String author;
    String text;

    // constructor function
    public Quote (String author, String text) {
        this.author = author;
        this.text = text;
    }

    //TODO: Fix constructor, since code is throwing an error when there the quote has extra parts to it.

    // constructor that takes in a quote from the StarWarsQuote class)
    public Quote(StarWarsQuote swQuote) {
        String[] origString = swQuote.starWarsQuote.split("-");
        this.author = origString[0];
        this.text = origString[1];
    }

    // return in a string
    @Override
    public String toString() {
        return String.format(
                "%s said: %s",
                this.author,
                this.text
        );
    }
}
