import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Guests {

	
	public static Connection con;

	  public static void createdtable4() {
	    	
			 String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		     String user = "sa";
		     String pass = "root";
		     Scanner scanner = new Scanner(System.in);
		     
		     String Sql = "CREATE TABLE Guests " + "(id INTEGER PRIMARY KEY IDENTITY(1,1), " + " guest_name VARCHAR(50) NOT NULL, "
						+ " guest_phone VARCHAR(50) NOT NULL, " + " guest_accompanying_members INTEGER NOT NULL, " + " guest_payment_amount INTEGER NOT NULL,"
								+ " room_id INTEGER FOREIGN KEY REFERENCES Rooms(id), "
								+ " hotel_id INTEGER FOREIGN KEY REFERENCES Hotels(id), "+" created_date date NOT NULL, "+" updated_date date, "+" is_Active bit NOT NULL)";
		     
      Connection con = null;

      try {

          Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
     
          DriverManager.registerDriver(driver);

 
          con = DriverManager.getConnection(url, user,
                  pass);

 
          Statement st = con.createStatement();

 
          int m = st.executeUpdate(Sql);
          if (m >=  0)
              System.out.println("Gusests table Created successfully");
          else
              System.out.println("Creation failed");



      con.close();
  }


  catch (Exception ex) {
  
      System.err.println(ex);
  }}

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
		         String sql="SELECT * FROM Gusests";
			     ResultSet result=st.executeQuery(sql);
			     while(result.next()&&count<userinput) {
			    	 int Hid=result.getInt("id");
			    	 String Hname=result.getString("guest_name");
			    	 String Hlocation=result.getString("guest_phone");
			    	 int Gm=result.getInt("guest_accompanying_members");
			    	 int Gp=result.getInt("guest_payment_amount");
			    	 int RI=result.getInt("room_id");
			    	 int HI=result.getInt("hotel_id");
			    	 Date CD=result.getDate("created_date");
			    	 Date UD=result.getDate("updated_date");
			    	 boolean Activated=result.getBoolean("is_Active");
			    	 
	   	  System.out.println(Hid+" "+Hname+" "+Hlocation+" "+Gm+" "+Gp+" "+RI+" "+HI+" "+CD+" "+UD+" "+Activated);
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
		       
		         System.out.println("Please Enter any id to display Guests data :");
		         int userinput =scanner.nextInt();
		         
		         
		         
		         String sql="SELECT * FROM Guests WHERE id='"+userinput+"'";
			     ResultSet result=st.executeQuery(sql);
			     while(result.next()) {
			    	 int Hid=result.getInt("id");
			    	 String Hname=result.getString("guest_name");
			    	 String Hlocation=result.getString("guest_phone");
			    	 int Gm=result.getInt("guest_accompanying_members");
			    	 int Gp=result.getInt("guest_payment_amount");
			    	 int RI=result.getInt("room_id");
			    	 int HI=result.getInt("hotel_id");
			    	 Date CD=result.getDate("created_date");
			    	 Date UD=result.getDate("updated_date");
			    	 boolean Activated=result.getBoolean("is_Active");
			    	 
	   	  System.out.println(Hid+" "+Hname+" "+Hlocation+" "+Gm+" "+Gp+" "+RI+" "+HI+" "+CD+" "+UD+" "+Activated);
	   	 
	      
	      
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
		      
		         System.out.println("Please Enter any id to Update Guests data :");
		         int userinput =scanner.nextInt();
		         System.out.println("Please Enter the new Guests name:");
		         String Guestsname=scanner.next();
		         System.out.println("Please Enter the new Guests Phone:");
		         int GuestsPhone=scanner.nextInt();
		
		      
		         String sql="UPDATE Guests SET guest_name='"+Guestsname+"',guest_phone='"+GuestsPhone+"' WHERE id='"+userinput+"'";
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
	      
	         System.out.println("Please Enter any id to delete Guests data :");
	         int userinput =scanner.nextInt();
	      

	      
	         String sql="DELETE From Guests WHERE id='"+userinput+"'";
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
	   


	        String sql="UPDATE Guests SET is_Active='false' WHERE id='"+userinput+"'";
		     ResultSet result=st.executeQuery(sql);
	 
	 
	}
	catch (Exception ex) {

	 System.err.println(ex);

	}
		
		
		
	}

		 
		 /////////////////////////////////////////////////////////////////////////////////
		 
	     
	public static void insertIntoTable() {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Statement st = null;

		Date date = new Date(System.currentTimeMillis());
		int idOfHotelType=1;
		Integer idOfRoom =1;
		boolean is_Active = true;
		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);

		Scanner scanner1 = new Scanner(System.in);
        System.out.println("Please Enter the number of rows ");
        int userinput=scanner1.nextInt();
        
        for(int i=0;i<userinput;i++) {
        	System.out.println("Please Enter the Guest Name:");
        	String GM=scanner1.next();
        	System.out.println("Please Enter the Guest Phone:");
        	String GP=scanner1.next();
        	System.out.println("Please Enter theguest_accompanying_members:");
        	int members=scanner1.nextInt();
        	System.out.println("Please Enter guest_payment_amount:");
        	int pay=scanner1.nextInt();

        	
        System.out.println(" Type number of room (number should be between 1-47)");
  		int room_id2 = scanner1.nextInt();

  		String sqlQuery_GetRoomId = "SELECT id From Rooms WHERE room_id =" + " '" + room_id2 + " '";
          try {
  			con = DriverManager.getConnection(url, user, pass);

  			st= con.createStatement();
  			ResultSet result2 = st.executeQuery(sqlQuery_GetRoomId);
             while(result2.next()) {
  	idOfRoom=result2.getInt("id");
           }
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
        
        
        
       
        	
		System.out.println(" Select one Hotel  ? " + " 1-W " + " 2-ParkINN" + " 3-Jumaira ");
		int hotel_id = scanner1.nextInt();
		String hotel_name = "";
		if (hotel_id > 1 && hotel_id < 8) {
			if (hotel_id == 2) {
				hotel_name = "W";
			} else if (hotel_id == 6) {
				hotel_name = "ParkINN";
			} else {
				hotel_name = "Jumaira";
			}
		}

		String sqlQuery_GetHotelId = "SELECT id From Hotels WHERE hotel_name =" + " '" + hotel_name + " '";
  
     try {
    	 con = DriverManager.getConnection(url, user, pass);
         st= con.createStatement();
 		ResultSet result = st.executeQuery(sqlQuery_GetHotelId);
		while(result.next()) {
		idOfHotelType=result.getInt("id");
		  }
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

		
          String sql = "insert into Guests(guest_name,guest_phone,guest_accompanying_members,guest_payment_amount,room_id,hotel_id,created_date,is_Active)values('"+GM+"','"+GP+"','"+members+"','"+pay+"','"+idOfRoom+"','"+idOfHotelType+"','" + date
				+ "',1)";
	

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface

			con = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			 st = con.createStatement();

			// Executing query
			int m = st.executeUpdate(sql);
			if (m >= 0)
				System.out.println("Data insearted successfully");
			else
				System.out.println("insert failed");

			con.close();
		} catch (Exception ex) {

			System.err.println(ex);

		}
	}}

}
