package Prac;
import java.util.Scanner;
public class Calculatortest {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number 1");
		int number = scanner.nextInt();
		
		System.out.println("Enter number 2");
		int number2 = scanner.nextInt();
		
		System.out.println("Choose The operation bellow +-*/");
		String operator = "";
		operator = scanner.next();
		
		int result = 0;
		
		switch(operator) {
		case"+":
			result = number + number2;
			break;
		case"-":
			result = number - number2;
			break;
		case"*":
			result = number * number2;
			break;
		case"/":
			if(number2!=0) {
				result = number/number;
			} else {
				System.out.println("Zero is not allowed");
			} default:
				System.out.println("Invalid operator");
				break;
		}
		System.out.println(" "+result );
	}
}
