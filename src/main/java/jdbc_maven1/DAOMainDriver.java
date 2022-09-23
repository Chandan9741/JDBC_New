package jdbc_maven1;

import java.sql.ResultSet;
import java.util.Scanner;

public class DAOMainDriver {

	public static void main(String[] args) {
		DAO dao=new DAO();
		Scanner s=new Scanner(System.in);
		boolean data=true;
		while(data) {
		System.out.println("Enter the choice");
		System.out.println("1.save person\n2.Update person\n3.Delete person\n4.Get person");
		int choice=s.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter the id");
			int id=s.nextInt();
			System.out.println("Enter the name");
			String name=s.next();
			System.out.println("Enter the address");
			String address=s.next();
			System.out.println("Enter the phoneno");
			Long phone=s.nextLong();
			System.out.println("Enter the pincode");
			int pincode=s.nextInt();


			String v=dao.savePerson(id,name,address,phone,pincode);
			System.out.println(v);
			break;
		case 2:
			System.out.println("Enter the id");
			int id1=s.nextInt();
			System.out.println("Enter the name");
			String name1=s.next();
			System.out.println("Enter the address");
			String address1=s.next();
			System.out.println("Enter the phoneno");
			Long phone1=s.nextLong();
			System.out.println("Enter the pincode");
			int pincode1=s.nextInt();

			String a=dao.updatePerson(id1, name1, address1, phone1, pincode1);
			System.out.println(a);
			break;
		case 3: 
			System.out.println("Enter the id to delete");
			int id3=s.nextInt();

			String s1=dao.deleteperson(id3);
			System.out.println(s1);
			break;
		case 4:
			System.out.println("Enter the id to get person");
			int id4=s.nextInt();

			ResultSet g=dao.getPerson(id4);
			System.out.println(g);
			break;
		default:System.out.println("Invalid choice");	

		}

	}

}
}