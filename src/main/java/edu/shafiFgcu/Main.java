package edu.shafiFgcu;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, CsvValidationException, SQLException {
        DatabaseManager db = new DatabaseManager();
   /*     db.clearTable("book");
        db.clearTable("author");*/
        CsvParser csvP = new CsvParser("src/Data/bookstore_report2.csv");
        csvP.pushCsv();

        Gson gson = new Gson();
        JsonReader jread = new JsonReader(new FileReader("src/Data/authors.json"));
        AuthorParser[] authors = gson.fromJson(jread, AuthorParser[].class);

        for (var element : authors) {
            String name = element.getName();
            String email = element.getEmail();
            String url = element.getEmail();

            db.insertToAuthor(name,email,url);

        }
    }
}
