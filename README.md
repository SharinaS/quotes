# Random Quote App

## Contributors:
* Sarah Fisher
* Sharina Stubbs

## About
This app allows the user to generate random quotes and their associated author from a provided json file. It uses the following:
* gson
* Json
* FileReader
* Scanner
* Java

Note that the following dependency was added to the file, build.gradle, to use gson:
```com.google.code.gson:gson:2.8.5```

When run, the app shows quotes from an API with history facts based on dates. Each quote is also stored in a JSON file. If offline, the app will show quotes which are pulled from the JSON file at random.

## How to run this application from the terminal:
1. Clone repository (from terminal: `git clone ___`)
2. To run the file run `./gradlew run`
3. To test the file, run `./gradlew test`
