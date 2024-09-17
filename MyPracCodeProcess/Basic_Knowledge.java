package MyPracCodeProcess;
import java.util.Scanner;
public class Basic_Knowledge {
	
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(" Enter Number 1");
		int num1 = scan.nextInt();
		System.out.println(" Enter Number 2");
		int num2 = scan.nextInt();
		
		// setting operator
		String operator = "";
		int result = 0;
		while(operator.isEmpty()) {
			System.out.println(" Choose the Operator +-*%/");
			operator = scan.next();
			
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
			case"%":
				result = num1 % num2;
				break;
			case"/":
				if(num2!=0) {
					result = num1/num2;
				} else {
					System.out.println(" Zero is not a valid number ");
				} default:
					System.out.println(" Invalid operator");
					break;
			} System.out.println("" + result);
		}
	}
}