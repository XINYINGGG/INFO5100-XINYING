package assignment5;

import java.text.DecimalFormat;

public class Candy extends DessertItem{
	protected double weight;
	protected double price;
	
	
	Candy(String name, double weight, double price) {
		super(name);
		this.weight = weight;
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	public double getWeight() {
		return weight;
	}
	public String getName() {
		return name;
	}
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		int cost = (int) Math.round(weight * price);
		return cost;
	}
	@Override
	public String toString() {
		String cost = DessertShoppe.cents2dollarsAndCents(getCost());
		String pricePerPound = DessertShoppe.cents2dollarsAndCents((int)Math.round(getPrice()));
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(getWeight())+" lbs. @ "+ pricePerPound + " /lb.\n"+getName()+DessertShoppe.space(getName(), cost)+cost+"\n";
		
	}
}
