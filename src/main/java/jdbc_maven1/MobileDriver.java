package jdbc_maven1;

import java.util.Scanner;

public class MobileDriver {

	public static void main(String[] args) {
		MobileDAO dao=new MobileDAO();
		Mobile m=new Mobile();
		Scanner s=new Scanner(System.in);
		boolean data=true;
		while(data) {
		System.out.println("Enter the choice");
		System.out.println("1.save Mobile\n2.Update Mobile\n3.Delete mobile\n4.Get mobile");
		int choice=s.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter the id");
			int id=s.nextInt();
			System.out.println("Enter the name");
			String name=s.next();
			System.out.println("Enter the brand");
			String brand=s.next();
			System.out.println("Enter the colour");
			String colour=s.next();
			System.out.println("Enter the price");
			double price=s.nextInt();
			System.out.println("Enter the ram");
			int ram=s.nextInt();
			System.out.println("Enter the manufacturer");
			String manufacturer=s.next();
			
			m.setId(id);
			m.setName(name);
			m.setBrand(brand);
			m.setColour(colour);
			m.setPrice(price);
			m.setRam(ram);
			m.setManufacturer(manufacturer);
			dao.saveMobile(m);
				
			
			
			
			
		}
		

	}

}
