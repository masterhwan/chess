
public class Fruit {
	private String name;
	private int no;
	private int price;

	public Fruit() {

	}

	public Fruit(String name, int no, int price) {
		this.name = name;
		this.no = no;
		this.price = price;
	}

	public int getNo() {
		return no;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", no=" + no + ", price=" + price + "]";
	}

}
