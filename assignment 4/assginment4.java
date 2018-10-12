package assginment4;

import java.util.ArrayList;
import java.util.List;

public class assginment4 {

	
		public static void main(String[] args) {
//			int[] arr = {0,1,3};
//			moveZeroes(arr);
//			for(Integer i: arr)
//				System.out.println(i);
//			
//			int[][] a = {{1}};
//			rotate(a);
			
			String s = "efgyjokigefjy";
			System.out.println(firstUniqChar(s));

			System.out.println(longestPalindrome("babad"));
		}
	
	
		
		/**
		 * The deadline of assignment4 is 10/12/2018 23:59 PST.
		 * Please feel free to contact Zane and Amanda for any questions.
		 */
		
		/*
		 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
		 * s = "leetcode" return 0. 
		 * s = "loveleetcode" return 2.
		 */
	    public static int firstUniqChar(String s) {
	    		//TODO
	    	
	    	for(int i = 0; i < s.length(); i++) {
	    		int j = 0;
	    		for (; j < s.length(); ) {
	    			if(s.charAt(j) != s.charAt(i) || j == i)
	    				j++;
		    		if(j == s.length())
		    			return i;
	    			if(s.charAt(j) == s.charAt(i) && j != i) {
	    				break;
	    			}
	    		}


	    	}
	    	return -1;
	    	
	     }
	    
	    /*
	     *Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
	     * Input: 38 Output: 2
	     * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
	     */
	    public static int addDigits(int n) {
	    		//TODO
	    	List<Integer> list = new ArrayList<>();
	    	int i =0;
	    	while(n != 0) {
	    		list.add(i, n % 10);
	    		i++;
	    		n /= 10;
	    	}
	    	int res = 0;
	    	for(int j = 0; j<list.size(); j++) {
	    		res += list.get(j);
	    	}
	    	if(res/10 != 0)
	    		res = addDigits(res);
	    	return res;
	    }
	    
	    /*
	     *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
	     *  Input: [0,1,0,3,12] Output: [1,3,12,0,0]
	     */
	    public static void moveZeroes(int[] nums) {
	    		//TODO
	    	for(int i = 0, j =0; i < nums.length && j< nums.length; ) {
		    	int temp = 0;
		    	if(nums[i] == 0 && nums[j] != 0) {
		    		nums[i] = nums[j];
		    		nums[j] = temp;
		    	}
		    	if(nums[i] != 0)
		    		i++;
		    	if(nums[j] == 0)
		    		j++;
	    	}

	    	
	     }
		
	    /*
	     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
	     * Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
	     */
		public static String longestPalindrome(String s) {
			//TODO
			if(s == "")
				return s;
			boolean[][] pa = new boolean[s.length()][s.length()];
			
			int l = 0;
			int length = 1;
			
			for(int i = 0; i< s.length(); i++) {
				pa[i][i] = true;
			}
			for(int i = 0; i < s.length() - 1; i++) {
				if(s.charAt(i) == s.charAt(i+1)) {
					pa[i][i+1] = true;
					l = i;
					length = 2;
				}else {
					pa[i][i+1] = false;
				}
			}
			for(int i = 3; i < s.length(); i++) {
				for(int a = 0; a < s.length()-i+1; a++) {
					int b = a + i -1;
					if(pa[a+1][b-1] == true && s.charAt(a) == s.charAt(b)) {
						pa[a][b] = true;
						l = a;
						length = i;
					}else {
						pa[a][b] = false;
					}
				}
			}
			
			String longestPalindrome = s.substring(l, l+length);
			return longestPalindrome;
		}
			

		
	    /*
	     * You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
	     * Given input matrix = [ [1,2,3],
	  			      [4,5,6],
	  			      [7,8,9] ],
	     * rotate the input matrix in-place such that it becomes: [  [7,4,1],
	  								 [8,5,2],
	  								  [9,6,3] ],
	     */
	    public static int[][] rotate(int[][] matrix) {
	    	int[][] m2 = new int[matrix.length][matrix.length];
	    	int n = matrix.length - 1;
	    	for(int i = 0; i <= n; i++) {
	    		for(int j = 0; j <= n; j++) {
	    			m2[j][n - i] = matrix[i][j];
	    		}
	    	}
	    	return m2;
	    	 
	   }
	    
	

	
}
