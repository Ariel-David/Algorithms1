package lis;

import java.util.Arrays;
import java.util.Stack;


public class LIS {
	int[] arr;
	int teta;
	private static int longestLength = 0;
	private static int lisCounter;
	private static Stack<String> stackOfLis = new Stack<String>();
	private static String pre = "";

	public LIS(int[] arr, int teta) {
		this.arr = arr;
		this.teta = teta;
	}

	public void printLengthLIS() {
		int size = arr.length;
		int d[] = new int[size];
		d[0] = arr[0];
		int end = 0;
		for (int i=1; i<size; i++){
			int index = binarySearchBetween(end, arr[i]);
			d[index] = arr[i];
			if (index > end) end++;
		}
		longestLength = end +1;
		System.out.println("The length of the LIS is: " + longestLength);
	}


	public void printNumOfLIS() {
		initLength();
		initStuck();
		System.out.println("Number of LIS is: "+ lisCounter);
	}

	public void printAllLIS() {
		initLength();
		int count =0;
		System.out.println("All The LIS is:");
		for (int i = stackOfLis.size()-1 ; i >= 0; i--) {
			if(count < teta) {
				System.out.println(stackOfLis.elementAt(i));
				count++;
			}
		}
	}

	public void initLength() {//NLOGN
		int size = arr.length;
		int d[] = new int[size];
		d[0] = arr[0];
		int end = 0;
		for (int i=1; i<size; i++){//O(N)
			int index = binarySearchBetween(end, arr[i]);//O(LOG(N)
			d[index] = arr[i];
			if (index > end) end++;
		}
		longestLength = end +1;
	}

	public void initStuck() {
		for (int i = 0; i < arr.length; i++) {
			find1(creatNewArray(arr,i));
		}
		for (int i = 0; i < arr.length; i++) {
			find2(creatNewArray(arr,i));
		}
	}

	public static int[] creatNewArray(int[] X,int index) {//O(N)
		int[] arrNew = new int[X.length-index];
		for(int i=0; i<X.length-index; i++) { //O(N)
			arrNew[i] =  X[i];
		}
		return arrNew;
	}

	public void find1(int[] X) { //O(M+N) +O(N)+ O(MIN(M,N))
		int[] temp = new int[X.length];
		for(int i=0; i<X.length; i++) {//O(N)
			temp[i] = X[i];
		}
		Arrays.sort(temp); //O(N)
		int[] lisArr = maxSequence(X, temp); //O(M+N) + O(MIN(M,N))
		if(lisArr.length == longestLength) {
			String lisStr = Arrays.toString(lisArr);
			if(!lisStr.equals(pre)) {
				stackOfLis.push(lisStr);
				lisCounter++;
				pre = lisStr;
			}
		}
	}

	public void find2(int[] X) {
		int[] temp = new int[X.length];
		for(int i=0; i<X.length; i++) {
			temp[i] = X[i];
		}
		Arrays.sort(temp);
		int[] lisArr = maxSequence(temp, X);
		if(lisArr.length == longestLength) {
			String lisStr = Arrays.toString(lisArr);
			if(!lisStr.equals(pre)) {
				stackOfLis.push(lisStr);
				lisCounter++;
				pre = lisStr;
			}
		}
	}

	public int binarySearchBetween( int end, int value){
		int low = 0, high = end;
		if (value<arr[0]) return 0;
		if (value>arr[end])  return end+1;
		while (low <=high){
			int middle = (low + high)/2;
			if (low == high) {// stop search
				return low;
			}
			else {
				if (arr[middle] == value){//value was found
					return middle;
				}
				if (value < arr[middle]){// value suppose to be left
					high = middle;
				}
				else{// value suppose to be right
					low = middle+1;
				}
			}
		}
		return -1;
	}

	public static int[] maxSequence(int[] X, int [] Y){ //O(M+N) + O(MIN(M,N))
		int mat[][] = buldMatrix(X, Y); 
		int row = mat.length;
		int col = mat[0].length;
		int seqLength = mat[row-1][col-1];
		int result[] = new int[seqLength];
		int i=row-1, j=col-1, count=seqLength-1;
		while (count>=0){
			if (X[i-1]==Y[j-1]){
				result[count--]=X[i-1];
				i--;
				j--;
			}
			else if (mat[i][j]==mat[i][j-1]) {
				j--;
			}
			else {
				i--;
			}
		}
		return result;
	}

	public static int[][] buldMatrix(int[] X, int [] Y) {  //O(M*N)
		int row = X.length+1,  col = Y.length+1;
		int mat[][] = new int[row][col]; 
		int i=0, j=0;
		for (i=0; i<row; i++) mat[i][0]=0;
		for (j=0; j<col; j++) mat[0][j]=0;
		for (i=1; i<row; i++) {
			for (j=1; j<col; j++) {
				if (X[i-1]==Y[j-1]){
					mat[i][j] = mat[i-1][j-1] + 1;
				}
				else{
					mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
				}
			}
		}
		return mat;
	}

	public int[] getArr() {
		return arr;
	}
	public void setArr(int[] arr) {
		this.arr = arr;
	}
	public int getTeta() {
		return teta;
	}
	public void setTeta(int teta) {
		this.teta = teta;
	}

}
