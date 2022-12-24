import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class A07 {

	public static void main(String[] args) {
		
		//Taking INPUT
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter rno:");
				int rno=sc.nextInt();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					//create connection between the database and Java
					//connection will be represented by a Connection object
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/assignment?useSSL=false","root","password");
							
					//create Query statement
					 Statement s = con.createStatement();
					 
					 
					 //execute query
					 
					 ResultSet rs=s.executeQuery("SELECT* from student where rno="+rno);
						
						while (rs.next())
						{
							System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+ rs.getFloat(3)+" "+ rs.getString(4));
							
						}
					//close statement
					 s.close();
					 //close connection
					 con.close();
					 sc.close();
					 
				} catch (ClassNotFoundException | SQLException e) {
					
					e.printStackTrace();
				}
	}

}
