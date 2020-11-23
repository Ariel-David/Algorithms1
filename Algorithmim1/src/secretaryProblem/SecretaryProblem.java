package secretaryProblem;

import java.util.Arrays;

public class SecretaryProblem {
	/**
	 * Execute the algorithm for the secretary problem:
	 * The function calculate an average wait time.
	 * @param times array of wait times
	 * @return average wait time
	 */
	public static double getAvarageTime(int[] times) {
		Arrays.sort(times);
		double avg = 0;
		for(int x : times) avg = avg + avg + x;
		return avg/times.length;
	}
}
