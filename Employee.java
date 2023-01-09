import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Employee {
	
	  public static Connection con;
	  public static void createdtable6() {
	    	
			 String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		     String user = "sa";
		     String pass = "root";
		     Scanner scanner = new Scanner(System.in);
      
		     String Sql = "CREATE TABLE Employee " + "(id INTEGER PRIMARY KEY IDENTITY(1,1), " + " employee_type_id INTEGER FOREIGN KEY REFERENCES Employee_Type(id), "
						+ " room_id INTEGER FOREIGN KEY REFERENCES Rooms(id), " + " created_date date NOT NULL, " + " updated_date date, "+" is_Active bit NOT NULL)";
    
          Connection con = null;

          try {

              Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
         
              DriverManager.registerDriver(driver);

     
              con = DriverManager.getConnection(url, user,
                      pass);

     
              Statement st = con.createStatement();

     
              int m = st.executeUpdate(Sql);
              if (m >=  0)
                  System.out.println("Employee table Created successfully");
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
      	         String sql="SELECT * FROM Employee";
      		     ResultSet result=st.executeQuery(sql);
      		     while(result.next()&&count<userinput) {
      		    	 int Hid=result.getInt("id");
      		    	 int EI=result.getInt("employee_type_id");
      		    	 int RI=result.getInt("room_id");
      		    	 Date CD=result.getDate("created_date");
      		    	 Date UD=result.getDate("updated_date");
      		    	 boolean Activated=result.getBoolean("is_Active");
      		    	 
         	  System.out.println(Hid+" "+EI+" "+RI+" "+CD+" "+UD+" "+Activated);
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
      	       
      	         System.out.println("Please Enter any id to display Employee data :");
      	         int userinput =scanner.nextInt();
      	         
      	         
      	         
      	         String sql="SELECT * FROM Employee WHERE id='"+userinput+"'";
      		     ResultSet result=st.executeQuery(sql);
      		     while(result.next()) {
      		    	 int Hid=result.getInt("id");
      		    	 int EI=result.getInt("employee_type_id");
      		    	 int RI=result.getInt("room_id");
      		    	 Date CD=result.getDate("created_date");
      		    	 Date UD=result.getDate("updated_date");
      		    	 boolean Activated=result.getBoolean("is_Active");
      		    	 
         	  System.out.println(Hid+" "+EI+" "+RI+" "+CD+" "+UD+" "+Activated);
         	 
            
            
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
      	      
      	         System.out.println("Please Enter any id to Update employee data :");
      	         int userinput =scanner.nextInt();
//      	         System.out.println("Please Enter the new created date:");
//      	         String Etn=scanner.next();
//      	      
//      	
//      	      
//      	         String sql="UPDATE Employee_type SET employee_type_name='"+Etn+"' WHERE id='"+userinput+"'";
//      		     ResultSet result=st.executeQuery(sql);
//            
            
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
            
               System.out.println("Please Enter any id to delete employee data :");
               int userinput =scanner.nextInt();
            

            
               String sql="DELETE From Employee WHERE id='"+userinput+"'";
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
         


              String sql="UPDATE Employee SET is_Active='false' WHERE id='"+userinput+"'";
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
  		int idOfEmployeeType=1;
  		Integer idOfRoom =1;
  		boolean is_Active = true;
  		Random rn = new Random();
  		Integer numberToAdd = rn.nextInt(100);

  		Scanner scanner1 = new Scanner(System.in);
          System.out.println("Please Enter the number of rows ");
          int userinput=scanner1.nextInt();
          for(int i=0;i<userinput;i++) {
  		System.out.println(" Select one Employee_Type  ? " + " 1-MANAGER " + " 2-ATTENDANT" + " 3-VALET  "+ "4-BUTLER"+ "5-DIRECTOR");
  		int Employee_type_id = scanner1.nextInt();
  		String Employee_name = "";
  		if (Employee_type_id > 1 && Employee_type_id < 8) {
  			if (Employee_type_id == 1) {
  				Employee_name = "MANAGER";
  			} else if (Employee_type_id == 2) {
  				Employee_name = "ATTENDANT";
  			} else if (Employee_type_id == 3) {
  				Employee_name = "VALET";
  			} else if (Employee_type_id == 6) {
  				Employee_name = "BUTLER";
  			} else {
  				Employee_name = "DIRECTOR";
  			}
  		}

  		String sqlQuery_GetEmployee_nameId = "SELECT id From Employee_Type WHERE Employee_type_name =" + " '" + Employee_name + " '";
    
       try {
      	 con = DriverManager.getConnection(url, user, pass);
           st= con.createStatement();
   		ResultSet result = st.executeQuery(sqlQuery_GetEmployee_nameId);
  		while(result.next()) {
  			idOfEmployeeType=result.getInt("id");
  		  }
  	} catch (SQLException e1) {
  		// TODO Auto-generated catch block
  		e1.printStackTrace();
  	}

  		System.out.println(" Type number of room (number should be between 1-47)");
  		int room_id2 = scanner1.nextInt();
//  		String room_type_name = "";
//  		if (room_id > 0 && room_id < 48) {
//  			if (room_id == 1) {
//  				room_type_name = "STANDARD";
//  			} else if (room_id == 2) {
//  				room_type_name = "DELUXE";
//  			} else {
//  				room_type_name = "SUITE";
//  			}
//  		}

  		String sqlQuery_GetRoomId = "SELECT id From Employee WHERE room_id =" + " '" + room_id2 + " '";
          try {
  			st= con.createStatement();
  			ResultSet result2 = st.executeQuery(sqlQuery_GetRoomId);
             while(result2.next()) {
  	idOfRoom=result2.getInt("id");
           }
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		
            String sql = "insert into Employee(employee_type_id,room_id,created_date,is_Active)values('"+idOfEmployeeType+"','"+room_id2+"','" + date
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
  	}}}
