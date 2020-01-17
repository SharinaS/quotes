package quotes;

public class Quote {
    // instance variables
    String author;
    String text;
    String starWarsQuote;

    // constructor function
    public Quote (String author, String text) {
        this.author = author;
        this.text = text;
    }

    // overloaded
    public Quote (String starWarsQuote) {
        //TODO: access the value for the key, starWarsQuote.
        this.starWarsQuote = starWarsQuote;
    }


    // return in a string
    @Override
    public String toString() {
        return String.format(
                "Here's a nice quote or history tidbit for you: %s %s",
                this.author,
                this.text);
    }


    public String starWarsString() {
        return String.format("Star Wars says: %s",
                this.starWarsQuote);
    }

    // ?Consider: When dealing with an API that has different keys for its JSON, requiring different instance
    // variables, create more instance variables and make an overloaded constructor?
}
