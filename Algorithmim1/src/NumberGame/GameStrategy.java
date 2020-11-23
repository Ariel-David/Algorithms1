package NumberGame;

public class GameStrategy {
	public static int[][] buildMatrix(int [] game){
		int n = game.length;
		int [][] mat = new int [n][n];
		for(int i=0; i<n-1; i++) {
			mat[i][i] = game[i];
		}
		for(int i=n-2; i>0; i--) {
			for(int j=i+1; j<n-1; j++) {
				mat[i][j] = Math.max(game[i]-mat[i+1][j],game[j]-mat[i][j-1]);
			}
		}
		return mat;
	}
	public static void gameStrategy(int [] game) {
		int n = game.length;
		int i = 0;
		int j = n-1;
		int first = 0;
		int second = 0;
		int firstSum = 0;
		int secondSum = 0;
		int[][] mat = buildMatrix(game);

		for(int k=0; k<n/2; k++) {
			if(game[i]-mat[i+1][j] > game[j]-mat[i][j-1]) {
				firstSum = firstSum + game[i];
				first = i++;
			}
			else{
				firstSum = firstSum + game[j];
				first = j--;
			}
			if(i!= j) {
				if(game[i]-mat[i+1][j] > game[j]-mat[i][j-1]) {
					secondSum = secondSum +game[i];
					second = i++;
				}
				else {
					secondSum = secondSum +game[j];
					second = j--;
				}
			}
			else {
				second = j;
				secondSum = secondSum + game[j];
			}
			System.out.println("First: game["+first+"] = "+game[first]+" second: game[" +second+"] = "+game[second]);
		}
		System.out.println("FirstSum = "+firstSum+",secondSum = " +secondSum+",diff = " +(firstSum-secondSum));
	}
	
	public static void main(String[] args) {
		int size = 4;
		int arr[] = {2,8,7,4};
		gameStrategy(arr);
	}
}
