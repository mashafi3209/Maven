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
import java.sql.SQLException;
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

  public void pushCsv() throws SQLException {
    DatabaseManager db = new DatabaseManager();
    ArrayList list = new ArrayList();
    int line = 0;
    for (Object row : fileRows) {
        for (String fields : (String[]) row) {
          if (fields.isEmpty()) {
            System.out.print("N/A, ");
          } else {
            list.add(fields);
          }
        }
        if(line >0 ) {
          db.insertToBook(list.get(0), list.get(3), list.get(2), list.get(1));

        }
        else{
          System.out.println("First line");
        }

      list.clear();

        line++;
      System.out.println(line);
        System.out.println("\n----------------------------");
      }
    }
  }

