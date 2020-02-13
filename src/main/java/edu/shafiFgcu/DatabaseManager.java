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
  public void insertToAuthor(String name, String email, String url){
    try{
      PreparedStatement stmt = this.con.prepareStatement("INSERT INTO author (author_name, author_email, author_url) VALUES (?,?,?)");
      stmt.setString(1, name);
      stmt.setString(2, email);
      stmt.setString(3, url);
      stmt.execute();

    } catch (Exception e) {
      e.printStackTrace();
    }


  }
  public void insertToBook(String isbn, String publisher_name, String author_name, int year, String book_title, Double price){
    try{
      PreparedStatement stmt = this.con.prepareStatement("INSERT INTO book (isbn, publisher_name, author_name,book_year,book_title,book_price) VALUES (?,?,?,?,?,?)");
      stmt.setString(1, isbn);
      stmt.setString(2, publisher_name);
      stmt.setString(3, author_name);
      stmt.setInt(4, year);
      stmt.setString(5, book_title);
      stmt.setDouble(6, price);
      stmt.execute();

    } catch (Exception e) {
      e.printStackTrace();
    }


  }





}
