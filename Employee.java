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

		String Sql = "CREATE TABLE Employee " + "(id INTEGER PRIMARY KEY IDENTITY(1,1), "
				+ " employee_type_id INTEGER FOREIGN KEY REFERENCES Employee_Type(id), "
				+ " room_id INTEGER FOREIGN KEY REFERENCES Rooms(id), " + " created_date date NOT NULL, "
				+ " updated_date date, " + " is_Active bit NOT NULL)";

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();

			int m = st.executeUpdate(Sql);
			if (m >= 0)
				System.out.println("Employee table Created successfully");
			else
				System.out.println("Creation failed");

			con.close();
		}

		catch (Exception ex) {

			System.err.println(ex);
		}
	}

	public static void readFromTable(int userinput) {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner scanner = new Scanner(System.in);

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			Statement st = con.createStatement();
			System.out.println("Please Enter the number of rows :");
			userinput = scanner.nextInt();
			int count = 0;
			String sql = "SELECT * FROM Employee";
			ResultSet result = st.executeQuery(sql);
			while (result.next() && count < userinput) {
				int Hid = result.getInt("id");
				int EI = result.getInt("employee_type_id");
				int RI = result.getInt("room_id");
				Date CD = result.getDate("created_date");
				Date UD = result.getDate("updated_date");
				boolean Activated = result.getBoolean("is_Active");

				System.out.println(Hid + " " + EI + " " + RI + " " + CD + " " + UD + " " + Activated);
				count++;

			}
		} catch (Exception ex) {

			System.err.println(ex);

		}
	}
	////////////////////////////////////////////////////////////////////

	public static void getById() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner scanner = new Scanner(System.in);

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			Statement st = con.createStatement();

			System.out.println("Please Enter any id to display Employee data :");
			int userinput = scanner.nextInt();

			String sql = "SELECT * FROM Employee WHERE id='" + userinput + "'";
			ResultSet result = st.executeQuery(sql);
			while (result.next()) {
				int Hid = result.getInt("id");
				int EI = result.getInt("employee_type_id");
				int RI = result.getInt("room_id");
				Date CD = result.getDate("created_date");
				Date UD = result.getDate("updated_date");
				boolean Activated = result.getBoolean("is_Active");

				System.out.println(Hid + " " + EI + " " + RI + " " + CD + " " + UD + " " + Activated);

			}
		} catch (Exception ex) {

			System.err.println(ex);

		}
	}

	/////////////////////////////////////////////////////////////
	public static void updateById() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner scanner = new Scanner(System.in);

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			Statement st = con.createStatement();

			System.out.println("Please Enter any id to Update employee data :");
			int userinput = scanner.nextInt();
//      	         System.out.println("Please Enter the new created date:");
//      	         String Etn=scanner.next();
//      	      
//      	
//      	      
//      	         String sql="UPDATE Employee_type SET employee_type_name='"+Etn+"' WHERE id='"+userinput+"'";
//      		     ResultSet result=st.executeQuery(sql);
//            

		} catch (Exception ex) {

			System.err.println(ex);

		}

	}
	////////////////////////////////////////////////////////////////////////////////

	public static void deleteById() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner scanner = new Scanner(System.in);

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			Statement st = con.createStatement();

			System.out.println("Please Enter any id to delete employee data :");
			int userinput = scanner.nextInt();

			String sql = "DELETE From Employee WHERE id='" + userinput + "'";
			ResultSet result = st.executeQuery(sql);

		} catch (Exception ex) {

			System.err.println(ex);

		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	public static void makeIsActiveFalseById() {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner scanner = new Scanner(System.in);

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			Statement st = con.createStatement();

			System.out.println("Please Enter any id to Update the status :");
			int userinput = scanner.nextInt();

			String sql = "UPDATE Employee SET is_Active='false' WHERE id='" + userinput + "'";
			ResultSet result = st.executeQuery(sql);

		} catch (Exception ex) {

			System.err.println(ex);

		}

	}

	/////////////////////////////////////////////////////////////////////////////////

	public static void insertIntoTable() {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Statement st = null;
		Integer idForEmployeeType = 1;
		Integer idForRoomType = 1;
		Integer idForHotel = 1;
		Integer idForRoom = 1;
		Date date = new Date(System.currentTimeMillis());
		int idOfEmployeeType = 1;
		Integer idOfRoom = 1;
		boolean is_Active = true;
		Random rn = new Random();
		
		Integer numberToAdd = rn.nextInt(100);

		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Please Enter the number of rows ");
		int userinput = scanner1.nextInt();
		for (int i = 0; i < userinput; i++) {
			System.out.println(" Select one Employee_Type  ? " + " 1-MANAGER " + " 2-ATTENDANT" + " 3-VALET  "
					+ "4-BUTLER" + "5-DIRECTOR");
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

			String sqlQuery_GetEmployee_nameId = "SELECT id From Employee_Type WHERE Employee_type_name =" + " '"
					+ Employee_name + " '";

			try {
				con = DriverManager.getConnection(url, user, pass);
				st = con.createStatement();
				ResultSet resultSet = st.executeQuery(sqlQuery_GetEmployee_nameId);
				while (resultSet.next()) {
					idForEmployeeType = resultSet.getInt("id");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			System.out.println(" Which Room Type Do You Want ? " + " 1 : STANDARD " + " 3 : DELUXE" + " 4 : SINGLE");
			int roomType = scanner1.nextInt();
			String roomTypeName = "";
			if (roomType > 0 && roomType < 6) {
				if (roomType == 1) {
					roomTypeName = "STANDARD";
				} else if (roomType == 3) {
					roomTypeName = "DELUXE";
				} else {
					roomTypeName = "SINGLE";
				}
			}
			String sqlQueryToGetRoomTypeId = "SELECT id From Room_Type WHERE room_type_name =" + " '" + roomTypeName
					+ " '";
			try {
			
				con = DriverManager.getConnection(url, user, pass);
				st = con.createStatement();
				ResultSet resultSet = st.executeQuery(sqlQueryToGetRoomTypeId);
				while (resultSet.next()) {
					idForRoomType = resultSet.getInt("id");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
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
				String sqlQueryToGetHotelId = "SELECT id From Hotels WHERE hotel_name =" + " '" + hotel_name + " '";
				try {
					con = DriverManager.getConnection(url, user, pass);
					st = con.createStatement();
					ResultSet resultSet = st.executeQuery(sqlQueryToGetHotelId);
					while (resultSet.next()) {
						idForHotel = resultSet.getInt("id");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				String sqlQueryToGetRoomlId = "SELECT id From Rooms WHERE hotel_id =" + idForHotel
						+ " AND room_type_id = " + idForRoomType;
				try {
					con = DriverManager.getConnection(url, user, pass);
					st = con.createStatement();
					ResultSet resultSet = st.executeQuery(sqlQueryToGetHotelId);
					while (resultSet.next()) {
						idForRoom = resultSet.getInt("id");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				String sqlQueryToInsert = "INSERT INTO Employee (employee_type_id,room_id ,created_date,is_Active)"
						+ "Values (" + idForEmployeeType + "," + idForRoom + ",'" + date + "'," + 1 + ")";
				System.out.println("This is the query to insert into Employee table: " + sqlQueryToInsert);
				try {
				
					st = con.createStatement();
					con = DriverManager.getConnection(url, user, pass);
					ResultSet e = st.executeQuery(sqlQueryToInsert);
					System.out.println(sqlQueryToInsert);
				} catch (SQLException e1) {
					System.out.println(e1.getLocalizedMessage());
				}
			}
		}
	}

