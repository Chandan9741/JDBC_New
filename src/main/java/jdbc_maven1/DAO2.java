package jdbc_maven1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO2 {
	String path="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/jdbcprc";
	String username="root";
	String password="root";
	Connection con=null;
	public String savePersonObj(Person p) {
		String query="INSERT INTO person values(?,?,?,?,?)";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,p.getId());
			ps.setString(2, p.getName());
			ps.setString(3, p.getAddress());
			ps.setLong(4, p.getPhone());
			ps.setInt(5, p.getPin());

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
	public String updatePersonObj(Person p) {
		String query="UPDATE person set name=?,address=?,phone=?,pincode=? where id=?";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);

			ps.setString(1, p.getName());
			ps.setString(2, p.getAddress());
			ps.setLong(3, p.getPhone());
			ps.setInt(4, p.getPin());
			ps.setInt(5,p.getId());

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
	public Person getPerson(int id) {
		String query="SELECT * from person where id=?";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);

			ps.setInt(1, id);

			ResultSet rs=ps.executeQuery();
			Person person=new Person();
			
			while(rs.next()) {
				person.setId(rs.getInt(1));
				person.setName(rs.getString(2));
				person.setAddress(rs.getString(3));
				person.setPhone(rs.getLong(4));
				person.setPin(rs.getInt(5));
			}

			return person;


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
