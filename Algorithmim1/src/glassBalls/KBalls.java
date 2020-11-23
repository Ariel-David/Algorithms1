package glassBalls;

public class KBalls {
	// k balls, n floors
	public static int numberOfCheckingK(int n, int k) {
		int numChecks = 0;
		int [][]checks = new int[k+1][n+1];
		for (int j = 0; j <= n; j++) {// one ball
			checks[0][j] = 0;
			checks[1][j] = j;
		}
		for (int i=2; i<=k; i++) {//i - number of the ball
			checks[i][0] = 0; checks[i][1] = 1; 
			if (n >= 2) checks[i][2] = 2;
			for (int j = 2; j <= n; j++) {//j - number of the floor
				int min = n + 1;
				for (int p=1; p<j; p++) {// p - number of the floor
					min = Math.min(Math.max(checks[i-1][p-1]+1, checks[i][j-p]+1), min);
				}
				checks[i][j] = min;
			}
		}
		numChecks = checks[k][n];
		return numChecks;
	}
	public static String[] checkNumbers(int n, int k) {
		int numChecks[] = new int[n+1];
		for (int i=1; i<=n; i++){// i - floor number
			numChecks[i-1] = numberOfCheckingK(i, k);
		}
		String[] temp = new String[n+1];
		int count = 1, j=1;
		for (int i=1; i<=n; i++){// i - floor number
			if (numChecks[i-1]==numChecks[i]) j++;
			else {
				temp[count++] = numChecks[i-1] + "("+j+")";
				j=1; 
			}
		}
		String[] ans = new String[count];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = temp[i];
		}
		return ans;
	}
	public static void main(String[] args) {
		int n = 666, k=7;
		System.out.println("number of checks for floors from 1 to "+n+", and "+k+" balls");
		for (int i=1; i<=n; i++){// i - floor number
			if (i%20 == 0) System.out.println();
			System.out.print(numberOfCheckingK(i, k)+", ");
		}
		
		String[] t = checkNumbers(n, k);
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i] + ", ");
			if (i%20 == 0) System.out.println();
		}
	}
}
