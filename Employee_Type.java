import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Random;
import java.util.Scanner;

public class Employee_Type {

	
	
	  public static void createdtable5() {
	    	
			 String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		     String user = "sa";
		     String pass = "root";
		     Scanner scanner = new Scanner(System.in);
      
		     String Sql = "CREATE TABLE Employee_Type " + "(id INTEGER PRIMARY KEY IDENTITY(1,1), " + " employee_type_name VARCHAR(50) NOT NULL, "
						+ " created_date date NOT NULL, " + " updated_date date, " + " is_Active bit NOT NULL)";


      Connection con = null;

      try {

          Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
     
          DriverManager.registerDriver(driver);

 
          con = DriverManager.getConnection(url, user,
                  pass);

 
          Statement st = con.createStatement();

 
          int m = st.executeUpdate(Sql);
          if (m >=  0)
              System.out.println("Employee Type table Created successfully");
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
 	         String sql="SELECT * FROM Employee_Type";
 		     ResultSet result=st.executeQuery(sql);
 		     while(result.next()&&count<userinput) {
 		    	 int Hid=result.getInt("id");
 		    	 String Ename=result.getString("employee_type_name");
 		    	 Date CD=result.getDate("created_date");
 		    	 Date UD=result.getDate("updated_date");
 		    	 boolean Activated=result.getBoolean("is_Active");
 		    	 
    	  System.out.println(Hid+" "+Ename+" "+CD+" "+UD+" "+Activated);
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
 	       
 	         System.out.println("Please Enter any id to display Employee type data :");
 	         int userinput =scanner.nextInt();
 	         
 	         
 	         
 	         String sql="SELECT * FROM Employee_type WHERE id='"+userinput+"'";
 		     ResultSet result=st.executeQuery(sql);
 		     while(result.next()) {
 		    	 int Hid=result.getInt("id");
 		    	 String Ename=result.getString("employee_type_name");
 		    	 Date CD=result.getDate("created_date");
 		    	 Date UD=result.getDate("updated_date");
 		    	 boolean Activated=result.getBoolean("is_Active");
 		    	 
    	  System.out.println(Hid+" "+Ename+" "+CD+" "+UD+" "+Activated);
    	 
       
       
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
 	      
 	         System.out.println("Please Enter any id to Update employee type data :");
 	         int userinput =scanner.nextInt();
 	         System.out.println("Please Enter the new employee type name:");
 	         String Etn=scanner.next();
 	      
 	
 	      
 	         String sql="UPDATE Employee_type SET employee_type_name='"+Etn+"' WHERE id='"+userinput+"'";
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
       
          System.out.println("Please Enter any id to delete employee type  data :");
          int userinput =scanner.nextInt();
       

       
          String sql="DELETE From Employee_type WHERE id='"+userinput+"'";
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
    


         String sql="UPDATE Employee_type SET is_Active='false' WHERE id='"+userinput+"'";
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
          Random rn = new Random();
          Integer numberToAdd = rn.nextInt(100);
          String employee_type_name="Reception";
          boolean is_Active=true;
         
          for(int i=0; i<=userinput;i++) {
          String sql = "insert into Employee_type values ("+numberToAdd+", '"+employee_type_name+i+"','"+date+"', '"+date+"', '"+is_Active+"')";
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
     
      
      
             		    }
             		 
             		 
   
