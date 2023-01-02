import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


public class Hotels {
	
	
	 public static void main(String[] args) {
    	
	 String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
     String user = "sa";
     String pass = "root";
     Scanner scanner1=new Scanner(System.in);
    
     
     //creating first table
     String Sql = "CREATE TABLE Hotels " + "(id INTEGER PRIMARY KEY, " + " hotel_name VARCHAR(50) NOt NULL, "
				+ " hotel_location VARCHAR(50), " + " created_date date NOT NULL, " + " updated_date date, "+"is_Active bit NOT NULL)";
     
     Connection con = null;
     try {

         Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
         // Registering drivers
         DriverManager.registerDriver(driver);

         // Reference to connection interface
         con = DriverManager.getConnection(url, user,
                 pass);

         // Creating a statement
         Statement st = con.createStatement();

         // Executing query
         int m = st.executeUpdate(Sql);
         if (m >=  0)
             System.out.println("Hotels table Created successfully");
         else
             System.out.println("Creation failed");

         
         con.close();
     }
     catch (Exception ex) {

         System.err.println(ex);
     }insertIntoTable();
     }
         
   
     
     public static void insertIntoTable(){
    	 
    	 String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
         String user = "sa";
         String pass = "root";
         
    	 Scanner sa=new Scanner(System.in);
     	System.out.println("Please type the number of rows");
         int userinput =sa.nextInt();
         String hotel_name="Plaza";
         
         String hotel_location="Seeb";
         
         String created_date="1996-03-01";
         
         String updated_date="1996-08-02";
         
         boolean is_Active=false;
         Random rn = new Random();
         Integer numberToAdd = rn.nextInt(100);
         for(int i=0; i<=userinput;i++) {
         String sql = "insert into Hotels values ("+i+numberToAdd+", '"+hotel_name+i+"', '"+hotel_location+i+"','"+created_date+i+"','"+updated_date+", '"+is_Active+"')";
    	 
         Connection con = null;
         try {

             Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
             // Registering drivers
             DriverManager.registerDriver(driver);

             // Reference to connection interface
             con = DriverManager.getConnection(url, user,
                     pass);

             // Creating a statement
             Statement st = con.createStatement();

             // Executing query
             int m = st.executeUpdate(sql);
             if (m >=  0)
                 System.out.println("Hotels table Created successfully");
             else
                 System.out.println("Creation failed");

             
             con.close();
         }
         catch (Exception ex) {

             System.err.println(ex);
    	 
     }}
    
     
     
     }}