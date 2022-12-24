import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class A11 {
	public static void main(String[] args) {
		
		//load the driver class
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					//create connection between the database and Java
					//connection will be represented by a Connection object
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/assignment?useSSL=false","root","password");
							
					//create Query statement
					// stored procedure or function is to be written inside {}
					CallableStatement s= con.prepareCall("{ call insertRec() }");
					 
					 
					 //execute query
					int i= s.executeUpdate() ;
					 System.out.println(i+" rows updated");
					//close statement
					 s.close();
					
					 //close connection
					 con.close();
					 
				} catch (ClassNotFoundException | SQLException e) {
					
					e.printStackTrace();
				}
		        System.out.println("Done");
			}

}
