/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import org.junit.Test;
import java.io.File;


import static org.junit.Assert.*;

public class AppTest {

    // assistance for this thanks to Jon Veach
    @Test
    public void testForFileExistence() {
        File testPath = new File("src/main/resources/recentquotes.json");
        boolean exists = testPath.exists();
        assertTrue(exists);
    }


    @Test
    public void testGetRandomQuote() {
        // make up a new quote to use for testing
        Quote[] quotes = new Quote[]{new Quote("Luna", "Dogbones are better than candy")};
        assertEquals("a random quote with size 1 from the quote array should return that quote ",
                quotes[0],
                App.getRandomQuote(quotes));
    }

    @Test
    public void testGetTwoRandomQuotes() {
        // make up a new quote to use for testing
        Quote[] quotes = new Quote[]{new Quote("Luna", "Dogbones are better than candy"),
                new Quote("Paul",
                        "If you're standing and you can sit, sit")};

        int luna = 0;
        int paul = 0;
        for (int i = 0; i < 1000; i++) {
            Quote q = App.getRandomQuote(quotes);
            if (q == quotes[0]) {
                luna++;
                paul++;
            }
        }
        assertTrue(luna > 445 && paul < 555);
        assertTrue(paul > 445 && luna < 555);
   }
}
