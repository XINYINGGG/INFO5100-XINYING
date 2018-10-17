package assignment5;

public class DessertShoppe {
	public static final double taxRate = 0.0654;
	public static final String storeName = "M & M Dessert Shoppe";
	public static final int maxSizeName = 20;
	public static final int width = 38;
	
	public static String cents2dollarsAndCents(int cost) {
		double dollar = cost / 100.00;
		int cent = cost % 100;
		String s = "";
		if(dollar < 1) {
			if(cent <= 9)
				s += ".0"+cent;
			else
				s += "." +cent;
		}else
			s += dollar;
		
		return s;
	}
	
	public static String space(String name, String cost) {
		int res = DessertShoppe.width - name.length() -cost.length();
		String space = " ";
		for (int i = 0; i<res; i++) {
			space += " ";
		}
		return space;
	}

}
