import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
		 
		 Hotels hotel=new Hotels();
		 Scanner scanner = new Scanner(System.in);
	
	  
		    System.out.println("Choose One Option :");
		    
	        System.out.println("1-Insert 10,000 hotels");
	        System.out.println("2-Insert 1 hotel");
	        System.out.println("3-Print 10 hotels");
	        System.out.println("4-Make first 10 hotels 'is_Active' = false");
	        System.out.println("5-Print hotel information by user input");
	        int option=scanner.nextInt();
	        
	        
	        switch(option) {
	        
	        case 1:
//	        	Hotels.createdtable1();
//	        	Room_Type.createdtable2();
//	        	Room.createdtable3();
//	        	Guests.createdtable4();
        	Employee.insertIntoTable();
 	         //Hotels.insert10000IntoTable();
	             break;
	        case 2:
	        
	        	Hotels.insert1IntoTable();
	             break;
	        case 3:
	        
	             Hotels.read10FromTable(10);
	             break;
	        case 4:
	        	Hotels.makeIsActiveFalse();
	        	
	             break;
		       
	        case 5:
	        	Hotels.printinfo();
		        
	   
	        		         	     

	        }   
	             
	            
	  	           
		      
		  	         
		  	             
		  	           

		
	}
	
	

}
