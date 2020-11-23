package MinMax;
/**
 * Finding the smallest and largest elements in the array 
 * (with the least number of comparisons)
 *
 */
public class minMax {	 
	/**
	 * Search of maximum && minimum elements by pairs
	 * Complexity: O(n) - 1.5 comparisons
	 * @param arr
	 * @return  number of comparisons
	 */
	public static int minMaxPairs(int []arr){  
		int min, max, comparisons=0;
		min = arr[0];
		max = arr[1];
		if (arr[0]>arr[1]){
			min = arr[1];
			max = arr[0];			
		}
		comparisons++;
		for (int i=2; i<arr.length-1; i=i+2){
			comparisons++;
			if(arr[i]<arr[i+1]){
				comparisons = comparisons + 2;
				if(arr[i]<min)  min = arr[i];
				if(arr[i+1]>max)  max = arr[i+1];
			}
			else{
				comparisons = comparisons + 2;
				if(arr[i+1]<min)  min = arr[i+1];
				if(arr[i]>max)  max = arr[i];				
			}
		}
		// if number of elements is odd, we check the last element
		if (arr.length%2!=0){
			comparisons++;
			if (arr[arr.length-1]>max){
				max = arr[arr.length-1];
			}
			else{
				comparisons++;
				if (arr[arr.length-1]<min){
					min = arr[arr.length-1];					
				}
			}
		}
		//System.out.println("min = "+min+", max = "+max);
		return comparisons;
	}
	
	/**
	 * standard algorithm with One Loop for search of maximum && minimum elements
	 * Complexity: O(n) - 2n comparisons	
	 * @param arr
	 * @return number of comparisons
	 */
	public static int minMaxStandard(int []arr){
		int max = arr[0], min = arr[0], comparisons = 0;
		for (int i=1; i<arr.length; i++){
			comparisons++;
			if(arr[i] < min){
				min = arr[i];
			}
			else{
				comparisons++;
				if(arr[i] > max){
					max = arr[i];
				}
			}
		}
		//System.out.println("min = "+min+", max = "+max);
		return comparisons;
	}
	/**
	 * standard algorithm with Two Loops for search of maximum && minimum elements
	 * Complexity: O(n) - 2n comparisons	
	 * @param arr
	 * @return number of comparisons
	 */	public static int minMaxTwoLoops(int []arr){
		int comparisons = 0;
		int min = arr[0];
		for (int i=1; i<arr.length; i++){
			comparisons++;
			if(arr[i] < min) min = arr[i];
		}
		int max = arr[0];
		for (int i=1; i<arr.length; i++){
			comparisons++;
			if(arr[i] > max) max = arr[i];
		}
		//System.out.println("min = "+min+", max = "+max);
		return comparisons;
	}
	
	/**
	 * Prints an average time and an average number of comparisons in standard algorithm
	 * @param arr 
	 * @param size
	 * @param loop
	 */
	public static void meanNumOfComparisonsStandard(int []arr, int size,int loop){
		int comparisons = 0;
		double diff = 0;
		for (int i=1; i<=loop; i++){
			long start = System.currentTimeMillis();
			comparisons = comparisons + minMaxStandard(arr);
			long end = System.currentTimeMillis();
			diff = diff + ((double)(end - start))/1000.0;
		}
		System.out.println("minMaxStandard");
		System.out.printf("average time minMaxStandard: %7.5f", diff/loop);
		System.out.println(";  average number of comparisons: " + comparisons/loop);
	}
	/**
	 * Prints an average time and an average number of comparisons in two loops algorithm
	 * @param arr
	 * @param size
	 * @param loop
	 */
	public static void meanNumOfComparisonsTwoLoops(int []arr, int size,int loop){
		int comparisons = 0;
		double diff = 0;
		for (int i=1; i<=loop; i++){
			long start = System.currentTimeMillis();
			comparisons = comparisons + minMaxTwoLoops(arr);
			long end = System.currentTimeMillis();
			diff = diff + ((double)(end - start))/1000.0;
		}
		System.out.println("minMaxTwoLoops");
		System.out.printf("average time minMaxTwoLoops: %7.5f", diff/loop);
		System.out.println(";  average number of comparisons: " + comparisons/loop);
	}
	/**
	 * Prints an average time and an average number of comparisons in pairs algorithm
	 * @param arr
	 * @param size
	 * @param loop
	 */
	public static void meanNumOfComparisonsPairs(int[]arr, int size,int loop){
		int comparisons = 0;
		double diff = 0;
		for (int i=1; i<=loop; i++){			
			long start = System.currentTimeMillis();
			comparisons = comparisons + minMaxPairs(arr);
			long end = System.currentTimeMillis();
			diff = diff + ((double)(end - start))/1000.0;
		}
		System.out.println("minMaxPairs");
		System.out.printf("average time minMaxPairs: %7.5f", diff/loop);
		System.out.println(";  average number of comparisons: " + comparisons/loop);
	}
	
	public static void main(String[] args) {
		/// number of comparisons
		int size = 100000, loop = 10;
		System.out.println("size = " + size + ";  loop = " + loop);
		int[]arr = MyLibrary.randomIntegerArray(size);
		meanNumOfComparisonsStandard(arr, size, loop);
		meanNumOfComparisonsTwoLoops(arr, size, loop);
		meanNumOfComparisonsPairs(arr, size, loop);
	}
}
/* OUTPUT 
size = 100000;  loop = 10
minMaxStandard
average time minMaxStandard: 0.00080;  average number of comparisons: 199984
minMaxTwoLoops
average time minMaxTwoLoops: 0.00110;  average number of comparisons: 199998
minMaxPairs
average time minMaxPairs: 0.00100;  average number of comparisons: 149998
		
size = 1000000;  loop = 10
minMaxStandard
average time minMaxStandard: 0.00220;  average number of comparisons: 1999987
minMaxTwoLoops
average time minMaxTwoLoops: 0.00320;  average number of comparisons: 1999998
minMaxPairs
average time minMaxPairs: 0.00430;  average number of comparisons: 1499998

size = 10000000;  loop = 10
minMaxStandard
average time minMaxStandard: 0.00620;  average number of comparisons: 19999986
minMaxTwoLoops
average time minMaxTwoLoops: 0.00960;  average number of comparisons: 19999998
minMaxPairs
average time minMaxPairs: 0.02600;  average number of comparisons: 14999998

*/
