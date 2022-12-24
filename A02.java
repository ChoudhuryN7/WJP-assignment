import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A02 {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?useSSL=false","root","password");
			
			Statement s =con.createStatement();
			
			int i= s.executeUpdate("insert into student values(7,'Yakuza',11,'1980-01-01')");
			 System.out.println(i+" rows inserted");
			
			//close statement
			 s.close();
			 //close connection
			 con.close();
			 
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}

}
