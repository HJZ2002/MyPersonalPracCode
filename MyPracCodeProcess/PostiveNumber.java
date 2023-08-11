package MyPracCodeProcess;
import java.util.Scanner;
public class PostiveNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(" Enter the number");
		double num = scan.nextDouble();
		
		String positive = (num + " is positive");
		String negative = (num + " is negative");
		String zero = (num + "zero is negative");
		
		if(num>0) {
			System.out.println(" Result is positive ");
		} else if (num<0) {
			System.out.println(" number is negative ");
		} else if (num<0) {
			System.out.println(" zero is negative");
		} else {
			System.out.println(" no zero is allowed ");
		}
	}

}
