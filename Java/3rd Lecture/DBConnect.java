import java.sql.*;

public class DBConnect 
{
  String name;
  int id;
  Connection con;
  Statement stmt;
  ResultSet rs;
  
  public DBConnect()
  {
    try
    {
    
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    System.out.println("Driver resgitered");
    con = DriverManager.getConnection("jdbc:odbc:my_dsn");
    System.out.println("Connection created");
    stmt= con.createStatement();
    System.out.println("Statement created");
    rs = stmt.executeQuery("select * from Users");
    System.out.println("Statement executed");
    while(rs.next())
    {
      id = rs.getInt("ID");
      name = rs.getString("Name");
      
      System.out.println("User info. : "+id+", "+name);
    }
    
    }
    catch(Exception e)
    {
      System.out.println("Exception: "+e.getMessage());
      e.printStackTrace();
    }
    finally
    {
    try
    {
      rs.close();
      stmt.close();
      con.close();
      System.out.println("Resources closed");
    }
    catch(Exception ee)
    {
      System.out.println("Exception: "+ee.getMessage());
      ee.printStackTrace();
    }
    }
  }

  public static void main(String[] args)
  {
    new DBConnect();
  }
}