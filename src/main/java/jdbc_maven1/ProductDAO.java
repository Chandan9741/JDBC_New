package jdbc_maven1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	String path="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/jdbcprc";
	String username="root";
	String password="root";
	Connection con=null;

	public Product saveProduct(Product p) {
		String query="INSERT INTO product values(?,?,?,?,?,?,?,?)";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setDouble(3,p.getPrice());
			ps.setString(4, p.getManufacturer());
			ps.setInt(5,p.getDiscount());
			ps.setInt(6, p.getWarrenty());
			ps.setInt(7,p.getDate());
			ps.setDouble(8, p.getGst());

			int a=ps.executeUpdate();
			return p;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public Product updateProduct(Product p) {
		String query="UPDATE product set productname=?,price=?,manufacturer=?,discount=?,warrenty=?,manufdate=?,GST=? where productid=?";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setString(3,p.getManufacturer());
			ps.setInt(4, p.getDiscount());
			ps.setInt(5, p.getWarrenty());
			ps.setInt(6, p.getDate());
			ps.setDouble(7,p.getGst());
			ps.setInt(8, p.getId());

			int a=ps.executeUpdate();
			return p;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public String deleteProduct(int id) {
		String query="delete from product where productid=?";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);

			ps.setInt(1,id);
			int b=ps.executeUpdate();
			return "deleted";
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public Product getProduct(int id) {
		String query="Select * from product where productid=?";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			Product pd=new Product();
			while(rs.next()) {
				pd.setId(rs.getInt(1));
				pd.setName(rs.getString(2));
				pd.setPrice(rs.getDouble(3));
				pd.setManufacturer(rs.getString(4));
				pd.setDiscount(rs.getInt(5));
				pd.setWarrenty(rs.getInt(6));
				pd.setDate(rs.getInt(7));
				pd.setGst(rs.getDouble(8));

			}
			return pd;


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public List<Product> getAllProduct() {
		String query="SELECT * from product";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			List<Product> list=new ArrayList<Product>();
			while(rs.next()) {
				Product p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setManufacturer(rs.getString(4));
				p.setDiscount(rs.getInt(5));
				p.setWarrenty(rs.getInt(6));
				p.setDate(7);
				p.setGst(rs.getDouble(8));
				
				list.add(p);
			}
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
