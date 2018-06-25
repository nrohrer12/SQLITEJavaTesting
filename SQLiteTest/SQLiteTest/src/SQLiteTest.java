import java.sql.*;
import java.util.Scanner;

public class SQLiteTest {
	//Declare variables
	public static Scanner input = new Scanner(System.in);
	public static Statement stmt = null;
	public static Connection c = null;
	public static boolean newEntry = true;
	public static boolean hasConnection = false;
	

	public static void main(String[] args)throws Exception {
		
		//Attempt to connect to database
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);
			hasConnection = true;
			System.out.println("SQLITE DB connected");
			
			while (hasConnection)
			{
				if (newEntry)
				{
					newEntry = false;
					
					stmt = c.createStatement();		
					ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");
					
					while (rs.next() ) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						int age = rs.getInt("age");
						String address = rs.getString("address");
						float salary = rs.getFloat("salary");
						
						System.out.println( "ID = " + id );
				         System.out.println( "NAME = " + name );
				         System.out.println( "AGE = " + age );
				         System.out.println( "ADDRESS = " + address );
				         System.out.println( "SALARY = " + salary );
				         System.out.println();
				         //End While
					}
					
					
					 rs.close();
					  stmt.close();
					System.out.println("---------------------------------------------");
					 // c.close();
					  System.out.println("Please Enter a SQL command:");
					  String sql = input.nextLine();
					  stmt.executeUpdate(sql);
					  stmt.close();
						c.commit();
						newEntry = true;
						System.out.println("----------------------------------------------");
				}
				
				
				
				//End While
			}
					
			
			 //End Try
		} 
		
		
		catch (Exception e) {
			System.out.println(e);
			//End Catch
		}
		
		
			//End Main
		}

	
	
	
	
	
	
	
	
}
