package Medain;

import java.util.Arrays;

public class medain {
	public static int Max(int[] arr) {
		int max = arr[0];
		for(int i=1; i<arr.length-1 && i <64-1; i = i+2) {
			if(arr[i] > arr[i+1]) {
				if(max < arr[i]) {
					max = arr[i];
				}
			}
			else {
				if(max < arr[i+1]) {
					max = arr[i+1];
				}
			}
		}
		return max;
	}
	public static int [] greatThenMedian2Arrays(int[]a, int[] b) {
		int n = a.length;
		int k = 0;
		int i = 0;
		int j = n-1;
		int [] ans = new int [n];
		while(k < n) {
			ans[k++] = a[i] >= b[j] ? a[i] : b[j];
			i++; 
			j--;
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] arr = new int [12];
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int) (Math.random()*12);
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Max(arr));
	}
}
