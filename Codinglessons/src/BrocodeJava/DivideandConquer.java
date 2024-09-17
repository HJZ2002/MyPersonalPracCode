package BrocodeJava;
import java.util.Scanner;
public class DivideandConquer {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter first number ");
		int first = scan.nextInt();
		
		System.out.println("Enter second number :");
		int second = scan.nextInt();
		
		System.out.println("Choose the operator +-/*");
		String choice = scan.next();
		
		int result = 0;
		
		switch (choice) {
		case "+":
			result = first + second;
			break;
		case "-":
			result = first -second;
			break;
		case "*":
			result = first * second;
			break;
		case "/":
			result = first / second;
			break;
			default:
		}
	}

}
