package parkingProblem;

import java.util.Arrays;
import java.util.LinkedList;

public class CalcCarsArray {
	/**
	 * Cars calculation: parking problem with array (cycle array)
	 * Complexity: O(n)
	 */
	public static int calcSize(int []arr, int start){
		int count=0, ind=0, backward=0, size = arr.length;
		int w=-1, v=0;
		arr[start] = v;
		ind = start;
		boolean flag = true; //continue
		while(flag){
			ind = (ind + 1)%size;
			count++;
			if (arr[ind] == v){
				arr[ind] = w;
				backward = ind-count;
				if (backward<0) backward = size + backward;
				if (arr[backward] == w) flag = false;
			}
		}
		return count;
	}
	
	public static void CheckCalcCarsArray(){
		int size = 10;
		int arr[] = new int[size];
		for (int i=0; i<size; i++){
			arr[i] = (int)(Math.random()*size);
		}
		System.out.println(Arrays.toString(arr));
		int start=(int)(Math.random()*size); 
		System.out.println("start: "+start);
		int count = calcSize(arr, start);
		System.out.println("count = "+count);
		System.out.println(Arrays.toString(arr));		
	}
	
	public static void main(String[] args) {
		CheckCalcCarsArray();
	}
}
