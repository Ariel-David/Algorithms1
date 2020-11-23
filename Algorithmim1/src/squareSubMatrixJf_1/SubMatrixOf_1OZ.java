package squareSubMatrixJf_1;

public class SubMatrixOf_1OZ {
	public static void main(String[] args) {
		//int mat[][] = MyLibrary.randomMatrixOf01(6, 6);
		int[][] mat = {{1,0,0,1,1,1},{1,0,1,1,1,1},{0,1,1,1,1,1},{0,0,1,1,1,1}};
		int mat1[][] = {{0,0,0,1,0}, {0,1,1,1,0}, {0,1,1,1,0},
				{0,1,1,1,0},{0,1,1,1,0},{0,1,0,1,1}};
		int[][] mat2 = {{0,0,1,0,1},{0,1,1,1,1},{0,1,1,1,1},{0,0,1,1,1}};
		int[][] mat3 = {{0,0,1,1,1},{0,1,1,1,1},{1,1,1,1,0},{0,1,1,1,1},{0,1,1,1,1}};
		subMatrixOf1(mat);
		//System.out.println("3 matrices");
		//subMatrixOf1_3Matrices(mat3);
		//subMatrixOf1(mat2);
		//System.out.println(numK(mat3, 3));
	}
	/**Finds the biggest k*k matrix of '1'.
	 * Complexity O(m*n)
	 * @param mat - matrix filled with 0,1*/
	public static void subMatrixOf1(int [][] mat){	
		// h - help matrix
		int [][]help = new int[mat.length][mat[0].length];
		int maxDim = 0, iMax = 0, jMax = 0;		
		// copy first row
		for (int j = 0; j < mat[0].length; j++) {
			if (mat[0][j] == 1){
				maxDim = 1;
				iMax = 0; 
				jMax = j;
			}
			help[0][j] = mat[0][j];
		}		
		// copy first column
		for (int i = 0; i < mat.length; i++) {
			if (mat[i][0] == 1){
				maxDim = 1;
				iMax = 0; 
				jMax = i;
			}
			help[i][0] = mat[i][0];
		}
		for (int i = 1; i < mat.length ; i++) {
			for (int j = 1; j < mat[0].length ; j++) {
				if (mat[i][j] != 0){
					help[i][j] = min3(help[i-1][j-1],help[i-1][j],help[i][j-1])+1;
					if (help[i][j] > maxDim){
						maxDim = help[i][j];
						iMax = i;
						jMax = j;
					}
				}
			}
		}
		MyLibrary.printIntMatrix(mat);
		System.out.println();
		MyLibrary.printIntMatrix(help);
		System.out.println(" maxDim: "+maxDim+", iMax: "+iMax+", jMax: "+jMax);
	}	
	/**returns min(a, b, c)*/
	public static int min3(int a, int b, int c){
		int min = a;
		if (min > b) min = b;
		if (min > c) min = c;
		return min;
	}
	
	public static int numK(int [][] help, int k) {
		int count = 0;
		for (int i = 0;  i< help.length; i++) {
			for (int j = 0; j < help[0].length; j++) {
				if(help[i][j] >= k) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void subMatrixOf1_3Matrices(int [][] mat){
		int rows = mat.length, cols = mat[0].length;
		int maxDim = 0, iMax = 0, jMax = 0;	
		int[][]x = new int[rows][cols];
		int[][]y = new int[rows][cols];
		int[][]z = new int[rows][cols];
		for (int i=0; i<rows; i++){// fill first column
			x[i][0] = mat[i][0];
			y[i][0] = mat[i][0];
			z[i][0] = mat[i][0];
		}
		for(int j=0; j<cols; j++){// fill first row
			x[0][j] = mat[0][j];
			y[0][j] = mat[0][j];
			z[0][j] = mat[0][j];
 		}
		for(int i=1; i<rows; i++){
			for(int j=1; j<cols; j++){
				if(mat[i][j]==1) x[i][j] = x[i][j-1] + 1;
			}
		}
		for(int j=1; j<cols; j++){
			for(int i=1; i<rows; i++){
				if(mat[i][j]==1) y[i][j] = y[i-1][j] + 1;
			}
		}
		for(int i=1; i<rows; i++){
			for(int j=1; j<cols; j++){
				if(mat[i][j]==1){
					z[i][j] = min3(z[i-1][j-1]+1, x[i][j], y[i][j]);
					if (z[i][j] > maxDim){
						maxDim = z[i][j];
						iMax = i; jMax = j;
					}
				}
			}
		}
		MyLibrary.printIntMatrix(mat);
		System.out.println("X");
		MyLibrary.printIntMatrix(x);
		System.out.println("Y");
		MyLibrary.printIntMatrix(y);
		System.out.println("Z");
		MyLibrary.printIntMatrix(z);
		System.out.println(" maxDim: "+maxDim+", iMax: "+iMax+", jMax: "+jMax);

	}
	
}

