package jdbc_maven1;

import java.util.List;
import java.util.Scanner;

public class ProductDriver {
	public static void main(String[] args) {
		ProductDAO dao=new ProductDAO();
		Product p=new Product();
		Scanner s=new Scanner(System.in);
		boolean data=true;
		while(data) {
			System.out.println("Enter the choice");
			System.out.println("1.save Product\n2.Update product\n3.Delete product\n4.Get product\n5.Get all product details");
			int choice=s.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the id");
				int id=s.nextInt();
				System.out.println("Enter the name");
				String name=s.next();
				System.out.println("Enter the price");
				double price=s.nextDouble();
				System.out.println("Enter the manufacturer");
				String manufacturer=s.next();
				System.out.println("Enter the discount");
				int discount=s.nextInt();
				System.out.println("Enter the warrenty");
				int warrenty=s.nextInt();
				System.out.println("Enter the manufdate");
				int date=s.nextInt();
				System.out.println("ENTER THE gst");
				int gst=s.nextInt();


				p.setId(id);
				p.setName(name);
				p.setPrice(price);
				p.setManufacturer(manufacturer);
				p.setDiscount(discount);
				p.setWarrenty(warrenty);
				p.setDate(date);
				p.setGst(gst);
				Product res=dao.saveProduct(p);
			
				break;

			case 2:
				System.out.println("Enter the id");
				int id1=s.nextInt();
				System.out.println("Enter the name");
				String name1=s.next();
				System.out.println("Enter the price");
				double price1=s.nextDouble();
				System.out.println("Enter the manufacturer");
				String manufacturer1=s.next();
				System.out.println("Enter the discount");
				int discount1=s.nextInt();
				System.out.println("Enter the warrenty");
				int warrenty1=s.nextInt();
				System.out.println("Enter the manufdate");
				int date1=s.nextInt();
				System.out.println("ENTER THE gst");
				int gst1=s.nextInt();

				p.setId(id1);
				p.setName(name1);
				p.setPrice(price1);
				p.setManufacturer(manufacturer1);
				p.setDiscount(discount1);
				p.setWarrenty(warrenty1);
				p.setDate(date1);
				p.setGst(gst1);

				Product p1=dao.updateProduct(p);
				System.out.println(p1);
				break;
			case 3: 
				System.out.println("Enter the id to delete");
				int id2=s.nextInt();

				String d=dao.deleteProduct(id2);
				System.out.println(d);
				break;
			case 4: 
				System.out.println("ENter the id to get Product");
				int id3=s.nextInt();

				Product r=dao.getProduct(id3);
				System.out.println(r.getId());
				System.out.println(r.getName());
				System.out.println(r.getPrice());
				System.out.println(r.getManufacturer());
				System.out.println(r.getDiscount());
				System.out.println(r.getWarrenty());
				System.out.println(r.getDate());
				System.out.println(r.getGst());
				break;
			case 5:
				List<Product> l=dao.getAllProduct();
				System.out.println(l);
				
				break;

			default:System.out.println("Invalid choice");


			}
		}
	}
}
