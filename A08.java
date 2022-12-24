import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class A08 {
public static void main(String[] args) {
		
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					//create connection between the database and Java
					//connection will be represented by a Connection object
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/assignment?useSSL=false","root","password");
							
					//create Query statement
					 Statement s = con.createStatement();
					 
					 
					 //execute query
					 
					 ResultSet rs=s.executeQuery("SELECT avg(marks) as AveragaMark from student");
						System.out.println("Average marks of the total students:");
						while (rs.next())
						{
							System.out.println(rs.getInt(1));
							
						}
					//close statement
					 s.close();
					 //close connection
					 con.close();
					
					 
				} catch (ClassNotFoundException | SQLException e) {
					
					e.printStackTrace();
				}
	}
}
