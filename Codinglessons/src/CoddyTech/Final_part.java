package CoddyTech;
import java.util.Scanner;
public class Final_part {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

        System.out.println("Calculator App");

        System.out.print("Enter first number: ");
        double num1 = scan.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scan.nextDouble();

        double sum = num1 + num2;
        double Difference = num1 - num2;
        double Product = num1 * num2;
        double Quotient = num1 / num2;

        System.out.printf("Sum: %.2f\n", sum);
        System.out.printf("Difference: %.2f\n", Difference);
        System.out.printf("Product: %.2f\n", Product);
        System.out.printf("Quotient: %.2f\n", Quotient);
    }
}

