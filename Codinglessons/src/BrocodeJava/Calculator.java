package BrocodeJava;
import java.util.Scanner;
public class Calculator {
	public static void main(String[]args) {
		//method
		Scanner scan = new Scanner (System.in);
		System.out.println(" Enter number 1");
		int num1 = scan.nextInt();
		System.out.println(" Enter number 2");
		int num2 = scan.nextInt();
		
		// operator
		System.out.println(" Choose a operator +-*/%");
		String operator = "";
		operator = scan.next();
		int result = 0;
		
		//switch method
		switch(operator) {
		case"+":
			result = num1 + num2;
			break;
		case"-":
			result = num1 - num2;
			break;
		case"*":
			result = num1 * num2;
			break;
		case"/":
			if(num2!=0) {
				result = num1/num2;
			} else {
				System.out.println(" Zero is not allowed ");
			} default:
				System.out.println(" Invalid operator");
				break;
		case"%":
			result = num1 % num2;
			break;
		}
		System.out.println(""+result);
	}
}
