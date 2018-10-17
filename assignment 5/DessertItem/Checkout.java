package assignment5;

import java.util.Vector;

public class Checkout {
	
	Vector<DessertItem> v = new Vector<>();

	
	public Checkout() {

	}
	
	public int numberOfItems() {
		int number = v.size();
		return number;
	}
	public void enterItem(DessertItem item) {
		v.add(item);
	}
	public void clear() {
		v.clear();
	}
	public int totalCost() {
		int cost = 0;
		for(int i = 0; i < v.size(); i++) {
			cost += v.get(i).getCost();
		}
		return cost;
	}
	public int totalTax() {
		int tax = (int)(totalCost() * DessertShoppe.taxRate);
		return tax;
	}

	@Override
	public String toString() {
		String result = "";
		result += "\n\n"+"          "+DessertShoppe.storeName+"\n"; 
		result += "          "+"--------------------\n\n";
		result +="\n";
		for(DessertItem dessert:v) {
			result += dessert.toString();
		}
		result += "\n"+"Tax"+DessertShoppe.space("Tax", DessertShoppe.cents2dollarsAndCents(totalTax())) + DessertShoppe.cents2dollarsAndCents(totalTax());
		result += "\n"+"Total Cost"+DessertShoppe.space("Total Cost", DessertShoppe.cents2dollarsAndCents(totalCost())) + DessertShoppe.cents2dollarsAndCents(totalCost()+totalTax())+"\n\n";
		return result;
	}

}
