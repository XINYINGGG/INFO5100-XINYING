package assignment5;

public class IceCream extends DessertItem{
	protected double cost;
	IceCream(String name, double cost) {
		super(name);
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	@Override
	public int getCost() {
		return (int)cost;
	}
	@Override
	public String toString() {
		String cost = DessertShoppe.cents2dollarsAndCents(getCost());
		return getName()+ DessertShoppe.space(name, cost) + cost+"\n";
	}
}
