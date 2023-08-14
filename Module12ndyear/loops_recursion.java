package Prac;

public class loops_recursion {
	//iterative factorial
	public static long iterativefactorial(int N) {
		long answer = 1;
		for (int i =1; i<=N; i++) {
			answer*=i;
		}
		return answer;
	}
	// recursive factorial
	public static long recursivefactorial(int N) {
		if(N ==0 || N==1) {
			return 1;
		}
		return N *recursivefactorial(N-1);
	}
	
	//iterative fibonacci
	public static long fibonacci(long N) {
		if(N<=0) {
			return 0;
		}
		if(N==1) {
			return 1;
		}
		
		long previous =0;
		long current = 1;
		for(int i =3;i<=N;i++) {
			long total  = current+previous;
			previous = current;
			current = total;
		}
		return current;
	}
	// recursive fibonacci
	public static long fibonacci2(int N) {
		if(N<=0) {
			return 0;
		}
		if(N==1||N<=2) {
			return 1;
		}
		return fibonacci(N-1)+fibonacci(N-2);
	    
	}
	public static void main(String[] args) {
		int n = 5;
		int position = 3;

        // Factorial
        System.out.println("The interative Factorial of "+ n +": " + iterativefactorial(n));
        System.out.println("The recursive Factorial of " + n + ": " + recursivefactorial(n));

        // Fibonacci
        System.out.println("The iterative Fibonacci of :" + n + " is at position " + position);
        System.out.println("The recursive Fibonacci of :" + n + " is at position " + position);
	}
}