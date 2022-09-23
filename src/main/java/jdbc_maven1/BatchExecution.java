package jdbc_maven1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatchExecution {

	public static void main(String[] args) {
		List<Person> l=new ArrayList<Person>();
		Person p1=new Person(4,"dfv","vv",661848,4444);
		Person p2=new Person(5,"fvv","ff",51884,6955);
		Person p3=new Person(6,"fbf","db",84844,1481);
		Person p4=new Person(7,"fv","fbf",9854,621561);
		
		l.add(p1);
		l.add(p2);
		l.add(p3);
		l.add(p4);
	System.out.println(l);
	
	//JDBC code
	
	String path="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/jdbcprc";
	String username="root";
	String password="root";
	Connection con=null;
	String query="INSERT INTO person values(?,?,?,?,?)";
	
	try {
		Class.forName(path);
		con=DriverManager.getConnection(url, username, password);

		PreparedStatement ps=con.prepareStatement(query);
		for(Person p: l) {
		ps.setInt(1,p.getId());
		ps.setString(2,p.getName());
		ps.setString(3,p.getAddress());
		ps.setLong(4,p.getPhone());
		ps.setInt(5,p.getPin());
		
		ps.addBatch();
		}
        ps.executeBatch();
        System.out.println("All details entered");
        
		


	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	}

}
