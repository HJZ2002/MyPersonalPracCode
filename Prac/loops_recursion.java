package Prac;
import java.util.Scanner;
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
	
	//loops fibonacci
	public static int fibonacci(int N) {
		if(N<=1) {
			return N;
		}

		int previous =0;
		int current = 1;
		for(int i =2;i<=N;i++) {
			int total  = current+previous;
			previous = current;
			current = total;
		}
		return current;
	}
	// recursive fibonacci
	public static int fibonacci2(int N) {
		if(N<=1) {
			return N;
		}
		int total = (fibonacci(N-1) + fibonacci2(N-2));
		return total;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		loops_recursion loops = new loops_recursion();
		
		System.out.println(" Enter the number");
		int n = scan.nextInt();
		
		System.out.println("Loop fibonacci " + loops.fibonacci(n));
		System.out.println("Recursive fibonacci " + loops.fibonacci2(n));
		
		System.out.println("Made by Hosea James Zacarias");
	}
}