package Prac;

public class fibonacci_recursion {
	public static int fibonacci(int N) {
		if(N<=1) {
			return N;
		}
		return fibonacci(N-1)+fibonacci(N-2);
	}
	public static void main(String[]args) {
		int N =10;
		
		System.out.println("fibonacci using recursion");
		for(int i =0; i<N; i++) {
			System.out.println(fibonacci(i)+ " ");
		}
		int n = 10;
		
		int []fibonacci = new int[n];
		
		fibonacci[0]=0;
		fibonacci[1]=1;
		
		//looping statment in fibonacci 
		for(int i = 2; i<n; i++) {
			fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
			
		}
		System.out.println("fibonacci using loop method");
		for(int num:fibonacci) {
			System.out.println(num +" ");
		}
	}
}


