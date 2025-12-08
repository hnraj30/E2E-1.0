package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteQueryJDBC {
	public static void main(String[]args) throws SQLException
	{
		Driver driver = new Driver();
		//Register Driver
		DriverManager.registerDriver(driver);
		
		//Get connection to the database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb","root","root");
		
		//Issue create statement
		Statement st = con.createStatement();
		
		//Execute query
		ResultSet result = st.executeQuery("select * from customerinfo where id=4;");
		
		while(result.next())
		{
			String value = result.getString(1)+"		"+result.getString(2)+"			"+result.getString(3);
			System.out.println(value);
		}
		
		//Close the database
		con.close();
		
	}

}
