package assignment5;

public class Cookie extends DessertItem{
	protected int number;
	protected double priceDZ;
	
	Cookie(String name, int number, double priceDZ) {
		super(name);
		this.number = number;
		this.priceDZ = priceDZ;
	}
	
	public int getCost() {
		int cost = (int) Math.round(number * (priceDZ / 12));
		return cost;
	}
	public String getName() {
		return name;
	}
	public int getNumber() {
		return number;
	}
	public double getPriceDZ() {
		return priceDZ;
	}
	@Override
	public String toString() {
		
		String price = DessertShoppe.cents2dollarsAndCents((int)Math.round(getPriceDZ()));
		String cost =  DessertShoppe.cents2dollarsAndCents((int)Math.round(getCost()));
		
		return getNumber() + " @ " + price + " /dz.\n"+getName()+DessertShoppe.space(getName(), cost)+cost+"\n";
	}
}
