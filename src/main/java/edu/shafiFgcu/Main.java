package edu.shafiFgcu;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, CsvValidationException {
        System.out.println("Hello It works");
        CsvParser csvP = new CsvParser("src/Data/SEOExample.csv");
        csvP.printCsv();
    }
}
