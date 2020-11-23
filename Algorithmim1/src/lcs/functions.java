package lcs;

public class functions {
	public static int Mat(int[] x, int[] y, int[] z) {
		int n = x.length+1;
		int m = y.length+1;
		int num = 0;
		int [][] ans = new int [n][m];
		int temp = 0;
		for(int i=1; i<ans.length; i++) {
			for(int j=1; j<ans[0].length; j++) {
				if(x[i-1] == y[j-1]) {
					for(int k=temp; k<z.length; k++) {
						if(x[i-1] == z[k]) {
							ans[i][j] = (ans[i-1][j-1]+1);
							temp = k;
							break;
						}
					}
					if(ans[i][j] == 0) {
						ans[i][j] = Math.max(ans[i-1][j], ans[i][j-1]);
					}
				}
				else {
					ans[i][j] = Math.max(ans[i-1][j], ans[i][j-1]);
				}
			}
		}
		num = ans[n-1][m-1];
		return num;
	}
	
	public static void main(String[] args) {
		int Y[] = {4,5,1,2,3};
		int X[] = {1,2,3,4,5};
		int Z[] = {4,5,6,7,8};
		
		System.out.println(Mat(X, Y, Z));
	}
}
