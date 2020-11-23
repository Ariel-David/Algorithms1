package recursionIteration;

public class CheckRecursionIteration {
	static long start = 0;
	static long finish = 0;
	static long arrLong[] = new long[60];

	static void initArr() {
		for (int i = 0; i < 60; i++)
			arrLong[i] = 0;
	}
	
	//Iterative method
	public static long iterationFibonacci(int n) {
		if (n == 1 || n == 2)
			return 1;
		else {
			long fibN = 0;
			long fibN_1 = 1;
			long fibN_2 = 1;
			for (int i = 3; i <= n; i++) {
				fibN = fibN_1 + fibN_2;
				fibN_2 = fibN_1;
				fibN_1 = fibN;
			}
			return fibN;
		}
	}
	
	//Recursive method
	static long recursionFibonacci(int n) {
		if ((n == 1) || (n == 2)) {
			return 1;
		}
		return recursionFibonacci(n - 1) + recursionFibonacci(n - 2);
	}

	//Recursive method with memorization
	static long recursionMemoFibonacci(int n) {
		if ((n == 1) || (n == 2)) {
			arrLong[0] = 1; arrLong[1] = 1;
			return 1;
		}
		if (arrLong[n] != 0)
			return arrLong[n];
		else {
			arrLong[n]=recursionMemoFibonacci(n - 1)+recursionMemoFibonacci(n - 2);
		}
		return arrLong[n];
	}
	
	//Tail recursion
	static long recursionTailFibonacci(int n, long f1, long f2 ) {
		if (n == 1 || n == 2) {
			return f2;
		} return recursionTailFibonacci(n-1, f2, f1 + f2);
	}

	public static void main(String[] args) {
		long fib = 0;		
		start = System.nanoTime();
		fib = iterationFibonacci(20);
		finish = System.nanoTime();
		System.out.println("*****************************************");
		System.out.println("*************** Iteration ***************");
		System.out.println("*****************************************");
		System.out.println("timeLong = " + String.format(" %,d ", (finish - start)) + " nsec");
		System.out.println("Calculate Fibonacci number 20 : fib20 = " + String.format(" %,d ",fib));
		System.out.println("***************************************************************");
		System.out.println("***************************************************************");
		fib = 0;
		start = System.nanoTime();
		fib = recursionFibonacci(20);
		finish = System.nanoTime();
		System.out.println("*****************************************");
		System.out.println("*************** Recursion ***************");
		System.out.println("*****************************************");
		System.out.println("timeLong = " + String.format(" %,d ", (finish - start)) + " nsec");
		System.out.println("Calculate Fibonacci number 20 : fib20 = " + String.format(" %,d ",fib));
		System.out.println("***************************************************************");
		System.out.println("***************************************************************");
		fib = 0;
		initArr();
		start = System.nanoTime();
		fib = recursionMemoFibonacci(20);
		finish = System.nanoTime();
		System.out.println("*****************************************");
		System.out.println("************* Recursion memo ************");
		System.out.println("*****************************************");
		System.out.println("timeLong = " + String.format(" %,d ", (finish - start)) + " nsec");
		System.out.println("Calculate Fibonacci number 20 : fib20 = " + String.format(" %,d ",fib));
		System.out.println("***************************************************************");
		System.out.println("***************************************************************");
		fib = 0;
		start = System.nanoTime(); fib = recursionTailFibonacci(20, 1, 1);
		finish = System.nanoTime();
		System.out.println("*****************************************");
		System.out.println("************* Recursion tail ************");
		System.out.println("*****************************************");
		System.out.println("timeLong = " + String.format(" %,d ", (finish - start)) + " nsec");
		System.out.println("Calculate Fibonacci number 20 : fib20 = " + String.format(" %,d ",fib));
		System.out.println("***************************************************************");
		System.out.println("***************************************************************");
	}
}
