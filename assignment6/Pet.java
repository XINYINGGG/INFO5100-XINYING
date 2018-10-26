package assignment6;

public class Pet {

	private String petName;
	private String ownerName;
	private String color;
	protected int sex;
	public static final int MALE = 1;
	public static final int FEMALE = 2;
	public static final int SPAYED  = 3;
	public static final int NEUTERED = 4;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pet pet = new Pet("P","w","b");
		pet.setSex(SPAYED);
		System.out.println(pet);
	}
	public Pet (String name, String ownerName, String color) {
		this.petName = name;
		this.ownerName = ownerName;
		this.color = color;
	}
	public String getPetName() {
		return petName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public String getColor() {
		return color;
	}
	public void setSex(int sexid) {
		this.sex = sexid;
	}
	public String getSex() {
		if(this.sex == MALE)
			return "MALE";
		else if(this.sex == FEMALE)
			return "FEMALE";
		else if(this.sex == SPAYED)
			return "SPAYED";
		else if(this.sex == NEUTERED)
			return "NEUTERED";
		else {
			return "the sex is wrong";
		}
	}
	public String toString() {
		return getPetName() +" owned by "+getOwnerName()+"\nColor: "+getColor()+"\nSex: "+getSex();
	}
}
