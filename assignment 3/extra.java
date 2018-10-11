package assignment3;
//score 2/2
public class extra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "  The sky is   blue";
		System.out.println(reverse(s));
	}
	public static String reverse(String s) { 
		s = s.replaceAll("\\s+"," " );
		s = s.trim();
		String arr[] = s.split(" ");
		String result = "";
		for(int i = arr.length -1; i>=0; i--) {
			result += arr[i]+" ";
		}
		return result;
	}

}
