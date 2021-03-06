/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {

    public static void main(String[] args) throws IOException {
        try {
            //cacheNumbersQuoteToFileAndPrintQuote();
            cacheStarWarsAPIQuoteToFileAndPrintQuote();
        } catch (IOException e){
            e.printStackTrace();
            readQuoteDirectlyFromFile();
        }
    }


    // === PUT QUOTE FROM API IN JSON FILE AND PRINT OUT ===
    // make a static method so it can be called from the main method without creating an instance of it.

    public static void cacheNumbersQuoteToFileAndPrintQuote() throws IOException {

        // access key value pairs from constructor in class Quote to format what we get from API
        Quote numbersQuote = new Quote("", new App().connectToNumbersAPI());
        // print quote to console
        System.out.println(numbersQuote);

        // Use the file writer to access the json file and use gson
        Reader fileReader = new FileReader(new File("src/main/resources/recentquotes.json"));
        Gson gson = new Gson();

        // make a quote array filled with quotes from the json file.
        Quote[] origQuotesArr = gson.fromJson(fileReader, Quote[].class);

        // make a new array that is longer by 1
        Quote[] newQuotesArr = new Quote[origQuotesArr.length + 1];

        // add all the quotes into the new array
        for(int i = 0; i < origQuotesArr.length; i++){
            newQuotesArr[i] = origQuotesArr[i];
        }

        // tack on a new quote to the end of the new array
        newQuotesArr[newQuotesArr.length-1] = numbersQuote;

        // replace stuff in json file with new array stuff
        FileWriter quoteWriter = new FileWriter("src/main/resources/recentquotes.json");
        gson.toJson(newQuotesArr, quoteWriter);

        // close the quoteWriter
        quoteWriter.close();
    }

    public static void cacheStarWarsAPIQuoteToFileAndPrintQuote() throws IOException {

        Gson gson = new Gson();

        // gets the star wars quote from the method below so we can use it
        String data = connectToStarWarsAPI();
        //System.out.println(quote);

        StarWarsQuote swQuote = gson.fromJson(data, StarWarsQuote.class);
        //System.out.println("made it to line 66" + swQuote.toString());

        // use Quote class to format StarWarsQuote into familiar string
        Quote quote = new Quote(swQuote);

        // print quote to console
        System.out.println(quote.toString());


        // === Add Quote to the JSON File

//        // Use the file writer to access the json file and use gson
//        Reader fileReader = new FileReader(new File("src/main/resources/recentquotes.json"));
//
//        // make a quote array filled with quotes from the json file.
//        Quote[] origQuotesArr = gson.fromJson(fileReader, Quote[].class);
//
//        // make a new array that is longer by 1
//        Quote[] newQuotesArr = new Quote[origQuotesArr.length + 1];
//
//        // add all the quotes into the new array
//        for(int i = 0; i < origQuotesArr.length; i++){
//            newQuotesArr[i] = origQuotesArr[i];
//        }
//
//        // tack on a new quote to the end of the new array
//        newQuotesArr[newQuotesArr.length-1] = quote;
//
//        // replace stuff in json file with new array stuff
//        FileWriter quoteWriter = new FileWriter("src/main/resources/recentquotes.json");
//        gson.toJson(newQuotesArr, quoteWriter);
//
//        // close the quoteWriter
//        quoteWriter.close();
    }


    // === GET A QUOTE DIRECTLY FROM JSON FILE ===
    public static void readQuoteDirectlyFromFile() throws FileNotFoundException {
        Gson gson = new Gson();
        // add data from json file to an array
        Quote[] fromJsonFileOfQuotes = gson.fromJson(
                new FileReader(new File("src/main/resources/recentquotes.json")),
                Quote[].class);

        System.out.println(getRandomQuote(fromJsonFileOfQuotes));
    }


    // === ACCESS API TO GET A QUOTE ===
    // base code to read from an api from Michelle Ferreirae - very standard code

    private String connectToNumbersAPI() throws IOException {
        // go to API
        URL url = new URL("http://numbersapi.com/random/year");
        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        connect.setRequestMethod("GET");

        String data = new BufferedReader(new InputStreamReader(connect.getInputStream())).readLine();
        return data;
    }

    private static String connectToStarWarsAPI() throws IOException {
        URL jqueryURL = new URL("http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote");
        HttpURLConnection connection = (HttpURLConnection) jqueryURL.openConnection();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder data = new StringBuilder();
        String line = reader.readLine();

        while(line != null) {
            data.append(line);
            line = reader.readLine();
        }
        //System.out.println(data.toString());
        return data.toString();
    }

    // === HELPER METHOD - Get random quote from array of quotes ===
    public static Quote getRandomQuote(Quote[] quotes) {
        int index = (int)(Math.random() * quotes.length);
        return quotes[index];
    }
}
