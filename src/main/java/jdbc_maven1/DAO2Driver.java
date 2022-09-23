package jdbc_maven1;

import java.util.Scanner;

public class DAO2Driver {
	public static void main(String[] args) {

		DAO2 dao2=new DAO2();
		Person p=new Person();
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
				int pin=s.nextInt();


				//Person p=new Person();
				p.setId(id);
				p.setName(name);
				p.setAddress(address);
				p.setPhone(phone);
				p.setPin(pin);
				String m=dao2.savePersonObj(p);
				System.out.println(m);
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
				int pin1=s.nextInt();

				p.setId(id1);
				p.setName(name1);
				p.setAddress(address1);
				p.setPhone(phone1);
				p.setPin(pin1);
				String a=dao2.updatePersonObj(p);
				System.out.println(a);
				break;
			case 3: 
				System.out.println("Enter the id to delete");
				int id2=s.nextInt();

				String s1=dao2.deleteperson(id2);
				System.out.println(s1);
				break;
			case 4:
				System.out.println("Enter the id to get person");
				int id3=s.nextInt();

				Person b=dao2.getPerson(id3);
				System.out.println(b.getId());
				System.out.println(b.getName());
				System.out.println(b.getAddress());
				System.out.println(b.getPhone());
				System.out.println(b.getPin());
				break;
			default:System.out.println("Invalid choice");	

			}

		}


	}
}
