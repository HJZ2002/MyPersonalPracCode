package MyPracCodeProcess;
import java.util.Scanner;
public class Basic_Knowledge {
	
	public static void main(String[]args) {
		//scanner
		Scanner scan = new Scanner (System.in);
		//putting the variables
		System.out.println(" Enter Number 1 ");
		int number = scan.nextInt();
		System.out.println(" Enter Number 2 ");
		int number2 = scan.nextInt();
		
		System.out.println(("Choose the operator + - / % * "));
		String operator = scan.next();
		
		int result = 0;
		// switch method
		switch(operator) {
		case"+":
			result = number + number2;
			break;
		case"-":
			result = number - number2;
			break;
		case"%":
			result = number % number2;
			break;
		case"*":
			result = number * number2;
			break;
		case"/":
		if (number2!=0) {
			result = number/number2;
		} else {
			System.out.println(" Zero is not allowed");
			return;
		}
		break;
		default:
			System.out.println(" Invalid operator");
	}
		System.out.println("Your answer is "+result);
}
}