package MinMax;

public class functions {

	public static int minMaxPairs(int []arr){  
		int min, max, comparisons=0;
		int first = 0; 
		int last = 0;
		min = arr[0];
		max = arr[1];

		if (arr[0]>arr[1]){
			min = arr[1];
			first = 1;
			max = arr[2];		
			last = 2;
		}

		comparisons++;

		for (int i=2; i<arr.length-1; i=i+2){
			comparisons++;
			if(arr[i]<arr[i+1]){
				comparisons = comparisons + 2;
				if(arr[i]<min) {
					min = arr[i];
					first = i;
				}
				if(arr[i+1]>max) {
					max = arr[i+1];
					last = i+1;
				}
			}

			else{
				comparisons = comparisons + 2;
				
				if(arr[i]>max) {
					max = arr[i];
					last = i;
				} 
				
				if(arr[i+1]<min && i <= last) {
					min = arr[i+1];
					first = i+1;
				}
			}
		}
		
		// if number of elements is odd, we check the last element
		if (arr.length%2!=0){
			comparisons++;
			if (arr[arr.length-1]>max){
				max = arr[arr.length-1];
				last = arr.length-1;
			}
		}
		System.out.println("max diff is: " +(max-min));
		System.out.println("min = "+min+", max = "+max);
		System.out.println("first = "+first+", last = "+last);

		return comparisons;
	}
	
	public static void main(String[] args) {
		int [] test = {7,2,1,0,4};
		minMaxPairs(test);
	}
}
