package CoddyTech;
import java.util.Scanner;
public class GettingNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Calculator App");
		scan.nextLine();
		
		System.out.println("Enter first number: ");
		double num1 = scan.nextDouble();
		System.out.println("Enter second number: ");
		double num2 = scan.nextDouble();
		
		
        System.out.println("First number: " + num1);
        System.out.println("Second number: " + num2);
	}

}
