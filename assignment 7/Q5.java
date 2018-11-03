package assignment7;

import java.util.Arrays;

public class Q5 {



	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    // add your code here
		int m = nums1.length;
		int n = nums2.length;
		int[] merge = new int[ m + n];
		for(int i = 0; i < m; i++) {
			 merge[i] = nums1[i];
		}
		for (int i = 0; i < n; i++) {
			merge[m + i] = nums2[i];
		}
		Arrays.sort(merge);
		double result = 0;
		int length = merge.length;
		if(length % 2 == 0) {
			int a = length / 2 - 1;
			int b = a + 1;
			result = (double)(merge[a] + merge[b]) / 2.0;
		}else {
			int a = length / 2;
			result = (double)(merge[a]);
		}
		return result;
	}
}
