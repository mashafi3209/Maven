package edu.shafiFgcu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseManager extends Main {

  private Connection con = null;
  public DatabaseManager() throws SQLException {
    this.con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\shafi\\IdeaProjects\\Maven\\src\\Data\\BookStore.db");



  }
/*  public void clearTable(String table){
    try {
      String sql = "DELETE * FROM " + table;
      PreparedStatement stmt = this.con.prepareStatement(sql);


    } catch (Exception e) {
      e.printStackTrace();
    }
  }*/
  public void insertToAuthor(String name, String email, String url){
    try{
      PreparedStatement stmt = this.con.prepareStatement("INSERT or Ignore INTO author (author_name, author_email, author_url) VALUES (?,?,?)");
      stmt.setString(1, name);
      stmt.setString(2, email);
      stmt.setString(3, url);
      stmt.execute();

    } catch (Exception e) {
      e.printStackTrace();
    }


  }
  public void insertToBook(Object isbn, Object publisher_name, Object author_name, Object book_title){
    try{
      String isbn_1 = String.valueOf(isbn);
      String publisher_name_1 = String.valueOf(publisher_name);
      String author_name_1 = String.valueOf(author_name);
      String book_title_1 = String.valueOf(book_title);
      PreparedStatement stmt = this.con.prepareStatement("INSERT or Ignore INTO book (isbn, publisher_name, author_name,book_title) VALUES (?,?,?,?)");
      stmt.setString(1, isbn_1);
      stmt.setString(2, publisher_name_1);
      stmt.setString(3, author_name_1);
      stmt.setString(4, book_title_1);
      stmt.execute();

    } catch (Exception e) {
      e.printStackTrace();
    }


  }


}
