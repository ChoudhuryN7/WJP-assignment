import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A01 {

	public static void main(String[] args) {
		
		//registering driver and loading the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
         // getting connection
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306?useSSL=false","root","password");
			
			
			//create Query statement
			 Statement s = con.createStatement();
			 
			 String query1 = "CREATE database Assignment";
			 String query2 =" use Assignment";
			 String query3 = "CREATE table student(rno int PRIMARY KEY,name VARCHAR(20),marks int ,dob VARCHAR(20))";
			 
			 
			 //adding multiple queries
			 s.addBatch(query1);
			 s.addBatch(query2);
			 s.addBatch(query3);
			 
			//Executing the query
			 s.executeBatch();
			 System.out.println("Assignment Database created! ");
			 System.out.println("Student table created! ");
			 
			 //closing resources
			 s.close();
			 con.close();
			 
			 
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Done");
		
		
		
	}

}
