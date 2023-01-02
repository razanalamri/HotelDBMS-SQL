import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Hotels {
	
	
	 public static void main(String[] args) {
    	
	 String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
     String user = "sa";
     String pass = "root";
     Scanner scanner = new Scanner(System.in);
     
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
     }


	
	
}}
