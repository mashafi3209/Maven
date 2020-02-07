package edu.shafiFgcu;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileInputStream;
import java.io.IOException;
import com.opencsv.CSVReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

  private List fileRows = new ArrayList();


  public CsvParser(String infile) throws IOException, CsvValidationException {
    if (checkFile(infile)) {
      readCsv(infile);
    }
  }

  protected void readCsv(String csvinfile) throws IOException, CsvValidationException {
    FileInputStream csvStream = new FileInputStream(csvinfile);
    InputStreamReader inputStream = new InputStreamReader(csvStream, StandardCharsets.UTF_8);
    CSVReader reader = new CSVReader(inputStream);

    String[] nextLine;
    while ((nextLine = reader.readNext()) != null) {
      fileRows.add(nextLine);
    }
    reader.close();
  }

  protected void writeCsv(String csvoutfile) {

  }


  private boolean checkFile(String csvfile) {
    if (!Files.exists((Paths.get(csvfile)))) {
      System.out.println("It doesnt exist");
      return false;
    }
    return true;

  }

  public void printCsv() {
    for (Object row : fileRows) {

      for (String fields : (String[]) row) {
        if (fields.isEmpty()) {
          System.out.print("N/A, ");
        } else {
          System.out.print(fields + ",  ");
        }

      } System.out.println("\n----------------------------");
    }
  }
}
