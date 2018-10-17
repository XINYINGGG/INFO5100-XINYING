package assignment5;

import java.util.ArrayList;
import java.util.List;

public class ExtraCredit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1,2,3}};
		//int[][] a = {};
		System.out.println(rotate(a));
		rotate(a);
	}
	
	
	
	public static List<Integer> rotate(int[][] matrix){
		List<Integer> list = new ArrayList<>();
    	if(matrix.length == 0)
    		return list;
		int m = matrix.length - 1;
		int n = matrix[0].length - 1;
		res(0,0,m,n,matrix,list);
		return list;

	}
		public static void res( int a , int b, int m, int n,int[][] matrix, List<Integer> list) {
			if(m < a || n < b) {
				return;
			}

			for(int i = b; i <= n; i++)
				list.add(matrix[a][i]);
			for(int i = a + 1; i <= m ; i++)
				list.add(matrix[i][n]);
			for(int i = n - 1; i >= b && a != m; i--)
				list.add(matrix[m ][i]);
			for(int i = m -1; i > a && b != n; i--)
				list.add(matrix[i][b]);
			 res(a+1,b+1,m-1,n-1,matrix,list);
		}

}
