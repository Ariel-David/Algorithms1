package squareSubMatrixJf_1;

public class SubSeqOf_1 {

	public static void subSqOf1(int[]arr){
		int[]h = new int[arr.length];
		h[0] = arr[0];
		int indMax = 0 ;
		for (int i = 1; i < h.length; i++) {
			if(arr[i]==1){
				h[i] = h[i-1] + 1;
			}
		}
		for (int i = 1; i < h.length; i++) {
			if (h[i] > h[indMax]) indMax=i;
		}
		int maxLen = h[indMax], iBegin = indMax-maxLen+1;

		System.out.println("maxLen = "+maxLen+", beg = "+iBegin);
	}
	public static void exhaustiveSearch(int[]arr){
		int n = arr.length;
		int maxLen = 0, beg = 0;
		for (int i=0; i<n; i++){
			for (int j=i; j<n; j++){
				if (checkForOne(arr, i, j) && j-i+1 > maxLen){
					maxLen = j-i+1;
					beg = i;
				}
			}
		}
		System.out.println("maxLen = "+maxLen + ", beg = "+beg);
	}
	public static boolean checkForOne(int []arr, int beg, int end){
		boolean ans = true;
		for(int i=beg; ans && i<=end; i++){
			if (arr[i]==0) ans = false;
		}
		return ans;
	}
	public static void subSqOf1Standard(int[]arr){
		int count = 0, maxLen = 0, beg = 0;
		for(int j=0; j<arr.length; j++) {
			if (arr[j]==1)  count++;
			else {//arr[j]==0
				if (count > maxLen) {
					maxLen = count;
					beg = j - count;
				}
				count = 0;
			}
		}
		if (count > maxLen) {// tail processing
			maxLen = count;
			beg = arr.length - count;
		}
		System.out.println("maxLen = "+maxLen + ", beg = "+beg);
	}
	// we start with any elements
	public static void greedyPlus(int[] arr) {
		int count = 0, maxLen = 0, beg = 0, j = 0;
		while(arr[j]==0 && j < arr.length) j++;
		while(j < arr.length) {
			if (arr[j]==1) {
				count++;
				j++;
			}
			else {
				if (count > maxLen) {
					maxLen = count;
					beg = j - count;
				}
				j = j + count;
				count = 0;
			}
		}
		if (count > maxLen) {// tail processing
			maxLen = count;
			beg = arr.length - count;
		}
		System.out.println("maxLen = "+maxLen + ", beg = "+beg);
	}
	public static void main(String[] args) {
		int[]arr = {1,1,1,1,1,1,1,0,0,1,1,0,1,1,1,1};
		int[]arr1 = {1,0,1};
		int[]arr2 = {1,0,1,1,1,0};
		int[]arr3 = {1,0,1,1,1};
		int[]arr4 = {1,0,1,1,1,0,1,1};
		int[]arr5 = {1,1,1,1,1,1,1,1};
		int[]arr6 = {0,0,1,1,1,1,1,1};

		subSqOf1(arr1);
		exhaustiveSearch(arr1);
		subSqOf1Standard(arr1);
		greedyPlus(arr1);
		System.out.println();
		//////
		subSqOf1(arr);
		exhaustiveSearch(arr);
		subSqOf1Standard(arr);
		greedyPlus(arr);
		System.out.println();
		//////
		subSqOf1(arr2);
		exhaustiveSearch(arr2);
		subSqOf1Standard(arr2);
		greedyPlus(arr2);
		System.out.println();
		//////
		subSqOf1(arr3);
		exhaustiveSearch(arr3);
		subSqOf1Standard(arr3);
		greedyPlus(arr3);
		System.out.println();
		//////
		subSqOf1(arr4);
		exhaustiveSearch(arr4);
		subSqOf1Standard(arr4);
		greedyPlus(arr4);
		System.out.println();
		//////
		subSqOf1(arr5);
		exhaustiveSearch(arr5);
		subSqOf1Standard(arr5);
		greedyPlus(arr5);
		System.out.println();
		//////
		subSqOf1(arr6);
		exhaustiveSearch(arr6);
		subSqOf1Standard(arr6);
		greedyPlus(arr6);
		System.out.println();
	}

}
