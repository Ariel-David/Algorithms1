package Prisoners;

import java.util.Arrays;

public class Prisoners {
	// first the lamp is on
	/**
	 * Prisoners problem when the initial state of light is known (on)
	 * Complexity: O(?)
	 * @param n Number of prisoners
	 * @return Number of steps
	 */
	public static boolean prisonersLampOn(int n){
		boolean enter[] = new boolean[n];
		for (int i = 0; i < enter.length; i++) {
			enter[i] = false;
		}
		boolean lamp = true;
		// the fist is the counter
		int count = 0, steps = 0;
		while (count < n){
			steps++;
			int p = (int)(Math.random()*n); //a random turn to enter for the prisoners
			//System.out.print(p+" ");
			if (p==0){// the counter enters
				if (!enter[p]){// the counter enters for the first time 
					enter[p] = true;
					count++;
				}
				if (!lamp){
					lamp = true;
					count++;
				}
			}
			else{
				if (!enter[p] && lamp){// p>=1, prisoner enters for the first time && the lamp is on 
					lamp = false;
					enter[p] = true;
				}
			}
		}
		boolean ans = true;
		for (int i = 0; ans && i < enter.length; i++) {
			if (!enter[i]) ans = false; //Fail: Prisoners aren't free
		}
		System.out.println(Arrays.toString(enter));
		System.out.println("steps = " + steps);
		return ans;
	}

	// first state of the lamp is unknown
	/**
	 * Prisoners problem when the initial state of light is is Unknown
	 * Complexity: O(?)
	 * @param n Number of prisoners
	 * @return Number of steps
	 */
	public static boolean prisonersLampUnknow(int n){
		int enter[] = new int[n];
		for (int i = 0; i < enter.length; i++) {
			enter[i] = 0;
		}
		// the fist is the counter
		int count = 0, steps = 0;
		boolean lamp = ((int)(Math.random()*2)==0) ? false : true; 
		while (count < 2*n){
			steps++;
			int p = (int)(Math.random()*n);
			if (p==0 && !lamp){// counter enters
				lamp = true;
				count++;
				if (enter[0] == 0){
					enter[0]++;
					count++;
				}
			}
			else{//p>=1, prisoner enters for the first and second time && the lamp is on 
				if (enter[p]<2 && lamp){
					enter[p]++;
					lamp = false;
				}
			}
		}
		boolean ans = true;
		for (int  i = 0; ans && i < enter.length; i++) {
			if (enter[i]==0) ans = false;
		}
		//System.out.println(Arrays.toString(enter));
		System.out.println("For prisoners problem when a first state of lamp is unknown,\nnumber of steps = "+steps);
		return ans;
	}

	public static void checkPrisonersLampOn(int n){
		int count = 0, nTry = 2;
		for (int i=1; i<nTry; i++){
			boolean ans = prisonersLampOn(n);
			System.out.println("ans= "+ ans);
		}
	}

	public static void checkPrisonersLampUnknown(int n){
		int count = 0, nTry = 2;
		for (int i=1; i<nTry; i++){
			if(!prisonersLampUnknow(n)) count++;
		}
		System.out.println("count for fail = "+count); 
	}
	public static void main(String[] args) {
		int n = 10;
		checkPrisonersLampOn(n);
		//checkPrisonersLampUnknown(n);
	}
}
