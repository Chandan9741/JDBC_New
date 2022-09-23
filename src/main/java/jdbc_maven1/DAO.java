package jdbc_maven1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	String path="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/jdbcprc";
	String username="root";
	String password="root";
	Connection con=null;
	public String savePerson(int id,String name,String address,long phone,int pincode) {
		String query="INSERT INTO person values(?,?,?,?,?)";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,id);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setLong(4, phone);
			ps.setInt(5, pincode);

			int a=ps.executeUpdate();
			if(a==1) {
				return "saved";
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		return "not saved";
	}
	
	public String updatePerson(int id,String name,String address,long phone,int pincode) {
		String query="UPDATE person set name=?,address=?,phone=?,pincode=? where id=?";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);

			ps.setString(1, name);
			ps.setString(2, address);
			ps.setLong(3, phone);
			ps.setInt(4, pincode);
			ps.setInt(5,id);

			int a=ps.executeUpdate();
			if(a==1)
				return "updated";


		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		return "not updated";
	}
	public String deleteperson(int id) {
		String query="delete from person where id=?";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);

			ps.setInt(1, id);

			int a=ps.executeUpdate();

			return "deleted";


		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		return "not deleted";
	}
	public ResultSet getPerson(int id) {
		String query="SELECT * from person where id=?";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);

			ps.setInt(1, id);

			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));
				System.out.println(rs.getInt(5));
			}

			return rs;


		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		return null;
	}
}