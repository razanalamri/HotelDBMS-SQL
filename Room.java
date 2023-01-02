import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Room {
	
	

	  public static void main(String[] args) {
	    	
			 String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		     String user = "sa";
		     String pass = "root";
		     Scanner scanner = new Scanner(System.in);
		     
		     //Creating third table
  	         
		     String Sql = "CREATE TABLE Rooms " + "(id INTEGER PRIMARY KEY, " + " room_type_id INTEGER FOREIGN KEY REFERENCES Room_Type(id), "
						+ " hotel_id INTEGER FOREIGN KEY REFERENCES Hotels(id), " + " created_date date NOT NULL, " + " updated_date date, "+" is_Active bit NOT NULL)";
	       
	             Connection con = null;

	             try {

	                 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	            
	                 DriverManager.registerDriver(driver);

	        
	                 con = DriverManager.getConnection(url, user,
	                         pass);

	        
	                 Statement st = con.createStatement();

	        
	                 int m = st.executeUpdate(Sql);
	                 if (m >=  0)
	                     System.out.println("Room Created successfully");
	                 else
	                     System.out.println("Creation failed");



	             con.close();
	         }

	      
	         catch (Exception ex) {
	         
	             System.err.println(ex);
	         }
	             

}}
