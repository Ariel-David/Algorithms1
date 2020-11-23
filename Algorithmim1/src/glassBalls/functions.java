package glassBalls;

public class functions {

	public static void useFloorPotential(int a , int[] arr) {
		int num = 1;
		int numFloors = arr.length;
		while(numFloors > num*(num+1)/2) {
			num++;
		}

		int jump = num;
		int step = num-1;

		while(arr[jump] < a) {
			jump = jump + step;
			step = step -1;
		}

		System.out.println("the first ball breaks at floor " +jump);

		int floor = jump - (step +1);
		
		while(arr[floor] < a) {
			floor++;
		}
		System.out.println("the second ball is broken at floor " +floor);
	}
	public static void main(String[] args) {
		int size = 10, a=9;
		int [] floorPotential = new int[size];
		for(int i=0; i<size; i++){
			floorPotential[i] = i+1;
		}
		useFloorPotential(a, floorPotential);
	}
}
