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
	        System.out.println("4-Add a new Subject");
	        System.out.println("5-Make first 10 hotels 'is_Active' = false");
	        System.out.println("6-Print hotel information by user input");
	        int option=scanner.nextInt();
	        
	        
	        switch(option) {
	        
	        case 1:
	        	Hotels.updateById();
	        	
	             break;
	        case 2:
	        	Hotels.insertIntoTable();
	             break;
	        case 3:
	     
	             break;
	        case 4:
	        	
	             break;
	        case 5:
	        
	             break;
		       
	        case 6:
		        
	   
	        		         	     

	        }   
	             
	            
	  	           
		      
		  	         
		  	             
		  	           

		
	}
	
	

}
