import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Room {
	
	

	  public static void createdtable3() {
	    	
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
	             

	  }
	  
		 public static void readFromTable(int userinput){
			 String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		     String user = "sa";
		     String pass = "root";
		     Scanner scanner=new Scanner(System.in);
		     
		    
		     Connection con = null;
			 try{
				 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				 DriverManager.registerDriver(driver);

		         // Reference to connection interface
		         con = DriverManager.getConnection(url, user,
		                 pass);

		         // Creating a statement
		         Statement st = con.createStatement();
		         System.out.println("Please Enter the number of rows :");
		         userinput=scanner.nextInt();
		         int count=0;
		         String sql="SELECT * FROM Room";
			     ResultSet result=st.executeQuery(sql);
			     while(result.next()&&count<userinput) {
			    	 int Rid=result.getInt("id");
			    	 String Rtype=result.getString("room_type_id");
			    	 String Rhtype=result.getString("hotel_id");
			    	 Date CD=result.getDate("created_date");
			    	 Date UD=result.getDate("updated_date");
			    	 boolean Activated=result.getBoolean("is_Active");
			    	 
	   	  System.out.println(Rid+" "+Rtype+" "+Rhtype+" "+CD+" "+UD+" "+Activated);
	   	  count++;
	      
	      
	  }}
	  catch (Exception ex) {

	      System.err.println(ex);
		 
	}}
		////////////////////////////////////////////////////////////////////
		 
		 
		 public static void getById(){
			 String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		     String user = "sa";
		     String pass = "root";
		     Scanner scanner=new Scanner(System.in);
		     
		    
		     Connection con = null;
			 try{
				 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				 DriverManager.registerDriver(driver);

		         // Reference to connection interface
		         con = DriverManager.getConnection(url, user,
		                 pass);

		         // Creating a statement
		         Statement st = con.createStatement();
		       
		         System.out.println("Please Enter any id to display room data :");
		         int userinput =scanner.nextInt();
		         
		         
		         
		         String sql="SELECT * FROM Room WHERE id='"+userinput+"'";
			     ResultSet result=st.executeQuery(sql);
			     while(result.next()) {
			    	 int Rid=result.getInt("id");
			    	 String Rtype=result.getString("room_type_id");
			    	 String Rhtype=result.getString("hotel_id");
			    	 Date CD=result.getDate("created_date");
			    	 Date UD=result.getDate("updated_date");
			    	 boolean Activated=result.getBoolean("is_Active");
			    	 
	   	  System.out.println(Rid+" "+Rtype+" "+Rhtype+" "+CD+" "+UD+" "+Activated);
	   	 
	      
	      
	  }}
	  catch (Exception ex) {

	      System.err.println(ex);
		 
	}
			    }
		 
		 /////////////////////////////////////////////////////////////
		 public static void updateById(){
			 String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		     String user = "sa";
		     String pass = "root";
		     Scanner scanner=new Scanner(System.in);
		     
		    
		     Connection con = null;
			 try{
				 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				 DriverManager.registerDriver(driver);

		         // Reference to connection interface
		         con = DriverManager.getConnection(url, user,
		                 pass);

		         // Creating a statement
		         Statement st = con.createStatement();
		      
		         System.out.println("Please Enter any id to Update room data :");
		         int userinput =scanner.nextInt();
		         System.out.println("Please Enter the new created date");
		         String createddate=scanner.next();
		        
		
		      
		         String sql="UPDATE Room_Type SET room_type_name='"+createddate+"'WHERE id='"+userinput+"'";
			     ResultSet result=st.executeQuery(sql);
	      
	      
	  }
	  catch (Exception ex) {

	      System.err.println(ex);
		 
	}
			
			    }
		 ////////////////////////////////////////////////////////////////////////////////
		 

	public static void deleteById() {
		 String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
	     String user = "sa";
	     String pass = "root";
	     Scanner scanner=new Scanner(System.in);
	     
	    
	     Connection con = null;
		 try{
			 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			 DriverManager.registerDriver(driver);

	         // Reference to connection interface
	         con = DriverManager.getConnection(url, user,
	                 pass);

	         // Creating a statement
	         Statement st = con.createStatement();
	      
	         System.out.println("Please Enter any id to delete room data :");
	         int userinput =scanner.nextInt();
	      

	      
	         String sql="DELETE From Room WHERE id='"+userinput+"'";
		     ResultSet result=st.executeQuery(sql);

		 
	  
	  
	}
	catch (Exception ex) {

	  System.err.println(ex);
	 
	}
	    }

	////////////////////////////////////////////////////////////////////////////////////


	public static void makeIsActiveFalseById() {
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
	    String user = "sa";
	    String pass = "root";
	    Scanner scanner=new Scanner(System.in);
	    
	   
	    Connection con = null;
		 try{
			 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			 DriverManager.registerDriver(driver);

	        // Reference to connection interface
	        con = DriverManager.getConnection(url, user,
	                pass);

	        // Creating a statement
	        Statement st = con.createStatement();
	     
	        System.out.println("Please Enter any id to Update the status :");
	        int userinput =scanner.nextInt();
	   


	        String sql="UPDATE Room SET is_Active='false' WHERE id='"+userinput+"'";
		     ResultSet result=st.executeQuery(sql);
	 
	 
	}
	catch (Exception ex) {

	 System.err.println(ex);

	}
		
		
		
	}

		 
		 /////////////////////////////////////////////////////////////////////////////////
		 
	     
	     public static void insertIntoTable(){
	    	 
	    	 String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
	         String user = "sa";
	         String pass = "root";
	         
	    	 Scanner scanner=new Scanner(System.in);
	     	System.out.println("Please type the number of rows");
	         int userinput =scanner.nextInt();
	         int room_type_id=1;
	         int hotel_id=1;
	         String created_date="1996-03-01";
	         String updated_date="1996-08-02";
	         boolean is_Active=true;
	         Random rn = new Random();
	         Integer numberToAdd = rn.nextInt(100);
	         for(int i=0; i<=userinput;i++) {
	         String sql = "insert into Room values ("+i+numberToAdd+", '"+room_type_id+"', '"+hotel_id+"','"+created_date+"', '"+updated_date+"', '"+is_Active+"')";
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
	                 System.out.println("Data insearted successfully");
	             else
	                 System.out.println("insert failed");

	             
	             con.close();
	         }
	         catch (Exception ex) {

	             System.err.println(ex);
	    	 
	     }}
	    
	     
	     
	     }}
