package jdbc_maven1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SaveStudent {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc", "root", "root");
			CallableStatement cs=con.prepareCall("call save_student(?,?,?,?,?)");
			cs.setInt(1,100);
			cs.setString(2,"chandu");
			cs.setLong(3,2165215);
			cs.setString(4,"BLR");
			cs.setInt(5,556);
			//4.
			cs.execute();
			System.out.println("Data saved");
			//5.
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
