package aeroplane;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class functions {

	public static int getBestPrice(Node[][] mat, int p1, int q1, int p2, int q2){
		for(int j=q1+1; j<=q2; j++) {
			mat[p1][j].price = mat[p1][j-1].price + mat[p1][j-1].x;
			mat[p1][j].numOfPaths = 1;
		}

		for(int i=p1+1; i<=p2; i++) {
			mat[i][q1].price = mat[i-1][q1].price + mat[i-1][q1].y;
			mat[i][q1].numOfPaths = 1;
		}

		for(int i=p1+1; i<=p2; i++) {
			for(int j=q1+1; j<=q2; j++) {
				int a =	mat[i-1][j].price + mat[i-1][j].y;
				int b = mat[i][j-1].price + mat[i][j-1].x;
				if(a < b) {
					mat[i][j].price = a;
					mat[i][j].numOfPaths = mat[i-1][j].numOfPaths;

				}
				else if(a > b) {
					mat[i][j].price = b;
					mat[i][j].numOfPaths = mat[i][j-1].numOfPaths;
				}
				else {
					mat[i][j].price = a;
					mat[i][j].numOfPaths = mat[i-1][j].numOfPaths + mat[i][j-1].numOfPaths;
				}
			}
		}
		System.out.println("Price is: " + mat[p2][q2].price);
		return mat[p2][q2].price;
	}

	public static boolean check(Node[][] mat , int p1, int q1, int p2, int q2) {
		int n = mat.length;
		int m = mat[0].length;
		int total = getBestPrice(mat,0,0,n-1,m-1);
		int first1 = getBestPrice(mat, 0, 0, p1, q1);
		int middle = getBestPrice(mat, p1, q1, p2, q2);
		int first2 = getBestPrice(mat, 0, 0, p2, q2);
		int last = getBestPrice(mat, p2, q2, n-1, m-1);

		boolean ans = true;

		if(p2 < p1 || q1 > q2) {
			ans = false;
		}
		if((first1 + (middle-first1) + (last - first2)) != total){
			ans = false;
		}
		return ans;
	}

	public static boolean checkListNodes(Node[][] mat , List<Node> nodes) {
			int p1 = 0;
			int p2 = 0;
			int q1 = 0;
			int q2 = 0;
			int n = mat.length;
			int m = mat[0].length;
			boolean ans = true;
			Iterator<Node> iter = nodes.iterator();
			if(nodes.size()%2 == 0) {
			while(iter.hasNext()) {
				Node current1 = iter.next();
				Node current2 = iter.next();
				p1 = current1.x;
				p2 = current1.y;
				q1 = current2.x;
				q2 = current2.y;

				int total = getBestPrice(mat,0,0,n-1,m-1);
				int first1 = getBestPrice(mat, 0, 0, p1, q1);
				int middle = getBestPrice(mat, p1, q1, p2, q2);
				int first2 = getBestPrice(mat, 0, 0, p2, q2);
				int last = getBestPrice(mat, p2, q2, n-1, m-1);


				if(p2 < p1 || q1 > q2) {
					ans = false;
				}
				if((first1 + (middle-first1) + (last - first2)) != total){
					ans = false;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int n=4;
		Node mat[][] = new Node[n][n];

		mat[0][0] = new Node(3,1);
		mat[0][1] = new Node(5,2);
		mat[0][2] = new Node(10,4);
		// the 2-nd row
		mat[1][0] = new Node(4,8);
		mat[1][1] = new Node(11,5);
		mat[1][2] = new Node(1,3);
		// the 3-d row
		mat[2][0] = new Node(8,3);
		mat[2][1] = new Node(1,3);
		mat[2][2] = new Node(4,1);
		// the 4-th row
		

		List<Node> nodes = new LinkedList<Node>();
		nodes.add(new Node(0,1));
		nodes.add(new Node(2,1));
		nodes.add(new Node(1,1));

		//System.out.println(getBestPrice(mat,0,0,3,1));
		//System.out.println(check(mat, 1, 1, 1, 0));
		System.out.println(checkListNodes(mat, nodes));
	}
}
