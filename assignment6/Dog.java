package assignment6;

public class Dog extends Pet implements Boardable{

	private String size;
	private int monthStart;
	private int monthEnd;
	private int dayStart;
	private int dayEnd;
	private int yearStart;
	private int yearEnd;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog("Spot", "Susan", "white", "medium");
		dog.setSex(SPAYED);
		System.out.println(dog);
		dog.setBoardStart(12, 1, 1997);
		dog.setBoardEnd(3, 1, 2013);
		System.out.println(dog.boarding(11, 1, 2000));

	}
	public Dog (String name, String ownerName, String color, String size) {
		super(name, ownerName, color);
		this.size = size;
	}
	public String getSize() {
		return size;
	}
	public String toString() {
		return "DOG: \n"+super.toString()+"\nSize: "+getSize();
	}
	@Override
	public void setBoardStart(int month, int day, int year) {
		if( month >=1 && month <= 12)
			this.monthStart= month;
		if( day >= 1 && day <= 31)
			this.dayStart = day;
		 if (year >= 1000 && year <= 9999)
			this.yearStart = year;
	}
	
	public void setBoardEnd(int month, int day, int year) {
		if(year == yearStart) {
			if(month == monthStart) {
				if(day >= dayStart && day <= 31) {
					this.monthEnd= month;
					this.dayEnd = day;
					this.yearEnd = year;
				}	
			}
			else if(month > monthStart && month <=12) {
				if(day >=1 && day <= 31) {
					this.monthEnd= month;
					this.dayEnd = day;
					this.yearEnd = year;
				}
			}
		}
		else if(year > yearStart && year <= 9999) {
			if(month >= 1 && month<= 12 && day >= 1 && day <=31) {
				this.monthEnd= month;
				this.dayEnd = day;
				this.yearEnd = year;
			}
		}

	}
	
	public boolean boarding(int month, int day, int year) {
		if(year > yearStart && year < yearEnd)
			return true;
		else if (year == yearStart) {
			if(month > monthStart)
				return true;
			else if(month == monthStart) {
				if(day >= dayStart)
					return true;
			}
		}
		else if(year == yearEnd) {
			if(month < monthEnd) 
				return true;
			else if(month == monthEnd) {
				if(day <= dayEnd)
					return true;
			}
		}
		return false;

	}
}
