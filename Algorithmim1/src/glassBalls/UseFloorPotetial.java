package glassBalls;

public class UseFloorPotetial {
	public static void useFloorPotential(int a, int arr[]){
		// if arr[i] < a arr[i+1] the ball is broken, i=1,2,...
		// numFloors - number of floors;
		// non-equal parts: 1,2,3,4,5,...number 
		// while (1+2+...< numFloors)
		// 1+2+...+number = number*(number+1)/2
		// Assumption: arr[len-1]>a
		int number = 1;
		int numFloors = arr.length;
		while (numFloors > number*(number+1)/2){
			number++;
		}
		int jump = number;
		int step = number-1;
		
		while(arr[jump]<a){
			jump = jump + step;
			step = step-1;
		}
		int floor = jump - (step + 1);
		while (arr[floor] < a){
			floor++;
		}
		System.out.println("floor = "+(floor+1));
	}

	public static void main(String[] args) {
		int [] arr={1,2,3,4,5,6,8,9,10};
		int a = 3;
		useFloorPotential(a, arr);

	}

}
