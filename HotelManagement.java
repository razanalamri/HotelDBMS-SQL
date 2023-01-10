import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class HotelManagement {

	public static void main(String[] args) {

		// endByE();
		// guestsPayingmorethan1000();
		// DELUXErooms();
		// GuestsHavingAInThierNames();
		// isActive0();
		HotelsH();

	}

	public static void endByE() {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner scanner1 = new Scanner(System.in);

		Connection con = null;
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			Statement st = con.createStatement();

			String Sql = "select * from Guests where guest_name like '%e'";
			ResultSet result = st.executeQuery(Sql);
			while (result.next()) {
				String guestname = result.getString("guest_name");

				System.out.println(guestname);

				// Executing query
				int m = st.executeUpdate(Sql);

				con.close();
			}
		} catch (Exception ex) {

			System.err.println(ex);
		}
	}

	public static void guestsPayingmorethan1000() {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner scanner1 = new Scanner(System.in);

		Connection con = null;
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			Statement st = con.createStatement();

			String Sql = "SELECT guest_name FROM Guests INNER JOIN Rooms ON Guests.hotel_id=Rooms.hotel_id WHERE  guest_payment_amount>1000";

			ResultSet result = st.executeQuery(Sql);
			while (result.next()) {
				String guestname = result.getString("guest_name");

				System.out.println(guestname);

			}
		} catch (Exception ex) {

			System.err.println(ex);
		}
	}

	public static void DELUXErooms() {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner scanner1 = new Scanner(System.in);

		Connection con = null;
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			Statement st = con.createStatement();

			String Sql = "SELECT COUNT(*) as 'count' FROM Guests INNER JOIN Rooms ON Guests.hotel_id=Rooms.hotel_id WHERE  room_type_id=2";

			ResultSet result = st.executeQuery(Sql);
			while (result.next()) {
				int guestnumber = result.getInt("count");

				System.out.println(guestnumber);

			}
		} catch (Exception ex) {

			System.err.println(ex);
		}
	}

	public static void GuestsHavingAInThierNames() {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner scanner1 = new Scanner(System.in);

		Connection con = null;
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			Statement st = con.createStatement();

			String Sql = "select * from Guests where guest_name like '%A%'";
			ResultSet result = st.executeQuery(Sql);
			while (result.next()) {
				String guestname = result.getString("guest_name");

				System.out.println(guestname);

			}
		} catch (Exception ex) {

			System.err.println(ex);
		}
	}

	public static void isActive0() {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner scanner1 = new Scanner(System.in);

		Connection con = null;
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			Statement st = con.createStatement();

			String Sql = "Select * from Rooms where room_type_id=2 AND is_Active=0";
			ResultSet result = st.executeQuery(Sql);
			while (result.next()) {
				int Rid = result.getInt("id");
				String Rtype = result.getString("room_type_id");
				String Rhtype = result.getString("hotel_id");
				Date CD = result.getDate("created_date");
				Date UD = result.getDate("updated_date");
				boolean Activated = result.getBoolean("is_Active");

				System.out.println(Rid + " " + Rtype + " " + Rhtype + " " + CD + " " + UD + " " + Activated);

			}
		} catch (Exception ex) {

			System.err.println(ex);
		}
	}

	public static void HotelsH() {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDBMS;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner scanner1 = new Scanner(System.in);

		Connection con = null;
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			Statement st = con.createStatement();

			String Sql ="SELECT room_type_name FROM Room_Type JOIN Rooms ON Room_Type.id = Rooms.room_type_id JOIN Hotels ON Rooms.hotel_id = Hotels.id WHERE Hotels.hotel_name LIKE '%H%' OR (Hotels.is_Active = 1 AND Rooms.id >5)";
					

			ResultSet result = st.executeQuery(Sql);
			while (result.next()) {
		
				String roomTypeName = result.getString("room_type_name");

				System.out.println(roomTypeName);

			}
		} catch (Exception ex) {

			System.err.println(ex);
		}
	}

}