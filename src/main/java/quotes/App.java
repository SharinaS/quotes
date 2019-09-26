/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class App {


    public static void main(String[] args) throws FileNotFoundException {

        Gson gson = new Gson();
        Reader reader = new FileReader(new File("src/main/resources/recentquotes.json"));
        Quotes[] superCoolQuotesArray = gson.fromJson(reader, Quotes[].class);

        System.out.println(superCoolQuotesArray[5].author);

        // create random number generator
        int max = superCoolQuotesArray.length;
        int min = 0;
        int randomNumber = (int) (Math.random() * ((max - min) + 1)) + min;
        //System.out.println(randomNumber);

        //System.out.println(superCoolQuotesArray[17]);
        System.out.println(superCoolQuotesArray[randomNumber]);
    }

    // ==== WORKING ON REFACTORING CODE --->  not yet working <----  ========

//    public static Object[] getJSONData() throws FileNotFoundException {
//        Gson gson = new Gson();
//        Reader reader = new FileReader(new File("src/main/resources/recentquotes.json"));
//        Quotes[] superCoolQuotesArray = gson.fromJson(reader, Quotes[].class);
//
//        //System.out.println(superCoolQuotesArray[17]);
//        System.out.println(superCoolQuotesArray[]);
//
//    }
//
//    public int randomNumberGenerator() {
//        // create random number generator
//        int max = superCoolQuotesArray.length;
//        int min = 0;
//        int randomNumber = (int) (Math.random() * ((max - min) + 1)) + min;
//        return randomNumber;
//    }

}
