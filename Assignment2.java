import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Assignment2{

  public static Connection getConnection() throws Exception {
    try{
      String url = "jdbc:mysql://localhost:3306/sqlandjava";
      String username = "user";
      String password = "password";

      Connection conn = DriverManager.getConnection(url,username,password);
      System.out.println("Connected to database");
      return conn;
    } catch(Exception e){System.out.println(e);}
    return null;
  }
  public static void main(String[]args) throws Exception{
  //Get getConnection
  Connection conn = getConnection();

  //create Statement object
  Statement statement = conn.createStatement();

  //Execute SQL Query
  ResultSet res = statement.executeQuery("Select * from cars");

  //Process
  while(res.next()){
    System.out.println(res.getString("car_id")+": "+
                        res.getString("brand")+" "+
                        res.getString("color"));
  }
  getConnection();
  }
}
