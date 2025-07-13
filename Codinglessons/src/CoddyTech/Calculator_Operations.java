package CoddyTech;

import java.util.Scanner;

public class Calculator_Operations {
	 public static void main(String[] args) {
	        System.out.println("Calculator App");

	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter first number: ");
	        double num1 = scanner.nextDouble();
	        System.out.print("Enter second number: ");
	        double num2 = scanner.nextDouble();

	        // Perform arithmetic operations
	        double sum = num1 + num2;
	        double difference = num1 - num2;
	        double product = num1 * num2;
	        double quotient = num1 / num2;

	        // Print the results
	        System.out.println("Sum: " + sum);
	        System.out.println("Difference: " + difference);
	        System.out.println("Product: " + product);
	        System.out.println("Quotient: " + quotient);
	    }
	}

