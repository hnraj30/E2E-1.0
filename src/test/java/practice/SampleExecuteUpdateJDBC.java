package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteUpdateJDBC {
	public static void main(String[]args) throws SQLException
	{
		//Register driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Get connection with the database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb","root","root");
		
		//Issue create statement
		Statement st = con.createStatement();
		
		//Execute query
		String query = "insert into customerinfo(name,id,address) values('Jackson',4,'Okinava');";
		int result = st.executeUpdate(query);
		
		if(result==1)
		{
			System.out.println("Data added successfuly");
		}
			
		//close the connection
		con.close();
		
		
		
		
	}

}
