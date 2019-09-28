/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
        try {

            // access key value pairs from constructor in class Quote to format what we get from API
            Quote quote = new Quote("", new App().getNumbersAPI());
            // print out the quote to the console (which was also stored to json file)
            System.out.println(quote);

            // Use the file writer to access the json file and use gson
            Reader fileReader = new FileReader(new File("src/main/resources/recentquotes.json"));

            Gson gson = new Gson();

            // make a quote array
            Quote[] origQuotesArr = gson.fromJson(fileReader, Quote[].class);
//            System.out.println("1st quote from end of origArr" + origQuotesArr[origQuotesArr.length-1]); // prints last line from origQuotesArr

            // make a new array that is longer by 1
            Quote[] newQuotesArr = new Quote[origQuotesArr.length + 1];


            // add all the quotes into the new array
            for(int i = 0; i < origQuotesArr.length; i++){
                newQuotesArr[i] = origQuotesArr[i];
            }

            // tack on a new quote to the end of the new array
            newQuotesArr[newQuotesArr.length-1] = quote;

            // checks last 3 lines of new quotes array
//            System.out.println("3rd quote from end of newArr: " + newQuotesArr[newQuotesArr.length-3]);
//            System.out.println("2nd quote from end of newArr: " + newQuotesArr[newQuotesArr.length-2]);
//            System.out.println("1st quote from end of newArr: " + newQuotesArr[newQuotesArr.length-1]);

            // replace stuff in json file with new array stuff
            FileWriter quoteWriter = new FileWriter("src/main/resources/recentquotes.json");
            gson.toJson(newQuotesArr, quoteWriter);

            // close the quoteWriter
            quoteWriter.close();


        } catch (IOException e) {
            // cannot access the api, so get something from the json file instead
            readQuoteFromFile();
        }
    }


    // === JSON SUPPLIES QUOTE ===
    public static void readQuoteFromFile() throws FileNotFoundException {
        // === Put quotes from JSON into Array ===
        // read all quotes from file into superCoolQuotesArray variable

        Gson gson = new Gson();
        Quote[] superCoolQuotesArray = gson.fromJson(
                new FileReader(new File("src/main/resources/recentquotes.json")),
                Quote[].class);

        System.out.println(getRandomQuote(superCoolQuotesArray));
    }


    // === API ===
    // API comes from: http://numbersapi.com/#42
    // base code to read from an api from Michelle Ferreirae

    public String getNumbersAPI() throws IOException {
        //URL jqueryUrl = new URL("http://numbersapi.com/12/12/date");
        URL jqueryUrl = new URL("http://numbersapi.com/random/year");
        HttpURLConnection connection = (HttpURLConnection) jqueryUrl.openConnection();

        // read
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder data = new StringBuilder();
        String line = reader.readLine();

        // if something is there, read line
        while(line != null) {
            data.append(line);
            line = reader.readLine();
        }
        return data.toString();
    }


    // === HELPER METHOD ===
    // get a random quote from an array of quotes using a helper method
    public static Quote getRandomQuote(Quote[] quotes) {
        int index = (int)(Math.random() * quotes.length);
        return quotes[index];
    }
}
