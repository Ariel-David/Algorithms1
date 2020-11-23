package Compiler;


public class Functions {

	public static void getOptimalOrder(Program[] programs) {
		mergeSort(programs,0,programs.length);
		int totalTime = 0;
		int totallen = 0;
		for(int i=0; i<programs.length; i++) {
			System.out.println(programs[i]);
			totalTime  = totalTime + (totallen+programs[i].len)*programs[i].freq;
			totallen = totallen + programs[i].len;
		}
		System.out.println("Total Time: " +totalTime);
	}

	public static void mergeSort(Program[] p, int low, int high) {
		int n = high - low;
		if(n <= 1) {
			return;
		}
		int mid = (low + high)/2;
		mergeSort(p, low, mid);
		mergeSort(p, mid, high);
		int i = low;
		int j = mid;
		int k = 0;
		Program[] temp = new Program[n];
		while(i<mid && j<high) {
			double t1 = (double)p[i].len/p[i].freq;
			double t2 = (double)p[j].len/p[j].freq;
			if(t1 < t2) {
				temp[k++] = p[i++];
			}
			else {
				temp[k++] = p[j++];
			}
		}
		while(i < mid) {
			temp[k++] = p[i++];
		}
		while(j < high) {
			temp[k++] = p[j++];
		}
		for(int m = 0; m<n; m++) {
			p[low+m] = temp[m];
		}

	}
	public static void main(String[] args) {
		Program a = new Program("a",1,2);
		Program b = new Program("b",2,2);
		Program c = new Program("c",1,3);
		Program d = new Program("d",3,1);
		Program [] p = {a,b,c,d};
		getOptimalOrder(p);

	}
}
