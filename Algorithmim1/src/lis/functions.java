package lis;

public class functions {

	public static int lisWithDiffAdjK_ON(int arr[] , int k) {
		int n = arr.length;
		int lis = 0;
		int index = 0;
		int sum = 0;
		int[] t = new int [n];
		t[0] = 0;
		for(int i=1; i<t.length; i++) {
			t[i] = Math.abs(arr[i]-arr[i-1]);
		}

		for(int i=1; i<t.length; i++) {
			if(t[i] == k) {
				lis++;
				index = i;
				sum = 0;
			}
			else if(lis == 0 && arr[i] == k) {
				lis++;
				index = i;
				sum = 0;
			}
			else {
				sum = sum + t[i];
				if(sum == k) {
					sum = 0;
					lis++;
					index = i;
				}
				else if(sum > k) {
					if(Math.abs(arr[index]-arr[i]) == k) {
						sum = 0;
						lis++;
						index = i;
					}
				}
			}
		}
		return lis;
	}
	public static void main(String[] args) {
		int[] arr = {10,7,5,4,3,4,1,2,4};
		System.out.println(lisWithDiffAdjK_ON(arr, 3));
	}
}