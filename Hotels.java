import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;


public class Hotels {
	
	
	 public static void createdtable1() {
    	
	 String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
     String user = "sa";
     String pass = "root";
     Scanner scanner1=new Scanner(System.in);
    
     
     //creating first table
     String Sql = "CREATE TABLE Hotels " + "(id INTEGER PRIMARY KEY IDENTITY(1,1), " + " hotel_name VARCHAR(50) NOt NULL, "
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
	         String sql="SELECT * FROM Hotels";
		     ResultSet result=st.executeQuery(sql);
		     while(result.next()&&count<userinput) {
		    	 int Hid=result.getInt("id");
		    	 String Hname=result.getString("hotel_name");
		    	 String Hlocation=result.getString("hotel_location");
		    	 Date CD=result.getDate("created_date");
		    	 Date UD=result.getDate("updated_date");
		    	 boolean Activated=result.getBoolean("is_Active");
		    	 
   	  System.out.println(Hid+" "+Hname+" "+Hlocation+" "+CD+" "+UD+" "+Activated);
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
	       
	         System.out.println("Please Enter any id to display hotel data :");
	         int userinput =scanner.nextInt();
	         
	         
	         
	         String sql="SELECT * FROM Hotels WHERE id='"+userinput+"'";
		     ResultSet result=st.executeQuery(sql);
		     while(result.next()) {
		    	 int Hid=result.getInt("id");
		    	 String Hname=result.getString("hotel_name");
		    	 String Hlocation=result.getString("hotel_location");
		    	 Date CD=result.getDate("created_date");
		    	 Date UD=result.getDate("updated_date");
		    	 boolean Activated=result.getBoolean("is_Active");
		    	 
   	  System.out.println(Hid+" "+Hname+" "+Hlocation+" "+CD+" "+UD+" "+Activated);
   	 
      
      
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
	      
	         System.out.println("Please Enter any id to Update hotel data :");
	         int userinput =scanner.nextInt();
	         System.out.println("Please Enter the new Hotel name:");
	         String hotelname=scanner.next();
	         System.out.println("Please Enter the new Hotel location:");
	         String hotellocatin=scanner.next();
	
	      
	         String sql="UPDATE Hotels SET hotel_name='"+hotelname+"',hotel_location='"+hotellocatin+"' WHERE id='"+userinput+"'";
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
      
         System.out.println("Please Enter any id to delete hotel data :");
         int userinput =scanner.nextInt();
      

      
         String sql="DELETE From Hotels WHERE id='"+userinput+"'";
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
   


        String sql="UPDATE Hotels SET is_Active='false' WHERE id='"+userinput+"'";
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
         Date date=new Date(System.currentTimeMillis());
    	 Scanner scanner=new Scanner(System.in);
     	System.out.println("Please type the number of rows");
         int userinput =scanner.nextInt();
         String hotel_name="ParkINN";
         String hotel_location="Muscat";
   ;
         boolean is_Active=true;
         Random rn = new Random();
         Integer numberToAdd = rn.nextInt(100);
         for(int i=0; i<=userinput;i++) {
         String sql = "insert into Hotels values ('"+hotel_name+i+"', '"+hotel_location+i+"', '"+date+"', '"+date+"', '"+is_Active+"')";
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
    	 
     }}}
    
     
         public static void insert10000IntoTable(){
        	 
        	 String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
             String user = "sa";
             String pass = "root";
             
        	 Scanner scanner=new Scanner(System.in);
             String hotel_name="Plaza";
             String hotel_location="Seeb";
             String created_date="1996-03-01";
             String updated_date="1996-08-02";
             boolean is_Active=true;
             Random rn = new Random();
             Integer numberToAdd = rn.nextInt(100);
             for(int i=0; i<=10000;i++) {
             String sql = "insert into Hotels values ("+i+numberToAdd+", '"+hotel_name+i+"', '"+hotel_location+i+"', '"+created_date+"', '"+updated_date+"', '"+is_Active+"')";
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
        	 
         }}}
             
             public static void insert1IntoTable(){
            	 
            	 String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
                 String user = "sa";
                 String pass = "root";
                 
            	 Scanner scanner=new Scanner(System.in);
                 String hotel_name="Plaza";
                 String hotel_location="Seeb";
                 String created_date="1996-03-01";
                 String updated_date="1996-08-02";
                 boolean is_Active=true;
                 Random rn = new Random();
                 Integer numberToAdd = rn.nextInt(100);
                 for(int i=0; i<=1;i++) {
                 String sql = "insert into Hotels values ("+i+numberToAdd+", '"+hotel_name+i+"', '"+hotel_location+i+"', '"+created_date+"', '"+updated_date+"', '"+is_Active+"')";
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
            	 
             }}}
                 
            	 public static void read10FromTable(int userinput){
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
            	         int count=0;
            	         String sql="SELECT * FROM Hotels";
            		     ResultSet result=st.executeQuery(sql);
            		     while(result.next()&&count<10) {
            		    	 int Hid=result.getInt("id");
            		    	 String Hname=result.getString("hotel_name");
            		    	 String Hlocation=result.getString("hotel_location");
            		    	 Date CD=result.getDate("created_date");
            		    	 Date UD=result.getDate("updated_date");
            		    	 boolean Activated=result.getBoolean("is_Active");
            		    	 
               	  System.out.println(Hid+" "+Hname+" "+Hlocation+" "+CD+" "+UD+" "+Activated);
               	  count++;
                  
                  
              }}
              catch (Exception ex) {

                  System.err.println(ex);
            	 
            }
        
     
     }
            	 public static void makeIsActiveFalse() {
            			
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
            		     
                            for(int i=0;i<10;i++) {
            		        String sql="UPDATE Hotels SET is_Active='false' WHERE id="+i;
            			     ResultSet result=st.executeQuery(sql);
                            }
            		 
            		}
            		catch (Exception ex) {

            		 System.err.println(ex);

            		}
            			
            			
            			
            		}
            	 public static void printinfo() {
            		 
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
            	      
            	         System.out.println("Please Enter the  Hotel name:");
            	         String hotelname=scanner.next();
            	         System.out.println("Please Enter the new Hotel location:");
            	         String hotellocatin=scanner.next();
            	
            	      
            	         String sql="UPDATE Hotels SET hotel_name='"+hotelname+"',hotel_location='"+hotellocatin+"'";
            		     ResultSet result=st.executeQuery(sql);
                  
                  
              }
              catch (Exception ex) {

                  System.err.println(ex);
            	 
            }
            		
            		    }
            		 
            		 
}           	 