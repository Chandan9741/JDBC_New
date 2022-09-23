package jdbc_maven1;

public class Person {
	private int id;
	private String name;
	private String address;
	private long phone;
	private int pin;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public Person(int id, String name, String address, long phone, int pin) {
		
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", pin=" + pin
				+ "]";
	}
	
	


}
