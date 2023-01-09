import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class HotelManagement {
	
	  public static void main (String[] args) {
		 
		  endByE();
		  
		  
		  
	  }
	
	 public static void endByE() {
		 
		 	
		 String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
	     String user = "sa";
	     String pass = "root";
	     Scanner scanner1=new Scanner(System.in);
	    
	            		
	            		
	                 
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
	                     
	                     
	                     String Sql ="select * from Guests where guest_name like '%e'";
	                     ResultSet result=st.executeQuery(Sql);
	        		     while(result.next()) {
	        		    	 String guestname=result.getString("guest_name");
	        		    
	           	               System.out.println(guestname);
	           	 

	                     // Executing query
	                     int m = st.executeUpdate(Sql);
	               
	                     con.close();
	                 }}
	                 catch (Exception ex) {

	                     System.err.println(ex);
	                 }
	                 }}