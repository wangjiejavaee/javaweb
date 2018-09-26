package bean;
public class Good {
	private String name;
	private int price;
	private int number;
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setName(String name2) {
		// TODO Auto-generated method stub
		this.name=name2;
	}
	public Good() {
		
	}
	public Good(String name,int price,int number) {
		this.name=name;
		this.price=price;
		this.number=number;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}