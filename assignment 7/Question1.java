package assignment7;

import java.util.Scanner;

class MyIndexOutOfBoundException extends Exception{
	int lowerBound;
	int upperBound;
	int index;
	MyIndexOutOfBoundException(int lowerBound, int upperBound, int index){
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.index = index;
	}
	public String toString() {
		return "Error Message: Index: "+index+ ", but Lower bound: "+lowerBound+", Upper bound: "+upperBound;
	}
}

public class Question1 {

	public static void main(String[] args) throws  MyIndexOutOfBoundException{
		// TODO Auto-generated method stub
		count();
	}
	public static void count() throws MyIndexOutOfBoundException{
		Scanner scanner = new Scanner(System.in);
		int a = 0;
		int b = 0;
		int c = 0;
		while(true) {
			try {
				System.out.println("Enter the lower bound..");
				a = Integer.parseInt(scanner.nextLine());
				System.out.println("Enter the upper bound..");
				b = Integer.parseInt(scanner.nextLine());
				System.out.println("Enter the index..");
				c = Integer.parseInt(scanner.nextLine());
				throw new MyIndexOutOfBoundException(a, b, c);
			}
			catch (MyIndexOutOfBoundException e) {
				if ( a > c || b < c) {
					 throw e;
				}
			}
		}
	}
	

}
