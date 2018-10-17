package assignment5;

public class Sundae extends IceCream{
	protected double toppingPrice;
	protected String toppingName;
	
	Sundae(String name, int cost){
		super(name, cost);
	}
	Sundae(String name, int cost, String toppingName, double toppingPrice) {
		super(name, cost);
		this.toppingName = toppingName;
		this.toppingPrice = toppingPrice;
	}
	public String getName() {
		return name;
	}
	public int getCost() {
			return (int) (super.cost + toppingPrice);
	}
	public String toString() {
		String cost = DessertShoppe.cents2dollarsAndCents(getCost());
		return getName()+ DessertShoppe.space(name, cost) + cost+"\n";
	}
	
}

