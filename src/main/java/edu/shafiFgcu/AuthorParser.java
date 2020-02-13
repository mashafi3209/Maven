package edu.shafiFgcu;

public class AuthorParser {
  private String author_name;
  private String author_email;
  private String author_url;


  protected String getName() {
    return author_name;
  }

  protected void setName(String newName){
    this.author_name = newName;
  }





  protected String getEmail() {
    return author_email;
  }
  protected void setEmail(String newEmail){
    this.author_email = newEmail;
  }


  protected String getUrl() {
    return author_url;
  }
  protected void setUrl(String newUrl){
    this.author_url = newUrl;
  }

}
